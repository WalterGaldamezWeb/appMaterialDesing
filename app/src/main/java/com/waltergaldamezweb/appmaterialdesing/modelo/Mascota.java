package com.waltergaldamezweb.appmaterialdesing.modelo;

public class Mascota {
    private int id;
    private int foto;
    private String nombreMascota;
    private String likes;

    public Mascota() {
    }

    public Mascota(int foto, String nombreMascota, String likes) {
        this.foto = foto;
        this.nombreMascota = nombreMascota;
        this.likes = likes;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombreMascota() {
        return nombreMascota;
    }

    public void setNombreMascota(String nombreMascota) {
        this.nombreMascota = nombreMascota;
    }

    public String getLikes() {
        return likes;
    }

    public void setLikes(String likes) {
        this.likes = likes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
