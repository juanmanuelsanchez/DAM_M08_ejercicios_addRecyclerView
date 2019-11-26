package com.example.addrecyclerview;

import android.media.MediaPlayer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {
    private MediaPlayer mp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Button botonPlay = findViewById(R.id.btn_play);
        Button botonStop = findViewById(R.id.btn_stop);
        TextView titulo = findViewById(R.id.tv_titulo);



        //String itemId = getIntent().getExtras().getString(MiAdaptador.ITEM_ID_KEY);
        String item = getIntent().getExtras().getString("nombre");
        Toast.makeText(this, "Received item: " + item, Toast.LENGTH_LONG).show();
        titulo.setText(item);
        //mp = MediaPlayer.create(this, R.raw.batman);
        int resID = getResources().getIdentifier(item, "raw", getPackageName());
        mp = MediaPlayer.create(this, resID);

        //TODO: revisa implementación para parar la reproducción
        // y volver a reanudarla.
        botonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
            }
        });

        botonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mp.stop();
    }
}
