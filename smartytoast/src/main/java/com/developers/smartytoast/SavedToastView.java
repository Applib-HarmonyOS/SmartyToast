package com.developers.smartytoast;

import ohos.agp.components.AttrSet;
import ohos.agp.components.Component;
import ohos.agp.render.Canvas;
import ohos.agp.render.Paint;
import ohos.agp.utils.Color;
import ohos.app.Context;

/**
 * Created by Amanjeet Singh on 03-Jun-17.
 */
public class SavedToastView extends Component implements Component.DrawTask {

  private final Paint paint = new Paint();

  /**A constructor to initialize drawing attributes.
   *
   * @param context app context
   * @param attrs   xml attributes
   */
  public SavedToastView(final Context context, final AttrSet attrs) {
    super(context, attrs);
    paint.setAntiAlias(true);
    paint.setStrokeWidth(5);
    paint.setColor(Color.BLACK);
    addDrawTask(this);
  }

  @Override
  public void onDraw(final Component component, final Canvas canvas) {
    canvas.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight() - 5, paint);
    canvas.drawLine(getWidth() / 2 - 15, getHeight() - 15, getWidth() / 2, getHeight() - 5, paint);
    canvas.drawLine(getWidth() / 2, getHeight() - 5, getWidth() / 2 + 15, getHeight() - 15, paint);
    paint.setColor(Color.BLACK);
  }

}
