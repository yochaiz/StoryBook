package com.example.yiz.anyonecan;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;


public class VideoSong1Activity extends BaseActivity {

    private VideoView mPlayer = null;
    private Button mPlayButton = null;

    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_video_song1);
        setPage(R.id.video_song_animation1);

        // Setup a play button to start the video
        mPlayButton = (Button) findViewById(R.id.play_button);
        mPlayer = (VideoView) findViewById(R.id.video_view);

        mPlayer.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_song_1));
        if (!mPlayer.isPlaying()) {
            mPlayer.seekTo(500);
        }

        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mPlayButton.setVisibility(View.VISIBLE);
                //finish();
            }
        });

        mPlayer.setOnTouchListener(mPlayerOnTouch);

        mPlayButton.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View v) {
                                               mPlayer.start();
                                               // hide button once playback starts
                                               mPlayButton.setVisibility(View.GONE);
                                           }
                                       }
        );
    }

    private View.OnTouchListener mPlayerOnTouch = new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (mPlayer.isPlaying()) {
                mPlayer.pause();
                mPlayButton.setVisibility(View.VISIBLE);
            }
            return false;
        }
    };

    public void onResume() {
        super.onResume();
        mPlayer = (VideoView) findViewById(R.id.video_view);
        Button mPlayButton = (Button) findViewById(R.id.play_button);
        mPlayButton.setVisibility(View.VISIBLE);
        mPlayer.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_song_1));
        if (!mPlayer.isPlaying()) {
            mPlayer.seekTo(500);
        }
    }
}

