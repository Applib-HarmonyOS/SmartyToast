package com.developers.smartytoast;

import ohos.agp.colors.RgbPalette;
import ohos.agp.components.AttrSet;
import ohos.agp.components.Component;
import ohos.agp.render.Arc;
import ohos.agp.render.Canvas;
import ohos.agp.render.Paint;
import ohos.agp.utils.Color;
import ohos.app.Context;
import ohos.eventhandler.EventHandler;
import ohos.eventhandler.EventRunner;

/**
 * Created by Amanjeet Singh on 04-Jun-17.
 */
public class UpdatingToastView extends Component implements Component.DrawTask, RunCheck {

  private static final int SWEEP_ANGLE = 220;
  private int startAngle1 = 120;
  private final RectF oval = new RectF();
  private boolean stopAnimator;
  private final Paint paint = new Paint();
  private final EventHandler event;
  private final EventRunner runner;
  private final Color colorUpdate = new Color(RgbPalette.parse("#1919ff"));

  /**
   * A constructor to initialize drawing attributes.
   *
   * @param context app context
   * @param attrs   xml attributes
   */
  public UpdatingToastView(final Context context, final AttrSet attrs) {
    super(context, attrs);
    paint.setAntiAlias(true);
    paint.setColor(colorUpdate);
    paint.setStyle(Paint.Style.STROKE_STYLE);
    paint.setStrokeWidth(5);
    runner = EventRunner.current();
    event = new EventHandler(runner);
    event.postTask(animator);
    addDrawTask(this);
    SmartyToast.registerListener(this);
    stopAnimator = false;
  }

  @Override
  public void onDraw(final Component component, final Canvas canvas) {
    oval.set(new RectF(getWidth() / 2 - 15, getHeight() / 2 - 15, getWidth() / 2 + 15,
        getHeight() / 2 + 15));
    canvas.drawArc(oval, new Arc(startAngle1, SWEEP_ANGLE, false), paint);
  }

  private final Runnable animator = new Runnable() {
    @Override
    public void run() {
      if (stopAnimator) {
        return;
      }

      if (startAngle1 <= 360) {
        startAngle1 += 10;
      } else {
        startAngle1 = 1;
      }
      invalidate();
      event.postTask(this, 30);
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
