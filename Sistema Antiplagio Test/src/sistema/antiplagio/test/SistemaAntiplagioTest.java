/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package sistema.antiplagio.test;

import java.io.File;
import java.io.IOException;
import org.jdom2.Document;
import org.jdom2.JDOMException;

public class SistemaAntiplagioTest {
    public static void main(String[] args) {
        XMLText xmlText = new XMLText();
        File file = new File("XML/Test.xml"); // Reemplaza con la ruta de tu archivo XML

        try {
            // Subir el archivo
            xmlText.uploadFile(file);

            // Almacenar temporalmente el archivo
            File tempFile = xmlText.storeTemporarily(file);
            System.out.println("Archivo almacenado temporalmente en: " + tempFile.getAbsolutePath());

            // Analizar el archivo XML
            Document xmlDocument = xmlText.parseXML(tempFile);
            System.out.println("Archivo XML analizado correctamente.");

            // Comparar texto con el contenido del XML
            String textToCompare = "texto a comparar"; // Reemplaza con el texto que deseas comparar
            boolean isTextPresent = xmlText.compareTextWithXML(textToCompare, xmlDocument);
            System.out.println("¿El texto está presente en el XML? " + isTextPresent);

        } catch (IOException | JDOMException e) {
            e.printStackTrace();
        }
    }
}
