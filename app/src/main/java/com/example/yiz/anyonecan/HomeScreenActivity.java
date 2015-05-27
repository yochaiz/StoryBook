package com.example.yiz.anyonecan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;

public class HomeScreenActivity extends Activity {

    Class nextPage = MenuActivity.class;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //create fullscreen
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

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
