<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Listado de Categorías</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2 class="mb-4">Gestión de Categorías</h2>

    <a href="categorias?action=nuevo" class="btn btn-primary mb-3">Nueva Categoría</a>
    <a href="${pageContext.request.contextPath}/index.jsp" class="btn btn-secondary mb-3">Volver al Inicio</a>

    <table class="table table-striped table-bordered">
        <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Descripción</th>
            <th>Acciones</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="categoria" items="${categorias}">
            <tr>
                <td>${categoria.id}</td>
                <td>${categoria.nombre}</td>
                <td>${categoria.descripcion}</td>
                <td>
                    <a href="categorias?action=editar&id=${categoria.id}" class="btn btn-warning btn-sm">Editar</a>
                    <a href="categorias?action=eliminar&id=${categoria.id}" class="btn btn-danger btn-sm"
                       onclick="return confirm('¿Está seguro de eliminar esta categoría?')">Eliminar</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>