/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import DAO.ReportePlagioDAO;
import java.io.IOException;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.XMLArchivoDAO;
import Modelo.ReportePlagio;
import Modelo.XMLArchivo;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ferna
 */

@WebServlet("/uploadXML")
public class XMLControlador extends HttpServlet {
        
    protected void doPostXML(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UUID id = UUID.randomUUID();
        String fileName = request.getParameter("fileName");
        byte[] fileData = request.getPart("file").getInputStream().readAllBytes();
        String uploadedAt = java.time.LocalDateTime.now().toString();
        
        XMLArchivo xmlFile = new XMLArchivo(id, fileName, fileData, uploadedAt);
        XMLArchivoDAO xmlFileDAO = new XMLArchivoDAO();

        try {
            // Guardar el archivo XML en la base de datos
            UUID fileId = xmlFileDAO.saveXMLArchivo(xmlFile);
            response.getWriter().write("Archivo XML cargado exitosamente. ID del archivo: " + fileId);
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().write("Error al cargar el archivo.");
        }
    }
    
    protected void doGetXML(JTable table){
        XMLArchivoDAO xmlArchivoDAO = new XMLArchivoDAO();
        
        try {
            // Obtener la lista de archivos XML
            List<XMLArchivo> archivos = xmlArchivoDAO.obtenerListaArchivos();
            
            // Crear un arreglo de datos para la tabla
            Object[][] data = new Object[archivos.size()][4]; // 4 columnas (id, fileName, uploadedAt)
            
            for (int i = 0; i < archivos.size(); i++) {
                XMLArchivo archivo = archivos.get(i);
                data[i][0] = archivo.getId();
                data[i][1] = archivo.getFileName();
                data[i][2] = archivo.getUploadedAt();
            }
            
            // Columnas de la tabla
            String[] columnNames = {"ID", "File Name", "Uploaded At"};
            
            // Crear el modelo de la tabla
            DefaultTableModel model = new DefaultTableModel(data, columnNames);
            table.setModel(model);
            
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al obtener los archivos XML.");
        }
    }
    
    protected void doPostReporte(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        // Obtener parámetros del request
        UUID xmlArchivoId = UUID.fromString(request.getParameter("xmlArchivoId"));  // ID del archivo XML
        String textRevisado = request.getParameter("textRevisado");  // Texto revisado
        double porcentajePlagio = Double.parseDouble(request.getParameter("porcentajePlagio"));  // Porcentaje de plagio
        
        // Crear objeto ReportePlagio con los datos obtenidos
        ReportePlagio reportePlagio = new ReportePlagio(UUID.randomUUID(), xmlArchivoId, textRevisado, porcentajePlagio);
        
        // Instanciar el DAO para ReportePlagio
        ReportePlagioDAO reportePlagioDAO = new ReportePlagioDAO();
        
        try {
            // Guardar el reporte de plagio en la base de datos
            UUID reporteId = reportePlagioDAO.guardarReportPlagio(reportePlagio);
            
            // Devolver respuesta con el ID del reporte de plagio guardado
            response.getWriter().write("Reporte de Plagio guardado exitosamente. ID: " + reporteId);
        } catch (SQLException e) {
            e.printStackTrace();
            response.getWriter().write("Error al guardar el reporte de plagio.");
        }
    }
    
    protected void doGetReporte(JTable table){
        ReportePlagioDAO reportePlagioDAO = new ReportePlagioDAO();
        
        try {
            // Obtener la lista de archivos XML
            List<ReportePlagio> reportes = reportePlagioDAO.obtenerListaReportes();
            
            // Crear un arreglo de datos para la tabla
            Object[][] data = new Object[reportes.size()][4]; // 4 columnas (id, fileName, uploadedAt)
            
            for (int i = 0; i < reportes.size(); i++) {
                ReportePlagio reporte = reportes.get(i);
                data[i][0] = reporte.getId();
                data[i][1] = reporte.getXmlArchivoId();
                data[i][2] = reporte.getTextRevisado();
                data[i][3] = reporte.getPorcentajePlagio();
                data[i][4] = reporte.getCreateAt();
            }
            
            // Columnas de la tabla
            String[] columnNames = {"ID", "Texto Analizado", "Resultado"};
            
            // Crear el modelo de la tabla
            DefaultTableModel model = new DefaultTableModel(data, columnNames);
            table.setModel(model);
            
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al obtener los archivos XML.");
        }
    }
    
}
