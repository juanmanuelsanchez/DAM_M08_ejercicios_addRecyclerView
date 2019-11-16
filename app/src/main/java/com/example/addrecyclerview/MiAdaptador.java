package com.example.addrecyclerview;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public  class MiAdaptador extends RecyclerView.Adapter<MiAdaptador.MyViewHolder>{
    public static final String ITEM_ID_KEY = "item_id_key";
    private String[]listado;
    private Context mContext;


    static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        View mView;
        MyViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.listado_alumnos);
            mView = view;
        }
    }

    MiAdaptador(Context context, String[] miListado){

        this.listado = miListado;
        this.mContext = context;
    }

    @NonNull
    @Override
    public MiAdaptador.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_layout, parent, false);
        return new MyViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull MiAdaptador.MyViewHolder holder, int position) {
        final String itemString = this.listado[position];
        holder.textView.setText(this.listado[position]);
        holder.mView.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
              System.out.println("Click!");
              //Toast.makeText(mContext, "You selected "+ item, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(mContext, DetailActivity.class);
                intent.putExtra("nombre", itemString);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        System.out.println(listado.length);
        return listado.length;
    }
}
