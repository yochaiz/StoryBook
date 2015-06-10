package com.example.yiz.anyonecan;

import android.view.animation.Animation;
import android.widget.RelativeLayout;

public abstract class AnimateOnClick {
    RelativeLayout layout = null;
    int duration = 1000;
    int repeat = 1;

    //    private void disableClipOnParents(View v) {
//        if (v.getParent() == null) {
//            return;
//        }
//        if (v instanceof ViewGroup) {
//            ((ViewGroup) v).setClipChildren(false);
//        }
//        if (v.getParent() instanceof View) {
//            disableClipOnParents((View) v.getParent());
//        }
//    }

    protected AnimateOnClick(RelativeLayout layout) {
        this.layout = layout;
    }

    protected AnimateOnClick(RelativeLayout layout, int repeat) {
        this(layout);
        this.repeat = repeat;
    }

    protected abstract Animation createAnimation();

    private void run(Animation.AnimationListener animListener) {
        layout.setClickable(false);
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
                layout.setClickable(true);
            }
        };
        run(new AnimListener(navigate));
    }

    public void click(final Navigation navigate) {
        Navigation newNavigate = new Navigation() {
            @Override
            public void run() {
                navigate.run();
                layout.setClickable(true);
            }
        };
        run(new AnimListener(newNavigate));
    }
}

