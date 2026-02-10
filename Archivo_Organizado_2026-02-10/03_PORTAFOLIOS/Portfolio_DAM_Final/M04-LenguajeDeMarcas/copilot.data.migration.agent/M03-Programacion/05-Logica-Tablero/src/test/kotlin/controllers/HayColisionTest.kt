package controllers

import org.example.controllers.hayColision
import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class HayColisionTest {

    val tableroVacio = Array(10) { IntArray(10) }

    // Pieza de prueba: ancho 2 (ocupa columna actual y la siguiente)
    val piezaDoble = arrayOf(intArrayOf(1, 1))

    //Verifica que la función impide que la pieza se salga de los límites del array
    @Test
    fun devuelveTrueSiLaPiezaSeSaleDelTablero() {
        val fila = 0
        val colLimite = 9 //El inicio (9) es válido, pero el final (9+1=10) no lo es

        //Preguntamos si hay colisión
        val resultado = hayColision(tableroVacio, piezaDoble, fila, colLimite)

        assertTrue(resultado, "Debería haber colisión porque la mitad de la pieza está fuera del array.")
    }

    /* Simulamos el momento exacto de perder la partida:
    Nace una nueva pieza en el origen (0,0), pero esa celda ya está ocupada por basura antigua.
    La función debe detectar que el espacio no es 0 y reportar colisión. */
    @Test
    fun devuelveTrueSiChocaConOtraPieza() {
        //Tablero con un bloque en la esquina superior izquierda
        val tableroLleno = Array(10) { IntArray(10) }
        tableroLleno[0][0] = 9 //Obstáculo antiguo

        val piezaSimple = arrayOf(intArrayOf(1)) //Pieza nueva 1x1

        //Intentamos poner la pieza nueva justo encima de la vieja
        val resultado = hayColision(tableroLleno, piezaSimple, 0, 0)

        //Indica al bucle principal que la pieza no puede nacer y debe lanzar Game Over
        assertTrue(resultado, "Debería haber colisión porque la celda ya está ocupada.")
    }

    /*Verificamos el comportamiento estándar:
    Si las coordenadas están dentro del tablero y las celdas valen 0, la función debe dar false. */
    @Test
    fun `test hayColision devuelve false si el espacio esta libre`() {
        //Coordenadas seguras en medio de la nada
        val fila = 5
        val col = 5

        val resultado = hayColision(tableroVacio, piezaDoble, fila, col)

        //False = no hay colisión = movimiento permitido
        assertFalse(resultado, "No debería haber colisión en un espacio vacío y dentro de los límites.")
    }
}