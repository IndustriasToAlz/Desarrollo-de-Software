'use strict'

//----------------------------------------------------

//funciones al cargar pagina

// $(function(){ //opcion recomendada
// 	alert("Primera Forma");
// });

// $().ready(function(){
// 	alert("Segunda Forma");
// });

// $(document).ready(function(){
// 	alert("Tercera Forma");
// });

// $('h1').ready(function(){
// 	alert("Cuarta Forma");
// });

//-----------------------------------------------------

//selectores

// $(document).ready(function(){
// 	$("#parrafo").text("Holi"); //id
// 	$('.saludo').css({       //cssclass
// 		'background-color': 'red'
// 	});
// 	$('div').text("Hola Mundo"); //etiqueta html
// });

//-------------------------------------------------------

//manejo de errores

// $.when( $.ready, $.getScript("js/index.js") ).then(function() {
// 	console.log("pasó");
// }) .catch(function(){
// 	console.log('No pasó');
// });

//--------------------------------------------------------

//getters and setters

// $(function(){
// 	//getters and setters

// 	//get texto de algo
// 	var s = $('.saludo').html();
// 	alert(s);

// 	//get atributo de un elemento html
// 	var s = $('h1').attr('class');
// 	alert(s);

// 	//set atributo de un elemento html
// 	$('h1').attr('class','hola'); //se envia el atributo
// 	$('h1').attr('id','titulo');
// 	var s = $('h1').attr('class');
// 	alert(s);
// });

//--------------------------------------------------------

//metodo css

// $(function(){
// 	$('p').css({
// 		'background-color': 'red',
// 		'font-family': 'sans-serif',
// 		'display' : 'inline-block',
// 		'padding' : '10px',
// 		'border-radius' : '6px',
// 		'margin-left' : '15px',
// 		'cursor' : 'pointer',	
// 	});
// });

//--------------------------------------------------------

//manejo de clases css hasClass addClass removeClass

// $(function(){
// 	$('.saludo').css({
// 		'background-color': 'red',
// 		'font-family': 'sans-serif',
// 		'display' : 'inline-block',
// 		'padding' : '10px',
// 		'border-radius' : '6px',
// 		'margin-left' : '15px',
// 		'cursor' : 'pointer',	
// 	});

// 	$('hola').css({
// 		'background-color': 'red',
// 		'font-family': 'sans-serif',
// 		'display' : 'inline-block',
// 		'padding' : '10px',
// 		'border-radius' : '6px',
// 		'margin-left' : '15px',
// 		'cursor' : 'pointer',	
// 	});

// 	if($('#parrafo').hasClass('saludo')){
// 		alert("tiene saludo");
// 		$('#parrafo').removeClass('saludo');
// 	} else {
// 		alert("no tiene saludo");
// 		$('div').addClass('hola');
// 	}
// });

//--------------------------------------------------------

//show and hide
// $(function(){
// 	if($('#parrafo').hasClass('saludo')){
// 		alert("tiene saludo");
// 		$('#parrafo').show(3000);
// 	} else {
// 		alert("no tiene saludo");
// 		$('div').hide(3000);
// 	}	
// });

//--------------------------------------------------------

//iterar elementos each, for-tradicional, For of

// $(function(){
// 	// var numbers = [1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192];
// 	var colors = [{
// 		"colors": [{
// 			"colorName" : "red",
// 			"hexValue" : "#f00"
// 		},
// 		{
// 			"colorName" : "green",
// 			"hexValue" : "#0f0"
// 		},
// 		{
// 			"colorName" : "blue",
// 			"hexValue" : "#00f"
// 		}]
// 	}];
	
// 	// $.each(numbers,function(i,value){
// 	// 	console.log(i + ":" + value);
// 	// });

// 	// for (var i = 0; i < numbers.length; i++) {
// 	// 	console.log(i + ":" + numbers[i]);	
// 	// }

// 	for(let color of colors){
// 		console.log(color.colors[2].colorName);
// 	}
// });

//--------------------------------------------------------

//Metodo Attr, Dimensiones, Efectos

// $(function(){
// 	// $('#nightcrawler').click(function(){
// 	// 	//attr
// 	// 	// $('#nightcrawler').attr('src','./img/Stark_Industries_logo.png');
// 	// 	// $('#nightcrawler').attr('width',300);
// 	// 	// $('#nightcrawler').removeAttr('src');

// 	// 	//dimensiones
// 	// 	// alert($('#nightcrawler').width());
// 	// 	// alert($('#nightcrawler').height());
// 	// 	// $('#nightcrawler').width(300).height(300);
// 	// });

// 	//efectos
// 	// $('#nightcrawler').attr('width',300);

// 	// $('#btn1').click(function(){
// 	// 	$('#nightcrawler').slideDown(3000);
// 	// });

// 	// $('#btn2').click(function(){
// 	// 	$('#nightcrawler').slideUp(3000);
// 	// });

// 	// $('#btn1').click(function(){
// 	// 	$('#nightcrawler').fadeIn(1500);
// 	// });

// 	// $('#btn2').click(function(){
// 	// 	$('#nightcrawler').fadeOut(1500);
// 	// });

// 	// $('#btn1').click(function(){
// 	// 	$('#nightcrawler').animate({height: "900px"},3000);
// 	// });

// 	// $('#btn2').click(function(){
// 	// 	$('#nightcrawler').animate({width: "900px"},3000);
// 	// });
// });

//--------------------------------------------------------

//eventos de teclado

// $(function(){
// 	$('#input').keydown(function(){
// 		console.log("se levanto el dedo de una tecla");
// 		$('#input').css({"background-color" : "red"});
// 	});
// 	var i = 0;
// 	$('#input').keypress(function(){
// 		$('span').text(i += 1);
// 	});

// 	$('#input').keyup(function(){
// 		console.log("se presiono una tecla");
// 		//$('#input').css({"background-color" : "blue"});
// 		$('#input').css({"background-color" : "white"});
// 	});

// 	$('#btnLimpiar').click(function(){
// 		console.clear();
// 		document.getElementById("input").value = null;
// 		$('#input').css({"background-color" : "white"});
// 		i = 0;
// 		$('span').text(i);
// 	});
// });

//--------------------------------------------------------

//eventos de mouse, metodo data

// $(function(){
// 	// $('#icon').mouseover(function(){
// 	// 	$('#icon').addClass('fa-volume-off').removeClass('fa-volume-up');
// 	// });

// 	$('#colors li').each(function(index,value){
// 		$('#colors').data('nombre',value);
// 		$('#colors').data('index',index);
// 		console.log($('#colors').data('nombre'));
// 		console.log($('#colors').data('index'));
// 	});
	
// 	$('#icon').data('atrib',{nombre:'fa-volume-off',color:'red'});
// 	var icon = $('#icon').data('atrib'); 

// 	console.log(icon.nombre);
	
// 	$('#icon').mousedown(function(){
// 		//$('#icon').data('status','cambiando');
// 		//$('#icon').addClass('fa-volume-off').removeClass('fa-volume-up');
// 		//console.log($('#icon').data('status'));
// 		$('#icon').addClass(icon.nombre).removeClass('fa-volume-up');
// 		$('#icon').css('color',icon.color);
// 	});

// 	// $('#icon').mouseleave(function(){
// 	// 	$('#icon').addClass('fa-volume-up').removeClass('fa-volume-off');
// 	// });

// 	$('#icon').mouseup(function(){
// 		//$('#icon').data('status','cambio');
// 		//$('#icon').addClass('fa-volume-up').removeClass('fa-volume-off');
// 		//console.log($('#icon').data('status'));
// 		$('#icon').addClass('fa-volume-up').removeClass(icon.nombre);
// 		$('#icon').css('color','black');
// 	});
// });


//--------------------------------------------------------

//metodo animate

// $(function(){
// 	$('body').keyup(function(event){
// 		if (event.keyCode == 37) {
// 			$('.cubo').animate({'left':'-=50px'},/*'slow'*/3000);
// 			console.log('left');
// 		} else if (event.keyCode == 39) {
// 			$('.cubo').animate({'left':'+=50px'},'fast');
// 			console.log('right');
// 		} else if (event.keyCode == 38) {
// 			$('.cubo').animate({'top':'-=50px'});
// 			console.log('up');
// 		} else if (event.keyCode == 40) {
// 			$('.cubo').animate({'top':'+=50px'});
// 			console.log('down');
// 		} else {
// 			console.log('Oe no sirve ninguna tecla de estas');
// 		}
// 	});

// 	$('.cubo').click(function(){
// 		$(this).animate({
// 			height: ['+=50','easeOutBounce'],
// 			width: ['+=100','linear']
// 		},3000);
// 	});


// 	$('#left').click(function(){
// 		$('.cubo').animate({'left':'-=50px'});
// 		console.log('left');
// 	});

// 	$('#right').click(function(){
// 		$('.cubo').animate({'left':'+=50px'});
// 		console.log('right');
// 	});

// 	$('#up').click(function(){
// 		$('.cubo').animate({'top':'-=50px'});
// 		console.log('up');
// 	});

// 	$('#down').click(function(){
// 		$('.cubo').animate({'top':'+=50px'});
// 		console.log('down');
// 	});
// });

//--------------------------------------------------------

//eventos scroll

// $(function(){

	// $('#up').click(function(){
	// 	$('body').animate({scrollTop : 0});
	// });

	// $(window).scroll(function(){
	// 	if ($(this).scrollTop() > 100) {
	// 		console.log('Hola scroll');
	// 	} else {
	// 		console.log('no scroll');
	// 	}
	// });
// });

//--------------------------------------------------------

//crear copiar mover y remover elementos

// $(function(){
// 	$('#exe').click(function(){
// 		//crear elementos
// 		// $('ol').append('<li>Nuevo Elemento</li>'); //al final
// 		// $('ol').prepend('<li>Primer Elemento</li>'); //al inicio

// 		//mover elementos
// 		//$('ol').append($('ol li:first')); // mover el primero de la lista hacia atras
// 		//$('ol').prepend($('ol li:last')); //mover el unltimo de la lista hacia adelante

// 		//copiar elementos
// 		// var clon = $('ol li:last').text();
// 		// console.log(clon);
// 		// $('h1').append(clon);
// 		// $('ol').prepend($('ol li:last'));

// 		//remover elementos
// 		$('ol li:last').remove();
// 	});
// });

//--------------------------------------------------------

//Padres, Hijos y Hermanos //crear elementos virtuales

// $(function(){
// 	var hijos = $('#padre-ol').children().text();
// 	var padre = $('.hijo').parent();
// 	var hermanos = $('.hijo').siblings();
// 	console.log(hijos);
// 	console.log(padre);
// 	console.log(hermanos);

// 	$('#exe').click(function(){
// 		var li = $('<li>',{text:'Virtual Element'});
// 		$(li).addClass('vElem');
// 		$('#padre-ol').append(li);
// 		$('.vElem').click(function(){
// 			alert('Este es un Elemeto Vitual');
// 		});
// 	});
// });

//--------------------------------------------------------

//JSON.Parse

// $(function(){
// 	var cadena = '{"name":"Carlos","lastname":"Tobon","edad":26}';
// 	var obj = JSON.parse(cadena);
// 	console.log(obj.name + ' ' + obj.lastname + ' mi edad es ' + obj.edad + ' años');
// });

//--------------------------------------------------------

//AJAX metodo get

//$(function(){
////		 $.get("./ejemplo.html", function(data) {
////		 	$('center').append(data);
////		 	// console.log(data);
////		 });
//
////		$.get('GetUserServlet',{userName : "Carlos"},function(data){
////                    console.log(data);
////                    $.('#resultado').text(data);
////                });
//
//        $.ajax({
//                type: 'GET',
//                url : 'GetUserServlet',
//                data : {
//                        userName : "Carlos"
//                },
//                success : function(responseText) {
//                        $('#resultado').text(responseText);
//                },
//                error : function (){
//                    $('#resultado').text('Error');
//                }
//        });
//
//        $.ajax({
//                type: 'GET',
//                url : 'ejemplo.htm',
//                data : {
//                        userName : "Carlos"
//                },
//                success : function(responseText) {
//                        $('#resultado2').text(responseText);
//                },
//                error : function (){
//                    $('#resultado2').text('Error');
//                }
//        });
//});
//        
////--------------------------------------------------------
//
////AJAX metodo post
//
//$(function() {
//    $('#ejecutar').click(function() {
//        
//        $.post('ejemplo.htm',{
//            nombre : "Carlos",
//            metodo : "POST"
//        },function(data,status) {
//            console.log(data+" "+status);
//        });
//        
//        $.post('GetUserServlet',{
//            nombre : "Carlos",
//            metodo : "POST"
//        },function(data,status) {
//            console.log(data+" "+status);
//        });
//        
//        //getJSON
//        
//        $.ajax({
//                type: 'GET',
//                url : 'ejemploJSON.htm',
//                dataType: 'JSON',
//                data : {
//                        nombre : "Carlos",
//                        metodo: "getJSON"
//                },
//                success : function(responseText) {
//                        //$('#resultado3').text(responseText);
//                        //console.log("json");
//                        console.log(responseText.jsonArray);
//                        $.each(responseText,function(i,value){
//                           console.log(i + " " + value); 
//                        });
//                },
//                error : function (){
//                    $('#resultado3').text('Error');
//                }
//        });
//    });
//});

////--------------------------------------------------------
//
////ejemplo ajax
$(function(){
    $('#ejecutar').click(function(){
        sumar($('#valor1').val(),$('#valor2').val());
    });
    function sumar(val1,val2){
        $.ajax({
            data: {
                val1:val1,
                val2:val2
            },
            url: "ejemploAJAX.htm",
            type: 'POST',
            beforeSend: function () {
                console.log("Se esta Procesando tu peticion");
            }
        })
        .done(function(data) {
            $("#resultado").text(data);
        });
    }
});
