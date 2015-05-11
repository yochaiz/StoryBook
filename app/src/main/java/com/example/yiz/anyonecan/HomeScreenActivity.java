package com.example.yiz.anyonecan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class HomeScreenActivity extends Activity {

    private Button btn = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        btn = (Button) findViewById(R.id.btn_home_screen);
        btn.setOnClickListener(btnClick);

    }

    private View.OnClickListener btnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(
                    getBaseContext(), Page1Activity.class);
            startActivity(intent);
        }
    };
}
