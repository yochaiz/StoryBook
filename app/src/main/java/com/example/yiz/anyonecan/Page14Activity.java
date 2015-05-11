package com.example.yiz.anyonecan;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class Page14Activity extends BaseActivity {

    //  private TextView tv_bobby = null;
    // private TextView tv_child = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page14);

        setPage(R.id.page14);

        setClickableTextView(R.id.tv_p14_bobby, R.raw.b_1_3_27);
        setClickableTextView(R.id.tv_p14_child, R.raw.b_1_3_26);
    }
}
