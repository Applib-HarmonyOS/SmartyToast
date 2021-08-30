package com.developers.smartytoast;

import java.util.ArrayList;
import java.util.List;
import ohos.agp.components.Component;
import ohos.agp.components.LayoutScatter;
import ohos.agp.components.Text;
import ohos.agp.window.dialog.CommonDialog;
import ohos.agp.window.dialog.ToastDialog;
import ohos.app.Context;

/**
 * Created by Amanjeet Singh on 09-May-17.
 */
public class SmartyToast implements CommonDialog.DestroyedListener {
  public static final int LENGTH_SHORT = 0;
  public static final int LENGTH_LONG = 1;
  public static final int DONE = 0;
  public static final int WARNING = 1;
  public static final int ERROR = 2;
  public static final int SAVED = 3;
  public static final int CONNECTED = 4;
  public static final int UPDATE = 5;
  private final ToastDialog toast;
  private final  Context context;
  private static final  List<RunCheck> listerners = new ArrayList<>();

  /**
   * A constructor to initialize toast.
   *
   * @param mcontext app context
   */
  public SmartyToast(final Context mcontext) {
    toast = new ToastDialog(mcontext);
    context = mcontext;
    toast.setDestroyedListener(this);
  }

  @Override
  public void onDestroy() {
    do {
      if (!listerners.isEmpty()) {
        final RunCheck runCheck = listerners.get(0);
        runCheck.stopRunner();
        listerners.remove(runCheck);
      }
    } while (!listerners.isEmpty());
  }

  public static void registerListener(final RunCheck listener) {
    listerners.add(listener);
  }

  /**
   * Method to create toast and display.
   *
   * @param msg    Toast Message
   * @param length duration
   * @param type   type of toast
   */
  public void makeText(final String msg, final int length, final int type) {
    switch (type) {
      case 0: {
        final Component layout = LayoutScatter.getInstance(context).parse(
            ResourceTable.Layout_done_layout, null, false);
        final Text textView = (Text) layout.findComponentById(ResourceTable.Id_done_message);
        textView.setText(msg);
        toast.setComponent(layout);
        break;
      }
      case 1: {
        final Component layout = LayoutScatter.getInstance(context).parse(
            ResourceTable.Layout_warning_layout, null, false);
        final Text textView = (Text) layout.findComponentById(ResourceTable.Id_warning_message);
        textView.setText(msg);
        toast.setComponent(layout);
        break;
      }
      case 2: {
        final Component layout = LayoutScatter.getInstance(context).parse(
            ResourceTable.Layout_error_layout, null, false);
        final Text textView = (Text) layout.findComponentById(ResourceTable.Id_error_message);
        textView.setText(msg);
        toast.setComponent(layout);
        break;
      }
      case 3: {
        final Component layout = LayoutScatter.getInstance(context).parse(
            ResourceTable.Layout_saved_layout, null, false);
        final Text textView = (Text) layout.findComponentById(ResourceTable.Id_saved_message);
        textView.setText(msg);
        toast.setComponent(layout);
        break;
      }
      case 4: {
        final Component layout = LayoutScatter.getInstance(context).parse(
            ResourceTable.Layout_connected_layout, null, false);
        final Text textView = (Text) layout.findComponentById(ResourceTable.Id_connected_message);
        textView.setText(msg);
        toast.setComponent(layout);
        break;
      }
      case 5: {
        final Component layout = LayoutScatter.getInstance(context).parse(
            ResourceTable.Layout_updating_layout, null, false);
        final Text textView = (Text) layout.findComponentById(ResourceTable.Id_updating_message);
        textView.setText(msg);
        toast.setComponent(layout);
        break;
      }
      default:
        break;
    }

    toast.setDuration(length);
    toast.show();
  }


}
