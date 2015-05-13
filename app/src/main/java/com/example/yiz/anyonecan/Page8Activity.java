package com.example.yiz.anyonecan;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class Page8Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page8);

        setPage(R.id.page8);

        setClickableRelativeLayout(R.id.rl_p13_bobby, R.raw.b_1_3_25);
        setClickableRelativeLayout(R.id.rl_p13_child, R.raw.b_1_3_24);

        setClickableRelativeLayout(R.id.rl_p14_bobby, R.raw.b_1_3_27);
        setClickableRelativeLayout(R.id.rl_p14_child, R.raw.b_1_3_26);
    }
}
