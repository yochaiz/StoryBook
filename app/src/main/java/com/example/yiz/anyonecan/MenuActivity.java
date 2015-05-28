package com.example.yiz.anyonecan;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class MenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        RelativeLayout layout_start = (RelativeLayout) findViewById(R.id.menuStart);
        layout_start.setOnClickListener(btnClick1);
        RelativeLayout layout_15 = (RelativeLayout) findViewById(R.id.menu15);
        layout_15.setOnClickListener(btnClick2);
        RelativeLayout layout_610 = (RelativeLayout) findViewById(R.id.menu610);
        layout_610.setOnClickListener(btnClick3);
        RelativeLayout layout_games = (RelativeLayout) findViewById(R.id.menuGames);
        layout_games.setOnClickListener(btnClick4);
        RelativeLayout layout_story = (RelativeLayout) findViewById(R.id.menuStory);
        layout_story.setOnClickListener(btnClick5);

    }

    private View.OnClickListener btnClick1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(
                    getBaseContext(), VideoSong1Activity.class);
            startActivity(intent);
            finish();
        }
    };
    private View.OnClickListener btnClick2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(
                    getBaseContext(), VideoSong1Activity.class);
            startActivity(intent);
            finish();
        }
    };
    private View.OnClickListener btnClick3 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(
                    getBaseContext(), VideoSong3Activity.class);
            startActivity(intent);
            finish();
        }
    };
    private View.OnClickListener btnClick4 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(
                    getBaseContext(), GamesMenuActivity.class);
            startActivity(intent);
            finish();
        }
    };
    private View.OnClickListener btnClick5 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(
                    getBaseContext(), VideoStory1Activity.class);
            startActivity(intent);
            finish();
        }
    };
}
