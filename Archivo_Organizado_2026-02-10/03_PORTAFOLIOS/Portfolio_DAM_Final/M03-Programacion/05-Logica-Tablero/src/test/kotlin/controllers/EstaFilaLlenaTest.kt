package controllers

import org.example.controllers.estaFilaLlena
import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class EstaFilaLlenaTest {

    //Probamos con una fila totalmente vacía no devuelva true por defecto
    @Test
    fun devuelveFalseSiLaFilaEsTodoCeros() {
        //Una fila llena de 0s
        val filaVacia = intArrayOf(0, 0, 0, 0, 0)

        //Preguntamos si está llena
        val resultado = estaFilaLlena(filaVacia)

        //Si fuera true el juego borraría filas vacías constantemente
        assertFalse(resultado, "Una fila llena de ceros no debería contar como llena.")
    }

    //La fila está llena al 90% o 99%, solo falta un bloque. La función debe recorrer todo el array buscando ese único cero.
    @Test
    fun devuelveFalseSiQuedaUnUnicoHueco() {
        //Una fila llena de bloques pero con un hueco en la última posición
        val filaCasiLlena = intArrayOf(1, 2, 3, 4, 0)

        val resultado = estaFilaLlena(filaCasiLlena)

        assertFalse(resultado, "Si hay al menos un cero (hueco), la fila NO está llena.")
    }

    //Verificamos que la función entiende que llena significa sin ceros, independientemente de qué números formen la fila
    @Test
    fun devuelveTrueSiNoHayCeros() {
        //Una fila completa con una mezcla de números distintos de 0
        val filaLlena = intArrayOf(1, 4, 2, 2, 3)

        val resultado = estaFilaLlena(filaLlena)

        //Debe devolver true para activar la eliminación de fila.
        assertTrue(resultado, "La fila no tiene huecos (ceros), debería devolver true.")
    }
}
