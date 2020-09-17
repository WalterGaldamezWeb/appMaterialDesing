package com.waltergaldamezweb.appmaterialdesing;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.waltergaldamezweb.appmaterialdesing.adapter.MascotaAdaptador;
import com.waltergaldamezweb.appmaterialdesing.modelo.Mascota;

import java.util.ArrayList;

public class MascotasFavoritas extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    public RecyclerView listaMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mascotas_favoritas);
        setToolBar();
        listaMascotas = (RecyclerView) findViewById(R.id.rvMascotaFav);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();
    }
    public void setToolBar(){
        Toolbar appBar = findViewById(R.id.appBar);
        setSupportActionBar(appBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
    }

    public void inicializarAdaptador () {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas () {
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.gato,"gato",5));
        mascotas.add(new Mascota(R.drawable.gato_perro,"Gato Y Perro",15));
        mascotas.add(new Mascota(R.drawable.labradores,"Labradores",5));
        mascotas.add(new Mascota(R.drawable.perrote,"Perrote",8));
        mascotas.add(new Mascota(R.drawable.labrador_adulto,"Labrador Adulto",12));
        /*mascotas.add(new Mascota(R.drawable.gato,"Gato","5"));
        mascotas.add(new Mascota(R.drawable.manchado,"Manchado","7"));
        mascotas.add(new Mascota(R.drawable.pitbull,"Pitbull","1"));
        mascotas.add(new Mascota(R.drawable.leon,"León","8"));*/
    }
}