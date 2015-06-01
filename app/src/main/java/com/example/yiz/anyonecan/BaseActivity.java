package com.example.yiz.anyonecan;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class BaseActivity extends Activity {

    // protected GestureDetectorCompat gestureDetectorCompat = null;
    protected Page page = null;
    protected GlobalState state = null;
    protected MediaPlayer mp = null;
    protected MediaPlayer stoppableMp = null;
    protected Button stoppableBtn = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE);
        state = (GlobalState) getApplicationContext();
        // gestureDetectorCompat = new GestureDetectorCompat(this, new MyGestureListener());
    }

    protected void setPage(int index) {
        page = state.getPage(index);
        setNavigationButtons();
    }

    protected void setClickableRelativeLayout(int tvId, int mediaID) {
        RelativeLayout tv = (RelativeLayout) findViewById(tvId);
        tv.setOnClickListener(new MediaPlayerOnClickListener(mediaID));
        //  tv.setOnTouchListener(new tvOnTouchListener()); //enables swipe gesture also on TextViews
    }

    private Button createNavigationButton(int bckgrndID) {
        Button btn = new Button(this);
        btn.setBackgroundResource(bckgrndID);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        btn.setLayoutParams(params);
        return btn;
    }

    protected void createMediaButton(int bckgrndID, int layoutID, int mediaID) {
        RelativeLayout layout = (RelativeLayout) findViewById(layoutID);
        if (layout != null) {
            Button btn = createNavigationButton(bckgrndID);
            btn.setOnClickListener(new MediaPlayerOnClickListener(mediaID));
            layout.addView(btn);
        }
    }

    private void addBtnToView(Button btn, Class target, int layoutID) {
        RelativeLayout layout = (RelativeLayout) findViewById(layoutID);
        if (layout != null) {
            btn.setOnClickListener(new NavOnClickListener(target));
            layout.addView(btn);
        }
    }

    protected void setNavigationButtons() {
        Button btn = createNavigationButton(R.drawable.homebtn);
        addBtnToView(btn, MenuActivity.class, R.id.homeBtn);
        Class target = page.getPrevious();
        if (target != null) {
            btn = createNavigationButton(R.drawable.backwards);
            addBtnToView(btn, target, R.id.prevBtn);
        }
        target = page.getNext();
        if (target != null) {
            btn = createNavigationButton(R.drawable.forward);
            addBtnToView(btn, target, R.id.nextBtn);
        }
    }

    class NavOnClickListener implements View.OnClickListener {
        private Class target = null;

        public NavOnClickListener(Class target) {
            this.target = target;
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getBaseContext(), this.target);
            startActivity(intent);
            finish();
        }
    }

    //Generic onClick method to all app media
    class MediaPlayerOnClickListener implements View.OnClickListener {
        private Integer mediaID = null;

        public MediaPlayerOnClickListener(Integer mediaID) {
            this.mediaID = mediaID;
        }

        @Override
        public void onClick(View v) {
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
