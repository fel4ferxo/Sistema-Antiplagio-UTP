## Sistema-Antiplagio-UTP


Este proyecto implementa un sistema de detección de plagio en Java siguiendo el patrón de diseño Modelo-Vista-Controlador (MVC) y utilizando Java Swing para la interfaz gráfica. El sistema permite comparar un texto ingresado con textos de referencia almacenados en archivos XML para identificar posibles casos de plagio.

## Características Principales

- **Patrón MVC**: Separación clara entre el modelo (lógica de negocio), vista (interfaz gráfica) y controlador (gestión de eventos).
- **Similitud de Jaccard**: Usa el índice de similitud de Jaccard para comparar el texto de entrada con los textos almacenados en archivos XML.
- **Carga Dinámica de Archivos XML**: Los textos de referencia para la detección de plagio se almacenan en archivos XML dentro de una carpeta específica.
- **Umbral de Similitud Ajustable**: Posibilidad de ajustar el umbral que determina cuándo un texto es considerado plagio.
- **Interfaz Gráfica con Java Swing**: Proporciona una interfaz de usuario visual para ingresar el texto, realizar la comparación y visualizar los resultados.

## Estructura del Proyecto

```plaintext
.
├── src
│   ├── controller
│   │   └── PlagiarismController.java
│   ├── model
│   │   └── PlagiarismModel.java
│   ├── view
│   │   └── PlagiarismView.java
│   └── Main.java
└── resources
    ├── texto_ejemplo.xml
    └── otros_archivos_xml.xml
