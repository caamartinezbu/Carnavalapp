package com.controlapp.beto.riosucio;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Beto on 07/10/2016.
 */
public class TarjetaAdapador extends  RecyclerView.Adapter<TarjetaAdapador.TarjetaViewHolder> {

    private List<Tarjeta> tarjetas;

    public TarjetaAdapador(List<Tarjeta> tarjetas) {
        this.tarjetas = tarjetas;
    }

    @Override
    public TarjetaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //return null;
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_tarjetas, parent, false);
        return  new TarjetaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(TarjetaViewHolder tarjetaViewHolder, int position) {
    Tarjeta tarjeta = tarjetas.get(position);
        tarjetaViewHolder.imgFoto.setImageResource(tarjeta.getFoto());
        tarjetaViewHolder.tvNombre.setText(tarjeta.getNombre());

    }

    @Override
    public int getItemCount() {
        return tarjetas.size();
    }

    public static class TarjetaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvNombre;

        public TarjetaViewHolder(View itemView) {
            super(itemView);

            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombre= (TextView) itemView.findViewById(R.id.tvNombretarjeta);
        }
    }


}
