package com.example.yiz.anyonecan;

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


public class VideoSongsActivity extends BaseActivity {
    private VideoView videoView1;
    private VideoView videoView2;
    private VideoView videoView3;


    public void onCreate(Bundle b) {
        super.onCreate(b);
        setContentView(R.layout.activity_video_songs);
        setPage(R.id.video_songs_animation);

        // Setup a play button to start the video
        final Button mPlayButton = (Button) findViewById(R.id.play_button);
        videoView1 = (VideoView) findViewById(R.id.video_view1);
        videoView2 = (VideoView) findViewById(R.id.video_view2);
        videoView3 = (VideoView) findViewById(R.id.video_view3);
        videoView1.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_song_1));
        videoView2.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_song_2));
        videoView3.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_song_3));
        videoView2.setVisibility(View.GONE);
        videoView3.setVisibility(View.GONE);

        videoView1.seekTo(100);


        videoView1.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                videoView1.stopPlayback();
                videoView2.setVisibility(View.VISIBLE);
                videoView1.setVisibility(View.GONE);
                videoView2.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_song_2));
                videoView2.start();
            }
        });

        videoView2.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                videoView2.stopPlayback();
                videoView3.setVisibility(View.VISIBLE);
                videoView2.setVisibility(View.GONE);
                videoView3.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_song_3));
                videoView3.start();
            }
        });

        videoView3.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                videoView3.stopPlayback();
                mPlayButton.setVisibility(View.VISIBLE);
            }
        });

        mPlayButton.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View v) {
                                               videoView1.setVisibility(View.VISIBLE);
                                               videoView3.setVisibility(View.GONE);
                                               videoView2.setVisibility(View.GONE);
                                               videoView1.start();
                                               // hide button once playback starts
                                               mPlayButton.setVisibility(View.GONE);
                                           }
                                       }
        );
    }

    public void onResume() {
        super.onResume();
        videoView1 = (VideoView) findViewById(R.id.video_view1);
        Button mPlayButton = (Button) findViewById(R.id.play_button);
        mPlayButton.setVisibility(View.VISIBLE);
        videoView1.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_song_1));
        videoView1.setVisibility(View.VISIBLE);
        videoView3.setVisibility(View.GONE);
        videoView2.setVisibility(View.GONE);
        if (!videoView1.isPlaying()) {
            videoView1.seekTo(100);
        }
    }

}
