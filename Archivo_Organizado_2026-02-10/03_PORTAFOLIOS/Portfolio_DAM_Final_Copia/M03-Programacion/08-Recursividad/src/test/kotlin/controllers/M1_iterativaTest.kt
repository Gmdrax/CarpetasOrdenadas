package org.example.ejercicios

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class M1_iterativaTest {

    @Test
    fun m1_casBaseZero() {
        // El factorial de 0 és 1
        val esperat = 1
        val obtingut = m1_iterativa(0)
        assertEquals(esperat, obtingut, "El factorial de 0 hauria de ser 1")
    }

    @Test
    fun m1_casNormal() {
        // El factorial de 5 és 120 (1*2*3*4*5)
        val esperat = 120
        val obtingut = m1_iterativa(5)
        assertEquals(esperat, obtingut, "El factorial de 5 hauria de ser 120")
    }

    @Test
    fun m1_comparacioRecursiva() {
        // Comprovem que la iterativa dona el mateix que la recursiva per a n=6
        val recursiu = m1_recursiva(6)
        val iteratiu = m1_iterativa(6)
        assertEquals(recursiu, iteratiu, "La versió iterativa ha de coincidir amb la recursiva")
    }



}