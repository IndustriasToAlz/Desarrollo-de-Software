<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="AppDaservaIndex">
    <head>
        <title>DASERVA Clinica Dental</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/autocomplete-jquery-ui.structure.css"/>
        <link rel="stylesheet" href="css/estilos.css"/>
        <link href="css/materialdesignicons.css" rel="stylesheet"/>
        <link href="css/lumx.css" rel="stylesheet"/>
        <link href="css/main.css" rel="stylesheet"/>
    </head>
    <body>
        <nav>
            <div class="bgc-blue-900 tc-white" flex-container="row" flex-align="center center">
                <div flex-item="4">
                    <h1 class="fs-display-3 display-block">DASERVA Clinica Dental</h1>
                </div>
                <div flex-item="1">
                    <a href="#">Inicio</a>
                </div>
                <div flex-item="1">
                    <a href="login.jsp">Login</a>
                </div>
            </div>
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
        <script src="js/app/ControllerIndex.js"></script>
    </body>
</html>
