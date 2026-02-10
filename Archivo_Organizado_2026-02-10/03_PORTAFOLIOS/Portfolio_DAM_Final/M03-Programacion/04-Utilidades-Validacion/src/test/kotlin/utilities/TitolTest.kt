package utilities

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TitleTest {

    private fun calcularEspais(text: String): Int {
        val ampladaPantalla = 80
        val espais = (ampladaPantalla - text.length) / 2
        return if (espais <= 0) 0 else espais
    }

    @Test
    fun testCentrarTextCurt() {
        val text = "HOLA" //longitud 4
        //(80 - 4) / 2 = 38 espacios
        assertEquals(38, calcularEspais(text))
    }

    @Test
    fun testTextLlarg() {
        //texto de 80 caracteres exactos
        val text = "a".repeat(80)
        //(80 - 80) / 2 = 0 espacios
        assertEquals(0, calcularEspais(text))
    }

    @Test
    fun testTextMassaLlarg() {
        //texto de 90 caracteres
        val text = "a".repeat(90)
        //debería dar 0 espacios
        assertEquals(0, calcularEspais(text))
    }
}