package com.example.yiz.anyonecan;

import android.os.Bundle;

public class SongPage2Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_page2);

        setPage(R.id.songbook_page2);

        createStoppableMediaButton(R.drawable.play, R.drawable.pause, R.id.playBtn, R.raw.song1_full);
        //createMediaButton(R.drawable.play, R.id.playBtn, R.raw.song1_full);

        // setClickableRelativeLayout(R.id.rl_song1_full, R.raw.song1_full);
        setClickableRelativeLayout(R.id.rl_song1_verse4, R.raw.song1_verse4);
        setClickableRelativeLayout(R.id.rl_song1_verse5, R.raw.song1_verse5);
    }
}
