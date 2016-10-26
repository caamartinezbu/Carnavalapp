package com.controlapp.beto.riosucio;

/**
 * Created by Beto on 06/10/2016.
 */
public class Tarjeta {
    //construimos el DataSet- POJO fotos como una entidad
    private int foto;
    private String nombre;

    public Tarjeta(int foto, String nombre) {
        this.foto = foto;
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {

        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
