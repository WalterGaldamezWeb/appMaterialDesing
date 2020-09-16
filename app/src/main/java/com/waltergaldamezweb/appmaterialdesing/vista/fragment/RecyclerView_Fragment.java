package com.waltergaldamezweb.appmaterialdesing.vista.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.waltergaldamezweb.appmaterialdesing.modelo.Mascota;
import com.waltergaldamezweb.appmaterialdesing.adapter.MascotaAdaptador;
import com.waltergaldamezweb.appmaterialdesing.R;
import com.waltergaldamezweb.appmaterialdesing.presentador.RecyclerViewFragmentPresentador;

import java.util.ArrayList;

public class RecyclerView_Fragment extends Fragment implements IRecyclerViewMascota {

    ArrayList<Mascota> mascotas;
    public RecyclerView listaMascotas;
    private RecyclerViewFragmentPresentador presentador;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview, container,false);
        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascota);
        presentador = new RecyclerViewFragmentPresentador(this, getContext());
        return v;
    }

    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptador(MascotaAdaptador adaptador) {
        listaMascotas.setAdapter(adaptador);
    }
}
