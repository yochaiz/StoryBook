package com.example.yiz.anyonecan;

import android.os.Bundle;

public class GamesMenuActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games_menu);

        setPage(R.id.gamesMenuPage);
    }
}
