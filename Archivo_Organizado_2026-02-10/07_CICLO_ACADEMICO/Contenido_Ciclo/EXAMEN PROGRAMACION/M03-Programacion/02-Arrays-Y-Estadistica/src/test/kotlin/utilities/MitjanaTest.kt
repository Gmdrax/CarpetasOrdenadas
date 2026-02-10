package utilities
import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class MitjanaTest {
    @Test
    fun testMitjana_case1_basicAverage() {
        val result = mitjana(arrayOf(2f, 4f, 6f))
        assertEquals(4f, result)
    }

    @Test
    fun testMitjana_case2_negativeNumbers() {
        val result = mitjana(arrayOf(-2f, -6f))
        assertEquals(-4f, result)
    }

    @Test
    fun testMitjana_case3_mixedNumbers() {
        val result = mitjana(arrayOf(5f, 0f, -5f))
        assertEquals(0f, result)
    }
}