package com.waltergaldamezweb.appmaterialdesing.vista.fragment;

import com.waltergaldamezweb.appmaterialdesing.modelo.Mascota;
import com.waltergaldamezweb.appmaterialdesing.adapter.MascotaAdaptador;

import java.util.ArrayList;

public interface IRecyclerViewMascota {

    public void generarLinearLayoutVertical();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptador(MascotaAdaptador adaptador);

}
