package com.waltergaldamezweb.appmaterialdesing;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class RecyclerViewMascota extends AppCompatActivity {


    TextView estrella;
    int contadorLikes;
    ImageButton btnLike;
    private String likes;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Toolbar tootlbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view_mascota);
        /*btnLike = (ImageButton) findViewById(R.id.btnLike);*/
        tootlbar = findViewById(R.id.toolBar);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        /*setToolBar();*/
        setUpViewPager();

        if (tootlbar != null) {
            setSupportActionBar(tootlbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
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


    /*public void setToolBar(){
        Toolbar appBar = findViewById(R.id.appBar);
        setSupportActionBar(appBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }*/

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerView_Fragment());
        fragments.add(new Perfil_Mascota());
        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.lista_mascotas);
        tabLayout.getTabAt(1).setIcon(R.drawable.perfil_mascota);
    }
}