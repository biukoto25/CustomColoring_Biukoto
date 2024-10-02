package edu.up.customcoloring_biukoto;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.graphics.Canvas;
import android.view.SurfaceView;
import android.widget.SeekBar;
import android.widget.TextView;

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

    public PetalModel petalModel;
    private SeekBar redSB;
    private SeekBar greenSB;
    private SeekBar blueSB;
    private TextView textView;
    private FlowerController controller;

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

        redSB = findViewById(R.id.redSeekBar);
        greenSB = findViewById(R.id.greenSeekBar);
        blueSB = findViewById(R.id.blueSeekBar);
        textView = findViewById(R.id.element);

        controller = new FlowerController(this, textView ,redSB,greenSB,blueSB);

        //background color
        setBackgroundColor(0xFF87CEFA);
        petalModel = new PetalModel();
    }
    public PetalModel getPetal() { return petalModel; }

    @Override
    protected void onDraw (Canvas canvas) {
        //sun
        canvas.drawCircle(x - 200,y - 150,(radius * 12) + 10,yellowPaint);

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

        //flower
    }
    public void drawTopPetal (Canvas canvas) {
        canvas.drawCircle(x * 4 + 25, y + 150, 85, pinkPaint);
    }

    public void drawLeftPetal (Canvas canvas) {
        canvas.drawCircle(x * 4 - 75, y * 2 - 10, 85, pinkPaint);
    }

    public void drawBottLeft (Canvas canvas) {
        canvas.drawCircle(x * 4 - 10, y * 2 + 75, 85, pinkPaint);
    }

    public void drawBottRight (Canvas canvas) {
        canvas.drawCircle(x * 4 + 65, y * 2 + 75, 85, pinkPaint);
    }

    public void drawRight (Canvas canvas) {
        canvas.drawCircle(x * 4 + 115, y * 2, 85,pinkPaint);
    }

    public void drawStem (Canvas canvas) {
        canvas.drawRect(x * 4, y * 2, x * 4 + 50,y * 4 , greenPaint);
    }
}
