const URL = 'http://localhost:8080/Proyecto_Producto/api/v1/empleados/';
let form;
let tabla;
let jefes;

window.addEventListener('DOMContentLoaded', async function() {

	// Mapeamos los objetos más importantes;
	form = document.querySelector('form');
	form.style.display = 'none';

	tabla = document.querySelector('table');
	jefes = document.querySelector('#jefe');

	// Gestionamos los eventos
	form.addEventListener('submit', async function(e) {
		e.preventDefault();

		const empleado = {};

		let metodo = 'POST';

		if (form.id.value) {
			empleado.id = parseInt(form.id.value);
			metodo = 'PUT';
		}

		empleado.nombre = form.nombre.value;
		empleado.nif = form.nif.value;

		if (form.jefe.value !== '0') {
			empleado.jefe = { id: parseInt(form.jefe.value) };
		}
		
		console.log(empleado);
		
		const respuesta = await fetch(URL + ((metodo === 'PUT') ? empleado.id : ''), {
			method: metodo,
			body: JSON.stringify(empleado),
			headers: {
				"Content-type": "application/json; charset=UTF-8"
			}
		});

		console.log(respuesta);

		if(!respuesta.ok) {
			alert('No se ha podido guardar el empleado');
			return;
		}

		await refrescarTabla();

		form.reset();

		tabla.style.display = 'table';
		form.style.display = 'none';
	});

	// Pedimos los empleados al servidor REST
	await refrescarTabla();

});

async function refrescarTabla() {
	const respuesta = await fetch(URL);

	console.log(respuesta);

	const empleados = await respuesta.json();

	console.log(empleados);

	const tbody = document.querySelector('tbody');

	tbody.innerHTML = '';
	jefes.innerHTML = '<option selected value="0">Seleccione un jefe</option>';

	empleados.forEach(function(empleado) {
		console.log(empleado);

		const tr = document.createElement('tr');

		// TODO No crear empleado que sea su propio jefe

		tr.innerHTML = `
			<th scope="row">${empleado.id}</th>
			<td>${empleado.nombre}</td>
			<td>${empleado.nif}</td>
			<td>${empleado.jefe.nombre ? empleado.jefe.nombre : ''}</td>
			<td>
				<a class="btn btn-primary btn-sm"
					href="javascript:editar(${empleado.id})">Editar</a> 
				<a class="btn btn-danger btn-sm"
					href="javascript:borrar(${empleado.id})">Borrar</a>
			</td>
		`;

		tbody.appendChild(tr);

		const option = document.createElement('option');

		option.value = empleado.id;
		option.innerText = empleado.nombre;

		jefes.appendChild(option);
	});
}

async function editar(id) {
	tabla.style.display = 'none';
	form.style.display = 'block';

	let empleado;

	if (id) {
		const respuesta = await fetch(URL + id);
		empleado = await respuesta.json();
	}

	const respuesta = await fetch(URL);
	const empleados = await respuesta.json();
	
	jefes.innerHTML = '<option selected value="0">No tiene jefe</option>';

	empleados.forEach(function(e) {
		if (id !== e.id) {
			const option = document.createElement('option');

			option.value = e.id;
			option.innerText = e.nombre;

			jefes.appendChild(option);
		} else {
			console.log('Excluyo el ' + e.nombre + ' de la lista');
		}
	});

	if(id) {
		form.id.value = empleado.id;
		form.nombre.value = empleado.nombre;
		form.nif.value = empleado.nif;
		form.jefe.value = empleado.jefe.id;
	}
}

async function borrar(id) {
	if (!id) {
		console.error('Se ha recibido un id no válido para borrar');
		return;
	}

	const respuesta = await fetch(URL + id, { method: 'DELETE' });

	console.log(respuesta);

	refrescarTabla();
}