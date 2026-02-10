package controllers

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.Scanner

class readArrayIntTest {

    @Test
    fun testLlegirArrayStandard() {
        // simulem que l'usuari escriu: 3 (mida) 10 20 30 (elements)
        val input = "3 10 20 30"
        val scan = Scanner(input)

        val resultat = readArrayInt(scan)

        // comprovem que ha llegit l'array correctament
        assertArrayEquals(arrayOf(10, 20, 30), resultat)
    }

    @Test
    fun testLlegirArrayBuit() {
        // simulem que l'usuari escriu: 0 (mida)
        val input = "0"
        val scan = Scanner(input)

        val resultat = readArrayInt(scan)

        // hauria de retornar un array buit
        assertEquals(0, resultat.size)
    }

    @Test
    fun testLlegirArrayAmbNegatius() {
        // simulem: 2 (mida) -5 5 (elements)
        val input = "2 -5 5"
        val scan = Scanner(input)

        val resultat = readArrayInt(scan)

        assertArrayEquals(arrayOf(-5, 5), resultat)
    }
}