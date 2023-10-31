package com.cpifppiramide.Actividad4.usuarios.infraestructure;

import com.cpifppiramide.Actividad4.usuarios.domain.Usuario;
import com.cpifppiramide.Actividad4.usuarios.domain.UsuarioRepository;
import com.cpifppiramide.context.ConnectionManager;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioRepositorySQL implements UsuarioRepository {

    private Connection con = ConnectionManager.getConnection();

    @Override
    public List<Usuario> getAll() {
        List<Usuario> usuarios = new ArrayList<>();

        try {
            Statement stmnt = con.createStatement();
            ResultSet rs = stmnt.executeQuery("SELECT nombre FROM usuarios");

            while(rs.next()){
                Usuario usuario = new Usuario(
                        rs.getString("nombre")
                );
                usuarios.add(usuario);
            }

            stmnt.close();
            rs.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return usuarios;
    }

    @Override
    public Usuario save(Usuario usuario) {
        Usuario usuarioGuardado = null;

        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO usuarios (nombre) VALUES(?)");
            ps.setString(1, usuario.getNombre());

            int rowAffected = ps.executeUpdate();

            if(rowAffected > 0){
                usuarioGuardado = usuario;
            }

            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return usuarioGuardado;
    }

    @Override
    public Usuario update(Integer id, Usuario usuario) {
        return null;
    }

    @Override
    public String delete(Integer id) {

        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM usuarios WHERE id = ?");
            ps.setInt(1, id);

            int rowAffected = ps.executeUpdate();
            if(rowAffected <= 0){
                return "El usuario no se ha encontrado en la base de datos";
            }

            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return "Usuario eliminado";
    }
}
