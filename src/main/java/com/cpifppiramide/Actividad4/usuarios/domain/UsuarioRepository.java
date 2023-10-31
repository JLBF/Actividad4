package com.cpifppiramide.Actividad4.usuarios.domain;

import java.util.List;

public interface UsuarioRepository {

    public List<Usuario> getAll();
    public Usuario save(Usuario usuario);
    public Usuario update(Integer id, Usuario usuario);
    public String delete(Integer id);
}
