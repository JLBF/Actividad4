package com.cpifppiramide.Actividad4.peliculas.infraestructure;

import com.cpifppiramide.Actividad4.peliculas.application.PeliculaUseCases;
import com.cpifppiramide.Actividad4.peliculas.domain.Pelicula;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PeliculaRestController {

    private PeliculaUseCases peliculaUseCases;

    public PeliculaRestController(){
        this.peliculaUseCases = new PeliculaUseCases(new PeliculaRepositorySQL());
    }

    @GetMapping("/usuario/{id}/peliculas")
    public List<Pelicula> find(@PathVariable Integer id){
        return this.peliculaUseCases.find(id);
    }

    @PostMapping("/usuario/{id}/peliculas")
    public List<Pelicula> save(@PathVariable Integer id, @RequestBody Pelicula pelicula){
        return this.peliculaUseCases.save(id, pelicula);
    }

    @PutMapping("/usuarios/{id}/pelicula/{nombre}")
    public List<Pelicula> update(@PathVariable Integer id, @PathVariable String nombre, @RequestBody Double duracion){
        return this.peliculaUseCases.update(id, nombre, duracion);
    }

    @DeleteMapping("/usuarios/{id}/pelicula/{nombre}")
    public List<Pelicula> delete(@PathVariable Integer id, @PathVariable String nombre){
        return this.peliculaUseCases.delete(id, nombre);
    }
}
