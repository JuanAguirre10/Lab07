# Laboratorio 07 - Aplicaciones Web con JSTL

Proyecto desarrollado para el curso de Desarrollo de Aplicaciones Web que implementa CRUD completo usando JSP, Servlets, JSTL y MySQL bajo la arquitectura MVC.

## Tecnologías Utilizadas

- Jakarta EE 11
- Apache Tomcat 10.1.44
- Maven
- MySQL 8.0
- JSTL 3.0
- Bootstrap 5
- JDK 24

## Estructura del Proyecto
Lab07/
├── src/main/java/com/tecsup/lab07/
│   ├── config/
│   │   └── ConexionDB.java
│   ├── model/
│   │   ├── Categoria.java
│   │   └── Producto.java
│   ├── dao/
│   │   ├── CategoriaDAO.java
│   │   └── ProductoDAO.java
│   └── controller/
│       ├── CategoriaServlet.java
│       └── ProductoServlet.java
└── src/main/webapp/
├── ejemplo01.jsp
├── ejemplo02.jsp
├── ejemplo03.jsp
├── index.jsp
└── views/
├── categorias/
│   ├── listar.jsp
│   └── form.jsp
└── productos/
├── listar.jsp
└── form.jsp

## Configuración de Base de Datos

CREATE DATABASE lab07_db;

USE lab07_db;

CREATE TABLE categoria (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255)
);

CREATE TABLE producto (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    precio DECIMAL(10,2) NOT NULL,
    stock INT NOT NULL,
    categoria_id INT NOT NULL,
    FOREIGN KEY (categoria_id) REFERENCES categoria(id) ON DELETE CASCADE
);

INSERT INTO categoria (nombre, descripcion) VALUES
('Electrónica', 'Productos electrónicos y tecnología'),
('Ropa', 'Prendas de vestir y accesorios'),
('Alimentos', 'Productos alimenticios y bebidas'),
('Hogar', 'Artículos para el hogar');

INSERT INTO producto (nombre, precio, stock, categoria_id) VALUES
('Laptop HP', 2500.00, 15, 1),
('Mouse Logitech', 45.50, 50, 1),
('Camisa Polo', 89.90, 30, 2),
('Pantalón Jean', 120.00, 25, 2),
('Arroz 5kg', 18.50, 100, 3),
('Aceite 1L', 12.00, 80, 3),
('Almohada', 35.00, 40, 4),
('Sábanas', 65.00, 20, 4);
Configuración de Conexión
Modificar los datos de conexión en ConexionDB.java si es necesario:
javaprivate static final String URL = "jdbc:mysql://localhost:3307/lab07_db";
private static final String USER = "root";
private static final String PASSWORD = "";
Instalación y Ejecución

Clonar el repositorio
Importar el proyecto en IntelliJ IDEA como proyecto Maven
Configurar Tomcat 10.1.44 en IntelliJ
Ejecutar el script SQL en MySQL
Ajustar el puerto de Tomcat a 8081 si el 8080 está ocupado
Ejecutar el proyecto

Funcionalidades
Ejemplos JSTL

Calculadora con operaciones básicas
Listado de cursos con forEach
Manipulación de strings con funciones JSTL

CRUD Categorías

Listar todas las categorías
Crear nueva categoría
Editar categoría existente
Eliminar categoría

CRUD Productos

Listar productos con información de categoría
Crear nuevo producto
Editar producto existente
Eliminar producto

Endpoints

/ - Página principal
/ejemplo01.jsp - Calculadora JSTL
/ejemplo02.jsp - Listado de cursos
/ejemplo03.jsp - Manipulación de strings
/categorias - Gestión de categorías
/productos - Gestión de productos

Patrón de Diseño
El proyecto implementa el patrón MVC:

Model: Clases POJO para representar entidades
View: JSP con JSTL sin scriptlets
Controller: Servlets que procesan peticiones HTTP

Autor
Juan Aguirre Saavedra
Desarrollo de Aplicaciones Web - Sección A
