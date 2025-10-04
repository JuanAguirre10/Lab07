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

```
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
```

## Configuración de Base de Datos

Ejecutar el siguiente script en MySQL:

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
```

## Configuración de Conexión

Modificar los datos de conexión en `ConexionDB.java` si es necesario:

```java
private static final String URL = "jdbc:mysql://localhost:3307/lab07_db";
private static final String USER = "root";
private static final String PASSWORD = "";
```

## Instalación y Ejecución

1. Clonar el repositorio
2. Importar el proyecto en IntelliJ IDEA como proyecto Maven
3. Configurar Tomcat 10.1.44 en IntelliJ
4. Ejecutar el script SQL en MySQL
5. Ajustar el puerto de Tomcat a 8081 si el 8080 está ocupado
6. Ejecutar el proyecto

## Funcionalidades

### Ejemplos JSTL
- Calculadora con operaciones básicas
- Listado de cursos con forEach
- Manipulación de strings con funciones JSTL

### CRUD Categorías
- Listar todas las categorías
- Crear nueva categoría
- Editar categoría existente
- Eliminar categoría

### CRUD Productos
- Listar productos con información de categoría
- Crear nuevo producto
- Editar producto existente
- Eliminar producto

## Endpoints

- `/` - Página principal
- `/ejemplo01.jsp` - Calculadora JSTL
- `/ejemplo02.jsp` - Listado de cursos
- `/ejemplo03.jsp` - Manipulación de strings
- `/categorias` - Gestión de categorías
- `/productos` - Gestión de productos

## Patrón de Diseño

El proyecto implementa el patrón MVC:
- Model: Clases POJO para representar entidades
- View: JSP con JSTL sin scriptlets
- Controller: Servlets que procesan peticiones HTTP

## Conclusiones

1. JSTL elimina la necesidad de usar scriptlets en JSP, lo que hace el código más limpio y fácil de mantener.

2. La arquitectura MVC separa correctamente la lógica de negocio de la presentación, facilitando el desarrollo y debugging.

3. El patrón DAO centraliza el acceso a la base de datos y permite reutilizar código sin duplicarlo en cada servlet.

4. Las etiquetas de JSTL como c:forEach y c:choose son más intuitivas que escribir bucles y condicionales en Java dentro del JSP.

5. Integrar Jakarta EE con MySQL mediante JDBC es directo, pero requiere manejar correctamente las excepciones y cerrar las conexiones.

## Autor
Juan Aguirre Saavedra
Desarrollo de Aplicaciones Web - Sección A
