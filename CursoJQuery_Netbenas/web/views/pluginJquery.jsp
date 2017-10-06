<%-- 
    Document   : pluginJquery
    Created on : 6/10/2017, 12:02:01 PM
    Author     : user
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta name="vieport" content="width=device-width, initial-scale=1.0" />
        <meta http-equiv="X-UA-Compatible" content="ie=edge" />
        <title>Plugin Jquery</title>
        <link href="../css/estilos.css">
    </head>
    <body>
        
    <center>
        <h1>Plugin Jquery</h1>
        <iframe class="video" width="560" height="315" src="https://www.youtube.com/embed/SKWxOsbt9gU?rel=0&amp;controls=0&amp;showinfo=0" frameborder="0" allowfullscreen></iframe>
    </center>
    
    <div style="height: 400px">Soy Un Espacio</div>
    <div style="height: 400px">Soy Un Espacio</div>
    <div style="height: 400px">Soy Un Espacio</div>
    <div style="height: 400px">Soy Un Espacio</div>

        
        <script src="../js/jquery.min.js"></script>
        <script src="../js/jquery.easing.1.3.js"></script>
        <script src="../js/e622d3b53e.js"></script>
        <script src="../js/pluginJquery.js"></script>
        <script>
            $(function () {
                $('.video').vscroll();
            });
        </script>
    </body>
</html>
