package com.controlapp.beto.riosucio;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Collections;
import java.util.List;

public class AdapterNoticia extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    List<Noticia> data= Collections.emptyList();
    Event current;
    int currentPos=0;


    // create constructor to innitilize context and data sent from MainActivity
    public AdapterNoticia(Context context, List<Noticia> data){
        this.context=context;
        inflater= LayoutInflater.from(context);
        this.data=data;
    }

    // Inflate the layout when viewholder created
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.tarjeta_noticia, parent,false);
        MyHolder holder=new MyHolder(view);
        return holder;
    }

    // Bind data
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        // Get current position of item in recyclerview to bind data and assign values from list
        MyHolder myHolder= (MyHolder) holder;
        Noticia current=data.get(position);
        myHolder.textNombre.setText(current.getTitular());
        myHolder.textFecha.setText(current.getFecha());
        //myHolder.textCapitan.setText(current.getNombreCapitan());//size
        //myHolder.textCiudad.setText(current.getCiudad());
        Glide.with(context).load("http://controlapp.com.co/carnaval/images/noticias/" + current.getLink_imagen())
                .placeholder(R.drawable.cloud_off)
                .error(R.drawable.cloud_off)
                .into(myHolder.imvPhoto);



    }

    // return total item from List
    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyHolder extends RecyclerView.ViewHolder{

        TextView textNombre;
        ImageView imvPhoto;
        TextView textFecha;
        
        // create constructor to get widget reference
        public MyHolder(View itemView) {
            super(itemView);
            textNombre= (TextView) itemView.findViewById(R.id.textNombre);
            imvPhoto= (ImageView) itemView.findViewById(R.id.imvPhoto);
            textFecha = (TextView) itemView.findViewById(R.id.textFecha_news);
        }

    }

}
