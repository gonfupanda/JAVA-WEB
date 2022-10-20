'use strict';

window.addEventListener('DOMContentLoaded', async function() {
    console.log('DOMContentLoaded');
    
    const h1 = document.querySelector('h1');

    console.log(h1);

    console.log(h1.innerHTML);

    h1.innerText = 'Modificado desde JavaScript';

    const p = document.querySelector('p');

    p.style.display = 'none';

    const form = document.querySelector('form');

    form.addEventListener('submit', (evento) => {
        evento.preventDefault();

        const inputNombre = document.getElementById('nombre');
        const spanSaludo = document.getElementById('saludo');

        console.log(inputNombre);
        console.log(spanSaludo);

        spanSaludo.innerText = 'Hola ' + inputNombre.value;
    });

    const repuesta = await this.fetch("../json/personas.json");//buscar de manera asincrona los datos de .JSON
    console.log(repuesta);

    const bdd = await repuesta.json(); //recoger el .json en estilo array

    console.log(bdd);
    //json-server -w jason.db

    //PARA HACERLUEGO

    ///CALCULADORA
    //GENERAR BLOQUES TENIENDO EN CUENTA LAS FILAS Y COLUMNAS K SE PONGAN
    
    let ul = document.getElementById('lista');

    let li;

    //INTRODUCE LOS NOMBRES DE LAS PERSONAS INTROUCIDAS EN LA ARRAY PERSONAS Y LAS AÑADE A LA LISTA VACIA DEL HTML
    for(let fila of bdd) {
        li = document.createElement('li'); // <li></li>

        li.innerHTML = fila.id + ' ' + fila.nombre; // <li>1 Javier</li>

        ul.appendChild(li); // <ul><li>1 Javier</li></ul>
    }
    //OTRA MANERA DE HACER EL FOR DE ARRIBA
    bdd.forEach((fila) => {
        li = document.createElement('li'); // <li></li>

        li.appendChild(document.createTextNode(`${fila.id} ${fila.nombre}`)); // <li>1 Javier</li>

        ul.appendChild(li); // <ul><li>1 Javier</li></ul>
    });
});