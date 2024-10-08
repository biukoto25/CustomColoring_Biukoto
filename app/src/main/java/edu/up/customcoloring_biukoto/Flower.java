package edu.up.customcoloring_biukoto;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.graphics.Canvas;
import android.view.SurfaceView;

/**
 * @author Becca Biukoto
 * date: 10/07/2024
 *
 *  Flower draws a flower on surface view
 */

public class Flower extends SurfaceView {
    private Paint yellowPaint;
    private Paint greenPaint;
    private Paint pinkPaint;

    private final float x = 250.0f;
    private final float y = 250.0f;
    private final float radius = 20.0f;

    public PetalModel petalModel;

    /**
     *
     * @param context
     * @param attrs
     */
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

        pinkPaint = new Paint(); // pink
        pinkPaint.setColor(0xFFF3D4D5);
        pinkPaint.setStyle(Paint.Style.FILL);

        //background color
        setBackgroundColor(0xFF87CEFA);
        petalModel = new PetalModel();
    }

    public PetalModel getPetal() { return petalModel; }

    @Override
    protected void onDraw (Canvas canvas) {

        //stem
        drawStem(canvas);

        //top petal
        drawTopPetal(canvas);

        // left petal
        drawLeftPetal(canvas);

        // bottom left petal
        drawBottLeft(canvas);

        // bottom right petal
        drawBottRight(canvas);

        // right petal
        drawRight(canvas);

        // middle
        canvas.drawCircle(x * 4 + 25,y * 2,75,yellowPaint);

        //sun
        canvas.drawCircle(x - 200,y - 150,(radius * 12) + 10,yellowPaint);

        //flower
    }
    public void drawTopPetal (Canvas canvas) {
        pinkPaint.setColor(petalModel.topPetalColor); // update color
        canvas.drawCircle(x * 4 + 25, y + 150, 85, pinkPaint);
    }

    public void drawLeftPetal (Canvas canvas) {
        pinkPaint.setColor(petalModel.leftPetalColor); // update color
        canvas.drawCircle(x * 4 - 75, y * 2 - 10, 85, pinkPaint);
    }

    public void drawBottLeft (Canvas canvas) {
        pinkPaint.setColor(petalModel.bottomLeftPetalColor); // update color
        canvas.drawCircle(x * 4 - 30, y * 2 + 75, 85, pinkPaint);
    }

    public void drawBottRight (Canvas canvas) {
        pinkPaint.setColor(petalModel.bottomRightPetalColor); // update color
        canvas.drawCircle(x * 4 + 65, y * 2 + 75, 85, pinkPaint);
    }

    public void drawRight (Canvas canvas) {
        pinkPaint.setColor(petalModel.rightPetalColor); // update color
        canvas.drawCircle(x * 4 + 115, y * 2, 85,pinkPaint);
    }

    public void drawStem (Canvas canvas) {
        greenPaint.setColor(petalModel.stemColor); // update color
        canvas.drawRect(x * 4, y * 2, x * 4 + 50,y * 4 , greenPaint);
    }
}

