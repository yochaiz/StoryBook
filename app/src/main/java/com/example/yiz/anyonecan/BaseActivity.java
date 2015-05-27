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
    private MediaPlayer mp = null;

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

//    protected void setClickableButton(int btnId, int mediaID) {
//        Button btn = (Button) findViewById(btnId);
//        btn.setOnClickListener(new MediaPlayerOnClickListener(mediaID));
//    }

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

    protected void createStoppableMediaButton(int playBtn, int stopBtn, int layoutID, int mediaID) {
        Button btn = (Button) findViewById(layoutID);
        if (btn != null) {
            //Button btn = createNavigationButton(playBtn);
            btn.setBackgroundResource(playBtn);
            btn.setOnClickListener(new StoppableMediaPlayerOnClickListener(mediaID, playBtn, stopBtn, btn));
            //layout.addView(btn);
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

//    //enables swipe gesture also on TextViews
//    class tvOnTouchListener implements View.OnTouchListener {
//        @Override
//        public boolean onTouch(View v, MotionEvent event) {
//            gestureDetectorCompat.onTouchEvent(event);
//            return false; //return true will ignore the click event, onClick won't be called
//        }
//    }

    class StoppableMediaPlayerOnClickListener implements View.OnClickListener {
        private Integer mediaID = null;
        private Integer playBtn = null;
        private Integer stopBtn = null;
        private Button btn = null;
        private Boolean isStopped = true;
        private int currentPos = 0;
        private int sessionID = 0;

        public StoppableMediaPlayerOnClickListener(Integer mediaID, Integer playBtn, Integer stopBtn, Button btn) {
            this.mediaID = mediaID;
            this.playBtn = playBtn;
            this.stopBtn = stopBtn;
            this.btn = btn;
            this.isStopped = true;
        }

        @Override
        public void onClick(View v) {
            if (mp == null) {
                mp = MediaPlayer.create(getBaseContext(), mediaID);
                currentPos = 0;
                btn.setBackgroundResource(stopBtn);
                isStopped = false;
                sessionID = mp.getAudioSessionId();

                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        currentPos = 0;
                        btn.setBackgroundResource(playBtn);
                        isStopped = true;
                    }
                });

                mp.start();
            } else if (mp.getAudioSessionId() == sessionID) {
                if (!isStopped) {
                    mp.pause();
                    currentPos = mp.getCurrentPosition();
                    btn.setBackgroundResource(playBtn);
                    isStopped = true;
                } else {
                    mp.seekTo(currentPos);
                    btn.setBackgroundResource(stopBtn);
                    isStopped = false;
                    mp.start();
                }
            } else {
                mp.release();
                mp = MediaPlayer.create(getBaseContext(), mediaID);
                currentPos = 0;
                btn.setBackgroundResource(stopBtn);
                isStopped = false;
                sessionID = mp.getAudioSessionId();

                mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        currentPos = 0;
                        btn.setBackgroundResource(playBtn);
                        isStopped = true;
                    }
                });

                mp.start();
            }
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
            Button btn = (Button) findViewById(R.id.playBtn);
            if (btn != null) {
                btn.setBackgroundResource(R.drawable.play);
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


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) { //TODO: create base activity class that overrides this function
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//
//        if (page.getPrevious() == null) {
//            menu.removeItem(R.id.prev_page);
//        }
//        if (page.getNext() == null) {
//            menu.removeItem(R.id.next_page);
//        }
//
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        switch (id) {
//            case R.id.prev_page: {
//                Intent intent = new Intent(getBaseContext(), page.getPrevious());
//                startActivity(intent);
//                return true;
//            }
//            case R.id.next_page: {
//                Intent intent = new Intent(getBaseContext(), page.getNext());
//                startActivity(intent);
//                return true;
//            }
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }
}
