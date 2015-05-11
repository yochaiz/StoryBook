package com.example.yiz.anyonecan;

import android.os.Bundle;
import android.util.TypedValue;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class Page1Activity extends BaseActivity {

//    private TextView tv_three = null;
//    private TextView tv_bobby = null;
//    private TextView tv_children_left = null;
//    private TextView tv_children_right = null;
//    private Button btn_bobby = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);

        setPage(R.id.page1);

        setClickableTextView(R.id.tv_p1_three, R.raw.b_1_3_1);
        setClickableTextView(R.id.tv_p1_bobby, R.raw.b_1_3_2);
        setClickableTextView(R.id.tv_p1_children_left, R.raw.b_1_3_3);
        setClickableTextView(R.id.tv_p1_children_right, R.raw.b_1_3_3);

        //setClickableButton(btn_bobby, R.id.btn_p1_bobby, R.raw.b_1_3_2);
    }

}
