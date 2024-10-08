package edu.up.customcoloring_biukoto;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * author: Becca Biukoto
 * date: 10/07/2024
 */

public class MainActivity extends AppCompatActivity {
    private Flower flower;
    private SeekBar redSeekBar;
    private SeekBar greenSeekBar;
    private SeekBar blueSeekBar;
    private TextView textView;

    /**
     * register listeners with view
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flower = findViewById(R.id.surfaceView); // surface view
        redSeekBar = findViewById(R.id.redSeekBar); // red seek bar
        greenSeekBar = findViewById(R.id.greenSeekBar); // green seek bar
        blueSeekBar = findViewById(R.id.blueSeekBar); // blue seek bar
        textView = findViewById(R.id.element); // textview change


        //Register the controller with the views it's listening (Step 3)
        FlowerController fc = new FlowerController(flower, textView, redSeekBar, greenSeekBar, blueSeekBar);
        flower.setOnTouchListener(fc);
        redSeekBar.setOnSeekBarChangeListener(fc);
        greenSeekBar.setOnSeekBarChangeListener(fc);
        blueSeekBar.setOnSeekBarChangeListener(fc);

    }

}