package com.example.yiz.anyonecan;

import android.os.Bundle;

public class Page6Activity extends BaseActivity {

    private final static int bobbySound = R.raw.b_1_3_10;
    private final static int childSound = R.raw.b_1_3_11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page6);

        setPage(R.id.page6);

        createMediaButton(R.drawable.bobbybutton, R.id.bobbyBtn, bobbySound);
        createMediaButton(R.drawable.child4, R.id.child4Btn, childSound);

        setClickableRelativeLayout(R.id.rl_p6_bobby_left, bobbySound);
        setClickableRelativeLayout(R.id.rl_p6_bobby_right, bobbySound);
        setClickableRelativeLayout(R.id.rl_p6_children, childSound);
    }
}
