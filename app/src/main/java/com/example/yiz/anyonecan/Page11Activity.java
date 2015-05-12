package com.example.yiz.anyonecan;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class Page11Activity extends BaseActivity {

    // private TextView tv_bobby = null;
    // private TextView tv_child = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page11);

        setPage(R.id.page11);

        setClickableTextView(R.id.tv_p11_bobby_top, R.raw.b_1_3_21);
        setClickableTextView(R.id.tv_p11_bobby_bottom, R.raw.b_1_3_21);
        setClickableTextView(R.id.tv_p11_child, R.raw.b_1_3_20);
    }
}
