import org.example.controllers.copiarTablero
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CopiaTest {

    @Test
    fun laCopiaTieneLosMismosValoresQueElOriginal() {
        //Tablero pequeño 2x2 con datos específicos
        val original = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(3, 4)
        )
        //Hacemos la copia
        val copia = copiarTablero(original)
        //Verificamos que los valores son idénticos
        assertEquals(1, copia[0][0])
        assertEquals(4, copia[1][1])
        assertEquals(original.size, copia.size) // Mismo número de filas
        assertEquals(original[0].size, copia[0].size) // Mismo número de columnas
    }

    @Test
    fun modificarLaCopiaNoAfectaAlTableroOriginal() {
        //Tablero vacío
        val original = Array(3) { IntArray(3) } // Todo ceros
        //Creamos la copia
        val copia = copiarTablero(original)
        //Manchamos la copia simulando dibujar una pieza
        copia[1][1] = 99
        //1. La copia debe tener el cambio
        assertEquals(99, copia[1][1])
        //2. El original sigue limpio
        assertEquals(0, original[1][1], "El original no debería haber cambiado")
    }
}