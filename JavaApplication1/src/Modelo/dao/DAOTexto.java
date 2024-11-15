/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.dao;

import Modelo.Texto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ferna
 */
public class DAOTexto {
    public void insertarTexto(Texto texto) throws SQLException {
        String sql = "INSERT INTO texto (titulo, contenido) VALUES (?,?)";
        try (Connection conn = ConexionBD.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, texto.getTitulo());
            pstmt.setString(2, texto.getContenido());
            pstmt.executeUpdate();
        }
    }
    
    public List<Texto> obtenerTextos() throws SQLException {
        List<Texto> textos = new ArrayList<>();
        String sql = "Select * FROM texto";
        try (Connection conn = ConexionBD.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                Texto texto = new Texto();
                texto.setId(rs.getInt("id"));
                texto.setTitulo(rs.getString("titulo"));
                texto.setContenido(rs.getString("contenido"));
                textos.add(texto);
            }
            
        }
        
        return textos;
    }
}
