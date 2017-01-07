package com.controlapp.beto.riosucio;

/**
 * Created by JuanSe on 6/01/17.
 */

public class Noticia {

    private int id;
    private String titular;
    private String contenido;
    private String link_imagen;

    public Noticia() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getLink_imagen() {
        return link_imagen;
    }

    public void setLink_imagen(String link_imagen) {
        this.link_imagen = link_imagen;
    }
}
