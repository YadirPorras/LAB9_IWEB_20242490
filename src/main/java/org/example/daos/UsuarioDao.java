package org.example.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.example.beans.Libros;
import org.example.beans.Usuario;

import java.sql.*;

public class UsuarioDao extends DaoBase{
    public Usuario validarUsuarioPassword(String email, String password){
        Usuario usuario = null;
        String sql = "SELECT * FROM usuario WHERE email = ? AND password_hash = SHA2(?,256)";
        try (Connection conn = this.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);){
             pstmt.setString(1, email);
             pstmt.setString(2, password);

             try (ResultSet waaaa = pstmt.executeQuery()){
                 if(waaaa.next()){
                     usuario = new Usuario();
                     usuario.setIdUsuario(waaaa.getInt("id_usuario"));
                     usuario.setNombres(waaaa.getString("nombres"));
                     usuario.setApellidos(waaaa.getString("apellidos"));
                     usuario.setEmail(waaaa.getString("email"));
                     usuario.setRol(waaaa.getString("rol"));
                     usuario.setEstado(waaaa.getString("estado"));
                 }
             }
        } catch (SQLException ex){
            ex.printStackTrace();
        }
        return usuario;
    }
}
