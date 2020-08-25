package com.waltergaldamezweb.appmaterialdesing;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewMascota extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    public RecyclerView listaMascotas;
    TextView estrella;
    int contadorLikes;
    ImageButton btnLike;
    private String likes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view_mascota);
        /*btnLike = (ImageButton) findViewById(R.id.btnLike);*/
        setToolBar();
        listaMascotas = (RecyclerView) findViewById(R.id.rvMascota);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();
        //estrella = findViewById(R.id.contadorMascotas);
        //estrella.setText(String.valueOf(totalMascotas()));


        /*btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contadorLikes++;
            }
        });*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemStrella:
                Intent intent = new Intent(RecyclerViewMascota.this,MascotasFavoritas.class);
                startActivity(intent);
                return true;
            case R.id.itemConatacto:
                Intent contactoIntent = new Intent(this,Contacto.class);
                startActivity(contactoIntent);
                return true;
            case R.id.itemAcercaDe:
                Log.i("Dos", "Se presiono Dos");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void inicializarAdaptador () {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }
    public int totalMascotas () {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas,this);
        return adaptador.getItemCount();
    }

    public void inicializarListaMascotas () {
        //likes = String.valueOf(contadorLikes);
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.gato_perro,"Gato Y Perro","5"));
        mascotas.add(new Mascota(R.drawable.peludo,"Peludo","2"));
        mascotas.add(new Mascota(R.drawable.labradores,"Labradores","5"));
        mascotas.add(new Mascota(R.drawable.perrote,"Perrote","8"));
        mascotas.add(new Mascota(R.drawable.labrador_adulto,"Labrador Adulto","12"));
        mascotas.add(new Mascota(R.drawable.gato,"Gato","5"));
        mascotas.add(new Mascota(R.drawable.manchado,"Manchado","7"));
        mascotas.add(new Mascota(R.drawable.pitbull,"Pitbull","1"));
        mascotas.add(new Mascota(R.drawable.leon,"León","8"));
    }
    public void setToolBar(){
        Toolbar appBar = findViewById(R.id.appBar);
        setSupportActionBar(appBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}