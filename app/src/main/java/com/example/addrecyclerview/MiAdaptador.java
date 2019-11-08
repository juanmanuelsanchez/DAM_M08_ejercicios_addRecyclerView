package com.example.addrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public  class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.MyViewHolder>{
    private String[]listado;

    static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        MyViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.listado_alumnos);
        }
    }

    MiAdaptador(String[] miListado){

        this.listado = miListado;
    }

    @NonNull
    @Override
    public MiAdaptador.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_layout, parent, false);
        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull MiAdaptador.MyViewHolder holder, int position) {
        holder.textView.setText(this.listado[position]);
    }

    @Override
    public int getItemCount() {
        System.out.println(listado.length);
        return listado.length;
    }
}
