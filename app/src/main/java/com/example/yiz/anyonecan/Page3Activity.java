package com.example.yiz.anyonecan;

import android.os.Bundle;

public class Page3Activity extends BaseActivity {

    private final static int kidsSound = R.raw.b_1_3_5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);

        setPage(R.id.page3);

        createMediaButton(R.drawable.kidsbutton, R.id.kidsBtn, kidsSound);

        setClickableRelativeLayout(R.id.rl_p3_children, kidsSound);
    }
}
