package controllers

import org.example.controllers.intentarMoverLateral
import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class IntentarMoverLateralTest {

    //Definimos una pieza simple de 2x2
    val piezaCuadrada = arrayOf(
        intArrayOf(1, 1),
        intArrayOf(1, 1)
    )

    //Tablero vacío de 10x10
    val tableroVacio = Array(10) { IntArray(10) }

    //Verificamos que la función detecta que -1 es inválido y cancela el movimiento, devolviendo la posición original (0) en lugar de permitir un índice negativo
    @Test
    fun chocaContraParedIzquierda() {
        //Estamos pegados a la pared izquierda
        val fila = 0
        val colActual = 0
        val direccion = 1 // 1 = Izquierda

        //Intentamos movernos fuera del tablero
        val nuevaCol = intentarMoverLateral(tableroVacio, piezaCuadrada, fila, colActual, direccion)

        //La columna debe seguir siendo 0
        assertEquals(0, nuevaCol, "La pieza no debería moverse si está en el límite izquierdo (índice 0).")
    }

    //Verifica que la función impide ocupar un espacio que no existe.
    @Test
    fun chocaContraParedDerecha() {
        //Estamos en la posición 8 (el límite máximo permitido para una pieza de ancho 2)
        val fila = 0
        val colActual = 8
        val direccion = 2 // 2 = Derecha

        //Intentamos movernos a la derecha (hacia la columna 9)
        val nuevaCol = intentarMoverLateral(tableroVacio, piezaCuadrada, fila, colActual, direccion)

        //Debemos quedarnos en 8
        assertEquals(8, nuevaCol, "La pieza no debería moverse si ya toca el límite derecho con su extremo.")
    }

    //Verificamos que, si no hay paredes ni obstáculos, la función actúa simplemente actualiza la posición.
    @Test
    fun `test intentarMoverLateral se mueve si hay espacio`() {
        //Estamos en medio del tablero lejos de las paredes
        val fila = 0
        val colActual = 4
        val direccion = 2 // 2 = Derecha

        //Intentamos movernos
        val nuevaCol = intentarMoverLateral(tableroVacio, piezaCuadrada, fila, colActual, direccion)

        //Sí se permite el cambio. 4 + 1 = 5
        assertEquals(5, nuevaCol, "Si hay espacio libre, la columna debería incrementarse.")
    }
}