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
import android.widget.TextView;

import java.util.ArrayList;

public class RecyclerViewMascota extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    public RecyclerView listaMascotas;
    TextView estrella;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view_mascota);
        setToolBar();
        listaMascotas = (RecyclerView) findViewById(R.id.rvMascota);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();
        //estrella = findViewById(R.id.contadorMascotas);
        //estrella.setText(String.valueOf(totalMascotas()));
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
                Log.i("Uno", "Se presiono Uno");
                return true;
            case R.id.itemAcercaDe:
                Log.i("Dos", "Se presiono Dos");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void inicializarAdaptador () {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        listaMascotas.setAdapter(adaptador);
    }
    public int totalMascotas () {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas);
        return adaptador.getItemCount();
    }

    public void inicializarListaMascotas () {
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.leon,"Catty","5"));
        mascotas.add(new Mascota(R.drawable.gato,"Ronny","5"));
        mascotas.add(new Mascota(R.drawable.leon,"Spay","5"));
        mascotas.add(new Mascota(R.drawable.gato,"Bruno","5"));
    }
    public void setToolBar(){
        Toolbar appBar = findViewById(R.id.appBar);
        setSupportActionBar(appBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}