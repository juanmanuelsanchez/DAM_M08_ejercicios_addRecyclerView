package com.example.addrecyclerview;

import android.media.MediaPlayer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import java.util.Objects;

public class DetailActivity extends AppCompatActivity {
    private MediaPlayer mp;
    private boolean isPaused = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Button botonPlay = findViewById(R.id.btn_play);
        Button botonPause = findViewById(R.id.btn_pause);
        Button botonStop = findViewById(R.id.btn_stop);
        TextView titulo = findViewById(R.id.tv_titulo);


        String item = Objects.requireNonNull(getIntent().getExtras()).getString("nombre");
        int numero = getIntent().getExtras().getInt("numero");
        Toast.makeText(this, "Received item: " + item, Toast.LENGTH_SHORT).show();
        titulo.setText(item);
        mp = MediaPlayer.create(this, numero);

        botonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mp.isPlaying()){
                    mp.start();
                }
                if (isPaused){
                    mp.start();
                }
                isPaused = false;
            }
        });

        botonPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mp.isPlaying()){
                    mp.pause();
                    isPaused = true;
                }
            }
        });

        botonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mp.isPlaying()){
                    mp.stop();
                    isPaused = false;
                    try{
                        mp.prepare();
                    }catch (Exception e){
                        System.out.println("Error: " + e.getMessage());
                    }
                }
                if (isPaused){
                    mp.stop();
                    isPaused = false;
                    try{
                        mp.prepare();
                    }catch (Exception e){
                        System.out.println("Error: " + e.getMessage());
                    }
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mp.stop();
    }
}
