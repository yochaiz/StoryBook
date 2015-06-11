package com.example.yiz.anyonecan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeScreenActivity extends ImmersiveActivity {

    Class nextPage = MenuActivity.class;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        Button btn = (Button) findViewById(R.id.btn_home_screen);
        btn.setOnClickListener(btnClick);

//        Timer timer = new Timer();
//        TimerTask task = new TimerTask() {
//            @Override
//            public void run() {
//                Intent intent = new Intent(
//                        getBaseContext(), nextPage);
//                startActivity(intent);
//
//
//            }
//        };
//        long delay = 4000;
//        timer.schedule(task, delay);
    }

    private View.OnClickListener btnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(
                    getBaseContext(), nextPage);
            startActivity(intent);
            finish();
        }
    };
}
