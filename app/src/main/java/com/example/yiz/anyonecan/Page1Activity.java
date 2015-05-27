package com.example.yiz.anyonecan;

import android.os.Bundle;

public class Page1Activity extends BaseActivity {

    private final static int bobbySound = R.raw.b_1_3_2;
    private final static int kidsSound = R.raw.b_1_3_3;
    private final static int threeSound = R.raw.b_1_3_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);

        setPage(R.id.page1);

        createMediaButton(R.drawable.bobbybutton, R.id.bobbyBtn, bobbySound);
        createMediaButton(R.drawable.kidsbutton, R.id.kidsBtn, kidsSound);

        setClickableRelativeLayout(R.id.rl_p1_three, threeSound);
        setClickableRelativeLayout(R.id.rl_p1_bobby, bobbySound);
        setClickableRelativeLayout(R.id.rl_p1_children_left, kidsSound);
        setClickableRelativeLayout(R.id.rl_p1_children_right, kidsSound);
        setClickableRelativeLayout(R.id.rl_p1_children_center, kidsSound);
    }
}
