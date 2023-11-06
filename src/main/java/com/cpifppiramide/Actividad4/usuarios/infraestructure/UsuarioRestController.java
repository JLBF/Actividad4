package com.cpifppiramide.Actividad4.usuarios.infraestructure;

import com.cpifppiramide.Actividad4.usuarios.application.UsuarioUseCases;
import com.cpifppiramide.Actividad4.usuarios.domain.Usuario;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioRestController {

    private UsuarioUseCases usuarioUseCases;

    public UsuarioRestController(){
        this.usuarioUseCases = new UsuarioUseCases(new UsuarioRepositorySQL());
    }

    @GetMapping("/usuarios")
    public List<Usuario> getAll(){
        return this.usuarioUseCases.getAll();
    }

    @PostMapping(path = "/usuarios", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Usuario save(@RequestBody Usuario usuario){
        return this.usuarioUseCases.save(usuario);
    }

    @PutMapping(path = "/usuarios/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Usuario update(@PathVariable Integer id, @RequestBody String nombre){
        return this.usuarioUseCases.update(id, nombre);
    }

    @DeleteMapping("/usuarios/{id}")
    public String delete(@PathVariable Integer id){
        return this.usuarioUseCases.delete(id);
    }
}
