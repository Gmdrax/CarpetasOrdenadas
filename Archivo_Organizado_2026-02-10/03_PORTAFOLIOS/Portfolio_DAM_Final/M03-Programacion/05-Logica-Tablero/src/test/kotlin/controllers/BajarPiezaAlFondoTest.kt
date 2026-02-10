package controllers

import org.example.controllers.bajarPiezaAlFondo
import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class BajarPiezaAlFondoTest {
    //Tablero estándar de 10x10 columnas
    val tableroVacio = Array(10) { IntArray(10) }
    //Pieza de ejemplo: palo vertical de 2 de altura
    val piezaVertical = arrayOf(
        intArrayOf(1),
        intArrayOf(1)
    )

    /* Probamos que la pieza cae todo lo posible hasta tocar el fondo del array. El tablero tiene 10 filas (indices 0 a 9).
    La pieza mide 2 de alto. Si cae al fondo, ocupará las filas 8 y 9. Por tanto, la función debe devolver 8 (la coordenada superior de la pieza)*/
    @Test
    fun caeHastaElSuelo() {
        //Tablero vacío y pieza en la fila 0
        val filaInicio = 0
        val col = 0

        val filaFinal = bajarPiezaAlFondo(tableroVacio, piezaVertical, filaInicio, col)
        //La pieza ocupa [f, f+1], si f=8, ocupa [8, 9], correcto. Si f=9, ocuparía [9, 10]: Error (10 fuera de rango)
        assertEquals(8, filaFinal, "La pieza debería detenerse justo antes de salirse del array.")
    }

    //Ponemos un obstáculo a mitad de camino y verificamos que frena justo encima
    @Test
    fun seDetieneSobreOtraPieza() {
        //ablero con un obstáculo en la fila 5, columna 0
        val tableroConObstaculo = Array(10) { IntArray(10) }
        tableroConObstaculo[5][0] = 9 //Bloque en el camino

        //Pieza en la cima (fila 0)
        val filaInicio = 0
        val col = 0

        val filaFinal = bajarPiezaAlFondo(tableroConObstaculo, piezaVertical, filaInicio, col)

        //El obstáculo está en 5. La pieza (altura 2) debe quedar encima. Ocupará filas 3 y 4.
        //Si la pieza está en fila 3 -> ocupa [3, 4]. La 5 está libre (pero bloqueada para entrar).
        assertEquals(3, filaFinal, "La pieza debería detenerse justo encima del obstáculo en la fila 5.")
    }

    //Verificamos el caso donde la pieza ya está tocando algo.
    //El bucle while no debería ejecutarse ni una vez.
    @Test
    fun devuelveLaMismaFilaSiNoPuedeBajarMas() {
        //La pieza ya está colocada justo encima del suelo (en fila 8)
        val filaInicio = 8 //Posición final válida del Test 1
        val col = 0

        val filaFinal = bajarPiezaAlFondo(tableroVacio, piezaVertical, filaInicio, col)

        assertEquals(8, filaFinal, "Si no hay espacio para bajar, debe devolver la posición actual.")
    }
}