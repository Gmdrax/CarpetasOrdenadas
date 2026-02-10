package org.example.controllers

//Crea un programa que llegeixi un número per teclat. Seguidament ha de cridar
//a una funció que torni el quadrat d’aquest número. El valor retornat l’ha de
//mostrar per pantalla.

import utilities.calcularQuadrat
import utilities.demanarInt
import utilities.mostrarResultat
import java.util.Scanner

fun main() {

    var scan = Scanner(System.`in`)

    var num = demanarInt("Introdueix un número: ", scan)

    var resultat = calcularQuadrat(num)

    println(mostrarResultat(resultat))

}