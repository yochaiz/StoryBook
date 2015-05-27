package com.example.yiz.anyonecan;

import android.os.Bundle;

public class SongPage1Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_page1);

        setPage(R.id.songbook_page1);

        createStoppableMediaButton(R.drawable.play,R.drawable.pause, R.id.playBtn, R.raw.song1_full);

        //setClickableRelativeLayout(R.id.rl_song1_full, R.raw.song1_full);
        setClickableRelativeLayout(R.id.rl_song1_verse1, R.raw.song1_verse1);
        setClickableRelativeLayout(R.id.rl_song1_verse2, R.raw.song1_verse2);
        setClickableRelativeLayout(R.id.rl_song1_verse3, R.raw.song1_verse3);
    }
}
