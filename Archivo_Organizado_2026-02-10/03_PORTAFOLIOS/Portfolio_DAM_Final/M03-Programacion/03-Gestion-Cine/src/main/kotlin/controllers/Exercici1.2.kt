package org.example.controllers

import utilities.abrirScanner
import utilities.cerrarScanner
import utilities.imprimirMensaje
import utilities.moverPunto
import java.util.Locale
import java.util.Scanner

/**
 * Función principal del programa.
 *
 * Solicita al usuario las coordenadas de un punto inicial y los valores de desplazamiento.
 * Después llama a [moverPunto] para mostrar el nuevo punto resultante.
 *
 * @author Gerard
 *
 * @return Unit No devuelve ningún valor; representa la ejecución principal del programa.
 */
fun main() {
    val scan = abrirScanner()

    //cojemos el punto de origen del usario
    imprimirMensaje("¿Cuál quieres que sea el punto de origen?")
    val x = scan.nextFloat()
    val y = scan.nextFloat()
    val puntos = Punt(x, y)

    //cojemos cuanto queremos mover los puntos originales
    imprimirMensaje("¿Cuánto quieres mover el punto desde su origen?")
    val xcogida = scan.nextFloat()
    val ycogida = scan.nextFloat()

    //movemos el punto llamando la funcion
    moverPunto(puntos, xcogida, ycogida)

    cerrarScanner(scan)
}