package com.example.yiz.anyonecan;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class Page5Activity extends BaseActivity {

    //   private TextView tv_bobby = null;
    //   private TextView tv_child = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page5);

        setPage(R.id.page5);

        setClickableRelativeLayout(R.id.rl_p8_bobby, R.raw.b_1_3_14);
        setClickableRelativeLayout(R.id.rl_p8_child, R.raw.b_1_3_15);

        setClickableRelativeLayout(R.id.rl_p9_bobby, R.raw.b_1_3_16);
        setClickableRelativeLayout(R.id.rl_p9_child_top, R.raw.b_1_3_17);
        setClickableRelativeLayout(R.id.rl_p9_child_bottom, R.raw.b_1_3_17);
    }
}
