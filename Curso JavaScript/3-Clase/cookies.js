'use strict'

document.addEventListener('DOMContentLoaded',launchCookieAdvisor);

function launchCookieAdvisor(){

    var capaCookies = document.createElement('div');
    capaCookies.innerHTML = '<p>Tienes que aceptar las cookies <span>Aceptar</span></p>'
    capaCookies.classList.add('avisoCookies');
    var todosLosSpanEnDiv = capaCookies.getElementsByTagName('span');
    todosLosSpanEnDiv.item(0).addEventListener('click',function(){
        capaCookies.remove();
        //capaCookies.parentElement.removeChild(capaCookies);
        //capaCookies.parentElement.getElementsByTagName('div').item(0).remove();
    });
    document.body.appendChild(capaCookies);
}