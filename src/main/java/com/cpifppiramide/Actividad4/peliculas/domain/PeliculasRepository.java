package com.cpifppiramide.Actividad4.peliculas.domain;

import java.util.List;

public interface PeliculasRepository {

    public List<Pelicula> find(Integer id);
    public List<Pelicula> save(Pelicula pelicula);
}
