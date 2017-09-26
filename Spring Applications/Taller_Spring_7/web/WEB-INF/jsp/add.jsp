<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <title>Hola desde Spring Web Mvc</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
    </head>
    <body>
        <div class="container">
            <ol class="breadcrumb">
                <li><a href="<c:url value="/home.htm" />">Listado de Clientes</a></li>
                <li class="active">Agregar</li>
            </ol>
            
                <div class="panel panel-primary">
                    <div class="panel-heading">Formulario</div>
                    <div class="panel-body">
                        <form:form method="post" commandName="clientes">
                            <h1>Complete el formulario</h1>
                            
                            <form:errors path="*" element="div" cssClass="alert alert-danger" />
                            
                            <p>
                                <form:label path="nom_cliente">Nombres:</form:label>
                                <form:input path="nom_cliente" cssClass="form-control" />
                            </p>
                            
                            <p>
                                <form:label path="ape_cliente">Apellidos:</form:label>
                                <form:input path="ape_cliente" cssClass="form-control" />
                            </p>
                            
                            <p>
                                <form:label path="dir_cliente">Direccion</form:label>
                                <form:input path="dir_cliente" cssClass="form-control" />
                            </p>
                            
                            <p>
                                <form:label path="email">Email:</form:label>
                                <form:input path="email" cssClass="form-control" />
                            </p>
                            
                            <p>
                                <form:label path="telefono_cliente">Telefono:</form:label>
                                <form:input path="telefono_cliente" cssClass="form-control" />
                            </p>
                            
                            <hr />
                            
                            <input type="submit" value="Enviar" class="btn btn-danger" />
                        </form:form>
                    </div>
                </div>
        </div>
    </body>
</html>
