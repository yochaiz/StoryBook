package com.example.yiz.anyonecan;

import android.os.Bundle;
import android.widget.TextView;


public class Page3Activity extends BaseActivity {

    private TextView tv_children = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);

        setPage(R.id.page3);

        setClickableTextView(tv_children,R.id.tv_p3_children,R.raw.b_1_3_5);
    }
}
