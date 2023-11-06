package com.cpifppiramide.Actividad4.peliculas.domain;

import java.util.List;

public interface PeliculasRepository {

    public List<Pelicula> find(Integer id);
    public List<Pelicula> save(Integer id, Pelicula pelicula);
    public List<Pelicula> update(Integer id, String nombre, Double duracion);
    public List<Pelicula> delete(Integer id, String nombre);
}
