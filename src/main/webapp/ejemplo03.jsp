<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
    <title>Manipulación de Datos con JSTL</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="container mt-5">
<h2 class="mb-4">Manipulación de Datos con JSTL</h2>

<c:set var="nombres" value="ana,juan,carlos,maria,beatriz" />
<c:set var="nombresList" value="${fn:split(nombres, ',')}" />

<table class="table table-bordered">
    <thead class="table-light">
    <tr>
        <th>#</th>
        <th>Nombre original</th>
        <th>Mayúsculas</th>
        <th>Número de caracteres</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="nombre" items="${nombresList}" varStatus="estado">
        <tr>
            <td>${estado.count}</td>
            <td>${nombre}</td>
            <td>${fn:toUpperCase(nombre)}</td>
            <td>${fn:length(nombre)}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<h4 class="mt-4">Nombres con más de 5 letras:</h4>
<ul>
    <c:forEach var="nombre" items="${nombresList}">
        <c:if test="${fn:length(nombre) > 5}">
            <li>${fn:toUpperCase(nombre)} (${fn:length(nombre)} letras)</li>
        </c:if>
    </c:forEach>
</ul>

<a href="index.jsp" class="btn btn-secondary">Volver al Inicio</a>
</body>
</html>