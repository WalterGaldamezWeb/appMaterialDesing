package com.waltergaldamezweb.appmaterialdesing;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{


    ArrayList<Mascota> mascotas;

    public MascotaAdaptador(ArrayList<Mascota> mascotas) {
        this.mascotas = mascotas;
    }

    //Infla el layout y lo pasa al viewholder para que obtenga los view
    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent,false);
        return new MascotaViewHolder(v);
    }
    //asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder holder, int position) {
        Mascota mascota = mascotas.get(position);
        holder.imgCardView.setImageResource(mascota.getFoto());
        holder.tvNombre.setText(mascota.getNombreMascota());
        holder.tvLikes.setText(mascota.getLikes());
    }

    @Override
    public int getItemCount() {//cantidad de elementos que tiene la lista
        return mascotas.size();
    }

    public class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgCardView;
        private TextView tvNombre;
        private TextView tvLikes;


        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgCardView = (ImageView) itemView.findViewById(R.id.imgCardView);
            tvNombre = (TextView) itemView.findViewById(R.id.tvNombre);
            tvLikes = (TextView) itemView.findViewById(R.id.tvLikes);

        }
    }
}
