/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author ferna
 */
public class ConexionBD {
    
    private static final String URL = "jdbc:postgresql://localhost:9856/verificador_plagio";
    private static final String USER = "Administrator";
    private static final String PASSWORD = "admin";
    
    public static Connection getConnection() throws SQLException {
    
        try{
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);            
        }catch(ClassNotFoundException e){
            throw new SQLException("Error al cargar el driver de Postgresql");
        }
    }
}
