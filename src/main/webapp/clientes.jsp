<%-- 
    Document   : Usuarios
    Created on : 14/12/2023, 3:06:22 PM
    Author     : steven
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>UsuarioS</title>
    </head>
    <body>
        <h1>Lista de Usuarios</h1>
        <ul>
            <c:forEach var="Usuario" items="${Usuarios}">
                
                <li>${Usuario.idUsuario} ${Usuario.nombre} ${Usuario.apellido}</li>
    
            </c:forEach>
        </ul>
    </body>
</html>
