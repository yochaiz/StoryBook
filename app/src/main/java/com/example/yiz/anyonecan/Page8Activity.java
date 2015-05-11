package com.example.yiz.anyonecan;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class Page8Activity extends BaseActivity {

    private TextView tv_bobby = null;
    private TextView tv_child = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page8);

        setPage(R.id.page8);

        setClickableTextView(tv_bobby, R.id.tv_p8_bobby, R.raw.b_1_3_14);
        setClickableTextView(tv_child, R.id.tv_p8_child, R.raw.b_1_3_15);
    }
}
