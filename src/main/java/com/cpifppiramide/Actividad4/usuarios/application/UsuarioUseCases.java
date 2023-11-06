package com.cpifppiramide.Actividad4.usuarios.application;

import com.cpifppiramide.Actividad4.usuarios.domain.Usuario;
import com.cpifppiramide.Actividad4.usuarios.domain.UsuarioRepository;

import java.util.List;

public class UsuarioUseCases {

    private UsuarioRepository usuarioRepository;

    public UsuarioUseCases(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> getAll(){
        return this.usuarioRepository.getAll();
    }

    public Usuario save(Usuario usuario){
        return this.usuarioRepository.save(usuario);
    }

    public Usuario update(Integer id, String nombre){
        return this.usuarioRepository.update(id, nombre);
    }

    public String delete(Integer id){
        return this.usuarioRepository.delete(id);
    }
}
