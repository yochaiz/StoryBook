package com.example.yiz.anyonecan;

import android.os.Bundle;

public class Page13Activity extends BaseActivity {

    private final static int bobbySound = R.raw.b_1_3_25;
    private final static int childSound = R.raw.b_1_3_24;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page13);

        setPage(R.id.page13);

        createMediaButton(R.drawable.child8, R.id.child8Btn, childSound);
        createMediaButton(R.drawable.bobbybutton, R.id.bobbyBtn, bobbySound);

        setClickableRelativeLayout(R.id.rl_p13_bobby, bobbySound);
        setClickableRelativeLayout(R.id.rl_p13_child, childSound);
    }
}
