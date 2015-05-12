package com.example.yiz.anyonecan;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class Page7Activity extends BaseActivity {

//    private TextView tv_bobby_left = null;
//    private TextView tv_bobby_right = null;
//    private TextView tv_child = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page7);

        setPage(R.id.page7);

        setClickableTextView(R.id.tv_p7_bobby_left, R.raw.b_1_3_12);
        setClickableTextView(R.id.tv_p7_bobby_right, R.raw.b_1_3_12);
        setClickableTextView(R.id.tv_p7_child_right, R.raw.b_1_3_13);
        setClickableTextView(R.id.tv_p7_child_left_top, R.raw.b_1_3_13);
        setClickableTextView(R.id.tv_p7_child_left_bottom, R.raw.b_1_3_13);
    }
}
