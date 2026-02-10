package controllers

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import utilities.IncrementarNumero

class IncrementarNumeroTest {

    //suma de positivos
    @Test
    fun testIncrementarPositivos() {
        val resultado = IncrementarNumero(10, 5)
        assertEquals(15, resultado, "10 + 5 debería ser 15")
    }

    //suma con número negativo
    @Test
    fun testIncrementarConNegativo() {
        val resultado = IncrementarNumero(10, -3)
        assertEquals(7, resultado, "10 + (-3) debería ser 7")
    }

    //suma con cero
    @Test
    fun testIncrementarConCero() {
        val resultado = IncrementarNumero(8, 0)
        assertEquals(8, resultado, "Sumar 0 no debería cambiar el número")
    }
}