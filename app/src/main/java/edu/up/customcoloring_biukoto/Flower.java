package edu.up.customcoloring_biukoto;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.graphics.Canvas;
import android.view.SurfaceView;

//@author Becca Biukoto
// date: 09/22/2024

public class Flower extends SurfaceView {
    private Paint yellowPaint;
    private Paint greenPaint;
    private Paint redPaint;
    private Paint pinkPaint;

    private final float x = 250.0f;
    private final float y = 250.0f;
    private final float radius = 20.0f;

    public Flower(Context context, AttributeSet attrs) {
        super(context, attrs);
        // draw on Surface View
        setWillNotDraw(false);

        // set up colors
        yellowPaint = new Paint();
        yellowPaint.setColor(0xFFFFDF22); //sunshine yellow
        yellowPaint.setStyle(Paint.Style.FILL);

        greenPaint = new Paint();
        greenPaint.setColor(0xFF228B22); // forest green
        greenPaint.setStyle(Paint.Style.FILL);

        redPaint = new Paint();
        redPaint.setColor(0xFFFF0000);  //a bright red
        redPaint.setStyle(Paint.Style.FILL);

        pinkPaint = new Paint();
        pinkPaint.setColor(0xFFF3D4D5);
        pinkPaint.setStyle(Paint.Style.FILL);

        //background color
        setBackgroundColor(0xFF87CEFA);
    }
    @Override
    protected void onDraw (Canvas canvas) {
        //sun
        canvas.drawCircle(x - 200,y - 150,(radius * 12) + 10,yellowPaint);

        //stem
        canvas.drawRect(x * 4, y * 2, x * 4 + 50,y * 4 , greenPaint);

        //top petal
        canvas.drawCircle(x * 4 + 25, y + 150, 85, pinkPaint);
        // left petal
        canvas.drawCircle(x * 4 - 75, y * 2 - 10, 85, pinkPaint);
        // bottom left petal
        canvas.drawCircle(x * 4 - 10, y * 2 + 75, 85, pinkPaint);
        // bottom right petal
        canvas.drawCircle(x * 4 + 65, y * 2 + 75, 85, pinkPaint);
        // right petal
        canvas.drawCircle(x * 4 + 115, y * 2, 85,pinkPaint);

        // middle
        canvas.drawCircle(x * 4 + 25,y * 2,75,yellowPaint);
        //flower
    }
}
