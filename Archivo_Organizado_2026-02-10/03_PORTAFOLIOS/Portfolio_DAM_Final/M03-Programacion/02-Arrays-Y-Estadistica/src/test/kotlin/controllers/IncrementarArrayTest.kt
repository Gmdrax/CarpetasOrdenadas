package controllers

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class IncrementarArrayTest {

    @Test
    fun testIncrementarPositiu() {
        // cas 1: sumar una quantitat positiva
        val nums = arrayOf(1, 2, 3)
        incrementarArray(nums, 2)

        // esperem que [1, 2, 3] + 2 sigui [3, 4, 5]
        assertArrayEquals(arrayOf(3, 4, 5), nums, "l'array hauria d'incrementar-se en 2")
    }

    @Test
    fun testIncrementarNegatiu() {
        // cas 2: sumar una quantitat negativa (restar)
        val nums = arrayOf(10, 20, 30)
        incrementarArray(nums, -5)

        // esperem que [10, 20, 30] - 5 sigui [5, 15, 25]
        assertArrayEquals(arrayOf(5, 15, 25), nums, "l'array hauria de decrementar-se en 5")
    }

    @Test
    fun testIncrementarNumerosNegatius() {
        // cas 3: l'array original té números negatius
        val nums = arrayOf(-10, -20, 0)
        incrementarArray(nums, 10)

        // esperem que [-10, -20, 0] + 10 sigui [0, -10, 10]
        assertArrayEquals(arrayOf(0, -10, 10), nums, "hauria de sumar correctament a números negatius")
    }
}