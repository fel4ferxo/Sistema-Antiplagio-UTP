/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.XMLArchivo;
import Utils.ConexionBD;
import java.sql.*;
import java.util.*;

/**
 *
 * @author ferna
 */
public class XMLArchivoDAO {
    public UUID saveXMLArchivo(XMLArchivo xmlfile) throws SQLException{
        String query = "INSERRT INTO xml_files (file_name, file_data) VALUES (?, ?) RETURNIN id";
        try (Connection conn = ConexionBD.getConnection();
                PreparedStatement stmt = conn.prepareStatement(query)) {
            
            UUID id = UUID.randomUUID();
            stmt.setObject(1, id);
            stmt.setString(2, xmlfile.getFileName());
            stmt.setBytes(3, xmlfile.getFileData());
            
            stmt.executeUpdate();

            return id;
        }
        
    }
    
    public List<XMLArchivo> obtenerListaArchivos() throws SQLException {
        List<XMLArchivo> listaArchivos = new ArrayList<>();
        String query = "SELECT id, file_name, file_data, uploaded_at FROM xml_files";  // Suponiendo que la tabla se llama 'xml_files'
        
        try (Connection conn = ConexionBD.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            
            while (rs.next()) {
                UUID id = (UUID) rs.getObject("id");  // Asumiendo que el campo 'id' es de tipo UUID
                String fileName = rs.getString("file_name");  // El nombre del archivo
                byte[] fileData = rs.getBytes("file_data");  // Los datos del archivo en byte[]
                String uploadedAt = rs.getString("uploaded_at");  // Fecha de subida del archivo
                
                // Crear el objeto ArchivoXml y agregarlo a la lista
                XMLArchivo archivoXml = new XMLArchivo(id, fileName, fileData, uploadedAt);
                listaArchivos.add(archivoXml);
            }
        }
        return listaArchivos;
    }
}
