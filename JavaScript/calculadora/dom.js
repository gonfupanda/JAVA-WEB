'use strict';

window.addEventListener('DOMContentLoaded', function(){
    const form = document.querySelector('form');

    form.addEventListener('submit',function(e) {
        e.preventDefault();

        const num1 =  parseInt(document.getElementById("num1").value);
        const num2 =  parseInt(document.getElementById("num2").value);

        const op = document.getElementById("op").value;
        console.log(op);
        let sol;
        if(op =="suma"){
            sol = num1+num2;
        }else if(op =="resta"){
            sol = num1-num2;
        }else if(op =="multi"){
            sol = num1*num2;
        }else {
            sol = num1/num2;
        }

       
        
        let spanSaludo = document.querySelector("span");

        spanSaludo.innerText = '= ' + sol;
    })

    //npx json-server--watch "ruta"

});