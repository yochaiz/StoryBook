package com.example.yiz.anyonecan;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class Page6Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page6);

        setPage(R.id.page6);

        setClickableRelativeLayout(R.id.rl_p10_bobby, R.raw.b_1_3_19);
        setClickableRelativeLayout(R.id.rl_p10_child, R.raw.b_1_3_18);
    }

}
