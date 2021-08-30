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
public class ErrorToastView extends Component implements Component.DrawTask, RunCheck {

  private boolean stopAnimator;
  private final Paint linepaint = new Paint();
  private int ival;
  private final EventHandler event;
  private final EventRunner runner;

  /**A constructor to initialize drawing attributes.
   *
   * @param context app context
   * @param attrs   xml attributes
   */
  public ErrorToastView(final Context context, final AttrSet attrs) {
    super(context, attrs);
    linepaint.setStyle(Paint.Style.STROKE_STYLE);
    linepaint.setStrokeWidth(5);
    linepaint.setAntiAlias(true);
    linepaint.setColor(Color.RED);
    ival = 0;
    runner = EventRunner.current();
    event = new EventHandler(runner);
    event.postTask(runnable);
    SmartyToast.registerListener(this);
    stopAnimator = false;
    addDrawTask(this);
  }

  @Override
  public void onDraw(final Component component, final Canvas canvas) {
    canvas.drawLine(0, 0, 2.5f + ival, 4.3f + ival, linepaint);
    canvas.drawLine(getWidth(), 0, getWidth() - 2.5f - ival, 4.3f + ival, linepaint);
  }

  private final  Runnable runnable = new Runnable() {
    @Override
    public void run() {
      if (stopAnimator) {
        return;
      }

      if (ival < 200) {
        ival += 10;
      } else {
        ival = 0;
      }
      invalidate();
      event.postTask(this, 200);
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
