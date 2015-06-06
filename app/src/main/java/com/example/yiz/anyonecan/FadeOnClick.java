package com.example.yiz.anyonecan;


import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.RelativeLayout;

public final class FadeOnClick extends AnimateOnClick {
    private static float from = 1f;
    private static float to = 0.2f;

    public FadeOnClick(RelativeLayout layout) {
        super(layout);
    }

    protected Animation createAnimation() {
        return new AlphaAnimation(from, to);
    }
}
