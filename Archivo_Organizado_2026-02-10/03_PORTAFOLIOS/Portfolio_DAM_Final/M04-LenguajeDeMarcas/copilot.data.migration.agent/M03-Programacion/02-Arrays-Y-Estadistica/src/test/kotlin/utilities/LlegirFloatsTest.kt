package utilities
import org.junit.jupiter.api.Test
import java.util.Scanner
import org.junit.jupiter.api.Assertions.*

class LlegirFloatsTest {
    @Test
    fun testLlegirFloats_case1_basicInput() {
        val input = "3 1.5 2.5 3.0"
        val scanner = Scanner(input)

        val result = llegirFloats(scanner)
        assertArrayEquals(arrayOf(1.5f, 2.5f, 3.0f), result)
    }

    @Test
    fun testLlegirFloats_case2_wrongSizeThenCorrect() {
        val input = "abc 2 4.5 5.5"
        val scanner = Scanner(input)

        val result = llegirFloats(scanner)
        assertArrayEquals(arrayOf(4.5f, 5.5f), result)
    }

    @Test
    fun testLlegirFloats_case3_negativeFloats() {
        val input = "2 -3.2 -4.8"
        val scanner = Scanner(input)

        val result = llegirFloats(scanner)
        assertArrayEquals(arrayOf(-3.2f, -4.8f), result)
    }
}