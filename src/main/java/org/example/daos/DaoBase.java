package org.example.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public abstract class DaoBase {

    public Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String user = "root"; //cambiar de acuerdo a su base de datos
        String pass = "root1234"; //cambiar de acuerdo a su base de datos
        String url = "jdbc:mysql://localhost:3306/lab9_biblioteca?serverTimezone=America/Lima";
        return DriverManager.getConnection(url, user, pass);
    }
}

