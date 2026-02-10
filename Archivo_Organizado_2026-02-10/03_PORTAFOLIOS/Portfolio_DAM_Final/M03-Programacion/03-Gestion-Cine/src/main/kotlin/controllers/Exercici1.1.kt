package org.example.controllers

import utilities.abrirScanner
import utilities.cerrarScanner
import utilities.imprimirMensaje
import utilities.mostraPunt
import java.util.Locale
import java.util.Scanner

/**
 * Función principal del programa.
 *
 * Lee dos valores numéricos introducidos por el usuario, crea un objeto [Punt]
 * con ellos y muestra sus coordenadas mediante [mostraPunt].
 *
 * @author Gerard
 *
 * @return Unit No devuelve ningún valor; ejecuta el flujo principal del programa.
 */
fun main() {
    val scan = abrirScanner()

    //pedimos datos
    imprimirMensaje("¿Qué puntos quieres mostrar?")
    val x = scan.nextFloat()
    val y = scan.nextFloat()

    //mostramos los puntos con la funcion
    val puntos = Punt(x, y)
    mostraPunt(puntos)

    cerrarScanner(scan)
}