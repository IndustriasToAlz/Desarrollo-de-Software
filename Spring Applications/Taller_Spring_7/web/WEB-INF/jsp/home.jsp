<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Ejemplo de JDBC_Template</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
    </head>
    <body>
        <div class="container">
            <div class="row">
                <h1>Ejemplo de JDBC_Template</h1>
                <p>
                    <a href="<c:url value="add.htm" />" class="btn btn-success"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span> Agregar</a>
                </p>
                
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                        <tr>
                            <th>COD_CLIENTE</th>
                            <th>NOM_CLIENTE</th>
                            <th>APE_CLEINTE</th>
                            <th>DIR_CLIENTE</th>
                            <th>EMAIL</th>
                            <th>TELEFONO_CLIENTE</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${datos}" var="dato">
                            <tr>
                                <td><c:out value="${dato.COD_CLIENTE}"/></td>
                                <td><c:out value="${dato.NOM_CLIENTE}"/></td>
                                <td><c:out value="${dato.APE_CLEINTE}"/></td>
                                <td><c:out value="${dato.DIR_CLIENTE}"/></td>
                                <td><c:out value="${dato.EMAIL}"/></td>
                                <td><c:out value="${dato.TELEFONO_CLIENTE}"/></td>
                                <td>
                                    <a href="<c:url value="edit.htm?cod_cliente=${dato.COD_CLIENTE}" />" ><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>
                                    <a href="<c:url value="delete.htm?cod_cliente=${dato.COD_CLIENTE}" />" ><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
