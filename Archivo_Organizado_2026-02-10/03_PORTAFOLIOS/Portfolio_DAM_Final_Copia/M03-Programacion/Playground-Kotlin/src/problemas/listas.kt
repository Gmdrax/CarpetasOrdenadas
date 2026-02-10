package problemas

import java.util.Scanner

fun main() {
    val scan = Scanner(System.`in`)

    // 1. Crear lista mutable (porque vamos a añadir y quitar gente)
    val invitados: MutableList<String> = mutableListOf()

    println("¿Cuántos invitados iniciales vienen?")
    val numInicial = scan.nextInt()
    scan.nextLine() // Limpiar buffer del enter

    // 2. Llenar lista
    println("Introduce los nombres:")
    repeat(numInicial) {
        val nombre = scan.nextLine()
        invitados.add(nombre)
    }

    // 3. Modificación: Llega un VIP tarde
    println("Llega el VIP 'Francesco'. Lo colamos el primero.")
    // .add(index, elemento) desplaza a los demás
    invitados.add(0, "Francesco")

    // 4. Eliminación: Alguien se va
    println("¿Quién se ha ido de la fiesta?")
    val seVa = scan.nextLine()
    // .remove devuelve true si lo encontró y borró, false si no estaba
    if (invitados.remove(seVa)) {
        println("Adiós, $seVa.")
    } else {
        println("$seVa no estaba en la lista.")
    }

    // 5. Ordenación
    // .sort() modifica la lista original alfabéticamente
    invitados.sort()
    println("Lista ordenada alfabéticamente: $invitados")

    // 6. Filtrado (Crear sublistas)
    // Queremos saber quiénes tienen nombres largos (> 5 letras)
    // .filter crea una lista NUEVA, no toca la original
    val nombresLargos = invitados.filter { it.length > 5 }
    println("Gente con nombre largo: $nombresLargos")

    // 7. Búsqueda
    // .contains comprueba si está
    if (invitados.contains("Francesco")) {
        // .indexOf nos dice en qué posición quedó tras ordenar
        val pos = invitados.indexOf("Francesco")
        println("Francesco sigue aquí en la posición $pos")
    }
}