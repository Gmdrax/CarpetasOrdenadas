package controllers

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class EsPrefixTest {

    @Test
    fun testPrefixCorrecte() {
        // cas 1: "Ho" és prefix de "Hola" true
        val resultat = esPrefix("Hola", "Ho")
        assertTrue(resultat, "'Ho' hauria de ser prefix de 'Hola'")
    }

    @Test
    fun testPrefixIncorrecte() {
        // cas 2: "Món" no és prefix de "Hola" false
        val resultat = esPrefix("Hola", "Món")
        assertFalse(resultat, "'Món' no hauria de ser prefix de 'Hola'")
    }

    @Test
    fun testPrefixMesLlarg() {
        // cas 3: el prefix és més llarg que la paraula false
        // "Hola" no és prefix de "Ho" és al revés
        val resultat = esPrefix("Ho", "Hola")
        assertFalse(resultat, "un prefix no pot ser més llarg que la paraula")
    }

}