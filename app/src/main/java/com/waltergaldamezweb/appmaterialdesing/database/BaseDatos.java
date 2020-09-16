package com.waltergaldamezweb.appmaterialdesing.database;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.waltergaldamezweb.appmaterialdesing.modelo.Mascota;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String queryCrearTablaMascota = " CREATE TABLE " + ConstantesBaseDatos.TABLA_MASCOTAS + "(" +
                ConstantesBaseDatos.TABLA_MASCOTAS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLA_MASCOTAS_NOMBRE + " TEXT, " +
                ConstantesBaseDatos.TABLA_MASCOTAS_FOTO + " INTEGER " +
                ")";

        String queryCrearTablaLikesContacto = " CREATE TABLE " + ConstantesBaseDatos.TABLA_LIKES_MASCOTAS + "(" +
                ConstantesBaseDatos.TABLA_LIKES_MASCOTAS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLA_LIKES_MASCOTAS_ID_MASCOTA + " INTEGER, " +
                ConstantesBaseDatos.TABLA_LIKES_MASCOTAS_NUMERO_LIKES + "INTEGER, " +
                " FOREIGN KEY (" + ConstantesBaseDatos.TABLA_LIKES_MASCOTAS_ID + ")" +
                " REFERENCES " + ConstantesBaseDatos.TABLA_MASCOTAS + "(" + ConstantesBaseDatos.TABLA_MASCOTAS_ID + ")" +
                ")";

        db.execSQL(queryCrearTablaMascota);
        db.execSQL(queryCrearTablaLikesContacto);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLA_MASCOTAS);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLA_LIKES_MASCOTAS);
        onCreate(db);
    }

    public ArrayList<Mascota> obtenerTodasMacotas(){
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLA_MASCOTAS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query,null);

        while (registros.moveToNext()) {
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombreMascota(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));

            mascotas.add(mascotaActual);
        }
        db.close();
        return mascotas;
    }

    public void insertarMascota(ContentValues contentValues) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLA_MASCOTAS, null, contentValues);
        db.close();
    }
}
