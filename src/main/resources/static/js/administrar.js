'use strict'


document.addEventListener('DOMContentLoaded', function () {
    document.getElementById('editarContenedor').classList.add('invisible'); // hace invisible el bloque 'editarContenedor'
    document.getElementById('eliminarContenedor').classList.add('invisible');// hace invisible el bloque 'eliminarContenedor'
    document.getElementById('editarEmpresaContenedor').classList.add('invisible');// hace invisible el bloque 'editarEmpresaContenedor'
    let btnEditarUsuario = document.getElementsByClassName('btnEditarUsuario');
    let btnEliminarUsuario = document.getElementsByClassName('btnEliminarUsuario');
    let idEmpleado = document.getElementsByClassName('idEmpleado');
    let nombreUsuarioCaja = document.getElementsByClassName('nombreUsuarioCaja');
    let idEmp = document.getElementById('idEmpr').value;// Toma el valor del id de la Empresa
    
    document.getElementById('editarEmpresa').addEventListener("click", ()=>{// Añade evento click a "editarEmpresa"
        editarEmpresa(idEmp);
    })
    
    for (let i = 0; i < btnEditarUsuario.length; i++) { //Asigna eventos a botones "editarUsuarios"
        btnEditarUsuario[i].addEventListener("click",()=>{
            editarUsuario(idEmpleado[i].value);
        })
        btnEliminarUsuario[i].addEventListener("click",()=>{
            eliminarUsuario(idEmpleado[i+1].value, nombreUsuarioCaja[i+1].value);
        })
    }
})

async function editarEmpresa(idEmp){
    await fetch("http://localhost:8080/empresaRest/"+idEmp).
        then(res => res.json()).
        then(datos => editarDatosEmpresa(datos));
    document.getElementById('editarEmpresaContenedor').classList.remove('invisible');
}

let idSesion = document.getElementById('idSesion').value;

function editarDatosEmpresa(datos){
    document.getElementById('formEditarEmpresa').innerHTML = `
    <h2>Editar datos de empresa.</h2><br>
    <label for="nombre">Nombre</label>
    <input value="${datos.nombre}" type="text" name="nombreEmpr" required><br><br>
    
    <label for="rubroEmpr">Rubro</label>
    <input value="${datos.rubro}" type="text" name="rubroEmpr" required><br><br>
    
    <label for="actividadEmpr">Actividad</label>
    <input value="${datos.actividad}" type="text" name="actividadEmpr" required><br><br>
    
    <label for="archivoUsuario">Seleccione una imagen de usuario</label>
    <input value="${datos.foto}" type="file" name="archivoUsuario" ><br><br>
    
    <input type="number" name="id" value="${datos.id}" hidden>
    <input type="number" name="idSesion" value="${idSesion}" hidden>

    <button type="submit">Guardar</button>`;
}

document.getElementById('cerrarEditarEmpresa').addEventListener("click", ()=>{
    document.getElementById('editarEmpresaContenedor').classList.add('invisible');
})

async function editarUsuario(idEmp){
    await fetch("http://localhost:8080/usuario/"+idEmp).
        then(res=> res.json()).
        then(datos => editarDatos(datos));

    function editarDatos(datos){
        document.getElementById('formEditarUsuario').innerHTML = `
        <h2>Editar datos de usuario.</h2><br>
        <label for="nombre">Nombre</label>
        <input value="${datos.nombre}" type="text" name="nombre" required><br><br>
        <label for="apellido">Apellido</label>
        <input value="${datos.apellido}" type="text" name="apellido" required><br><br>
        <label for="dni">dni</label>
        <input value="${datos.dni}" type="text" name="dni" maxlength="9" onKeypress="if (event.keyCode < 45 || event.keyCode > 57) event.returnValue = false;" required ><br><br>
        <label for="archivoUsuario">Seleccione una imagen de usuario</label>
        <input value="${datos.foto}" type="file" name="archivoUsuario" ><br><br>
        <label for="email">Email</label>
        <input value="${datos.email}" type="text" name="email" required><br><br>
        <label for="puesto">Puesto</label>
        <input value="${datos.puesto}" type="text" name="puesto" required><br><br>
        <input type="number" name="id" value="${datos.id}" hidden>

        <button type="submit">Guardar</button>`
    }
    document.getElementById('editarContenedor').classList.remove('invisible');
    document.getElementById('cerrarEditarUsuario').addEventListener("click", ()=>{
        document.getElementById('editarContenedor').classList.add('invisible');
    })
}



function eliminarUsuario(idEmp, nombreUsuarioCaja){
    document.getElementById('subContEliminar').innerHTML = `<h3 style="text-align: center;">Desea eliminar a ${nombreUsuarioCaja}?</h3>
    <form action="/eliminarUsuario" method="post" id="formEliminar">
        <input type="number" name="idEmp" value="${idEmp}" hidden>
        <button type="submit" id="btnSi">SI</button>
        <button id="btnNo" type="button">NO</button>
    </form>`;
    document.getElementById('eliminarContenedor').classList.remove('invisible');
    document.getElementById('eliminarContenedor').classList.add('displayFlexCentrar');
    document.getElementById('btnNo').addEventListener("click", ()=>{
        document.getElementById('eliminarContenedor').classList.remove('displayFlexCentrar');
        document.getElementById('eliminarContenedor').classList.add('invisible');
    })
}

let idEmp = document.getElementById('idEmpr').value;
llenarCantUsuarios(idEmp);

async function llenarCantUsuarios(idEmp){
    await fetch("http://localhost:8080/empresaRest/"+idEmp).
    then(res=> res.json()).
        then(datos => {
            if(datos.cantUsuarios<5){
                document.getElementById('cantidadUsuarios').innerHTML = `<a href="/crearUsuario" > Agregar usuario a ${datos.nombre}</a>`;
            } else {
                document.getElementById('cantidadUsuarios').innerHTML = `<h3 >La empresa ya tiene el maximo de 5 usuarios, elija la version Premium</h3>`;
            }
        });
}
