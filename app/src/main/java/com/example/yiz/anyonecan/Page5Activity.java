package com.example.yiz.anyonecan;

import android.os.Bundle;

public class Page5Activity extends BaseActivity {

    private final static int bobbySound = R.raw.b_1_3_8;
    private final static int childSound = R.raw.b_1_3_9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page5);

        setPage(R.id.page5);

        createMediaButton(R.drawable.bobbybutton, R.id.bobbyBtn, bobbySound);
        createMediaButton(R.drawable.child2, R.id.child2Btn, childSound);

        setClickableRelativeLayout(R.id.rl_p5_bobby, bobbySound);
        setClickableRelativeLayout(R.id.rl_p5_child, childSound);
    }
}
