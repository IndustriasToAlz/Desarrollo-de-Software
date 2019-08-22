'use strict';

angular.module("AppDaservaSystem")
.controller('agendaController',function($scope,$http){
    $scope.cliente = {};
    $scope.listaDoctores = [];
    $scope.codCliente = 0;
    $scope.bandera = false;
    $scope.banderaMensaje = false;
    $scope.banderaAgenda = false;
    $scope.mensaje = "";
    $scope.disponibilidadAgenda = {};
    var doctor;
    var fecha;
    
    $.datepicker.regional['es'] = {
        closeText: 'Cerrar',
        prevText: '< Ant',
        nextText: 'Sig >',
        currentText: 'Hoy',
        monthNames: ['Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto', 'Septiembre', 'Octubre', 'Noviembre', 'Diciembre'],
        monthNamesShort: ['Ene','Feb','Mar','Abr', 'May','Jun','Jul','Ago','Sep', 'Oct','Nov','Dic'],
        dayNames: ['Domingo', 'Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado'],
        dayNamesShort: ['Dom','Lun','Mar','Mié','Juv','Vie','Sáb'],
        dayNamesMin: ['Do','Lu','Ma','Mi','Ju','Vi','Sá'],
        weekHeader: 'Sm',
        dateFormat: 'dd/mm/yy',
        firstDay: 1,
        isRTL: false,
        showMonthAfterYear: false,
        yearSuffix: ''
        };
    $.datepicker.setDefaults($.datepicker.regional['es']);
    
    $(function(){
       $('#datepicker').datepicker({
           dateFormat: 'dd/mm/yy',
           minDate: 0,
           changeMonth:true,
           changeYear:true,
           beforeShowDay: function(date){
            var day = date.getDay();
            return [day !== 0,''];
            }
       }); 
       
       $('#datepickerFecha').datepicker({
           dateFormat: 'dd/mm/yy',
           minDate: 0,
           changeMonth:true,
           changeYear:true,
           beforeShowDay: function(date){
            var day = date.getDay();
            return [day !== 0,''];
            }
       });
       
       var dataDoc;
       
       $http({
           method: 'get',
           url: 'getDoctoresLista.htm',
           headers: {
               'Content-Type': 'application/json'
           }
       }).then(function(response){
            $.each(response.data, function(i, item){
                dataDoc = response.data[i];
                $scope.listaDoctores.push({
                  codigo: dataDoc.codigo,
                  nombre: dataDoc.primerNombre + " " + dataDoc.segundoNombre + " " + dataDoc.primerApellido + " " + dataDoc.segundoApellido + " "
                });
            });
       }),function(error){
           $scope.mensaje = error;
           $scope.banderaMensaje = true;
           $('#lblMensaje').addClass('error');
       };
    });
    
    $(function(){
        $('#cmbDoctores').change(function(){
            $scope.banderaAgenda = false;
        });
    });
    
    function limpiarCampos(){
        $scope.codCliente = "";
        $scope.cliente.nombre = "";
        $scope.cliente.direccion = "";
        $scope.cliente.comuna = "";
        $scope.cliente.telParticular = "";
        $scope.cliente.telTrabajo = "";
        $scope.cliente.telMovil = "";
        $scope.cliente.email = "";
        $scope.cliente.fecNacimiento = "";
        $scope.bandera = false;
        $('#datepicker').val("");
        $('#cmbDoctores').val("");
        $scope.banderaAgenda = false;
    }
    
    $('#txtRut').keypress(function(event){
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
                }else {
                    $scope.codCliente = response.data.codigo;
                    $scope.cliente.nombre = response.data.primerNombre + " " + response.data.segundoNombre + " " + response.data.primerApellido + " " + response.data.segundoApellido;
                    $scope.cliente.direccion = response.data.direccionResidencia;
                    $scope.cliente.comuna = response.data.comuna;
                    $scope.cliente.telParticular = response.data.telefonoParticular;
                    $scope.cliente.telTrabajo = response.data.telefonoTrabajo;
                    $scope.cliente.telMovil = response.data.telefonoMovil;
                    $scope.cliente.email = response.data.email;
                    $scope.cliente.fecNacimiento = response.data.fechaNacimiento;
                    $scope.bandera = true;
                    $scope.banderaMensaje = false;
                    $scope.banderaAgenda = false;
                }
            }),function(error){
                $scope.mensaje = error;
                $scope.banderaMensaje = true;
                $('#lblMensaje').addClass('error');
            };
        }
    });
    
    function validar(){
        $scope.mensaje = "";
        
        if($scope.codCliente === 0){
            $scope.mensaje = $scope.mensaje + "Debe ingrear un cliente existente. ";
        }
        
        if($('#datepicker').val() === ""){
            $scope.mensaje = $scope.mensaje + "Debe seleccionar una fecha valida. ";
        }
        
        if($('#cmbDoctores').val() === ""){
            $scope.mensaje = $scope.mensaje + "Debe seleccionar una doctor de la lista. ";
        }
        
        if($scope.mensaje !== ""){
            $scope.banderaMensaje = true;
            $('#lblMensaje').addClass('error');
            exit();
        }
    }
    
    $scope.disponibilidadCitas = function(){
        validar();
        $scope.banderaMensaje = false;
        $scope.bandera = true;
        
        doctor = $('#cmbDoctores').val();
        fecha = $('#datepicker').val();
        
        $http({
            method: 'get',
            url: 'getDisponibilidad.htm',
            headers: {
                'Content-Type': 'application/json'
            },
            params: {
                cod_cliente: $scope.codCliente,
                cod_doctor: doctor,
                fecha: fecha
            }
        }).then(function(response){
            $scope.disponibilidadAgenda = response.data;
            $scope.banderaAgenda = true;
        }),function(error){
            $scope.mensaje = error;
            $scope.banderaMensaje = true;
            $('#lblMensaje').addClass('error');
        };
        
    };
    
    
    $scope.agendarCita = function(hora,asignada){
        
        var operacion;
        
        if(asignada === 0){
            operacion = 1;
            validarAgendamiento();
        }else{
            operacion = 0;
        }
        
        var acum = 0;
        
        $.each($scope.disponibilidadAgenda,function(index,data){
           acum = acum + data.asignada;
        });
        
        function validarAgendamiento(){
            $http({
                method: 'get',
                url: 'validarAgendamiento.htm',
                headers: {
                    'Content-Type': 'appliction/json'
                },
                params: {
                    cod_cliente: $scope.codCliente,
                    cod_doctor: doctor,
                    fecha: fecha
                }
            }).then(function(response){
                console.log(response.data);
            }),
            function(error){
                $scope.mensaje = error;
                $scope.banderaMensaje = true;
                $('#lblMensaje').removeClass('sucess');
                $('#lblMensaje').addClass('error');
            };
        }
        
        function ejecutar(){
            
            $http({
                method: 'post',
                url: 'CRUDagenda.htm',
                headers: {
                    'Content-Type': 'application/json'
                },
                params: {
                    cod_cliente: $scope.codCliente,
                    cod_doctor: doctor,
                    fecha: fecha,
                    hora: hora,
                    accion: operacion
                }
            }).then(function(response){
                $scope.disponibilidadCitas();
                $scope.mensaje = response.data.resultado;
                $scope.banderaMensaje = true;
                $('#lblMensaje').removeClass('error');
                $('#lblMensaje').addClass('sucess');
            }),
            function(error){
                $scope.mensaje = error;
                $scope.banderaMensaje = true;
                $('#lblMensaje').removeClass('sucess');
                $('#lblMensaje').addClass('error');
            };
        }
        
        if (acum === 0){
            ejecutar();
        }else{
            if(operacion === 0){
                ejecutar();
            }else{
                $scope.mensaje = "Solo se puede asiganr una cita por dia";
                $scope.banderaMensaje = true;
                $('#lblMensaje').removeClass('sucess');
                $('#lblMensaje').addClass('error');
            }
        }
    };
    
    $scope.ConsultarCitas = function(){
        $http({
            method: 'get',
            url: '',
            headers: {
                'Content-Type': 'application/json'
            },
            params: {
                cod_doctor: $('#cmbDoctoresFecha').val(),
                fecha: $('#datepickerFecha').val()
            }
        }).then(function(response){
            
        }),function(error){
            
        };
    };

    $scope.openTab = function(TabName) {
        var i, tabcontent, tablinks;
        tabcontent = document.getElementsByClassName("tabcontent");
        for (i = 0; i < tabcontent.length; i++) {
            tabcontent[i].style.display = "none";
        }
        tablinks = document.getElementsByClassName("tablinks");
        for (i = 0; i < tablinks.length; i++) {
            tablinks[i].className = tablinks[i].className.replace(" active", "");
        }
        document.getElementById(TabName).style.display = "block";
    };
        
});


