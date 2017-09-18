<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
        <title>JSP Page</title>
    <body>
        <div class="content">
            <h1>#manosenelcodigo</h1>
            <table class="table table-bordered">
                <thead>
                    <th>ID</th>
                    <th>Nombre</th>
                </thead>
                <tbody>
                    <tr>
                        <td>
                            1020443492
                        </td>
                        <td>
                            Carlos Tobon
                        </td>
                    </tr>
                    <tr>
                        <td>
                            43433031
                        </td>
                        <td>
                            Piedad Alzate
                        </td>
                    </tr>
                </tbody>
            </table>
            <hr />
            <div class="thumbnail">
                <img src="<c:url value="/public/images/logo.jpg" />" />
            </div>
            <hr />
            <div class="panel panel-info">
                <div class="panel-heading">encabezado</div>
                <div class="panel-body">
                    Basic panel Example
                </div>
            </div>
            <hr />
            <a href="<c:url value="/home.htm" />">ir a home</a>
        </div>
    </body>
</html>
