package com.waltergaldamezweb.appmaterialdesing;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;
import com.waltergaldamezweb.appmaterialdesing.adapter.PageAdapter;
import com.waltergaldamezweb.appmaterialdesing.vista.fragment.Perfil_Mascota;
import com.waltergaldamezweb.appmaterialdesing.vista.fragment.RecyclerView_Fragment;

import java.util.ArrayList;

public class RecyclerViewMascota extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private Toolbar tootlbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view_mascota);
        tootlbar = findViewById(R.id.toolBar);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
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
                Intent acerca_de_Intent = new Intent(this,AcercaDe.class);
                startActivity(acerca_de_Intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

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