package com.example.addrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private String[] miListado = new String[]{"avengers","fear_will_find_you","peace_frog", "why_do_we_fall"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Enlace con el objeto del layout principal.
        RecyclerView recyclerView = findViewById(R.id.listadoCompañeros);
        //Ajuste que mejora rendimiento si no es previsible
        //que aumente el tamaño del layout del RecyclerView.
        recyclerView.setHasFixedSize(true);

        //Se usa un linear layout manager.
        //Se le pasa el contexto y se asigna al RecyclerView.
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //Se define un adaptador.
        RecyclerView.Adapter adaptador = new MiAdaptador(this, miListado, 0);//
        recyclerView.setAdapter(adaptador);
    }
}

