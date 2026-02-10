package org.example.controllers

import java.util.Scanner
import kotlin.collections.indices
import kotlin.random.Random




fun main() {
    val scan = Scanner(System.`in`)

    var j = pedirTabla(scan)

    val frame1: Array<IntArray> = Array(j.first) { IntArray(j.second) }

    println("Pieza Aleatoria Generada")
    val miPieza = piezaAleatoria()
    printPieza(miPieza)


    var filaDondeCae = 0
    var colDondeCae = j.second/2

    colocarPieza(frame1, miPieza, filaDondeCae, colDondeCae)

    println("Tablero con la pieza")
    printPicture(frame1)

    var inputDireccion = demanarAccio(scan)

    while (inputDireccion != 4) {

        resetFrame(frame1)

        colDondeCae = calcularNuevaColumna(colDondeCae, inputDireccion)

        colocarPieza(frame1, miPieza, filaDondeCae, colDondeCae)

        println()
        printPicture(frame1)

        inputDireccion = demanarAccio(scan)
        if (inputDireccion == 3 ){
            resetFrame(frame1)

            val alturaPieza = miPieza.size
            filaDondeCae = j.first - alturaPieza

            // 3. Reutilizamos colocarPieza con la nueva fila calculada
            colocarPieza(frame1, miPieza, filaDondeCae, colDondeCae)

            println("\n--- Pieza bajada al fondo ---")
            printPicture(frame1)

        }
    }

}



fun pedirTabla(scan: Scanner): Pair<Int, Int> {

    println("Introduce el numero de filas: ")
    val filas = scan.nextInt()

    println("Introduce el numero de columnas: ")
    val columnas = scan.nextInt()

    return Pair(filas, columnas)
}

fun calcularNuevaColumna(columnaActual: Int, direccion: Int): Int {

    if (direccion == 1) return columnaActual - 1
    if (direccion == 2) return columnaActual + 1

    return columnaActual
}

fun resetFrame(frame: Array<IntArray>){
    for (f in frame.indices) {
        for (c in frame[f].indices) {
            frame[f][c] = 0
        }
    }
}




fun colocarPieza(tablero: Array<IntArray>, pieza: Array<IntArray>, filaPos: Int, colPos: Int) {
    for (i in pieza.indices) {
        for (j in pieza[i].indices) {

            if (pieza[i][j] != 0) {

                val filaTablero = filaPos + i
                val colTablero = colPos + j


                if (filaTablero in tablero.indices && colTablero in tablero[0].indices) {
                    tablero[filaTablero][colTablero] = pieza[i][j]
                }
            }
        }
    }
}



fun demanarAccio(scanner: Scanner): Int {
    println("Selecciona una acció: 1:Esquerra / 2:Dreta / 3:Deixar caure")
    return scanner.nextInt()
}






val cubo = arrayOf(
    intArrayOf(1, 1),
    intArrayOf(1, 1)
)


val palo = arrayOf(
    intArrayOf(1),
    intArrayOf(1),
    intArrayOf(1),
    intArrayOf(1)
)


val eleHorizontal = arrayOf(
    intArrayOf(0, 0, 1),
    intArrayOf(1, 1, 1)
)


val eleVertical = arrayOf(
    intArrayOf(1, 0),
    intArrayOf(1, 0),
    intArrayOf(1, 1)
)



fun piezaAleatoria(): Array<IntArray> {
    val numeroRandom = Random.nextInt(0, 4)

    return when (numeroRandom) {
        0 -> cubo
        1 -> eleHorizontal
        2 -> eleVertical
        3 -> palo
        else -> cubo
    }
}


fun printPieza(pieza: Array<IntArray>) {
    val RESET = "\u001b[0m"
    val RED_BG = "\u001b[41m"
    val WHITE = "\u001b[37m"

    for (fila in pieza) {
        for (celda in fila) {
            if (celda != 0) {

                print("$RED_BG$WHITE[1]$RESET")
            } else {

                print("  ")
            }
        }
        println()
    }
}


fun printPicture(frame: Array<IntArray>) {
    val RESET = "\u001b[0m"
    val WHITE = "\u001b[37m"
    val BOLD = "\u001b[1m"
    val BLACK_BG = "\u001b[40m"
    val RED_BG = "\u001b[41m"
    val GREEN_BG = "\u001b[42m"

    print("   ")
    for (i in frame[0].indices) print("[$i]")
    println("")

    for (f in frame.indices) {
        print("[$f]")
        for (c in frame[f].indices) {
            when (frame[f][c]) {
                1 -> print(BLACK_BG + WHITE + BOLD + String.format("%2s ", 1) + RESET)
                2 -> print(RED_BG + WHITE + BOLD + String.format("%2s ", 2) + RESET)
                3 -> print(GREEN_BG + WHITE + BOLD + String.format("%2s ", 3) + RESET)
                else -> print(String.format("%2s ", 0)) // Imprime 0 si está vacío
            }
        }
        println("")
    }
}