package com.developers.smartytoast;

import ohos.agp.components.AttrSet;
import ohos.agp.components.Component;
import ohos.agp.render.Canvas;
import ohos.agp.render.Paint;
import ohos.agp.utils.Color;
import ohos.app.Context;
import ohos.eventhandler.EventHandler;
import ohos.eventhandler.EventRunner;

/**
 * Created by Amanjeet Singh on 03-Jun-17.
 */
public class WarningToastView extends Component implements Component.DrawTask, RunCheck {

  private final Paint paint = new Paint();
  private final Paint circlepaint = new Paint();
  private int iwval;
  private final EventHandler event;
  private final EventRunner runner;
  private boolean stopAnimator;

  /**
   * A constructor to initialize drawing attributes.
   *
   * @param context app context
   * @param attrs   xml attributes
   */
  public WarningToastView(final Context context, final AttrSet attrs) {
    super(context, attrs);
    paint.setStyle(Paint.Style.STROKE_STYLE);
    paint.setColor(Color.RED);
    paint.setAntiAlias(true);
    paint.setStrokeWidth(5);
    circlepaint.setAntiAlias(true);
    circlepaint.setStyle(Paint.Style.FILL_STYLE);
    circlepaint.setColor(Color.RED);
    iwval = 0;
    runner = EventRunner.current();
    event = new EventHandler(runner);
    event.postTask(animator);
    addDrawTask(this);
    SmartyToast.registerListener(this);
    stopAnimator = false;
  }

  @Override
  public void onDraw(final Component component, final Canvas canvas) {
    canvas.drawLine(getWidth() / 2, 0, getWidth() / 2, 5 + iwval, paint);
    canvas.drawCircle(getWidth() / 2, getHeight() - 5, 5, circlepaint);
  }

  private final  Runnable animator = new Runnable() {
    @Override
    public void run() {
      if (stopAnimator) {
        return;
      }

      if (iwval <= getHeight() / 2) {
        iwval += 5;
      } else {
        iwval = 0;
      }
      invalidate();
      event.postTask(this, 300);
    }
  };

  @Override
  public void stopRunner() {
    stopAnimator = true;
    if (runner != null) {
      runner.stop();
    }
  }
}
