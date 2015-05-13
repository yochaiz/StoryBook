package com.example.yiz.anyonecan;

import android.os.Bundle;

public class Page1Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);

        setPage(R.id.page1);

        setClickableRelativeLayout(R.id.rl_p1_three, R.raw.b_1_3_1);
        setClickableRelativeLayout(R.id.rl_p1_bobby, R.raw.b_1_3_2);
        setClickableRelativeLayout(R.id.rl_p1_children_left, R.raw.b_1_3_3);
        setClickableRelativeLayout(R.id.rl_p1_children_right, R.raw.b_1_3_3);

        //setClickableButton(btn_bobby, R.id.btn_p1_bobby, R.raw.b_1_3_2);
    }

}
