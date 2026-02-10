package org.example.controllers

import utilities.abrirScanner
import utilities.cerrarScanner
import utilities.imprimirMensaje
import utilities.verificarPuntoIgual
import java.util.Locale
import java.util.Scanner

/**
 * Función principal del programa.
 *
 * Solicita al usuario las coordenadas de dos puntos, crea el primero como objeto [Punt]
 * y compara sus valores con las coordenadas del segundo punto mediante la función [verificarPuntoIgual].
 *
 * @author Gerard
 *
 * @return Unit No devuelve ningún valor; representa la ejecución principal del programa.
 */

fun main() {
    val scan = abrirScanner()

    //cojemos los puntos originales del usuario
    imprimirMensaje("¿Cuáles son los primeros puntos?")
    val x = scan.nextFloat()
    val y = scan.nextFloat()
    val puntos = Punt(x, y)

    //cojemos los otros puntos que nos ha dado el usario
    imprimirMensaje("¿Cuáles son los segundos puntos?")
    val segundaX = scan.nextFloat()
    val segundaY = scan.nextFloat()

    //llamamos la funcion que verifica si son iguales los dos puntos dados por el usario
    verificarPuntoIgual(puntos, segundaX, segundaY)

    cerrarScanner(scan)
}
