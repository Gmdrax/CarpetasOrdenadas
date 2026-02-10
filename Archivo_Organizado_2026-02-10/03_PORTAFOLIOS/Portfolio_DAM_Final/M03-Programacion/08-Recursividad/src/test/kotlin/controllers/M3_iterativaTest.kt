package org.example.ejercicios

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class M3_iterativaTest {

    @Test
    fun m3_casMenorQueDos() {
        // Si n < 2, retorna 0
        val esperat = 0
        val obtingut = m3_iterativa(1)
        assertEquals(esperat, obtingut, "El log2 enter de 1 hauria de ser 0")
    }

    @Test
    fun m3_casPotenciaExacta() {
        // 32 és 2^5, per tant el resultat ha de ser 5
        val esperat = 5
        val obtingut = m3_iterativa(32)
        assertEquals(esperat, obtingut, "El log2 enter de 32 hauria de ser 5")
    }

    @Test
    fun m3_casNoExacte() {
        // 33 no és potència exacte, però la part entera del logaritme és 5
        val esperat = 5
        val obtingut = m3_iterativa(33)
        assertEquals(esperat, obtingut, "El log2 enter de 33 hauria de ser 5")
    }

}