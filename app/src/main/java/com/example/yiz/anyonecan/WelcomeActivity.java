package com.example.yiz.anyonecan;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.plattysoft.leonids.ParticleSystem;
import com.plattysoft.leonids.modifiers.ScaleModifier;

import java.util.Timer;
import java.util.TimerTask;


public class WelcomeActivity extends ActionBarActivity {

    private MediaPlayer mp = null;
    private Intent intent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        intent = new Intent(this, Page1Activity.class);
        mp = MediaPlayer.create(this, R.raw.welcome);
        mp.setOnCompletionListener(mpComplete);
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                mp.start();
            }
        };
        long delay = 5000;
        timer.schedule(task, delay);

//        new ParticleSystem(this, 200, R.drawable.star_pink, 10000)
//                //.setSpeedModuleAndAngleRange(0f, 0.3f, 180, 180)
//                .setSpeedModuleAndAngleRange(0f, 0.3f, 0, 0)
//                .setRotationSpeed(144)
//                .setAcceleration(0.00005f, 90)
//                .emit(findViewById(R.id.emiter_top_right), 50);

        new ParticleSystem(this, 200, R.drawable.confeti2, 10000)
                .setSpeedModuleAndAngleRange(0f, 0.3f, 0, 0)
                .setRotationSpeed(144)
                .setAcceleration(0.00005f, 90)
                .emit(findViewById(R.id.emiter_top_left), 50);

//        new ParticleSystem(this, 10, R.drawable.star, 3000)
//                .setSpeedByComponentsRange(-0.1f, 0.1f, -0.1f, 0.02f)
//                .setAcceleration(0.000003f, 90)
//                .setInitialRotationRange(0, 360)
//                .setRotationSpeed(120)
//                .setFadeOut(2000)
//                .addModifier(new ScaleModifier(0f, 1.5f, 0, 1500))
//                .oneShot(findViewById(R.id.emiter_top_left), 10);

    }

    private MediaPlayer.OnCompletionListener mpComplete = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            startActivity(intent);
        }
    };
}
