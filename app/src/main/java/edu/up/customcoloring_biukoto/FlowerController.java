package edu.up.customcoloring_biukoto;

import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * @author: Becca Biukoto
 * date: 10/07/2024
 *
 * Controller that implements multiple listeners so that the seekbar and touchscreen
 * would work and do something
 */

public class FlowerController implements View.OnTouchListener, SeekBar.OnSeekBarChangeListener {
    private Flower flower;
    private TextView element;
    private PetalModel petalModel;
    private SeekBar redSB;
    private SeekBar greenSB;
    private SeekBar blueSB;
    private CharSequence currentElement;
    private int color;

    public FlowerController (Flower flower, TextView element, SeekBar redSB, SeekBar greenSB, SeekBar blueSB) {
        this.flower = flower;
        this.redSB = redSB;
        this.greenSB = greenSB;
        this.blueSB = blueSB;
        this.element = element;
        this.petalModel = flower.getPetal();
    }

    /**
     * onTouch method should determine what element was touched,
     * change the textview to that element
     * and adjust the seekbar to the color's values
     *
     * @param view
     * @param motionEvent
     * @return
     */

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();

        //Step 1. Figure out which element was touched
        //Step 2. Update the text view to reflect the current element
        //Step 3. Update color to be whatever element was touched
        if (petalModel.isTopPetalTouched(x, y)) {
            currentElement = petalModel.topPetal;
            element.setText(petalModel.topPetal);
            color = petalModel.topPetalColor;
        }
        else if (petalModel.isLeftPetalTouched(x, y)) {
            currentElement = petalModel.leftPetal;
            element.setText(petalModel.leftPetal);
            color = petalModel.leftPetalColor;
        }
        else if (petalModel.isBottLeftPetalTouched(x, y)) {
            currentElement = petalModel.bottLeftPetal;
            element.setText(petalModel.bottLeftPetal);
            color = petalModel.bottomLeftPetalColor;
        }
        else if (petalModel.isBottRightPetalTouched(x, y)) {
            currentElement = petalModel.bottRightPetal;
            element.setText(petalModel.bottRightPetal);
            color = petalModel.bottomRightPetalColor;
        }
        else if (petalModel.isRightPetalTouched(x,y)) {
            currentElement = petalModel.rightPetal;
            element.setText(petalModel.rightPetal);
            color = petalModel.rightPetalColor;
        }
        else if (petalModel.isStemTouched(x,y)) {
            currentElement = petalModel.stem;
            element.setText(petalModel.stem);
            color = petalModel.stemColor;
        }

        /**
         * External Citation
         * Date: October 7, 2024
         * Problem: Could not figure out how to adjust seekbar to reflect current element's RGB values
         *
         * Resource: AI
         * Solution: I copied the code that's now in step four
         */

        //Step 4.  modify the seekbars' progress values to reflect the current element's RGB values
        int red = (color >> 16) & 0xFF;
        int green = (color >> 8) & 0xFF;
        int blue = color & 0xFF;
        redSB.setProgress(red);
        greenSB.setProgress(green);
        blueSB.setProgress(blue);

        //Step 5:  Redraw the image (invalidate)
        flower.invalidate();

        return true;
    }

    /**
     *
     * onProgressChanged should change the color of the element that was recently touched
     * to the progress of all three of the seekbars
     *
     * @param seekBar
     * @param progress
     * @param b
     */

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
        //Step 1:  Get progress of each seekbar
        int red = redSB.getProgress();
        int green = greenSB.getProgress();
        int blue = blueSB.getProgress();

        //Step 2:  Calculate a color based on the RBG values
        color = Color.rgb(red, green, blue);

        //Step 3:  Set the color of the current element (if one is selected) to this new color
        if (currentElement != null) {
            if (currentElement == petalModel.topPetal) {
                petalModel.topPetalColor = color;
            }
            else if (currentElement == petalModel.leftPetal) {
                petalModel.leftPetalColor = color;
            }
            else if (currentElement == petalModel.bottLeftPetal) {
                petalModel.bottomLeftPetalColor = color;
            }
            else if (currentElement == petalModel.bottRightPetal) {
                petalModel.bottomRightPetalColor = color;
            }
            else if (currentElement == petalModel.rightPetal) {
                petalModel.rightPetalColor = color;
            }
            else if (currentElement == petalModel.stem) {
                petalModel.stemColor = color;
            }
        }

        //Step 4:  Redraw the image (invalidate)
        flower.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) { // do nothing
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) { // do nothing
    }
}
