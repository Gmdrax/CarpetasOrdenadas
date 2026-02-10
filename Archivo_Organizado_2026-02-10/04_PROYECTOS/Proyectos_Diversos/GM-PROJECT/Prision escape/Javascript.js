var Totes_les_escenes = [
    {
      Titol: 'Escena 0',
      Descripcio: 'Estás en una habitación oscura. Hay una puerta cerrada frente a ti.',
      Opcions: [
        {
          Text: 'Abrir la puerta',
          Desti: 1
        }
      ]
    },
    {
      Titol: 'Escena 1',
      Descripcio: 'La puerta se abre y entras en una habitación iluminada. Hay una llave en una mesa.',
      Opcions: [
        {
          Text: 'Coger la llave',
          Desti: 2
        },
        {
          Text: 'Dejar la llave',
          Desti: 3
        }
      ]
    },
    {
      Titol: 'Escena 2',
      Descripcio: 'Caminas por un pasillo. Al final del pasillo, ves una puerta cerrada.',
      Opcions: [
        {
          Text: 'Abrir la puerta con la llave',
          Desti: 4
        },
        {
          Text: 'Intentar abrir la puerta sin la llave',
          Desti: 5
        }
      ]
    },
    {
      Titol: 'Escena 3',
      Descripcio: 'La puerta se abre y encuentras la salida. ¡Felicidades!',
      Opcions: [
        {
          Text: 'Jugar de nuevo',
          Desti: 0
        }
      ]
    },
    {
      Titol: 'Escena 4',
      Descripcio: 'La puerta está cerrada y no puedes abrirla. Necesitas la llave.',
      Opcions: [
        {
          Text: 'Volver atrás',
          Desti: 2
        }
      ]
    }
  ];
  
  var escena_actual = 0;
  
  function actualitzar_escena() {
    var escena = Totes_les_escenes[escena_actual];
    if (escena) {
      document.getElementById('titulo-escena').innerHTML = escena.Titol;
      document.getElementById('descripcion-escena').innerHTML = escena.Descripcio;
      var opcions = '';
      for (var i = 0; i < escena.Opcions.length; i++ ) {
        opcions += '<li><a href="#" onclick="nova_escena(' + escena.Opcions[i].Desti + ')">' + escena.Opcions[i].Text + '</a></li>';
      }
      document.getElementById('opciones-escena').innerHTML = opcions;
    }
  }
  
  function nova_escena(desti) {
    escena_actual = desti;
    actualitzar_escena();
    return false;
  }
  
  window.onload = function() {
    actualitzar_escena();
  };