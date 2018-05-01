<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="AppDaservaSystem">
    <head>
        <title>DASERVA Clinica Dental</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/autocomplete-jquery-ui.structure.css"/>
        <link rel="stylesheet" href="css/estilos.css"/>
        <link href="css/materialdesignicons.css" rel="stylesheet"/>
        <link href="css/lumx.css" rel="stylesheet"/>
        <link href="css/main.css" rel="stylesheet"/>
        <link href="css/menu.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <nav>
            <div class="bgc-blue-900 tc-white" flex-container="row" flex-align="center center">
                <div flex-item="4">
                    <h1 class="fs-display-3 display-block">DASERVA Clinica Dental</h1>
                </div>
                <div flex-item="1">
                    <a href="index.jsp">Inicio</a>
                </div>
                <div flex-item="1">
                    <a href="index.jsp">Salir</a>
                </div>
            </div>
        </nav>
        <header>
            <div class="menu_bar" align="center">
                <a href="#" class="bt-menu">Menu</a>            
            </div>
        </header>
        <nav align="center" class="nav_menu">
            <ul>
                <li class="submenu">
                    <a><span>Clinica</span></a>
                    <ul class="children">
                        <li id="cruCliente"><a href="#!/menu/Consulta&ActualizaCliente.html">Cliente</a></li>
                        <li id="cruCliente"><a href="#!/menu/Consulta&ActualizaDoctor.html">Doctor</a></li>
                    </ul>
                </li>
                <li><a href="#!/menu/angendaSystem.html">Agenda</a></li>
                <li><a href="#">Servicios</a></li>
                <li><a href="#">Contacto</a></li>
            </ul>
        </nav>
        <div flex-container="row" flex-align="center">
            <div ng-view flex-item="9">
            
            </div>
        </div>
        
        <script src="js/jquery/jquery.min.js"></script>
        <script src="js/jquery/jquery.easing.1.3.js"></script>
        <script src="js/jquery/jquery-ui.min.js"></script>
        <script src="js/angular/angular.js"></script>
        <script src="js/angular/angular-local-storage.min.js"></script>
        <script src="js/angular/angular-route.js"></script>
        <script src="js/angular/angular-resource.min.js"></script>
        <script src="js/velocity.min.js"></script>
        <script src="js/moment-with-locales.min.js"></script>
        <script src="js/lumx.js"></script>
        <script src="js/app/app.js"></script>
        <script src="js/app/ControllerMenu.js"></script>
        <script src="js/app/ControllerCliente.js"></script>
        <script src="js/app/ControllerDoctor.js"></script>
        <script src="js/app/ControllerAgenda.js"></script>
        <script src="js/menu.js"></script>
    </body>
</html>
