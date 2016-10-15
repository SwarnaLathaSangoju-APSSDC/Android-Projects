package com.example.sango.musicplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
ImageButton playButton,pauseButton;
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        playButton=(ImageButton)findViewById(R.id.playButton);
        pauseButton=(ImageButton)findViewById(R.id.pauseButton);
        mediaPlayer = MediaPlayer.create(this,R.raw.yamunatheeram );
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              mediaPlayer.start();
                //  Toast.makeText(getApplicationContext(),"Play",Toast.LENGTH_SHORT).show();
            }
        });
        pauseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
                //Toast.makeText(getApplicationContext(),"Pause",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
