package com.example.yiz.anyonecan;

import android.os.Bundle;

public class Page11Activity extends BaseActivity {

    private final static int bobbySound = R.raw.b_1_3_21;
    private final static int childSound = R.raw.b_1_3_20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page11);

        setPage(R.id.page11);

        invertFlip();
        createMediaButton(R.drawable.child6, R.id.child6Btn, childSound);
        createMediaButton(R.drawable.bobbybutton, R.id.bobbyBtn, bobbySound);

        setClickableRelativeLayout(R.id.rl_p11_bobby, bobbySound);
        setClickableRelativeLayout(R.id.rl_p11_child, childSound);
    }
}
