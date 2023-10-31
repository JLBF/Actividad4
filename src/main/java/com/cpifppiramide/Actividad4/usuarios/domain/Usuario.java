package com.cpifppiramide.Actividad4.usuarios.domain;

import com.cpifppiramide.Actividad4.peliculas.domain.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class Usuario {

    private String nombre;
    private List<Pelicula> peliculas;
    public Usuario(String nombre){
        this.nombre = nombre;
        this.peliculas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
