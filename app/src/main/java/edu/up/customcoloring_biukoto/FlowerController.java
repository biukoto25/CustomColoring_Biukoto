package edu.up.customcoloring_biukoto;

import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

// @author: Becca Biukoto
// date: 09/30/2024

public class FlowerController implements View.OnTouchListener, SeekBar.OnSeekBarChangeListener {
    private Flower flower;
    private TextView element;
    private PetalModel petalModel;
    private SeekBar redSB;
    private SeekBar greenSB;
    private SeekBar blueSB;

    public FlowerController (Flower flower, TextView element, SeekBar redSB, SeekBar greenSB, SeekBar blueSB) {
        this.flower = flower;
        this.redSB = redSB;
        this.greenSB = greenSB;
        this.blueSB = blueSB;
        this.element = element;
        this.petalModel = flower.getPetal();
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getX() == 1250 && motionEvent.getY() == 400) {
            element.setText(petalModel.topPetal);
        }
        return true;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
        int red = redSB.getProgress();
        int green = greenSB.getProgress();
        int blue = blueSB.getProgress();

        int color = Color.rgb(red, green, blue);

        flower.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) { // do nothing
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) { // do nothing
    }
}
