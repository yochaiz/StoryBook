package com.example.yiz.anyonecan;

import android.os.Bundle;

public class WordPage1Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_page1);

        setPage(R.id.wordbook_page1);

        setClickableRelativeLayout(R.id.rl_word_number, R.raw.word_number);
        setClickableRelativeLayout(R.id.rl_word_one, R.raw.word_one);
        setClickableRelativeLayout(R.id.rl_word_two, R.raw.word_two);
        setClickableRelativeLayout(R.id.rl_word_three, R.raw.word_three);
        setClickableRelativeLayout(R.id.rl_word_four, R.raw.word_four);
        setClickableRelativeLayout(R.id.rl_word_five, R.raw.word_five);
    }
}
