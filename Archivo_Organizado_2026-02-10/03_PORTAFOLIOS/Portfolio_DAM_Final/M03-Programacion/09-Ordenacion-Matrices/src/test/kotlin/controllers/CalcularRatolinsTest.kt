package controllers

import controllers.calcularRatolins
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test


class CalcularRatolinsTest {

    @Test
    fun  testestandar(){

        val esperat = 8
        val real = calcularRatolins(5)
        assertEquals(real,esperat)
    }

    @Test
    fun testRatolinsLimit() {

        assertEquals(1, calcularRatolins(0))
        assertEquals(1, calcularRatolins(1))
    }

    @Test
    fun testRatolinsNegatiu() {

        val esperat = -1
        val real = calcularRatolins(-5)

        assertEquals(esperat, real)
    }

}