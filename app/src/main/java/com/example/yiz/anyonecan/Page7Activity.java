package com.example.yiz.anyonecan;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class Page7Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page7);

        setPage(R.id.page7);

        setClickableRelativeLayout(R.id.rl_p11_bobby, R.raw.b_1_3_21);
        setClickableRelativeLayout(R.id.rl_p11_child, R.raw.b_1_3_20);

        setClickableRelativeLayout(R.id.rl_p12_bobby, R.raw.b_1_3_23);
        setClickableRelativeLayout(R.id.rl_p12_child, R.raw.b_1_3_22);
    }
}
