package problemas

import java.util.Scanner

fun main() {
    val scan = Scanner(System.`in`)

    // Definimos el tamaño del mapa
    val filas = 5
    val columnas = 5

    // 1. Crear Matriz (Tablero de juego)
    // Usamos 0 para vacío, 1 para tesoro, 2 para jugador
    val mapa = mutableListOf<MutableList<Int>>()
    repeat(filas) {
        // Creamos filas llenas de ceros
        mapa.add(MutableList(columnas) { 0 })
    }

    // 2. Colocar cosas
    // Ponemos un tesoro en el centro (2,2)
    mapa[2][2] = 1
    // Ponemos obstáculos (piedras) en las esquinas
    mapa[0][0] = 9
    mapa[0][4] = 9
    mapa[4][0] = 9
    mapa[4][4] = 9

    println("Introduce tu posición inicial (Fila y Columna 0-4):")
    val miFila = scan.nextInt()
    val miCol = scan.nextInt()

    // Validamos que no se salga del mapa
    if (miFila in 0 until filas && miCol in 0 until columnas) {

        // 3. Comprobar casilla actual
        val contenido = mapa[miFila][miCol]

        when (contenido) {
            1 -> println("¡Has caído justo encima del TESORO!")
            9 -> println("¡Ay! Has caído sobre una piedra.")
            0 -> println("Has caído en suelo vacío.")
        }

        // 4. Lógica de Vecinos (Radar)
        // Vamos a contar cuántas cosas hay alrededor (Tesoro o Piedras)
        var cosasCerca = 0

        // Recorremos el cuadrado de 3x3 alrededor del jugador
        for (i in miFila - 1..miFila + 1) {
            for (j in miCol - 1..miCol + 1) {

                // IMPORTANTE: Verificar límites para no dar error (IndexOutOfBounds)
                if (i >= 0 && i < filas && j >= 0 && j < columnas) {

                    // No nos contamos a nosotros mismos (el centro)
                    if (!(i == miFila && j == miCol)) {
                        // Si la casilla no es 0 (hay algo)
                        if (mapa[i][j] != 0) {
                            cosasCerca++
                            println("Radar detectó algo en ($i, $j)")
                        }
                    }
                }
            }
        }
        println("Total de objetos detectados alrededor: $cosasCerca")

    } else {
        println("Te has caído del mapa...")
    }

    // 5. Imprimir el mapa final para verlo
    println("\n--- MAPA ---")
    for (fila in mapa) {
        // joinToString hace que se vea bonito separado por espacios
        println(fila.joinToString(" "))
    }
}