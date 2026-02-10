package utilities

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.*

class ScannerTest {

    @Test
    fun `abrirScanner devuelve un Scanner con Locale UK`() {
        val scanner = abrirScanner()

        // El scanner no debe ser null
        assertNotNull(scanner)

        // Debe ser instancia de Scanner
        assertTrue(scanner is Scanner)

        // Debe tener Locale UK
        assertEquals(Locale.UK, scanner.locale())

        // Lo cerramos para evitar fugas
        scanner.close()
    }
}
