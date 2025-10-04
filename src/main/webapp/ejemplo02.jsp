<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Listado de Cursos</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5">
<h2 class="mb-4">Listado de Cursos</h2>

<c:set var="listaCursos" value="${[
        {'curCodigo':'C001', 'vchNombre':'Matemáticas', 'intCreditos':3},
        {'curCodigo':'C002', 'vchNombre':'Física', 'intCreditos':4},
        {'curCodigo':'C003', 'vchNombre':'Historia', 'intCreditos':2}
    ]}" />

<table class="table table-bordered table-striped">
    <thead class="table-dark">
    <tr>
        <th>Código</th>
        <th>Nombre</th>
        <th>Créditos</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="curso" items="${listaCursos}">
        <tr>
            <td>${curso.curCodigo}</td>
            <td>${curso.vchNombre}</td>
            <td>${curso.intCreditos}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<a href="index.jsp" class="btn btn-secondary">Volver al Inicio</a>
</body>
</html>