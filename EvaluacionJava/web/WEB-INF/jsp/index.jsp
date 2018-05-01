<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html ng-app="EvaluacionJava">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>EVALUACION DE JAVA</title>
    </head>

    <body ng-controller="Controller">
        <form>
            <table>
                <tbody>
                    <tr>
                        <th>EVALUACION DE JAVA</th>
                    </tr>
                    <tr>
                        <td>
                            Cedula Cliente
                        </td>
                        <td>
                            <input type="text" id="txtCedulaCliente" ng-model="lista.CedulaCliente"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Nombre Cliente
                        </td>
                        <td>
                            <input type="text" id="txtNombreCliente" ng-model="lista.NombreCliente"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Direccion
                        </td>
                        <td>
                            <input type="text" id="txtDireccion" ng-model="lista.Direccion"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Email
                        </td>
                        <td>
                            <input type="email" id="txtEmail" ng-model="lista.Email"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Cedula Usuario
                        </td>
                        <td>
                            <input type="text" id="txtCedulaUsuario" ng-model="lista.CedulaUsuario"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Telefono
                        </td>
                        <td>
                            <input type="text" id="txtTelefono" ng-model="lista.Telefono"/>
                        </td>
                        <td>
                            Contacto
                        </td>
                        <td>
                            <input type="text" id="txtContacto" ng-model="lista.Contacto"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Logo
                        </td>
                        <td>
                            <input type="text" id="txtLogo" ng-model="lista.Logo"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Activa
                        </td>
                        <td>
                            <input type="checkbox" id="chbActivo" ng-model="lista.Activo"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <button ng-click="CRUD()">Guardar</button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
        
        <script src="js/jquery/jquery.min.js"></script>
        <script src="js/jquery/jquery.easing.1.3.js"></script>
        <script src="js/jquery/jquery-ui.min.js"></script>
        <script src="js/angular/angular.js"></script>
        <script src="js/angular/angular-local-storage.min.js"></script>
        <script src="js/angular/angular-route.js"></script>
        <script src="js/angular/angular-resource.min.js"></script>
        <script src="js/app/appController.js" type="text/javascript"></script>
    </body>
</html>
