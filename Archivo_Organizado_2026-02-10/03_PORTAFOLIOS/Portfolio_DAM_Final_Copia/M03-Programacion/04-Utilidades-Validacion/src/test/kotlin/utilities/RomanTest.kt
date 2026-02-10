package utilities

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RomanTest {

    //logica del ejercicio para poder hacer el test sin el escaner
    private fun calcularRomano(numero: Int): String {
        val valors = listOf(1000 to "M", 900 to "CM", 500 to "D", 400 to "CD", 100 to "C",
            90 to "XC", 50 to "L", 40 to "XL", 10 to "X", 9 to "IX", 5 to "V", 4 to "IV", 1 to "I")
        var restant = numero
        val resultat = StringBuilder()
        for ((valor, simbol) in valors) {
            while (restant >= valor) {
                resultat.append(simbol)
                restant -= valor
            }
        }
        return resultat.toString()
    }

    @Test
    fun testNumerosBasicos() {
        //comprobamos números simples
        assertEquals("I", calcularRomano(1))
        assertEquals("V", calcularRomano(5))
        assertEquals("X", calcularRomano(10))
        assertEquals("L", calcularRomano(50))
    }

    @Test
    fun testNumerosComplejos() {
        //comprobamos números con restas y combinaciones largas
        assertEquals("IV", calcularRomano(4))
        assertEquals("IX", calcularRomano(9))
        assertEquals("MCMXCIV", calcularRomano(1994)) // Año 1994
        assertEquals("MMMCMXCIX", calcularRomano(3999)) // Límite superior
    }
}