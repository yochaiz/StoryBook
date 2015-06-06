package com.example.yiz.anyonecan;

import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;

public final class SlideOnClick extends AnimateOnClick {
    private static int xLength = 150;

    public SlideOnClick(RelativeLayout layout) {
        super(layout);
    }

    protected Animation createAnimation() {
        return new TranslateAnimation(0, xLength, 0, 0);
    }
}
