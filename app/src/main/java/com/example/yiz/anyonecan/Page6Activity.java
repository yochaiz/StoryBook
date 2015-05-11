package com.example.yiz.anyonecan;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class Page6Activity extends BaseActivity {

    //   private TextView tv_bobby = null;
    //  private TextView tv_child = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page6);

        setPage(R.id.page6);

        setClickableTextView(R.id.tv_p6_bobby, R.raw.b_1_3_10);
        setClickableTextView(R.id.tv_p6_child, R.raw.b_1_3_11);
    }

}
