package com.example.addrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //private String[] miListado = new String[]{"avengers","fear_will_find_you","peace_frog", "why_do_we_fall"};
    private String[] miListado = new String[]{"The Avengers | Alan Silvestri | 2:03","Fear will find you | Hans Zimmer | 3:07","Peace frog | The Doors | 2:48", "Why do we fall? | Hans Zimmer | 2:03"};
    private ArrayList<Integer> misCanciones = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Enlace con el objeto del layout principal.
        RecyclerView recyclerView = findViewById(R.id.listadoCompañeros);
        //Ajuste que mejora rendimiento si no es previsible
        //que aumente el tamaño del layout del RecyclerView.
        recyclerView.setHasFixedSize(true);

        misCanciones.add(R.raw.avengers);
        misCanciones.add(R.raw.fear_will_find_you);
        misCanciones.add(R.raw.peace_frog);
        misCanciones.add(R.raw.why_do_we_fall);

        //Se usa un linear layout manager.
        //Se le pasa el contexto y se asigna al RecyclerView.
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //Se define un adaptador.
        RecyclerView.Adapter adaptador = new MiAdaptador(this, miListado, misCanciones,-1);//
        recyclerView.setAdapter(adaptador);
    }
}

