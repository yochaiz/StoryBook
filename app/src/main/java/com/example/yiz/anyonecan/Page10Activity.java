package com.example.yiz.anyonecan;

import android.os.Bundle;

public class Page10Activity extends BaseActivity {

    private final static int bobbySound = R.raw.b_1_3_19;
    private final static int childSound = R.raw.b_1_3_18;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page10);

        setPage(R.id.page10);

        createMediaButton(R.drawable.child5, R.id.child5Btn, childSound);
        createMediaButton(R.drawable.bobbybutton, R.id.bobbyBtn, bobbySound);

        setClickableRelativeLayout(R.id.rl_p10_bobby, bobbySound);
        setClickableRelativeLayout(R.id.rl_p10_child, childSound);
    }
}
