package com.example.yiz.anyonecan;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class Page12Activity extends BaseActivity {

    //  private TextView tv_bobby = null;
    //  private TextView tv_child = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page12);

        setPage(R.id.page12);

        setClickableTextView(R.id.tv_p12_bobby_top, R.raw.b_1_3_23);
        setClickableTextView(R.id.tv_p12_bobby_bottom, R.raw.b_1_3_23);
        setClickableTextView(R.id.tv_p12_child, R.raw.b_1_3_22);
    }
}
