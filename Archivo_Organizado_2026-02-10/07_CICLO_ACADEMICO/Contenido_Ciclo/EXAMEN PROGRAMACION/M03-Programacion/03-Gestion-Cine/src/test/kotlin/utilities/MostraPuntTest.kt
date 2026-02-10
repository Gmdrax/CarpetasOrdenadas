package utilities

import org.example.controllers.Punt
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.util.*

class MostraPuntTest {

    @Test
    fun `mostraPunt imprime las coordenadas con 6 decimales`() {
        val punto = Punt(1.2345678f, 9.8765432f)

        // Capturar salida estándar
        val output = ByteArrayOutputStream()
        System.setOut(PrintStream(output))

        // Llamamos a la función a testear
        mostraPunt(punto)

        // Formato esperado
        val expected = """
            1.234568
            9.876543
        """.trimIndent()

        // Comparamos líneas ignorando diferencias de salto de línea
        assertEquals(expected, output.toString().trim())

        // Restauramos salida estándar
        System.setOut(System.out)
    }
}
