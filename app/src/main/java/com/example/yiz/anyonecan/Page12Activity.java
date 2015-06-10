package com.example.yiz.anyonecan;

import android.os.Bundle;

public class Page12Activity extends BaseActivity {

    private final static int bobbySound = R.raw.b_1_3_23;
    private final static int childSound = R.raw.b_1_3_22;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page12);

        setPage(R.id.page12);

        invertFlip();
        createMediaButton(R.drawable.child7, R.id.child7Btn, childSound);
        createMediaButton(R.drawable.bobbybutton, R.id.bobbyBtn, bobbySound);

        setClickableRelativeLayout(R.id.rl_p12_bobby, bobbySound);
        setClickableRelativeLayout(R.id.rl_p12_child, childSound);
    }
}
