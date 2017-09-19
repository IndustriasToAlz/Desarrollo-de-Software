<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Resultado de los datos</h1>
        <ul>
            <li>Nombre : <c:out value="${nombre}" /> </li>
            <li>E-Mail : <c:out value="${correo}" /> </li>
            <li>Pais : <c:out value="${Pais}" /> </li>
        </ul>

    </body>
</html>
