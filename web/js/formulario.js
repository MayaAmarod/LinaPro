 var check = function() {
      if (document.getElementById('password').value ==
          document.getElementById('password2').value) {
          document.getElementById('alerta').style.color = 'green';
          document.getElementById('alerta').innerHTML = '';
      } else {
      		document.getElementById('alerta').style.color = 'red';
          document.getElementById('alerta').innerHTML = 'La contraseña no coincide';
      }
  }
  
   var checkmail = function() {
      if (document.getElementById('correo').value ==
          document.getElementById('ccorreo').value) {
          document.getElementById('alertamail').style.color = 'green';
          document.getElementById('alertamail').innerHTML = '';
      } else {
      		document.getElementById('alertamail').style.color = 'red';
          document.getElementById('alertamail').innerHTML = 'El correo no coincide';
      }
  }