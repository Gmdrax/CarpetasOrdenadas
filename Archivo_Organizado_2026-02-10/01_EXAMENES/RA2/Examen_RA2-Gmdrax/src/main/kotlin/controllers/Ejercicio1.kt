package org.example.controllers


fun main() {

    val texto = "Hola"
    println("Original: " + texto)
    println("Girado: " + invertirFrase(texto))
}


/**
 * Executa l’exercici principal: crea una matriu aleatòria, la mostra,
 * demana coordenades i color, pinta la zona corresponent i torna a mostrar la matriu.
 *
 * @param str palabra inicial
 * @param String nos da la palabra cambiada
 *
 */
fun invertirFrase(str: String): String {

    //en caso de ser solo un letra no hacemos nada y devolvemos la frase
    if (str.length <= 1) {
        return str
    }

    //cojemos la ultima letra de la frase
    var ultimaLetra = str[str.length - 1]

    //vamos letra po letra girandola hasta llegar al final, no se como hacerlo con la funcion .reversed
    var restoDelTexto = str.reversed()

    //en el caso de ser mas larga suamaos el resto del texto
    return ultimaLetra + invertirFrase(restoDelTexto)
}