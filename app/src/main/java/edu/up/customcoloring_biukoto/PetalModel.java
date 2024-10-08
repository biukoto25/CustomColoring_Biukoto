package edu.up.customcoloring_biukoto;

/**
 * author: Becca Biukoto
 * date: 10/07/2024
 *
 * PetalModel contains the six elements, their locations,
 * names, and colors.
 */

public class PetalModel {

    // names of petals and stem
    public CharSequence topPetal = "Top Petal";
    public CharSequence leftPetal = "Left Petal";
    public CharSequence bottRightPetal = "Bottom Right Petal";
    public CharSequence bottLeftPetal = "Bottom Left Petal";
    public CharSequence rightPetal = "Right Petal";
    public CharSequence stem = "Stem";

    // colors of petals and stem
    public int topPetalColor = 0xFFF3D4D5; // pink
    public int leftPetalColor = 0xFFF3D4D5; // pink
    public int bottomLeftPetalColor = 0xFFF3D4D5; // pink
    public int bottomRightPetalColor = 0xFFF3D4D5; // pink
    public int rightPetalColor = 0xFFF3D4D5; // pink
    public int stemColor = 0xFF228B22; // green

    // locations of petals and stem in the following helper methods
    public boolean isTopPetalTouched(float x, float y) {
        if (x >= 940 && x <= 1335 && y >= 315 && y <= 485) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isLeftPetalTouched(float x, float y) {
        if (x >= 840 && x <= 1010 && y >= 405 && y <= 575) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isBottLeftPetalTouched(float x, float y) {
        if (x >= 885 && x <= 1055 && y >= 490 && y <= 660) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isBottRightPetalTouched(float x, float y) {
        if (x >= 980 && x <= 1150 && y >= 490 && y <= 660) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isRightPetalTouched(float x, float y) {
        if (x >= 1030 && x <= 1200 && y >= 415 && y <= 585) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isStemTouched(float x, float y) {
        if (x >= 1000 && x<= 1050 && y >= 500 && y <= 1000) {
            return true;
        } else {
            return false;
        }
    }
}
