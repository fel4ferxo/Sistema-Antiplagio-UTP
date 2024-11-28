/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.UUID;
/**
 *
 * @author ferna
 */
public class ReportePlagio {
    private UUID id;
    private UUID xmlArchivoId;
    private String textRevisado;
    private double porcentajePlagio;
    private String createAt;

    public ReportePlagio(UUID id, UUID xmlArchivoId, String textRevisado, double porcentajePlagio) {
        this.id = UUID.randomUUID();
        this.xmlArchivoId = xmlArchivoId;
        this.textRevisado = textRevisado;
        this.porcentajePlagio = porcentajePlagio;
        this.createAt = createAt;
    }
    
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getXmlArchivoId() {
        return xmlArchivoId;
    }

    public void setXmlArchivoId(UUID xmlArchivoId) {
        this.xmlArchivoId = xmlArchivoId;
    }

    public String getTextRevisado() {
        return textRevisado;
    }

    public void setTextRevisado(String textRevisado) {
        this.textRevisado = textRevisado;
    }

    public double getPorcentajePlagio() {
        return porcentajePlagio;
    }

    public void setPorcentajePlagio(double porcentajePlagio) {
        this.porcentajePlagio = porcentajePlagio;
    }    
    
    public String getCreateAt() {
        return createAt;
    }

    public void setCreateAt(String createAt) {
        this.createAt = createAt;
    }
    
    
}
