package com.example.yiz.anyonecan;

import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.RelativeLayout;

public final class RotateOnClick extends AnimateOnClick {
    private static float fromDeg = 0f;
    private static float toDeg = 360f;
    private static int pivotType = Animation.RELATIVE_TO_SELF;
    private static float pivotX = 0.5f;
    private static float pivotY = 0.5f;
    private static final int repeat = 0;

    public RotateOnClick(RelativeLayout layout) {
        super((RelativeLayout) layout.getParent().getParent(), layout, repeat);
    }

    protected Animation createAnimation() {
        return new RotateAnimation(fromDeg, toDeg, pivotType, pivotX, pivotType, pivotY);
    }
}
