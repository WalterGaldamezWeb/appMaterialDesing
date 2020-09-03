package com.waltergaldamezweb.appmaterialdesing;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PerfilAdaptador extends RecyclerView.Adapter<PerfilAdaptador.PerfilViewHolder>{
    ArrayList<Mascota> mascotas;
    private Activity contexto;

    public PerfilAdaptador(ArrayList<Mascota> mascotas, Activity contexto) {
        this.mascotas = mascotas;
        this.contexto = contexto;
    }

    //Infla el layout y lo pasa al viewholder para que obtenga los view
    @NonNull
    @Override
    public PerfilAdaptador.PerfilViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_perfil, parent,false);
        return new PerfilViewHolder(v);
    }
    //asocia cada elemento de la lista con cada view
    @Override
    public void onBindViewHolder(@NonNull final PerfilAdaptador.PerfilViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);
        holder.imgCardView.setImageResource(mascota.getFoto());
        holder.tvLikes.setText(mascota.getLikes());
    }

    @Override
    public int getItemCount() {//cantidad de elementos que tiene la lista
        return mascotas.size();
    }

    public static class PerfilViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgCardView;
        private TextView tvLikes;

        public PerfilViewHolder(@NonNull View itemView) {
            super(itemView);
            imgCardView = (ImageView) itemView.findViewById(R.id.imgCardView);
            tvLikes = (TextView) itemView.findViewById(R.id.tvLikes);

        }
    }
}
