package com.controlapp.beto.riosucio;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Collections;
import java.util.List;

public class AdapterFish extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private LayoutInflater inflater;
    List<Event> data= Collections.emptyList();
    Event current;
    int currentPos=0;

    // create constructor to innitilize context and data sent from MainActivity
    public AdapterFish(Context context, List<Event> data){
        this.context=context;
        inflater= LayoutInflater.from(context);
        this.data=data;
    }

    // Inflate the layout when viewholder created
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.tarjeta, parent,false);
        MyHolder holder=new MyHolder(view);
        return holder;
    }

    // Bind data
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        // Get current position of item in recyclerview to bind data and assign values from list
        MyHolder myHolder= (MyHolder) holder;
        Event current=data.get(position);
        myHolder.textFishName.setText(current.nombre);
        myHolder.textSize.setText( current.fecha);//size
        myHolder.textPrice.setText(current.hora_inicio + "-" + current.hora_final);
        myHolder.textType.setText(current.lugar);
        /*myHolder.textPrice.setTextColor(ContextCompat.getColor(context, R.color.letras));
        myHolder.textFishName.setTextColor(ContextCompat.getColor(context, R.color.letras));
        myHolder.textSize.setTextColor(ContextCompat.getColor(context, R.color.letras));
        myHolder.textType.setTextColor(ContextCompat.getColor(context, R.color.letras));*/

        // load image into imageview using glide
        Glide.with(context).load("http://controlapp.com.co/carnaval/images/" + current.link_imagen)
                .placeholder(R.drawable.cloud_sync)
                .error(R.drawable.cloud_off)
                .into(myHolder.ivFish);



    }

    // return total item from List
    @Override
    public int getItemCount() {
        return data.size();
    }


    class MyHolder extends RecyclerView.ViewHolder{

        TextView textFishName;
        ImageView ivFish;
        TextView textSize;
        TextView textType;
        TextView textPrice;

        // create constructor to get widget reference
        public MyHolder(View itemView) {
            super(itemView);
            textFishName= (TextView) itemView.findViewById(R.id.textFishName);
            ivFish= (ImageView) itemView.findViewById(R.id.ivFish);
            textSize = (TextView) itemView.findViewById(R.id.textSize);
            textType = (TextView) itemView.findViewById(R.id.textType);
            textPrice = (TextView) itemView.findViewById(R.id.textPrice);
        }

    }

}
