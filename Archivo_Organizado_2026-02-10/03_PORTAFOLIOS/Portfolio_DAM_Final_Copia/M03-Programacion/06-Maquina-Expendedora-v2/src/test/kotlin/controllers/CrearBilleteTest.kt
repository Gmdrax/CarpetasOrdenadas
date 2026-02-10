package org.example.controllers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CrearBilleteTest {

    /**
     * Verifica el càlcul matemàtic del preu amb el multiplicador de zona 2.
     */
    @Test
    fun calculPreuTCasualZona2() {
        //Tipus 2 (TCasual base 11.35) a Zona 2 (x1.3125)
        val resultat = calcularPreuBitllet(2, 2)

        //11.35 * 1.3125 = 14.896875
        assertEquals(14.896875, resultat, 0.0001, "El preu ha d'incloure el recàrrec de zona 2")
    }

    /**
     * Verifica que la Zona 1 no aplica cap multiplicador extra.
     */
    @Test
    fun calculPreuSenzillZona1() {
        //Tipus 1 (Senzill base 2.40) a Zona 1 (x1.0)
        val resultat = calcularPreuBitllet(1, 1)

        assertEquals(2.40, resultat, 0.001, "La zona 1 no ha de modificar el preu base")
    }

    /**
     * Verifica que la funció de noms retorna el text correcte segons l'ID.
     */
    @Test
    fun obtenirNomCorrecte() {
        assertEquals("Bitllet senzill", obtenirNomBitllet(1))
        assertEquals("TCasual", obtenirNomBitllet(2))
        assertEquals("TJove", obtenirNomBitllet(5))
        assertEquals("Desconegut", obtenirNomBitllet(99))
    }
}