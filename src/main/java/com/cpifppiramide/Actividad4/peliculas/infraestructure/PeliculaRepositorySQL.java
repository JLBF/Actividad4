package com.cpifppiramide.Actividad4.peliculas.infraestructure;

import com.cpifppiramide.Actividad4.peliculas.domain.Pelicula;
import com.cpifppiramide.Actividad4.peliculas.domain.PeliculasRepository;

import java.util.List;

public class PeliculaRepositorySQL implements PeliculasRepository {
    @Override
    public List<Pelicula> find(Integer id) {
        return null;
    }

    @Override
    public List<Pelicula> save(Integer id, Pelicula pelicula) {
        return null;
    }

    @Override
    public List<Pelicula> update(Integer id, String nombre, Double duracion) {
        return null;
    }

    @Override
    public List<Pelicula> delete(Integer id, String nombre) {
        return null;
    }
}
