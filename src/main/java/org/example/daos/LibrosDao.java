package org.example.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.example.beans.Libros;

import java.sql.*;
import java.util.ArrayList;

public class LibrosDao extends DaoBase{

    public ArrayList<Libros> listarLibros() {

        ArrayList<Libros> lista = new ArrayList<>();
        String sql = "SELECT * FROM libro";
        try (Connection conn = this.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Libros ls = new Libros();
                ls.setId_libro(rs.getInt("id_libro"));
                ls.setId_genero(rs.getInt("id_genero"));
                ls.setTitulo(rs.getString("titulo"));
                ls.setAutor(rs.getString("autor"));
                ls.setAnio_publicacion(rs.getInt("anio_publicacion"));
                lista.add(ls);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
