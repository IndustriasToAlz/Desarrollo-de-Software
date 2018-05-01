'use strict'

$(function(){    
    $.fn.vscroll = function(){
        var video = $(this);
        var alto = video.height();
        var ancho = video.width();
        $(window).scroll(function(){
            
            var posiscion = $(window).scrollTop();
            //console.log(posiscion);
            
            if (posiscion >= 400){
                video.css({
                    position: "fixed",
                    width: "280px",
                    height: "160px",
                    bottom: "10px",
                    left: "10px"
                });
            } else {
                video.css({
                    position: "relative",
                    width: ancho,
                    height: alto
                });
            }
        });
    };
}(jQuery))




