'use srict';

angular.module("AppDaservaSystem")
.controller('clientesController',function($scope,$http,$routeParams){
    $scope.titulo = "Buscar Cliente";
    $scope.cliente = {};
    $scope.usuario = $routeParams.login;
    $scope.btn_bandera = false;
    $scope.lbl_bandera = false;
    $scope.validar = "";
    var resConsulta = false;
    
    $(function(){
        $('form').keypress(function(e){
           if(e === 13){
               return false;
           }
        });
        
        $('input').keypress(function(e){
            if(e.which === 13){
              return false;  
            };
        });
    });
    
    function limpiarCampos(){
        $scope.cliente.primer_nombre = "";
        $scope.cliente.segundo_nombre = "";
        $scope.cliente.primer_apellido = "";
        $scope.cliente.segundo_apellido = "";
        $scope.cliente.direccion = "";
        $scope.cliente.comuna = "";
        $scope.cliente.tel_particular = "";
        $scope.cliente.tel_trabajo = "";
        $scope.cliente.tel_Movil = "";
        $scope.cliente.email = "";
        $("#dtpFecha_nacimiento").val("");
        $scope.titulo = "Buscar Cliente";
        $scope.lbl_bandera = false;
        $scope.bt_bandera = false;
        $scope.validar = "";
    };
    
    function validarCampos(){
        $scope.validar = "";
        
        if($scope.cliente.primer_nombre.trim() === ""){
            $scope.validar = $scope.validar + " Primer Nombre invalido.";
        };
        
        if($scope.cliente.primer_apellido.trim() === ""){
            $scope.validar = $scope.validar + " Primer Apellido invalido.";
        };
        
        if($scope.cliente.direccion.trim() === ""){
            $scope.validar = $scope.validar + " Direccion invalida.";
        };
        
        if($scope.cliente.comuna.trim() === ""){
            $scope.validar = $scope.validar + " Comuna invalida.";
        };
        
        var emailRegex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3,4})+$/;
        
        if(emailRegex.test($scope.cliente.email)){
            $scope.validar = $scope.validar + " Email invalido.";
        };
        
        if($scope.cliente.tel_Movil.trim() === "" && $scope.cliente.tel_particular.trim() === ""){
            $scope.validar = $scope.validar + " Debe ingresar el telefono movil o el telefono particular.";
        };
        
        if($("#dtpFecha_nacimiento").val().trim() === ""){
            $scope.validar = $scope.validar + " Fecha invalida.";
        }
        
        if($scope.validar !== ""){
            $scope.lbl_bandera = true;
            $("#lblMensaje").removeClass("sucess");
            $("#lblMensaje").addClass("error");
            exit();
        }       
    };
    
    $('#txtRut').keyup(function(event){
        if(event.keyCode === 13){
            $http({
               method: 'get',
               url: 'getCliente.htm',
               headers: {
                    'Content-Type': 'application/json'
                },
               params: {
                   rut: $scope.cliente.rut.trim()
               }
            }).then(function(response){
                if(jQuery.isEmptyObject(response.data)){
                    limpiarCampos();
                    $scope.titulo = "Crear Cliente";
                    $scope.btn_bandera = true;
                    $scope.lbl_bandera = false;
                    $scope.boton = "Guardar";
                    resConsulta = false;
                }else {
                    limpiarCampos();
                    $scope.titulo = "Actualizar Cliente";
                    $scope.cliente.primer_nombre = response.data.primerNombre;
                    $scope.cliente.segundo_nombre = response.data.segundoNombre;
                    $scope.cliente.primer_apellido = response.data.primerApellido;
                    $scope.cliente.segundo_apellido = response.data.segundoApellido;
                    $scope.cliente.direccion = response.data.direccionResidencia;
                    $scope.cliente.comuna = response.data.comuna;
                    $scope.cliente.tel_particular = response.data.telefonoParticular;
                    $scope.cliente.tel_trabajo = response.data.telefonoTrabajo;
                    $scope.cliente.tel_Movil = response.data.telefonoMovil;
                    $scope.cliente.email = response.data.email;
                    $("#dtpFecha_nacimiento").val(response.data.fechaNacimiento);
                    $scope.btn_bandera = true;
                    $scope.boton = "Actualizar";
                    resConsulta = true;
                }
            }),function(error){
                $scope.lbl_bandera = true;
                $("#lblMensaje").addClass("error");
                $scope.validar = error;
            };
        }
    });
    
    $scope.cruCliente = function(){
        validarCampos();
        if(resConsulta){
            $http({
                method: 'post',
                url: 'CRUCliente.htm',
                headers: {
                    'Content-Type': 'application/json'
                },
                params: {
                    accion: 2,
                    rut: $scope.cliente.rut,
                    primer_nombre: $scope.cliente.primer_nombre,
                    segundo_nombre: $scope.cliente.segundo_nombre,
                    primer_apellido: $scope.cliente.primer_apellido,
                    segundo_apellido: $scope.cliente.segundo_apellido,
                    direccion: $scope.cliente.direccion,
                    comuna: $scope.cliente.comuna,
                    tel_particular: $scope.cliente.tel_particular.trim(),
                    tel_trabajo: $scope.cliente.tel_trabajo.trim(),
                    tel_movil: $scope.cliente.tel_Movil.trim(),
                    email: $scope.cliente.email,
                    fechaNacimiento: $("#dtpFecha_nacimiento").val()
                }
            }).then(function(response){
                limpiarCampos();
                $scope.validar = response.data.resultado;
                $("#lblMensaje").addClass("sucess");
                $scope.lbl_bandera = true;
                $scope.btn_bandera = false;
            }),function(error){
                $scope.lbl_bandera = true;
                $("#lblMensaje").addClass("error");
                $scope.validar = error;
            };
        }else{
            validarCampos();
            $http({
                method: 'post',
                url: 'CRUCliente.htm',
                headers: {
                    'Content-Type': 'application/json'
                },
                params: {
                    accion: 1,
                    rut: $scope.cliente.rut,
                    primer_nombre: $scope.cliente.primer_nombre,
                    segundo_nombre: $scope.cliente.segundo_nombre,
                    primer_apellido: $scope.cliente.primer_apellido,
                    segundo_apellido: $scope.cliente.segundo_apellido,
                    direccion: $scope.cliente.direccion,
                    comuna: $scope.cliente.comuna,
                    tel_particular: $scope.cliente.tel_particular.trim(),
                    tel_trabajo: $scope.cliente.tel_trabajo.trim(),
                    tel_movil: $scope.cliente.tel_Movil.trim(),
                    email: $scope.cliente.email,
                    fechaNacimiento: $("#dtpFecha_nacimiento").val()
                }
            }).then(function(response){
                limpiarCampos();
                $scope.validar = response.data.resultado;
                $("#lblMensaje").addClass("sucess");
                $scope.lbl_bandera = true;
                $scope.btn_bandera = false;
            }),function(error){
                $scope.lbl_bandera = true;
                $("#lblMensaje").addClass("error");
                $scope.validar = error;
            };
        }
    };
});