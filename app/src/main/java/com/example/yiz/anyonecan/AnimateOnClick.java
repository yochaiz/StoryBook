package com.example.yiz.anyonecan;

import android.view.View;
import android.view.animation.Animation;
import android.widget.RelativeLayout;

public abstract class AnimateOnClick {
    RelativeLayout clickableLayout = null;
    RelativeLayout layout = null;
    int duration = 1000;
    int repeat = 1;

    protected AnimateOnClick(RelativeLayout layout) {
        this.layout = layout;
        this.clickableLayout = layout;
    }

    protected AnimateOnClick(RelativeLayout layout, RelativeLayout clickableLayout) {
        this.layout = layout;
        this.clickableLayout = clickableLayout;
    }

    protected AnimateOnClick(RelativeLayout layout, RelativeLayout clickableLayout, int repeat) {
        this(layout, clickableLayout);
        this.repeat = repeat;
    }

    protected abstract Animation createAnimation();

    private void run(Animation.AnimationListener animListener) {
        clickableLayout.setClickable(false);
        Animation anim = createAnimation();
        anim.setDuration(duration); // 1000 ms = 1second
        anim.setRepeatCount(repeat);
        anim.setRepeatMode(Animation.REVERSE);
        anim.setAnimationListener(animListener);
        layout.startAnimation(anim);
    }

    public void click() {
        Navigation navigate = new Navigation() {
            @Override
            public void run() {
                clickableLayout.setClickable(true);
            }
        };
        run(new AnimListener(navigate));
    }

    public void click(final Navigation navigate) {
        Navigation newNavigate = new Navigation() {
            @Override
            public void run() {
                navigate.run();
                clickableLayout.setClickable(true);
            }
        };
        run(new AnimListener(newNavigate));
    }
}

