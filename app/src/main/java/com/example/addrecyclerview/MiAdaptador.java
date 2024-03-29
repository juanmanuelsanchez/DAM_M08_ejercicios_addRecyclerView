package com.example.addrecyclerview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public  class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.MyViewHolder>{
    private String[]listado;
    private Context mContext;
    private ArrayList<Integer> misCanciones;
    private int selectedItem;

    static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        View mView;

        MyViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.listado_alumnos);
            mView = view;
        }
    }

    MiAdaptador(Context context, String[] miListado, ArrayList<Integer> misCanciones, int selectedItem){

        this.listado = miListado;
        this.mContext = context;
        this.misCanciones = misCanciones;
        this.selectedItem = selectedItem;
    }

    @NonNull
    @Override
    public MiAdaptador.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_layout, parent, false);
        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull final MiAdaptador.MyViewHolder holder, final int position) {
        final String itemString = this.listado[position];
        holder.textView.setText(this.listado[position]);
        holder.textView.setBackgroundColor(Color.parseColor("#00000000"));

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedItem = misCanciones.get(position);
                System.out.println("Click!");
                holder.textView.setBackgroundColor(Color.parseColor("#30000000"));
                Intent intent = new Intent(mContext, DetailActivity.class);
                intent.putExtra("nombre", itemString);
                intent.putExtra("numero", selectedItem);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listado.length;
    }
}
