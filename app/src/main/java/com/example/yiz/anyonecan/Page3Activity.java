package com.example.yiz.anyonecan;

import android.os.Bundle;
import android.widget.TextView;


public class Page3Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);

        setPage(R.id.page3);

        setClickableRelativeLayout(R.id.rl_p3_children_left, R.raw.b_1_3_5);
        setClickableRelativeLayout(R.id.rl_p3_children_right, R.raw.b_1_3_5);
    }
}
