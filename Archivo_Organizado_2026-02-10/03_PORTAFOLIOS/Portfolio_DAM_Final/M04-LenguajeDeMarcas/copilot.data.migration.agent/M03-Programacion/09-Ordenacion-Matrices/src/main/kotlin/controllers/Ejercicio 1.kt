package controllers

import utilities.*


data class Coordenades(val y:Int, val x:Int)

fun main() {
    exercici1(15,15)
}

/**
 * Executa l’exercici principal: crea una matriu aleatòria, la mostra,
 * demana coordenades i color, pinta la zona corresponent i torna a mostrar la matriu.
 *
 * @param height nombre de files de la matriu
 * @param width nombre de columnes de la matriu
 * @author Gerard, Joel, Leo
 */
fun exercici1(height: Int, width: Int) {
    val matriu = crearMatriu(height, width)
    printMatriu(matriu)
    val start = demanarCoordenades(height, width)
    val newColor = demanarcolor()
    pintarMatriu(matriu, start, newColor)
    printMatriu(matriu)
    sc.close()
}

/**
 * Crea una matriu de dimensions donades amb valors aleatoris blancs o negres.
 *
 * @param height nombre de files
 * @param width nombre de columnes
 * @return matriu de caràcters inicialitzada
 * @author Gerard, Joel, Leo
 */
fun crearMatriu(height: Int, width: Int): Array<CharArray> {
    val blackOrWhite = listOf('B', 'N')
    val matriu = Array(height) { CharArray(width) }
    for (y in matriu.indices) {
        for (x in matriu[0].indices) {
            matriu[y][x] = blackOrWhite.random()
        }
    }
    return matriu
}

/**
 * Mostra per pantalla la matriu amb colors de fons segons el valor de cada cel·la.
 *
 * @param matriu matriu de caràcters a imprimir
 * @author Gerard, Joel, Leo
 */
fun printMatriu(matriu: Array<CharArray>) {
    val reset = "\u001B[0m"

    fun bg(r: Int, g: Int, b: Int) = "\u001B[48;2;${r};${g};${b}m"

    for (row in matriu) {
        for (cell in row) {
            val color = when (cell) {
                'G' -> bg(120, 120, 120)
                'B' -> bg(255, 255, 255)
                'N' -> bg(0, 0, 0)
                'V' -> bg(0, 180, 0)
                else -> bg(128, 0, 128)
            }
            print("$color  $reset")
        }
        println()
    }
}

/**
 * Demana a l’usuari unes coordenades vàlides dins la matriu.
 *
 * @param height nombre de files de la matriu
 * @param width nombre de columnes de la matriu
 * @return objecte Coordenades amb índexos ajustats a base 0
 * @author Gerard, Joel, Leo
 */
fun demanarCoordenades(height: Int, width: Int): Coordenades {
    val y = demanarEnter("Introdueix la fila que vols pintar.(Ha de ser entre 1 i $height)")
    val x = demanarEnter("Introdueix la columna que vols pintar.(Ha de ser entre 1 i $width)")
    return Coordenades(y - 1, x - 1)
}

/**
 * Demana a l’usuari el color amb què vol pintar.
 *
 * @return caràcter que representa el nou color
 * @author Gerard, Joel, Leo
 */
fun demanarcolor(): Char {
    println("De quin color vols pintar la illa?(blanc, negre, gris, verd o morat)")
    val newColor = sc.next()[0]
    return newColor
}

/**
 * Pinta recursivament una zona connectada de la matriu a partir d’un punt inicial.
 *
 * @param matriu matriu sobre la qual es pinta
 * @param start coordenades inicials
 * @param newColor color amb què es vol pintar la zona
 * @author Gerard, Joel, Leo
 */
fun pintarMatriu(matriu: Array<CharArray>, start: Coordenades, newColor: Char) {
    val colorCambiar = matriu[start.y][start.x]

    fun domainExpansion(r: Int, c: Int) {
        if (r in 0 until matriu.size &&
            c in 0 until matriu[0].size &&
            matriu[r][c] == colorCambiar
        ) {
            matriu[r][c] = newColor

            domainExpansion(r + 1, c)
            domainExpansion(r - 1, c)
            domainExpansion(r, c + 1)
            domainExpansion(r, c - 1)
        }
    }


    domainExpansion(start.y, start.x)
}