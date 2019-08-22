'use srict';

angular.module("AppDaservaSystem")
.controller('doctorController',function($scope,$http,$routeParams){
    $scope.titulo = "Buscar Doctor";
    $scope.doctor = {};
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
        $scope.doctor.primer_nombre = "";
        $scope.doctor.segundo_nombre = "";
        $scope.doctor.primer_apellido = "";
        $scope.doctor.segundo_apellido = "";
        $scope.doctor.direccion = "";
        $scope.doctor.comuna = "";
        $scope.doctor.tel_particular = "";
        $scope.doctor.tel_trabajo = "";
        $scope.doctor.tel_Movil = "";
        $scope.doctor.email = "";
        $("#dtpFecha_nacimiento").val("");
        $scope.titulo = "Buscar Cliente";
        $scope.lbl_bandera = false;
        $scope.bt_bandera = false;
        $scope.validar = "";
    };
    
    function validarCampos(){
        $scope.validar = "";
        
        if($scope.doctor.primer_nombre.trim() === ""){
            $scope.validar = $scope.validar + " Primer Nombre invalido.";
        };
        
        if($scope.doctor.primer_apellido.trim() === ""){
            $scope.validar = $scope.validar + " Primer Apellido invalido.";
        };
        
        if($scope.doctor.direccion.trim() === ""){
            $scope.validar = $scope.validar + " Direccion invalida.";
        };
        
        if($scope.doctor.comuna.trim() === ""){
            $scope.validar = $scope.validar + " Comuna invalida.";
        };
        
        var emailRegex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3,4})+$/;
        
        if(emailRegex.test($scope.doctor.email)){
            $scope.validar = $scope.validar + " Email invalido.";
        };
        
        if($scope.doctor.tel_Movil.trim() === "" && $scope.doctor.tel_particular.trim() === ""){
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
               url: 'getDoctor.htm',
               headers: {
                    'Content-Type': 'application/json'
                },
               params: {
                   rut: $scope.doctor.rut.trim()
               }
            }).then(function(response){
                if(jQuery.isEmptyObject(response.data)){
                    limpiarCampos();
                    $scope.titulo = "Crear Doctor";
                    $scope.btn_bandera = true;
                    $scope.lbl_bandera = false;
                    $scope.boton = "Guardar";
                    resConsulta = false;
                }else {
                    limpiarCampos();
                    $scope.titulo = "Actualizar Doctor";
                    $scope.doctor.primer_nombre = response.data.primerNombre;
                    $scope.doctor.segundo_nombre = response.data.segundoNombre;
                    $scope.doctor.primer_apellido = response.data.primerApellido;
                    $scope.doctor.segundo_apellido = response.data.segundoApellido;
                    $scope.doctor.direccion = response.data.direccionResidencia;
                    $scope.doctor.comuna = response.data.comuna;
                    $scope.doctor.tel_particular = response.data.telefonoParticular;
                    $scope.doctor.tel_trabajo = response.data.telefonoTrabajo;
                    $scope.doctor.tel_Movil = response.data.telefonoMovil;
                    $scope.doctor.email = response.data.email;
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
                url: 'CRUDoctor.htm',
                headers: {
                    'Content-Type': 'application/json'
                },
                params: {
                    accion: 2,
                    rut: $scope.doctor.rut,
                    primer_nombre: $scope.doctor.primer_nombre,
                    segundo_nombre: $scope.doctor.segundo_nombre,
                    primer_apellido: $scope.doctor.primer_apellido,
                    segundo_apellido: $scope.doctor.segundo_apellido,
                    direccion: $scope.doctor.direccion,
                    comuna: $scope.doctor.comuna,
                    tel_particular: $scope.doctor.tel_particular.trim(),
                    tel_trabajo: $scope.doctor.tel_trabajo.trim(),
                    tel_movil: $scope.doctor.tel_Movil.trim(),
                    email: $scope.doctor.email,
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
                url: 'CRUDoctor.htm',
                headers: {
                    'Content-Type': 'application/json'
                },
                params: {
                    accion: 1,
                    rut: $scope.doctor.rut,
                    primer_nombre: $scope.doctor.primer_nombre,
                    segundo_nombre: $scope.doctor.segundo_nombre,
                    primer_apellido: $scope.doctor.primer_apellido,
                    segundo_apellido: $scope.doctor.segundo_apellido,
                    direccion: $scope.doctor.direccion,
                    comuna: $scope.doctor.comuna,
                    tel_particular: $scope.doctor.tel_particular.trim(),
                    tel_trabajo: $scope.doctor.tel_trabajo.trim(),
                    tel_movil: $scope.doctor.tel_Movil.trim(),
                    email: $scope.doctor.email,
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