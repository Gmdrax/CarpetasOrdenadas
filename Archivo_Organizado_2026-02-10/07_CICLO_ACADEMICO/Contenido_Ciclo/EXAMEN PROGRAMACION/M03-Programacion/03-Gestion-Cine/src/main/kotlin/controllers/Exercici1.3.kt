package org.example.controllers

import utilities.abrirScanner
import utilities.cerrarScanner
import utilities.escalarPunto
import utilities.imprimirMensaje
import java.util.Locale
import java.util.Scanner

/**
 * Función principal del programa.
 *
 * Solicita al usuario las coordenadas de un punto inicial y un factor de escala.
 * Después llama a [escalarPunto] para mostrar el punto resultante tras la operación.
 *
 * @author Gerard
 *
 * @return Unit No devuelve ningún valor; representa la ejecución principal del programa.
 */

fun main() {
    val scan = abrirScanner()

    //cojemos el puntos de origen segun el usario
    imprimirMensaje("¿Cuál quieres que sea el punto de origen?")
    val x = scan.nextFloat()
    val y = scan.nextFloat()
    val puntos = Punt(x, y)

    //vemos cuanto quiere escalarr los puntos el usario
    imprimirMensaje("¿Cuánto quieres escalar los puntos?")
    val escalar = scan.nextFloat()

    //llamamos la funcion para escalar los puntos y los mostramos
    escalarPunto(puntos, escalar)

    cerrarScanner(scan)
}
