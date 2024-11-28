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
public class XMLArchivo {
    
    private UUID id;
    private String fileName;
    private byte[] fileData;
    private String uploadedAt;
    
    public XMLArchivo(UUID id, String fileName, byte[] fileData, String uploadedAt1) {
        this.id = UUID.randomUUID();
        this.fileName = fileName;
        this.fileData = fileData;
    }
    
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getFileData() {
        return fileData;
    }

    public void setFileData(byte[] fileData) {
        this.fileData = fileData;
    }

    public String getUploadedAt() {
        return uploadedAt;
    }

    public void setUploadedAt(String uploadedAt) {
        this.uploadedAt = uploadedAt;
    }
    
}
