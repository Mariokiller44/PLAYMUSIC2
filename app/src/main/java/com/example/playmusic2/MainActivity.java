package com.example.playmusic2;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MediaPlayer mp;
    int pausa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void play(View v){
        if (mp==null) {
            mp = MediaPlayer.create(this, R.raw.eminemloseyourself);
            mp.start();
            Toast.makeText(this, "Play", Toast.LENGTH_SHORT).show();
        }else if (!mp.isPlaying()){
            mp.seekTo(pausa);
            mp.start();
            Toast.makeText(this, "Replaying", Toast.LENGTH_SHORT).show();
        }
    }
    public void pause(View v){
        if (mp !=null) {
            mp.pause();
            pausa=mp.getCurrentPosition();
            Toast.makeText(this, "Pause", Toast.LENGTH_SHORT).show();
        }
    }
    public void parar(View v){
        mp.stop();
        mp=null;
        Toast.makeText(this, "Stop", Toast.LENGTH_SHORT).show();
    }


}