package controllers

import org.example.controllers.calcularNuevaColumna
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CalcularNuevaColumnaTest {
    @Test
    fun direccion1Resta1ALaColumnaIzquierda() {
        //Estamos en la columna 5
        val colActual = 5
        //Dirección es 1
        val resultado = calcularNuevaColumna(colActual, 1)
        //Deberíamos ir a la 4
        assertEquals(4, resultado)
    }

    @Test
    fun direccion2Suma1ALaColumnaDerecha() {
        //Estamos en la columna 5
        val colActual = 5
        //Dirección es 2
        val resultado = calcularNuevaColumna(colActual, 2)
        //Deberíamos ir a la 6
        assertEquals(6, resultado)
    }

    @Test
    fun cualquierOtraDireccionDevuelveLaMismaColumna() {
        val colActual = 5
        //Casos raros: Dirección 3 (Caer), 4 (Salir), o un número inventado 99
        assertEquals(5, calcularNuevaColumna(colActual, 3))
        assertEquals(5, calcularNuevaColumna(colActual, 4))
        assertEquals(5, calcularNuevaColumna(colActual, 99))
    }

    @Test
    fun calculaCoordenadasNegativasCorrectamente() {
        /*Solo calcula matemáticas, no comprueba si te sales del tablero (eso lo hace validarMovimiento).
        Por tanto, si estás en la columna 0 y vas a la izquierda, debe dar -1.*/
        val resultado = calcularNuevaColumna(0, 1)
        assertEquals(-1, resultado)
    }
}