package com.example.yiz.anyonecan;

import android.os.Bundle;

public class Page2Activity extends BaseActivity {

    private final static int bobbySound = R.raw.b_1_3_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        setPage(R.id.page2);

        createMediaButton(R.drawable.bobbybutton, R.id.bobbyBtn, bobbySound);

        setClickableRelativeLayout(R.id.rl_p2_bobby, bobbySound);
    }
}
