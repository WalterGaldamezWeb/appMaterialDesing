package com.waltergaldamezweb.appmaterialdesing.database;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.waltergaldamezweb.appmaterialdesing.modelo.Mascota;
import com.waltergaldamezweb.appmaterialdesing.R;

import java.util.ArrayList;

public class ConstructorMascotas {

    private Context context;
    private ArrayList<Mascota> mascotas;

    public ConstructorMascotas(Context context) {
        this.context = context;
    }

    public ArrayList<Mascota> obteberDatos(){
        /*mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota(R.drawable.gato_perro,"Gato Y Perro","5"));
        mascotas.add(new Mascota(R.drawable.peludo,"Peludo","2"));
        mascotas.add(new Mascota(R.drawable.labradores,"Labradores","5"));
        mascotas.add(new Mascota(R.drawable.perrote,"Perrote","8"));
        mascotas.add(new Mascota(R.drawable.labrador_adulto,"Labrador Adulto","12"));
        mascotas.add(new Mascota(R.drawable.gato,"Gato","5"));
        mascotas.add(new Mascota(R.drawable.manchado,"Manchado","7"));
        mascotas.add(new Mascota(R.drawable.pitbull,"Pitbull","1"));
        mascotas.add(new Mascota(R.drawable.leon,"León","8"));
        return mascotas;*/

        BaseDatos db = new BaseDatos(context);
        insertarTresMascotas(db);
        return db.obtenerTodasMacotas();
    }

    public void insertarTresMascotas(BaseDatos db){
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_NOMBRE, "Gato Y Perro");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_FOTO, R.drawable.gato_perro);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_NOMBRE, "Peludo");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_FOTO, R.drawable.peludo);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_NOMBRE, "Labradores");
        contentValues.put(ConstantesBaseDatos.TABLA_MASCOTAS_FOTO, R.drawable.labradores);
        db.insertarMascota(contentValues);
    }

}
