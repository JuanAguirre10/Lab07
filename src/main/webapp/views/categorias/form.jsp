<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Formulario Categoría</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2 class="mb-4">
        <c:choose>
            <c:when test="${categoria != null}">Editar Categoría</c:when>
            <c:otherwise>Nueva Categoría</c:otherwise>
        </c:choose>
    </h2>

    <form method="post" action="categorias">
        <c:if test="${categoria != null}">
            <input type="hidden" name="id" value="${categoria.id}">
        </c:if>

        <div class="mb-3">
            <label for="nombre" class="form-label">Nombre:</label>
            <input type="text" class="form-control" id="nombre" name="nombre"
                   value="${categoria.nombre}" required>
        </div>

        <div class="mb-3">
            <label for="descripcion" class="form-label">Descripción:</label>
            <textarea class="form-control" id="descripcion" name="descripcion"
                      rows="3">${categoria.descripcion}</textarea>
        </div>

        <c:choose>
            <c:when test="${categoria != null}">
                <input type="hidden" name="action" value="actualizar">
                <button type="submit" class="btn btn-success">Actualizar</button>
            </c:when>
            <c:otherwise>
                <input type="hidden" name="action" value="insertar">
                <button type="submit" class="btn btn-primary">Guardar</button>
            </c:otherwise>
        </c:choose>

        <a href="categorias" class="btn btn-secondary">Cancelar</a>
    </form>
</div>
</body>
</html>