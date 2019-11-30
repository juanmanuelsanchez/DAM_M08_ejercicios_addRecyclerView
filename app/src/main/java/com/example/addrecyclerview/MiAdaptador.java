package com.example.addrecyclerview;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
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
    private int selectedItem = 0;//



    static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        View mView;

        MyViewHolder(View view) {
            super(view);
            textView = view.findViewById(R.id.listado_alumnos);
            mView = view;
        }
    }

    MiAdaptador(Context context, String[] miListado, int selectedItem){

        this.listado = miListado;
        this.mContext = context;
        this.selectedItem = selectedItem;//
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
        /*if (selectedItem == position){//
            holder.textView.setBackgroundColor(Color.parseColor("#30000000"));
        }else {
            holder.textView.setBackgroundColor(Color.parseColor("#00000000"));
        }*/
        holder.textView.setBackgroundColor(Color.parseColor("#00000000"));
        holder.mView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                selectedItem = position;
                System.out.println("Click!");
                holder.textView.setBackgroundColor(Color.parseColor("#30000000"));//
               /* for (int i = 0; i < listado.length; i++){
                    if (selectedItem == position){
                        holder.textView.setBackgroundColor(Color.parseColor("#30000000"));
                    }else {
                        holder.textView.setBackgroundColor(Color.parseColor("#00000000"));
                    }
                }*/
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
