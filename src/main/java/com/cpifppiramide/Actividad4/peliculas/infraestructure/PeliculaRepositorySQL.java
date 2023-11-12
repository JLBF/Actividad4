package com.cpifppiramide.Actividad4.peliculas.infraestructure;

import com.cpifppiramide.Actividad4.peliculas.domain.Pelicula;
import com.cpifppiramide.Actividad4.peliculas.domain.PeliculasRepository;
import com.cpifppiramide.context.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PeliculaRepositorySQL implements PeliculasRepository {

    Connection con = ConnectionManager.getConnection();

    @Override
    public List<Pelicula> find(Integer idUsuario) {
        List<Pelicula> peliculas = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM peliculas WHERE idUsuario = ?");
            ps.setInt(1, idUsuario);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                Pelicula pelicula = new Pelicula(
                        rs.getString("nombre"),
                        rs.getDouble("duracion")
                );
                peliculas.add(pelicula);
            }

            rs.close();
            ps.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return peliculas;
    }

    @Override
    public List<Pelicula> save(Integer idUsuario, Pelicula pelicula) {
        List<Pelicula> peliculas = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO peliculas (nombre, duracion, idUsuario) values (?,?,?)");
            ps.setString(1, pelicula.getNombre());
            ps.setDouble(2,pelicula.getDuracion());
            ps.setInt(3, idUsuario);

            ps.executeUpdate();

            PreparedStatement ps1 = con.prepareStatement("SELECT * FROM peliculas WHERE idUsuario = ?");
            ps1.setInt(1, idUsuario);

            ResultSet rs = ps1.executeQuery();

            while(rs.next()){
                Pelicula peliculaLista = new Pelicula(
                        rs.getString("nombre"),
                        rs.getDouble("duracion")
                );
                peliculas.add(peliculaLista);
            }

            ps.close();
            ps1.close();
            rs.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return peliculas;
    }

    @Override
    public List<Pelicula> update(Integer idUsuario, String nombre, Double duracion) {

        List<Pelicula> peliculas = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement("UPDATE peliculas SET nombre = ?, duracion = ? WHERE idUsuario = ?");
            ps.setString(1, nombre);
            ps.setDouble(2, duracion);
            ps.setInt(3, idUsuario);

            ps.executeUpdate();

            PreparedStatement ps1 = con.prepareStatement("SELECT * FROM peliculas WHERE idUsuario = ?");
            ps1.setInt(1, idUsuario);

            ResultSet rs = ps1.executeQuery();

            while(rs.next()){
                Pelicula peliculaLista = new Pelicula(
                        rs.getString("nombre"),
                        rs.getDouble("duracion")
                );
                peliculas.add(peliculaLista);
            }

            ps.close();
            ps1.close();
            rs.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return peliculas;
    }

    @Override
    public List<Pelicula> delete(Integer idUsuario, String nombre) {
        List<Pelicula> peliculas = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM peliculas WHERE idUsuario = ? AND nombre = ?");
            ps.setInt(1, idUsuario);
            ps.setString(2, nombre);

            ps.executeUpdate();

            PreparedStatement ps1 = con.prepareStatement("SELECT * FROM peliculas WHERE idUsuario = ?");
            ps1.setInt(1, idUsuario);

            ResultSet rs = ps1.executeQuery();

            while(rs.next()){
                Pelicula peliculaLista = new Pelicula(
                        rs.getString("nombre"),
                        rs.getDouble("duracion")
                );
                peliculas.add(peliculaLista);
            }

            ps.close();
            ps1.close();
            rs.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return peliculas;
    }
}
