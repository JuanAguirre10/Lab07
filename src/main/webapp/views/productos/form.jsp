<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Formulario Producto</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2 class="mb-4">
        <c:choose>
            <c:when test="${producto != null}">Editar Producto</c:when>
            <c:otherwise>Nuevo Producto</c:otherwise>
        </c:choose>
    </h2>

    <form method="post" action="productos">
        <c:if test="${producto != null}">
            <input type="hidden" name="id" value="${producto.id}">
        </c:if>

        <div class="mb-3">
            <label for="nombre" class="form-label">Nombre:</label>
            <input type="text" class="form-control" id="nombre" name="nombre"
                   value="${producto.nombre}" required>
        </div>

        <div class="mb-3">
            <label for="precio" class="form-label">Precio:</label>
            <input type="number" step="0.01" class="form-control" id="precio" name="precio"
                   value="${producto.precio}" required>
        </div>

        <div class="mb-3">
            <label for="stock" class="form-label">Stock:</label>
            <input type="number" class="form-control" id="stock" name="stock"
                   value="${producto.stock}" required>
        </div>

        <div class="mb-3">
            <label for="categoriaId" class="form-label">Categoría:</label>
            <select class="form-control" id="categoriaId" name="categoriaId" required>
                <option value="">Seleccione una categoría</option>
                <c:forEach var="categoria" items="${categorias}">
                    <option value="${categoria.id}"
                            <c:if test="${producto.categoriaId == categoria.id}">selected</c:if>>
                            ${categoria.nombre}
                    </option>
                </c:forEach>
            </select>
        </div>

        <c:choose>
            <c:when test="${producto != null}">
                <input type="hidden" name="action" value="actualizar">
                <button type="submit" class="btn btn-success">Actualizar</button>
            </c:when>
            <c:otherwise>
                <input type="hidden" name="action" value="insertar">
                <button type="submit" class="btn btn-primary">Guardar</button>
            </c:otherwise>
        </c:choose>

        <a href="productos" class="btn btn-secondary">Cancelar</a>
    </form>
</div>
</body>
</html>