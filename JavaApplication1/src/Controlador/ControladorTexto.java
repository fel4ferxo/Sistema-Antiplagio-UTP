/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Texto;
import Modelo.dao.DAOTexto;

/**
 *
 * @author ferna
 */
public class ControladorTexto {
    private DAOTexto daoTexto;
    
    public ControladorTexto() {
        daoTexto = new DAOTexto();
    }
    
    public void agregarTexto(String titulo, String contenido) {
        Texto texto = new Texto();
        texto.setTitulo(titulo);
        texto.setContenido(contenido);
        
        try {
            daoTexto.insertarTexto(texto);
            System.out.println("Texto Agregado exitosamente");
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
