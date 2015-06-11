package com.example.yiz.anyonecan;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.Random;

public class BaseActivity extends ImmersiveActivity {

    // protected GestureDetectorCompat gestureDetectorCompat = null;
    protected Page page = null;
    protected GlobalState state = null;
    protected MediaPlayer mp = null;
    protected MediaPlayer stoppableMp = null;
    protected Button stoppableBtn = null;
    private static int flip = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        flip = 1;
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
        state = (GlobalState) getApplicationContext();
        // gestureDetectorCompat = new GestureDetectorCompat(this, new MyGestureListener());
    }

    protected void setPage(int index) {
        page = state.getPage(index);
        setNavigationButtons();
    }

    protected void invertFlip() {
        flip = -1;
    }

    protected void setClickableRelativeLayout(int tvId, int mediaID) {
        RelativeLayout tv = (RelativeLayout) findViewById(tvId);
        tv.setOnClickListener(new MediaPlayerOnClickListener(mediaID));
        //  tv.setOnTouchListener(new tvOnTouchListener()); //enables swipe gesture also on TextViews
    }

    protected void createMediaButton(int bckgrndID, int layoutID, int mediaID) {
        RelativeLayout layout = (RelativeLayout) findViewById(layoutID);
        if (layout != null) {
            layout.setBackgroundResource(bckgrndID);
            layout.setOnClickListener(new MediaPlayerOnClickListener(mediaID, layout));
        }
    }

    private void setNavigationRV(Class target, int layoutID, int bckgrndID, int flipVal) {
        if (target != null) {
            RelativeLayout layout = (RelativeLayout) findViewById(layoutID);
            if (layout != null) {
                layout.setBackgroundResource(bckgrndID);
                layout.setOnClickListener(new NavOnClickListener(target, layout, flipVal));
            }
        }
    }

    protected void setNavigationButtons() {
        setNavigationRV(MenuActivity.class, R.id.homeBtn, R.drawable.homebtn, -1);
        setNavigationRV(page.getPrevious(), R.id.prevBtn, R.drawable.backwards, 1);
        setNavigationRV(page.getNext(), R.id.nextBtn, R.drawable.forward, -1);
    }

    class NavOnClickListener implements View.OnClickListener {
        private AnimateOnClick anim = null;
        private Navigation navigate = null;

        public NavOnClickListener(final Class target, RelativeLayout layout, int flipVal) {
            navigate = new Navigation() {
                @Override
                public void run() {
                    Intent intent = new Intent(getBaseContext(), target);
                    startActivity(intent);
                    finish();
                }
            };
            this.anim = randomAnimation(layout, flipVal);
        }

        @Override
        public void onClick(View v) {
            anim.click(navigate);
        }
    }

    //Generic onClick method to all app media
    class MediaPlayerOnClickListener implements View.OnClickListener {
        private Integer mediaID = null;
        private AnimateOnClick anim = null;

        public MediaPlayerOnClickListener(Integer mediaID) {
            this.mediaID = mediaID;
        }

        public MediaPlayerOnClickListener(Integer mediaID, RelativeLayout layout) {
            this(mediaID);
            this.anim = randomAnimation(layout, flip);
        }

        @Override
        public void onClick(View v) {
            if (anim != null) {
                anim.click();
            }

            if (stoppableBtn != null) {
                stoppableMp.pause();
                stoppableBtn.setBackgroundResource(R.drawable.play);
            }
            if (mp != null) {
                mp.release();
            }
            mp = MediaPlayer.create(getBaseContext(), mediaID);
            mp.start();
        }
    }

    protected static AnimateOnClick randomAnimation(RelativeLayout layout, int flipVal) {
        Random rand = new Random();
        int max = 3;
        int randomNum = rand.nextInt((max) + 1);
        AnimateOnClick anim = null;
        switch (randomNum) {
            case 0:
                anim = new ScaleOnClick(layout);
                break;

            case 1:
                anim = new SlideOnClick(layout, flipVal);
                break;

            case 2:
                anim = new RotateOnClick(layout);
                break;

            case 3:
                anim = new FadeOnClick(layout);
                break;
        }
        return anim;
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mp != null) {
            mp.release();
            mp = null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mp != null) {
            mp.release();
            mp = null;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mp != null) {
            mp.release();
            mp = null;
        }
    }

    //    //enables swipe gesture also on TextViews
//    class tvOnTouchListener implements View.OnTouchListener {
//        @Override
//        public boolean onTouch(View v, MotionEvent event) {
//            gestureDetectorCompat.onTouchEvent(event);
//            return false; //return true will ignore the click event, onClick won't be called
//        }
//    }

//    @Override
//    public boolean onTouchEvent(MotionEvent event) {
//        this.gestureDetectorCompat.onTouchEvent(event);
//        return super.onTouchEvent(event);
//    }
//
//    class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
//        @Override
//        public boolean onFling(MotionEvent event1, MotionEvent event2,
//                               float velocityX, float velocityY) {
//            Class targetPage = null;
//            if (event2.getX() < event1.getX()) {//next page
//                //switch another activity
//                targetPage = page.getNext();
//            } else if (event2.getX() > event1.getX()) {//previous page
//                //switch another activity
//                targetPage = page.getPrevious();
//            }
//
//            if (targetPage != null) {//there is prev/next page
//                Intent intent = new Intent(
//                        getBaseContext(), targetPage);
//                startActivity(intent);
//            }
//            return true;
//        }
//    }
}
