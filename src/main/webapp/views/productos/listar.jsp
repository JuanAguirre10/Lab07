<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Listado de Productos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2 class="mb-4">Gestión de Productos</h2>

    <a href="productos?action=nuevo" class="btn btn-primary mb-3">Nuevo Producto</a>
    <a href="${pageContext.request.contextPath}/index.jsp" class="btn btn-secondary mb-3">Volver al Inicio</a>

    <table class="table table-striped table-bordered">
        <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Precio</th>
            <th>Stock</th>
            <th>Categoría</th>
            <th>Acciones</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="producto" items="${productos}">
            <tr>
                <td>${producto.id}</td>
                <td>${producto.nombre}</td>
                <td>S/ <fmt:formatNumber value="${producto.precio}" pattern="#,##0.00"/></td>
                <td>${producto.stock}</td>
                <td>${producto.categoriaNombre}</td>
                <td>
                    <a href="productos?action=editar&id=${producto.id}" class="btn btn-warning btn-sm">Editar</a>
                    <a href="productos?action=eliminar&id=${producto.id}" class="btn btn-danger btn-sm"
                       onclick="return confirm('¿Está seguro de eliminar este producto?')">Eliminar</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>