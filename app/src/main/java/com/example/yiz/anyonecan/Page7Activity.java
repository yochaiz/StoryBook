package com.example.yiz.anyonecan;

import android.os.Bundle;

public class Page7Activity extends BaseActivity {

    private final static int bobbySound = R.raw.b_1_3_12;
    private final static int childSound = R.raw.b_1_3_13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page7);

        setPage(R.id.page7);

        createMediaButton(R.drawable.bobbybutton, R.id.bobbyBtn, bobbySound);
        createMediaButton(R.drawable.child4, R.id.child4Btn, childSound);

        setClickableRelativeLayout(R.id.rl_p7_bobby_left, bobbySound);
        setClickableRelativeLayout(R.id.rl_p7_bobby_right, bobbySound);
        setClickableRelativeLayout(R.id.rl_p7_children, childSound);
    }
}
