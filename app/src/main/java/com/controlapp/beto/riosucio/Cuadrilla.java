package com.controlapp.beto.riosucio;

/**
 * Created by unalman on 3/01/2017.
 */

public class Cuadrilla {

    private String id;
    private String nombre;
    private String nombreCapitan;
    private String ciudad;
    private String linkImagen;

    public Cuadrilla() {
    }

    public Cuadrilla(String id, String nombre, String nombreCapitan, String ciudad, String linkImagen) {
        this.id = id;
        this.nombre = nombre;
        this.nombreCapitan = nombreCapitan;
        this.ciudad = ciudad;
        this.linkImagen = linkImagen;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreCapitan() {
        return nombreCapitan;
    }

    public void setNombreCapitan(String nombreCapitan) {
        this.nombreCapitan = nombreCapitan;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getLinkImagen() {
        return linkImagen;
    }

    public void setLinkImagen(String linkImagen) {
        this.linkImagen = linkImagen;
    }

    public String toString(){
        return "Nombre: " + this.nombre + "\nCapitan: " + this.getNombreCapitan() + "\nCiudad: " + this.ciudad;
    }
}
