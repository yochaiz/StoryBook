package com.example.yiz.anyonecan;

import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;

public final class ScaleOnClick extends AnimateOnClick {
    private static float scaleFactor = 1.5f;
    private static float scaleXfrom = 0f;
    private static float scaleXto = 0f;
    private static float scaleYfrom = 0f;
    private static float scaleYto = 0f;
    private static int pivotType = Animation.RELATIVE_TO_SELF;
    private static float pivotX = 0.4f;
    private static float pivotY = 0.5f;

    public ScaleOnClick(RelativeLayout layout) {
        super(layout);

        scaleXfrom = layout.getScaleX();
        scaleYfrom = layout.getScaleY();
        scaleXto = scaleXfrom * scaleFactor;
        scaleYto = scaleYfrom * scaleFactor;
    }

    protected Animation createAnimation() {
        return new ScaleAnimation(scaleXfrom, scaleXto, scaleYfrom, scaleYto, pivotType, pivotX, pivotType, pivotY);
    }
}

