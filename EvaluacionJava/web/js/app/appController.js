'use srict';

angular.module("EvaluacionJava",[])
    .controller("Controller",function($scope,$http){
        $scope.lista = {};
        $scope.hayDatos = null;
        $scope.accion = 0;

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
        
        $('#txtCedulaCliente').keyup(function(event){
            if(event.keyCode === 13){
                $http({
                   method: 'get',
                   url: 'getCliente.htm',
                   headers: {
                        'Content-Type': 'application/json'
                    },
                   params: {
                       CedulaCliente: $scope.lista.CedulaCliente.trim()
                   }
                }).then(function(response){
                    $scope.lista.Telefono = response.data.cdtelefono;
                    $scope.lista.CedulaUsuario = response.data.cdusuario;
                    $scope.lista.Contacto = response.data.dscontacto;
                    $scope.lista.Direccion = response.data.dsdireccion;
                    $scope.lista.Logo = response.data.dslogo;
                    $scope.lista.Email = response.data.dsmail;
                    $scope.lista.NombreCliente = response.data.dsnombre;
                    
                    console.log(response.data);
                    
                    if(response.data.snactivo === '1'){
                        $('#chbActivo').prop('checked',true);
                    }else{
                        $('#chbActivo').prop('checked',false);
                    };
                    
                    if(response.data !== null){
                        $scope.hayDatos = 1;
                    };
                }),function(error){
                    console.log(error);
                };
            }
        });
        
        $scope.CRUD = function(){
            var activo = 0;
            
            if($('#chbActivo').prop('checked')){
                activo = 1;
            }
            
            if($scope.hayDatos !== null){
                $scope.accion = 1;
            }
            
            $http({
                method: 'post',
                url: 'cruCliente.htm',
                headers: {
                    'Content-Type': 'application/json'
                },
                params: {
                    CedulaCliente: $scope.lista.CedulaCliente.trim(),
                    NombreCliente: $scope.lista.NombreCliente,
                    Direccion: $scope.lista.Direccion,
                    Email: $scope.lista.Email,
                    CedulaUsuario: $scope.lista.CedulaUsuario,
                    Telefono: $scope.lista.Telefono,
                    Contacto: $scope.lista.Contacto,
                    Logo: $scope.lista.Logo,
                    Activo: activo,
                    Accion: $scope.accion
                    }
                }).then(function(response){
                    alert(response.data.resultado);
                    $scope.lista = {};
                    $('#chbActivo').prop('checked',false);
                    console.log(response.data);
                }),function(error){
                    console.log(error);
            };     
        };
    });



