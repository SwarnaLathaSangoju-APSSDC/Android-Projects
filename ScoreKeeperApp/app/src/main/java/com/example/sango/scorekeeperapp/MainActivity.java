package com.example.sango.scorekeeperapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextClock;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int score_1;
    private int score_2;
    private boolean night_mode = false;
    private TextView score_text_1;
    private TextView score_text_2;


    static final String STATE_SCORE_1 = "Team 1 Score";
    static final String STATE_SCORE_2 = "Team 2 Score";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        night_mode = getIntent().getBooleanExtra("nightMode",false);
        if(night_mode){
            setTheme(android.support.v7.appcompat.R.style.Theme_AppCompat);
        } else {
            setTheme(R.style.AppTheme);
        }
        setContentView(R.layout.activity_main);
        score_text_1 = (TextView)findViewById(R.id.tm1_score);
        score_text_2 = (TextView)findViewById(R.id.tm2_score);
        if (savedInstanceState != null) {
            score_1 = savedInstanceState.getInt(STATE_SCORE_1);
            score_2 = savedInstanceState.getInt(STATE_SCORE_2);

        } else{
            score_1 = getIntent().getIntExtra(STATE_SCORE_1,0);
            score_2 = getIntent().getIntExtra(STATE_SCORE_2,0);
        }
        score_text_1.setText(String.valueOf(score_1));
        score_text_2.setText(String.valueOf(score_2));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        if (night_mode) {
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else{
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.night_mode){
            Intent intent = new Intent(this,MainActivity.class);
            if(!night_mode){
                intent.putExtra("nightMode",true).putExtra(STATE_SCORE_1,score_1).putExtra(STATE_SCORE_2,score_2);
            } else{
                intent.putExtra("nightMode",false).putExtra(STATE_SCORE_1,score_1).putExtra(STATE_SCORE_2,score_2);
            }
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void minus_team1(View view) {
        score_1--;
        if (score_text_1 != null) {
            score_text_1.setText(String.valueOf(score_1));
        }
    }

    public void plus_team1(View view) {
        score_1++;
        if (score_text_1 != null) {
            score_text_1.setText(String.valueOf(score_1));
        }
    }

    public void minus_team2(View view) {
        score_2--;
        if (score_text_2 != null) {
            score_text_2.setText(String.valueOf(score_2));
        }
    }

    public void plus_team2(View view) {
        score_2++;
        if (score_text_2 != null) {
            score_text_2.setText(String.valueOf(score_2));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(STATE_SCORE_1, score_1);
        outState.putInt(STATE_SCORE_2, score_2);
        super.onSaveInstanceState(outState);
    }



}
