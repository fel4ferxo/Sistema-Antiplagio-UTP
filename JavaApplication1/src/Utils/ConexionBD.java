/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author ferna
 */
public class ConexionBD {
    
    private static final String URL = "postgresql://ud1iwc5ri6j1uejafkzq:GDv71jeK7p0N8s2A1VjpZAD8Kt4Rjp@bhlniehgni4dxirxrje5-postgresql.services.clever-cloud.com:50013/bhlniehgni4dxirxrje5";
    private static final String USER = "ud1iwc5ri6j1uejafkzq";
    private static final String PASSWORD = "GDv71jeK7p0N8s2A1VjpZAD8Kt4Rjp";
    
    public static Connection getConnection() throws SQLException {
    
        try{
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);            
        }catch(ClassNotFoundException e){
            throw new SQLException("Error al cargar el driver de Postgresql");
        }
    }

 
}
