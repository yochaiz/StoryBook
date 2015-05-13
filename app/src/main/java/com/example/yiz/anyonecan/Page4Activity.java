package com.example.yiz.anyonecan;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class Page4Activity extends BaseActivity {

    // private TextView rl_bobby = null;
    // private TextView rl_child = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page4);

        setPage(R.id.page4);

        setClickableRelativeLayout(R.id.rl_p4_bobby_top, R.raw.b_1_3_6);
        setClickableRelativeLayout(R.id.rl_p4_bobby_bottom, R.raw.b_1_3_6);
        setClickableRelativeLayout(R.id.rl_p4_child, R.raw.b_1_3_7);

        setClickableRelativeLayout(R.id.rl_p5_bobby_top, R.raw.b_1_3_8);
        setClickableRelativeLayout(R.id.rl_p5_bobby_bottom, R.raw.b_1_3_8);
        setClickableRelativeLayout(R.id.rl_p5_child, R.raw.b_1_3_9);

        setClickableRelativeLayout(R.id.rl_p6_bobby_left, R.raw.b_1_3_10);
        setClickableRelativeLayout(R.id.rl_p6_bobby_right, R.raw.b_1_3_10);
        setClickableRelativeLayout(R.id.rl_p6_child_top, R.raw.b_1_3_11);
        setClickableRelativeLayout(R.id.rl_p6_child_bottom, R.raw.b_1_3_11);

        setClickableRelativeLayout(R.id.rl_p7_bobby_left, R.raw.b_1_3_12);
        setClickableRelativeLayout(R.id.rl_p7_bobby_right, R.raw.b_1_3_12);
        setClickableRelativeLayout(R.id.rl_p7_child_top, R.raw.b_1_3_13);
        setClickableRelativeLayout(R.id.rl_p7_child_bottom, R.raw.b_1_3_13);
    }
}
