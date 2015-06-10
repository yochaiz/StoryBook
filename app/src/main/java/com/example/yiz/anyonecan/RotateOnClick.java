package com.example.yiz.anyonecan;

import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.RelativeLayout;

import java.util.Random;

public final class RotateOnClick extends AnimateOnClick {
    private float fromDeg = 0f;
    private float toDeg = 360f;
    private static int pivotType = Animation.RELATIVE_TO_SELF;
    private static float pivotX = 0.5f;
    private static float pivotY = 0.5f;
    private static final int repeat = 0;

    public RotateOnClick(RelativeLayout layout) {
        super(layout, repeat);

        Random rand = new Random();
        int max = 1;
        int randomNum = rand.nextInt((max) + 1);
        if (randomNum == 1) { //randomize rotate direction: clockwise, counter-clockwise
            fromDeg = 360f;
            toDeg = 0f;
        }
    }

    protected Animation createAnimation() {
        return new RotateAnimation(fromDeg, toDeg, pivotType, pivotX, pivotType, pivotY);
    }
}
