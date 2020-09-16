package com.waltergaldamezweb.appmaterialdesing.vista.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.waltergaldamezweb.appmaterialdesing.R;
import com.waltergaldamezweb.appmaterialdesing.adapter.PerfilAdaptador;
import com.waltergaldamezweb.appmaterialdesing.modelo.Mascota;

import java.util.ArrayList;

public class Perfil_Mascota extends Fragment {

    ArrayList<Mascota> mascotas;
    public RecyclerView listaMascotas;
    TextView tvNombrePerfil;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_perfil__mascota, container,false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvPerfilMascota);
        tvNombrePerfil = (TextView) v.findViewById(R.id.tvNombrePerfil);

        GridLayoutManager glm = new GridLayoutManager(getActivity(),3);
        glm.setOrientation(GridLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(glm);
        inicializarListaMascotas();
        inicializarAdaptador();
        tvNombrePerfil.setText(mascotas.get(2).getNombreMascota().toString());


        return v;
    }
    public void inicializarAdaptador () {
        PerfilAdaptador adaptador = new PerfilAdaptador(mascotas, getActivity());
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas () {
        //likes = String.valueOf(contadorLikes);
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.gato_perro,"Gato Y Perro","5"));
        mascotas.add(new Mascota(R.drawable.gato_perro,"Gato Y Perro","5"));
        mascotas.add(new Mascota(R.drawable.gato_perro,"Gato Y Perro","5"));
        mascotas.add(new Mascota(R.drawable.gato_perro,"Gato Y Perro","5"));
        mascotas.add(new Mascota(R.drawable.gato_perro,"Gato Y Perro","5"));
        mascotas.add(new Mascota(R.drawable.gato_perro,"Gato Y Perro","5"));
        mascotas.add(new Mascota(R.drawable.gato_perro,"Gato Y Perro","5"));
        mascotas.add(new Mascota(R.drawable.gato_perro,"Gato Y Perro","5"));
        mascotas.add(new Mascota(R.drawable.gato_perro,"Gato Y Perro","5"));
        /*mascotas.add(new Mascota(R.drawable.peludo,"Peludo","2"));
        mascotas.add(new Mascota(R.drawable.labradores,"Labradores","5"));
        mascotas.add(new Mascota(R.drawable.perrote,"Perrote","8"));
        mascotas.add(new Mascota(R.drawable.labrador_adulto,"Labrador Adulto","12"));
        mascotas.add(new Mascota(R.drawable.gato,"Gato","5"));
        mascotas.add(new Mascota(R.drawable.manchado,"Manchado","7"));
        mascotas.add(new Mascota(R.drawable.pitbull,"Pitbull","1"));
        mascotas.add(new Mascota(R.drawable.leon,"León","8"));*/
    }
}