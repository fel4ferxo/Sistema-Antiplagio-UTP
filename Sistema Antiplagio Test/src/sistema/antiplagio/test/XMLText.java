/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema.antiplagio.test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class XMLText implements FileHandler {
    private final List<File> temporaryFiles = new ArrayList<>();
    private final Path tempDir = Paths.get(System.getProperty("java.io.tmpdir"));

    @Override
    public void uploadFile(File file) throws IOException {
        // Implementación de la lógica de subida de archivos
        System.out.println("Archivo subido: " + file.getName());
    }

    @Override
    public File storeTemporarily(File file) throws IOException {
        Path tempFilePath = Files.copy(file.toPath(), tempDir.resolve(file.getName()));
        File tempFile = tempFilePath.toFile();
        temporaryFiles.add(tempFile);
        return tempFile;
    }

    @Override
    public List<File> listTemporaryFiles() {
        return new ArrayList<>(temporaryFiles);
    }

    @Override
    public Document parseXML(File file) throws JDOMException, IOException {
        SAXBuilder saxBuilder = new SAXBuilder();
        return saxBuilder.build(file);
    }

    @Override
    public boolean compareTextWithXML(String text, Document xmlDocument) {
        // Implementación de la lógica de comparación
        Element rootElement = xmlDocument.getRootElement();
        String xmlContent = rootElement.getTextNormalize();
        return xmlContent.contains(text);
    }
}
