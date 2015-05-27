package com.example.yiz.anyonecan;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;



public class VideoStory2Activity extends BaseActivity  {

    private VideoView mPlayer;

    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_video_story2);
        setPage(R.id.video_story_animation2);

        // Setup a play button to start the video
        final Button mPlayButton = (Button) findViewById(R.id.play_button);
        mPlayer = (VideoView)findViewById(R.id.video_view);

        mPlayer.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_story_2));
        if (!mPlayer.isPlaying()) {
            mPlayer.seekTo(100);
        }

        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                mPlayButton.setVisibility(View.VISIBLE);
                //finish();
            }
        });
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

    public void onResume(){
        super.onResume();
        mPlayer = (VideoView)findViewById(R.id.video_view);
        Button mPlayButton = (Button) findViewById(R.id.play_button);
        mPlayButton.setVisibility(View.VISIBLE);
        mPlayer.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_story_2));
        if (!mPlayer.isPlaying()) {
            mPlayer.seekTo(100);
        }
    }

}
