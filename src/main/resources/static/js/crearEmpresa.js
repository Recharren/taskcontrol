'use strict'

document.addEventListener('DOMContentLoaded', function () {

alert("a ver si anda");

})
let empresaForm = document.getElementById('empresaForm');

document.getElementById('btnCrearEmpresa').addEventListener("click", ()=>{
let nombreEmp = document.getElementById('nombreEmp').value;
let rubroEmp = document.getElementById('rubroEmp').value;
let actividadEmp = document.getElementById('actividadEmp').value;
    crearEmpresa(nombreEmp,rubroEmp,actividadEmp);
   
})

async function crearEmpresa(nombreEmp,rubroEmp,actividadEmp){
    let empresaJson = {
        "nombre": nombreEmp,
        "rubro" : rubroEmp,
        "actividad" : actividadEmp
    }
let idUsuario = document.getElementById('id').value;

  await fetch("http://localhost:8080/empresa", {
  method: 'POST',
  headers: {
    'Content-Type': 'application/json',
    'idUsuario' : idUsuario,
  },
  body: JSON.stringify(empresaJson),
}).then(prom => {
    if(prom.status==200){
      empresaForm.innerHTML= `<h2 id="formTitulo">La empresa fue creada correctamente.</h2>`;
      alert("Empresa creada");
    }
})
}
