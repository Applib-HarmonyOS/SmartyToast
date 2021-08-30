package com.developers.smartytoast;

import ohos.agp.components.AttrSet;
import ohos.agp.components.Component;
import ohos.agp.render.Canvas;
import ohos.agp.render.Paint;
import ohos.agp.utils.Color;
import ohos.agp.utils.Point;
import ohos.app.Context;
import ohos.eventhandler.EventHandler;
import ohos.eventhandler.EventRunner;

/**
 * Created by Amanjeet Singh on 09-May-17.
 */
public class DoneToastView extends Component implements Component.DrawTask, RunCheck {

  private final Point start = new Point();
  private int ival;
  private final Point point = new Point();
  private int jval;
  private int flag;
  private final Point stop = new Point();
  private final Paint paint = new Paint();
  private final EventHandler event;
  private final EventRunner runner;
  private boolean stopAnimator;

  /** A constructor to initialize drawing attributes.
   *
   * @param context app context
   * @param attrs   xml attributes
   */
  public DoneToastView(final Context context, final AttrSet attrs) {
    super(context, attrs);
    paint.setStyle(Paint.Style.STROKE_STYLE);
    paint.setColor(Color.BLACK);
    paint.setStrokeWidth(5);
    paint.setAntiAlias(true);
    flag = 0;
    jval = 0;
    ival = 10;
    runner = EventRunner.current();
    event = new EventHandler(runner);
    addDrawTask(this);
    event.postTask(animator);
    SmartyToast.registerListener(this);
    stopAnimator = false;
  }

  @Override
  public void onDraw(final Component component, final Canvas canvas) {
    start.modify(getWidth() / 2 - 10, getHeight() / 2 - 10);
    canvas.drawLine(start.getPointX(), start.getPointY(), stop.getPointX(), stop.getPointY(),
        paint);
    if (flag == 1) {
      canvas.drawLine(getWidth() / 2 - 2, getHeight() / 2 - 2, point.getPointX(),
          point.getPointY(), paint);
    }
  }

  private final Runnable animator = new Runnable() {
    @Override
    public void run() {
      if (stopAnimator) {
        return;
      }

      if (ival >= 0) {
        stop.modify(getWidth() / 2 - ival, getHeight() / 2 - ival);
        ival -= 10;
      } else {
        while (jval <= 25) {
          flag = 1;
          point.modify(getWidth() / 2 + jval, getHeight() / 2 - jval);
          jval += 5;
        }
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
