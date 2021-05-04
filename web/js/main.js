
const formulario = document.getElementById('formincio');
const inputs = document.querySelectorAll('#formincio input');

//expresiones regulares
const expresiones = {
    usuario: /^[a-zA-Z0-9\_\-]{4,16}$/, // Letras, numeros, guion y guion_bajo    
    clave: /^.{4,12}$/ // 4 a 12 digitos.     
};

const campos = {
    usuario: false,
    clave: false
};


const validarFormulario = (e) => {
    switch (e.target.name) {
        case "textUsuario":
            validarCampo(expresiones.usuario, e.target, 'usuario');
            break;
        case "textClave":
            validarCampo(expresiones.clave, e.target, 'clave');
            break;
    }
};

const validarCampo = (expresion, input, campo) => {
    if (expresion.test(input.value)) {
        document.getElementById(`grupo__${campo}`).classList.remove('formulario__grupo-incorrecto');
        document.getElementById(`grupo__${campo}`).classList.add('formulario__grupo-correcto');
        document.querySelector(`#grupo__${campo} i`).classList.add('fa-check-circle');
        document.querySelector(`#grupo__${campo} i`).classList.remove('fa-times-circle');
        document.querySelector(`#grupo__${campo} .formulario__input-error`).classList.remove('formulario__input-error-activo');
        campos[campo] = true;
    } else {
        document.getElementById(`grupo__${campo}`).classList.add('formulario__grupo-incorrecto');
        document.getElementById(`grupo__${campo}`).classList.remove('formulario__grupo-correcto');
        document.querySelector(`#grupo__${campo} i`).classList.add('fa-times-circle');
        document.querySelector(`#grupo__${campo} i`).classList.remove('fa-check-circle');
        document.querySelector(`#grupo__${campo} .formulario__input-error`).classList.add('formulario__input-error-activo');
        campos[campo] = false;
    }
};

inputs.forEach((input) => {
    input.addEventListener('keyup', validarFormulario);
    input.addEventListener('blur', validarFormulario);
});

formulario.addEventListener('submit', (e) => {
    //e.preventDefault(); -> Error, si lo habilito,
    /*entonces no se realiza la funcion de enviar los datos y se va mantener en la pagina, 
     lo que permite visualizar el mensaje
     Si se oculta o se elimina, se enviara la validacion 
     lo que generara un recargue de pagina y se visualizara el mensaje*/

    if (campos.usuario && campos.clave) {
        //formulario.reset();-> Eliminar cajas

        document.getElementById('formulario__mensaje-exito').classList.add('formulario__mensaje-exito-activo');
        setTimeout(() => {
            document.getElementById('formulario__mensaje-exito').classList.remove('formulario__mensaje-exito-activo');
        }, 5000);

        document.querySelectorAll('.formulario__grupo-correcto').forEach((icono) => {
            icono.classList.remove('formulario__grupo-correcto');
        });
    } else {
        document.getElementById('formulario__mensaje').classList.add('formulario__mensaje-activo');
    }
});



window.addEventListener('load', function () {
    //document.getElementById('formulario__mensaje').classList.add('formulario__mensaje-activo');
    //document.getElementById('formulario__mensaje-exito').classList.add('formulario__mensaje-exito-activo');
    
    
    /*Ejecutar segundo metodo de validacion cuando se cargue la pagina, mediante un alerta
    Lo que permite es parar la pagina y enviar el mensaje*/
    /*
    document.getElementById('botoniniciar').addEventListener('click', function () {
     var nombre = document.getElementById('usuario').value;
     var clave = document.getElementById('clave').value;
     var vacios = false;
     
     if (nombre.length > 0 && clave.length > 0)
     {
     var vacios = true;
     }
     if (vacios) {
     document.getElementById('formincio').submit();
     valor = "";
     } else {
     alert("Por favor rellene todos los campos");
     //valor = " Error: Por favor rellene todos los campos";
     }
     //valor = "Por favor rellene todos los campos";
     //location.href = "Login.jsp?variable=" + valor + "";
     });*/


    /*document.getElementById('usuario').addEventListener('keyup', function (e) {
     
     key = e.keyCode || e.which;
     tecla = String.fromCharCode(key).toLowerCase();
     letras = "áéíóúabcdefghijklmnñopqrstuvwxyz";
     especiales = [8, 37, 39, 46];
     
     tecla_especial = false;
     
     for (var i in especiales) {
     if (key == especiales[37]) {
     tecla_especial = true;
     alert("permitido");
     break;
     }
     }
     {
     if (letras, indexOf(tecla) == -1 && !tecla_especial) {
     return false;
     alert("Por favor vaya escribiendo bien");
     }
     }
     
     });*/


});


