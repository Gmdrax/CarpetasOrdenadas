import org.example.controllers.verificarFiSeleccio
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import java.util.Scanner

class LogicaBucleTest {

    // Si ja tenim 3 bitllets, la funció ha de retornar true (acabar) automàticament
    @Test
    fun maximBitlletsAssolit() {
        val scan = Scanner("".byteInputStream())
        val finalitzar = verificarFiSeleccio(scan, 3)
        assertTrue(finalitzar, "Ha de finalitzar automàticament si tenim 3 bitllets")
    }

    // Si l'usuari diu 'N', finalitza la selecció
    @Test
    fun usuariDiuNo() {
        val input = "N\n"
        val scan = Scanner(ByteArrayInputStream(input.toByteArray()))
        val finalitzar = verificarFiSeleccio(scan, 1)
        assertTrue(finalitzar, "Ha de finalitzar si l'usuari escriu N")
    }

    // Si l'usuari diu 'S', NO finalitza (retorna false)
    @Test
    fun usuariDiuSi() {
        val input = "S\n"
        val scan = Scanner(ByteArrayInputStream(input.toByteArray()))
        val finalitzar = verificarFiSeleccio(scan, 1)
        assertFalse(finalitzar, "No ha de finalitzar si l'usuari escriu S")
    }
}