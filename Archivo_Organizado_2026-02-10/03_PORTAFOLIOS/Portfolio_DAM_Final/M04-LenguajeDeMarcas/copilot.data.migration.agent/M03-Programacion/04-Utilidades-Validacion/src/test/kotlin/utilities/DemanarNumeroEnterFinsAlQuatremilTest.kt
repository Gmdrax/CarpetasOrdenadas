package utilities

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import java.util.Scanner

class InputNumberTest {

    @Test
    fun testEntradaValida() {
        //el usuario escribe 150 y pulsa enter
        val input = "150"
        val inStream = ByteArrayInputStream(input.toByteArray())
        val scanner = Scanner(inStream)

        val resultado = demanarNumeroEnterFinsAlQuatremil(scanner)

        //verificamos que la función devuelve el entero 150
        assertEquals(150, resultado)
    }

    @Test
    fun testEntradaInvalidaLuegoValida() {
        //el suario escribe texto hola, luego 5000, luego 10
        val input = "hola\n5000\n10"
        val inStream = ByteArrayInputStream(input.toByteArray())
        val scanner = Scanner(inStream)

        val resultado = demanarNumeroEnterFinsAlQuatremil(scanner)

        //la función debe ignorar los errores y devolver el primer válido
        assertEquals(10, resultado)
    }
}