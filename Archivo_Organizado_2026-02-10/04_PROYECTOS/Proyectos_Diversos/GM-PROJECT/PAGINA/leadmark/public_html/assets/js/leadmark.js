
$(document).ready(function(){
    $(".navbar .nav-link").on('click', function(event) {

        if (this.hash !== "") {

            event.preventDefault();

            var hash = this.hash;

            $('html, body').animate({
                scrollTop: $(hash).offset().top
            }, 700, function(){
                window.location.hash = hash;
            });
        } 
    });
});

// protfolio filters
$(window).on("load", function() {
    var t = $(".portfolio-container");
    t.isotope({
        filter: ".new",
        animationOptions: {
            duration: 750,
            easing: "linear",
            queue: !1
        }
    }), $(".filters a").click(function() {
        $(".filters .active").removeClass("active"), $(this).addClass("active");
        var i = $(this).attr("data-filter");
        return t.isotope({
            filter: i,
            animationOptions: {
                duration: 750,
                easing: "linear",
                queue: !1
            }
        }), !1
    })
})

var Totes_les_escenes = [
    {
      Titol: "Presentació dels personatges",
      Descripció: "El joan està passejant tranquil·lament pel carrer dels llenyataires quan veu que un senyor amb pinta de dolent persegueix a la princesa",
      Vídeo: "video_introducció.mpg",
      Totes_les_opcions: [
        { Opcio: "Abandonar el joc", Cap_a_lEscena: 10 },
        { Opcio: "Seguir discretament al segrestador", Cap_a_lEscena: 11 },
        { Opcio: "Atacar al segrestador", Cap_a_lEscena: 2 }
      ]
    },
    {
      Titol: "La princesa capturada",
      Descripció: "El joan ha seguit al segrestador i ha arribat a la seva guarida, on la princesa està capturada.",
      Vídeo: "video_escena2.mpg",
      Totes_les_opcions: [
        { Opcio: "Intentar rescatar la princesa", Cap_a_lEscena: 3 },
        { Opcio: "Buscar ajuda", Cap_a_lEscena: 12 },
        { Opcio: "Rendir-se", Cap_a_lEscena: 13 }
      ]
    },
    {
      Titol: "Rescatant la princesa",
      Descripció: "Joan ha entrat a la guarida del segrestador i ha de trobar la manera de rescatar la princesa.",
      Vídeo: "video_escena3.mpg",
      Totes_les_opcions: [
        { Opcio: "Enfrontar-se als guardes", Cap_a_lEscena: 4 },
        { Opcio: "Buscar una manera d'entrar a la cel·la", Cap_a_lEscena: 5 },
        { Opcio: "Intentar sobornar al segrestador", Cap_a_lEscena: 6 }
      ]
    },
    {
      Titol: "Combat amb els guardes",
      Descripció: "Joan s'enfronta als guardes de la guarida per intentar rescatar la princesa.",
      Vídeo: "video_escena4.mpg",
      Totes_les_opcions: [
        { Opcio: "Utilitzar les habilitats de lluita", Cap_a_lEscena: 7 },
        { Opcio: "Intentar fugir", Cap_a_lEscena: 8 },
        { Opcio: "Demanar ajuda a la princesa", Cap_a_lEscena: 9 }
      ]
    },
    {
      Titol: "Buscant una manera d'entrar a la cel·la",
      Descripció: "Joan busca una manera de entrar a la cel·la on la princesa està capturada.",
      Vídeo: "video_escena5.mpg",
      Totes_les_opcions: [
        { Opcio: "Buscar una clau", Cap_a_lEscena: 14 },
        { Opcio: "Buscar una eina per obrir la porta", Cap_a_lEscena: 15 },
        { Opcio: "Intentar forçar la porta", Cap_a_lEscena: 16 }
      ]
    },
    {
      Titol: "Intentant sobornar al segrestador",
      Descripció: "Joan intenta sobornar al segrestador per obtenir la llibertat de la princesa.",
      Vídeo: "video_escena6.mpg",
      Totes_les_opcions: [
        { Opcio: "Ofereix diners al segrestador", Cap_a_lEscena: 17 },
        { Opcio: "Ofereix una altra cosa al segrestador", Cap_a_lEscena: 18 },
        { Opcio: "Intenta enganyar al segrestador", Cap_a_lEscena: 19 }
      ]
    },
    {
      Titol: "Utilitzant les habilitats de lluita",
      Descripció: "Joan fa servir les seves habilitats de lluita per enfrontar-se als guardes de la guarida.",
      Vídeo: "video_escena7.mpg",
      Totes_les_opcions: [
        { Opcio: "Utilitzar els punys i les peus", Cap_a_lEscena: 20 },
        { Opcio: "Utilitzar una arma", Cap_a_lEscena: 21 },
        { Opcio: "Intentar fugir mentre lluita", Cap_a_lEscena: 22 }
      ]
    },
    {
      Titol: "Intentant fugir",
      Descripció: "Joan intenta fugir de la guarida amb la princesa.",
      Vídeo: "video_escena8.mpg",
      Totes_les_opcions: [
        { Opcio: "Buscar una sortida", Cap_a_lEscena: 23 },
        { Opcio: "Ferir als guardes per obrir camí", Cap_a_lEscena: 24 },
        { Opcio: "Provar de passar desapercebut", Cap_a_lEscena: 25 }
      ]
    },
    {
      Titol: "Demanant ajuda a la princesa",
      Descripció: "Joan demana ajuda a la princesa per derrotar als guardes.",
      Vídeo: "video_escena9.mpg",
      Totes_les_opcions: [
        { Opcio: "La princesa ajuda a lluitar", Cap_a_lEscena: 26 },
        { Opcio: "La princesa dóna consells", Cap_a_lEscena: 27 },
        { Opcio: "La princesa intenta escapar", Cap_a_lEscena: 28 }
      ]
    },
    {
      Titol: "Final",
      Descripció: "Joan ha rescatat la princesa i ha acabat la seva missió.",
      Vídeo: "video_final.mpg",
      Totes_les_opcions: [
        { Opcio: "Jugar de nou", Cap_a_lEscena: 1 },
        { Opcio: "Sortir del joc", Cap_a_lEscena: 10 }
      ]
    }
  ];
   




