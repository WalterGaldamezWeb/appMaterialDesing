package com.waltergaldamezweb.appmaterialdesing.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.waltergaldamezweb.appmaterialdesing.R;
import com.waltergaldamezweb.appmaterialdesing.modelo.ConstructorMascotas;
import com.waltergaldamezweb.appmaterialdesing.modelo.Mascota;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{


    ArrayList<Mascota> mascotas;
    private Activity contexto;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity contexto) {
        this.mascotas = mascotas;
        this.contexto = contexto;
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
    public void onBindViewHolder(@NonNull final MascotaViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);
        holder.imgCardView.setImageResource(mascota.getFoto());
        holder.tvNombre.setText(mascota.getNombreMascota());
        holder.tvLikes.setText(String.valueOf(mascota.getLikes()));


        holder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(contexto,"Like a : " + mascota.getNombreMascota() , Toast.LENGTH_SHORT).show();
                ConstructorMascotas constructorMascotas = new ConstructorMascotas(contexto);
                constructorMascotas.darLikeMascota(mascota);
                holder.tvLikes.setText(String.valueOf(constructorMascotas.obtenerLikesMascota(mascota)));
            }
        });


    }

    @Override
    public int getItemCount() {//cantidad de elementos que tiene la lista
        return mascotas.size();
    }

    public class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgCardView;
        private TextView tvNombre;
        private TextView tvLikes;
        private ImageButton btnLike;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            imgCardView = (ImageView) itemView.findViewById(R.id.imgCardView);
            tvNombre = (TextView) itemView.findViewById(R.id.tvNombre);
            tvLikes = (TextView) itemView.findViewById(R.id.tvLikes);
            btnLike = (ImageButton) itemView.findViewById(R.id.btnLike);

        }
    }
}
