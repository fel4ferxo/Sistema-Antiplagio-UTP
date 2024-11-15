/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package sistema.antiplagio.test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.JDOMException;

public interface FileHandler {
    void uploadFile(File file) throws IOException;
    File storeTemporarily(File file) throws IOException;
    List<File> listTemporaryFiles();
    Document parseXML(File file) throws JDOMException, IOException;
    boolean compareTextWithXML(String text, Document xmlDocument);
}
