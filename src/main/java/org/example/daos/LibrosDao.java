package org.example.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.example.beans.Libros;

import java.sql.*;

public class LibrosDao extends DaoBase{

    public ArrayList<Libros> listarLibros() {

        ArrayList<Libros> lista = new ArrayList<>();
        String sql = "SELECT id_libro, titulo, autor, anio_publicacion FROM libro";
        try (Connection conn = this.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Libros ls = new Libros();
                ls.setIdLibro(rs.getInt(1));
                ls.setTitulo(rs.getString(2));
                ls.setAutor(rs.getString(3));
                ls.setAnioPublicacion(rs.getInt(4));
                lista.add(ls);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
