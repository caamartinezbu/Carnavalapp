package com.controlapp.beto.riosucio;

/**
 * Created by unalman on 3/01/2017.
 */

public class Cuadrilla {

    private String id;
    private String nombre;
    private String nombreCapitan;
    private String ciudad;
    public boolean esta_activo;
    private String linkImagen;
    private String presentacion;
    private String letra_uno;
    private String letra_dos;
    private String letra_tres;
    private String titulo_uno;
    private String titulo_dos;
    private String titulo_tres;


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

    public boolean esta_activo() {
        return esta_activo;
    }

    public void setEsta_activo(boolean esta_activo) {
        this.esta_activo = esta_activo;
    }

    public boolean isEsta_activo() {
        return esta_activo;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }

    public String getLetra_uno() {
        return letra_uno;
    }

    public void setLetra_uno(String letra_uno) {
        this.letra_uno = letra_uno;
    }

    public String getLetra_dos() {
        return letra_dos;
    }

    public void setLetra_dos(String letra_dos) {
        this.letra_dos = letra_dos;
    }

    public String getLetra_tres() {
        return letra_tres;
    }

    public void setLetra_tres(String letra_tres) {
        this.letra_tres = letra_tres;
    }

    public String getTitulo_uno() {
        return titulo_uno;
    }

    public void setTitulo_uno(String titulo_uno) {
        this.titulo_uno = titulo_uno;
    }

    public String getTitulo_dos() {
        return titulo_dos;
    }

    public void setTitulo_dos(String titulo_dos) {
        this.titulo_dos = titulo_dos;
    }

    public String getTitulo_tres() {
        return titulo_tres;
    }

    public void setTitulo_tres(String titulo_tres) {
        this.titulo_tres = titulo_tres;
    }

    public String toString(){
        return "Nombre: " + this.nombre + "\nCapitan: " + this.getNombreCapitan() + "\nCiudad: " + this.ciudad;
    }
}
