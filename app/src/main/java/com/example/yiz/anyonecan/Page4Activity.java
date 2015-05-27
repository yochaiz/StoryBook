package com.example.yiz.anyonecan;

import android.os.Bundle;

public class Page4Activity extends BaseActivity {

    private final static int bobbySound = R.raw.b_1_3_6;
    private final static int childSound = R.raw.b_1_3_7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page4);

        setPage(R.id.page4);

        createMediaButton(R.drawable.bobbybutton, R.id.bobbyBtn, bobbySound);
        createMediaButton(R.drawable.child1, R.id.child1Btn, childSound);

        setClickableRelativeLayout(R.id.rl_p4_bobby, bobbySound);
        setClickableRelativeLayout(R.id.rl_p4_child, childSound);
    }
}
