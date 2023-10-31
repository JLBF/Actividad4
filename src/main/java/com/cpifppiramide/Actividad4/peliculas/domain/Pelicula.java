package com.cpifppiramide.Actividad4.peliculas.domain;

public class Pelicula {

    private String nombre;
    private Double duracion;

    public Pelicula(String nombre, Double duracion) {
        this.nombre = nombre;
        this.duracion = duracion;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getDuracion() {
        return duracion;
    }

    public void setDuracion(Double duracion) {
        this.duracion = duracion;
    }
}
