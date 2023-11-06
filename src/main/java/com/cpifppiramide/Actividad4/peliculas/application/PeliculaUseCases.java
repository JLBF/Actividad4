package com.cpifppiramide.Actividad4.peliculas.application;

import com.cpifppiramide.Actividad4.peliculas.domain.Pelicula;
import com.cpifppiramide.Actividad4.peliculas.domain.PeliculasRepository;

import java.util.List;

public class PeliculaUseCases {

    private PeliculasRepository peliculasRepository;

    public PeliculaUseCases(PeliculasRepository peliculasRepository){
        this.peliculasRepository = peliculasRepository;
    }

    public List<Pelicula> find(Integer id){
        return this.peliculasRepository.find(id);
    }

    public List<Pelicula> save(Integer id, Pelicula pelicula){
        return this.peliculasRepository.save(id, pelicula);
    }

    public List<Pelicula> update(Integer id, String nombre, Double duracion){
        return this.peliculasRepository.update(id, nombre, duracion);
    }

    public List<Pelicula> delete(Integer id, String nombre){
        return this.peliculasRepository.delete(id, nombre);
    }


}
