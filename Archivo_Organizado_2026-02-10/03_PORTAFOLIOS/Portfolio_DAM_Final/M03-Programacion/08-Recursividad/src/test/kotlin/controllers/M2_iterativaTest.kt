package org.example.ejercicios

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class M2_iterativaTest {

    @Test
    fun m2_casBaseZero() {
        // Si n=0, la suma és 0
        val esperat = 0
        val obtingut = m2_iterativa(2.0, 0) // El paràmetre x s'ignora
        assertEquals(esperat, obtingut, "La suma fins a 0 hauria de ser 0")
    }

    @Test
    fun m2_casNormal() {
        // Suma de 4 a 1: 4 + 3 + 2 + 1 = 10
        val esperat = 10
        val obtingut = m2_iterativa(9.9, 4)
        assertEquals(esperat, obtingut, "La suma de 1..4 hauria de ser 10")
    }

    @Test
    fun m2_comparacioRecursiva() {
        // Comprovem igualtat per a n=10
        val recursiu = m2_recursiva(5.0, 10)
        val iteratiu = m2_iterativa(5.0, 10)
        assertEquals(recursiu, iteratiu, "La versió iterativa ha de coincidir amb la recursiva per n=10")
    }


}