var escena_actual = 0;
var historial_escenas = [];

function actualitzar_escena() {
  var escena = Totes_les_escenes[escena_actual];
  if (escena) {
    document.getElementById('titulo-escena').innerHTML = escena.Titol;
    document.getElementById('descripcion-escena').innerHTML = escena.Descripcio;
    var opcionesContainer = document.getElementById('opciones-escena');
    opcionesContainer.innerHTML = '';
    for (var i = 0; i < escena.Opcions.length; i++) {
      var button = document.createElement('button');
      button.textContent = escena.Opcions[i].Text;
      button.setAttribute('onclick', 'nova_escena(' + escena.Opcions[i].Desti + ')');
      opcionesContainer.appendChild(button);
    }
  }
}

function nova_escena(desti) {
  historial_escenas.push(escena_actual);
  escena_actual = desti;
  actualitzar_escena();
  return false;
}

function volver_atras() {
  if (historial_escenas.length > 0) {
    escena_actual = historial_escenas.pop();
    actualitzar_escena();
  }
  return false;
}

window.onload = function() {
  actualitzar_escena();
};
