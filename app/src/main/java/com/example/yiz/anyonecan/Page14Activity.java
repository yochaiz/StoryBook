package com.example.yiz.anyonecan;

import android.os.Bundle;

public class Page14Activity extends BaseActivity {

    private final static int bobbySound = R.raw.b_1_3_27;
    private final static int childSound = R.raw.b_1_3_26;
    private final static int song = R.raw.b_1_3_28;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page14);

        setPage(R.id.page14);

        invertFlip();
        createMediaButton(R.drawable.child6, R.id.child6Btn_1, childSound);
        createMediaButton(R.drawable.bobbybutton, R.id.bobbyBtn, bobbySound);
        createMediaButton(R.drawable.child6, R.id.child6Btn_2, song);

        setClickableRelativeLayout(R.id.rl_p14_bobby, bobbySound);
        setClickableRelativeLayout(R.id.rl_p14_child, childSound);
    }
}
