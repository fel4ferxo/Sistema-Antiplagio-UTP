/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Modelo.ReportePlagio;
import Utils.ConexionBD;
import java.sql.*;
import java.util.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 *
 * @author ferna
 */
public class ReportePlagioDAO {
    
    public UUID guardarReportPlagio (ReportePlagio reporte) throws SQLException {
        
        String query = "INSERT INTO plagiarism_reports (xml_file_id, reviewed_text, plagiarism_percentage) VALUES (?, ?, ?) RETURNING id";
        try (Connection conn = ConexionBD.getConnection();
                 PreparedStatement stmt = conn.prepareStatement(query)) {
            
            stmt.setObject(1, reporte.getXmlArchivoId());
            stmt.setString(2, reporte.getTextRevisado());
            stmt.setDouble(3, reporte.getPorcentajePlagio());
            
            ResultSet resultSet = stmt.executeQuery();
            if(resultSet.next()) {
                return (UUID) resultSet.getObject("id");
            }
        }
        
        return null;
    }
    
    
    public List<ReportePlagio> obtenerListaReportes() throws SQLException {
        List<ReportePlagio> listaReportes = new ArrayList<>();
        String query = "SELECT id, xml_file_id, reviewed_text, plagiarism_percentage FROM plagiarism_reports";
        
        try (Connection conn = ConexionBD.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            
            while (rs.next()) {
                UUID id = (UUID) rs.getObject("id");
                UUID xmlFileId = (UUID) rs.getObject("xml_file_id");
                String reviewedText = rs.getString("reviewed_text");
                double plagiarismPercentage = rs.getDouble("plagiarism_percentage");
                String createAt = rs.getString("createAt");

                ReportePlagio reporte = new ReportePlagio(id, xmlFileId, reviewedText, plagiarismPercentage);
                listaReportes.add(reporte);
            }
        }
        return listaReportes;
    }
    
}
