package com.example.yiz.anyonecan;


import android.media.MediaPlayer;
import android.view.View;
import android.widget.Button;

public class SongActivity extends BaseActivity {

    private Integer playBtn = R.drawable.play;
    private Integer stopBtn = R.drawable.pause;
    private Integer layoutID = R.id.playBtn;

    protected void createStoppableMediaButton(int mediaID) {
        stoppableBtn = (Button) findViewById(layoutID);
        if (stoppableBtn != null) {
            stoppableBtn.setBackgroundResource(playBtn);
            stoppableBtn.setOnClickListener(new StoppableMediaPlayerOnClickListener(mediaID));
        }
    }

    private class StoppableMediaPlayerOnClickListener implements View.OnClickListener {

        public StoppableMediaPlayerOnClickListener(Integer mediaID) {
            stoppableMp = MediaPlayer.create(getBaseContext(), mediaID);
            stoppableMp.setOnCompletionListener(mpOnComplete);
        }

        private MediaPlayer.OnCompletionListener mpOnComplete = new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stoppableMp.seekTo(0);
                stoppableBtn.setBackgroundResource(playBtn);
            }
        };

        @Override
        public void onClick(View v) {
            if (mp != null) {
                mp.release();
                mp = null;
            }
            if (stoppableMp.isPlaying()) {
                stoppableMp.pause();
                stoppableBtn.setBackgroundResource(playBtn);
            } else {
                stoppableMp.start();
                stoppableBtn.setBackgroundResource(stopBtn);
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (stoppableMp != null) {
            stoppableMp.pause();
            stoppableBtn.setBackgroundResource(playBtn);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (stoppableMp != null) {
            stoppableMp.release();
            stoppableMp = null;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (stoppableMp != null) {
            stoppableMp.pause();
            stoppableBtn.setBackgroundResource(playBtn);
        }
    }
}
