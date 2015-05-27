package com.example.yiz.anyonecan;

import android.os.Bundle;

public class SongPage3Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_page3);

        setPage(R.id.songbook_page3);

        createStoppableMediaButton(R.drawable.play, R.drawable.pause, R.id.playBtn, R.raw.song2_full);
        //createMediaButton(R.drawable.play, R.id.playBtn, R.raw.song2_full);

        //setClickableRelativeLayout(R.id.rl_song2_full, R.raw.song2_full);
        setClickableRelativeLayout(R.id.rl_song2_verse1, R.raw.song2_verse1);
        setClickableRelativeLayout(R.id.rl_song2_verse2, R.raw.song2_verse2);
        setClickableRelativeLayout(R.id.rl_song2_verse3, R.raw.song2_verse3);
    }
}
