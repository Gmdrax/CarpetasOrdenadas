package controllers

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import sumaElements


class SumaElementsTest {

    @Test
    fun testSumaPositius() {
        //suma de números positius
        val nums = arrayOf(10, 20, 30)
        val resultat = sumaElements(nums)
        assertEquals(60, resultat, "La suma de 10, 20 i 30 hauria de ser 60")
    }

    @Test
    fun testSumaNegatius() {
        //suma de números negatius
        val nums = arrayOf(-5, -10, -15)
        val resultat = sumaElements(nums)
        assertEquals(-30, resultat, "La suma de -5, -10 i -15 hauria de ser -30")
    }

    @Test
    fun testSumaMixte() {
        //barreja de positius, negatius i zero
        val nums = arrayOf(10, -5, 0, 5)
        val resultat = sumaElements(nums)
        assertEquals(10, resultat, "La suma de 10, -5, 0 i 5 hauria de ser 10")
    }
}