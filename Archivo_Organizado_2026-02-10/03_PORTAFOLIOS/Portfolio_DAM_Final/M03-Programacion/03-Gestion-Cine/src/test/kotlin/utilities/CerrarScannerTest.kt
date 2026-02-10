package utilities
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.*

class CerrarScannerTest {

    @Test
    fun `cerrarScanner cierra correctamente el scanner`() {
        val scanner = Scanner("123").useLocale(Locale.UK)

        // Cerramos el scanner
        cerrarScanner(scanner)

        // Al usar un scanner cerrado debe lanzarse IllegalStateException
        assertThrows(IllegalStateException::class.java) {
            scanner.nextInt()
        }
    }
}
