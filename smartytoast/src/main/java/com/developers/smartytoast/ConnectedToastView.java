package com.developers.smartytoast;

import ohos.agp.components.AttrSet;
import ohos.agp.components.Component;
import ohos.agp.render.Arc;
import ohos.agp.render.Canvas;
import ohos.agp.render.Paint;
import ohos.agp.utils.Color;
import ohos.app.Context;

/**
 * Created by Amanjeet Singh on 04-Jun-17.
 */
public class ConnectedToastView extends Component implements Component.DrawTask {

  private final RectF oval = new RectF();
  private final Paint paint = new Paint();
  private final RectF oval1 = new RectF();
  private final RectF oval2 = new RectF();

  /** A constructor to initialize drawing attributes.
   *
   * @param context app context
   * @param attrs   xml attributes
   */
  public ConnectedToastView(final Context context, final AttrSet attrs) {
    super(context, attrs);
    paint.setStrokeWidth(5);
    paint.setStyle(Paint.Style.STROKE_STYLE);
    paint.setAntiAlias(true);
    paint.setColor(Color.BLUE);
    addDrawTask(this);
  }

  @Override
  public void onDraw(final Component component, final Canvas canvas) {
    final int width = getWidth();
    final int height = getHeight();
    oval.set(new RectF(width / 2 - 5, height / 2 - 5, width / 2 + 5, height / 2 + 5));
    canvas.drawArc(oval, new Arc(-20, -140, false), paint);
    oval1.set(new RectF(width / 2 - 15, height / 2 - 15, width / 2 + 15, height / 2 + 15));
    canvas.drawArc(oval1, new Arc(-20, -140, false), paint);
    oval2.set(new RectF(width / 2 - 25, height / 2 - 25, width / 2 + 25, height / 2 + 25));
    canvas.drawArc(oval2, new Arc(-20, -140, false), paint);
  }
}
