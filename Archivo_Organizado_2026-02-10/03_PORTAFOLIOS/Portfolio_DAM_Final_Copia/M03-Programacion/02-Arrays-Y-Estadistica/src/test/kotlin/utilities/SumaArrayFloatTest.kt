package utilities

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SumaArrayFloatTest {
    @Test
    fun testSumaArrayFloat_case1_positiveValues() {
        val result = sumaArrayFloat(arrayOf(1f, 2f, 3f))
        assertEquals(6f, result)
    }

    @Test
    fun testSumaArrayFloat_case2_negativeValues() {
        val result = sumaArrayFloat(arrayOf(-2f, -3f, -5f))
        assertEquals(-10f, result)
    }

    @Test
    fun testSumaArrayFloat_case3_mixedValues() {
        val result = sumaArrayFloat(arrayOf(10f, -3f, 2f))
        assertEquals(9f, result)
    }
}