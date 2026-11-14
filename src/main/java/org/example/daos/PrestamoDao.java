package org.example.daos;

import org.example.beans.Prestamo;

import java.sql.*;
import java.util.ArrayList;


public class PrestamoDao extends DaoBase{

    public void registrarPrestamo(int idUsuario, int idLibro){
        String sql = "INSERT INTO prestamo (id_usuario, id_libro, fecha_prestamo, fecha_limite) + VALUES (?. ?. CURDATE(), DATE_ADD(CURDATE(), INTERVAL 7 DAY))";
        try (Connection conn = this.getConnection();
             PreparedStatement hola = conn.prepareStatement(sql);){
            hola.setInt(1,idUsuario);
            hola.setInt(2,idLibro);
            hola.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Prestamo> listarPrestamoUsuario(){

        ArrayList<Prestamo> lista = new ArrayList<>();
        String sql = "SELECT * FROM prestamo";
        try (Connection conn = this.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Prestamo ls = new Prestamo();
                ls.setIdPrestamo(rs.getInt("id_prestamo"));
                ls.setIdUsuario(rs.getInt("id_usuario"));
                ls.setIdLibro(rs.getInt("id_libro"));
                ls.setFechaPrestamo(rs.getString("fecha_prestamo"));
                ls.setFechaPrestamo(rs.getString("fecha_limite"));
                lista.add(ls);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
