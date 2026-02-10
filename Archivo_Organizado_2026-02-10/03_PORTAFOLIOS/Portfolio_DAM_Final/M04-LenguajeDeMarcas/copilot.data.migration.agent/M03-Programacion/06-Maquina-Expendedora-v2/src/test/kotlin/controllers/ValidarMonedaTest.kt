package org.example.controllers

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ValidacionesTest {

    /**
     * Verifica que les monedes acceptades retornen true.
     */
    @Test
    fun monedesValides() {
        assertTrue(validarMoneda(0.05), "0.05 hauria de ser vàlid")
        assertTrue(validarMoneda(1.0), "1.0 hauria de ser vàlid")
        assertTrue(validarMoneda(50.0), "50.0 hauria de ser vàlid")
    }

    /**
     * Verifica que imports estranys retornen false.
     */
    @Test
    fun monedesInvalides() {
        assertFalse(validarMoneda(0.03), "0.03 no existeix com a moneda")
        assertFalse(validarMoneda(3.0), "Bitllet de 3 euros no existeix")
        assertFalse(validarMoneda(-5.0), "Monedes negatives no vàlides")
    }
}