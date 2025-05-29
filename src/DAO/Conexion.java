package dao;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;


public class Conexion {

    private static final String URL = "jdbc:sqlite:hiraoka.db";


    public static Connection conectar() {

        try {

            return DriverManager.getConnection(URL);

        } catch (SQLException e) {

            System.out.println("Error de conexión: " + e.getMessage());

            return null;

        }
    }
}