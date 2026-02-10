package org.example.ejercicios

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class M4_iterativaTest {

    @Test
    fun m4_casZero() {
        // Suma dígits de 0 és 0
        val esperat = 0
        val obtingut = m4_iterativa(0)
        assertEquals(esperat, obtingut, "La suma dels dígits de 0 ha de ser 0")
    }

    @Test
    fun m4_casUnDigit() {
        // Suma dígits de 7 és 7
        val esperat = 7
        val obtingut = m4_iterativa(7)
        assertEquals(esperat, obtingut, "La suma dels dígits de 7 ha de ser 7")
    }

    @Test
    fun m4_casMultidigit() {
        // Suma dígits de 1234 -> 1+2+3+4 = 10
        val esperat = 10
        val obtingut = m4_iterativa(1234)
        assertEquals(esperat, obtingut, "La suma dels dígits de 1234 ha de ser 10")
    }

}