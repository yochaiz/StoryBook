package com.example.yiz.anyonecan;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import static android.widget.RelativeLayout.*;

public class BaseActivity extends Activity {

    protected GestureDetectorCompat gestureDetectorCompat = null;
    protected Page page = null;
    protected GlobalState state = null;
    private MediaPlayer mp = null;
    private int nextBtnID = R.id.nextBtn;
    private int prevBtnID = R.id.prevBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        state = (GlobalState) getApplicationContext();
        gestureDetectorCompat = new GestureDetectorCompat(this, new MyGestureListener());
    }

    protected int dipToPixels(int dip) {
        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dip, getResources().getDisplayMetrics());
        return px;
    }

    protected void setPage(int index) {
        page = state.getPage(index);
        setNavigationButtons();
    }

    protected void setClickableTextView(int tvId, int mediaID) {
        TextView tv = (TextView) findViewById(tvId);
        tv.setOnClickListener(new MediaPlayerOnClickListener(mediaID));
        tv.setOnTouchListener(new tvOnTouchListener()); //enables swipe gesture also on TextViews
    }

    protected void setClickableButton(Button btn, int btnId, int mediaID) {
        btn = (Button) findViewById(btnId);
        btn.setOnClickListener(new MediaPlayerOnClickListener(mediaID));
    }

    //private Button createNavigationButton(int bckgrndID, int rule, int bottomMargin, int leftMargin, int rightMargin) {
    private Button createNavigationButton(int bckgrndID) {
        Button btn = new Button(this);
        btn.setBackgroundResource(bckgrndID);
        //int px = dipToPixels(100);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        //params.addRule(rule);
        //params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        //params.setMargins(leftMargin, 0, rightMargin, bottomMargin);
        btn.setLayoutParams(params);
        return btn;
    }

    private void addBtnToView(Button btn, Class target, int layoutID) {
        RelativeLayout layout = (RelativeLayout) findViewById(layoutID);
        btn.setOnClickListener(new NavOnClickListener(target));
        layout.addView(btn);
    }

    protected void setNavigationButtons() {
        //int px = dipToPixels(50);
        // RelativeLayout layout = (RelativeLayout) findViewById(pageID);
        Button btn = null;
        Class target = page.getPrevious();
        if (target != null) {
            //btn = createNavigationButton(R.drawable.backwards, ALIGN_PARENT_LEFT, px, px, 0);
            btn = createNavigationButton(R.drawable.backwards);
            addBtnToView(btn, target, prevBtnID);
        }
        target = page.getNext();
        if (target != null) {
            // btn = createNavigationButton(R.drawable.forward, ALIGN_PARENT_RIGHT, px, 0, px);
            btn = createNavigationButton(R.drawable.forward);
            addBtnToView(btn, target, nextBtnID);
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
        }
    }

    //enables swipe gesture also on TextViews
    class tvOnTouchListener implements View.OnTouchListener {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            gestureDetectorCompat.onTouchEvent(event);
            return false; //return true will ignore the click event, onClick won't be called
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

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetectorCompat.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    class MyGestureListener extends GestureDetector.SimpleOnGestureListener {
        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2,
                               float velocityX, float velocityY) {
            Class targetPage = null;
            if (event2.getX() < event1.getX()) {//next page
                //switch another activity
                targetPage = page.getNext();
            } else if (event2.getX() > event1.getX()) {//previous page
                //switch another activity
                targetPage = page.getPrevious();
            }

            if (targetPage != null) {//there is prev/next page
                Intent intent = new Intent(
                        getBaseContext(), targetPage);
                startActivity(intent);
            }
            return true;
        }
    }

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
