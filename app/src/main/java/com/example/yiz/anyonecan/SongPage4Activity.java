package com.example.yiz.anyonecan;

import android.os.Bundle;

public class SongPage4Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_page4);

        setPage(R.id.songbook_page4);

        createStoppableMediaButton(R.drawable.play, R.drawable.pause, R.id.playBtn, R.raw.song2_full);
        //createMediaButton(R.drawable.play, R.id.playBtn, R.raw.song2_full);

        //setClickableRelativeLayout(R.id.rl_song2_full, R.raw.song2_full);
        setClickableRelativeLayout(R.id.rl_song2_verse4, R.raw.song2_verse4);
        setClickableRelativeLayout(R.id.rl_song2_verse5, R.raw.song2_verse5);
    }
}
