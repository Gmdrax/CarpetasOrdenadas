package utilities

import controllers.PASSWORD_CORRECTE
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import java.util.Scanner
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import org.junit.jupiter.api.Assertions.assertTrue

class PasswordTest {

    @Test
    fun testContrasenyaCorrecta() {
        //simulamos que el usuario introduce la contraseña correcta a la primera
        val input = "$PASSWORD_CORRECTE\n"
        val inStream = ByteArrayInputStream(input.toByteArray())
        val scanner = Scanner(inStream)

        //capturamos la salida de consola para verificar el mensaje
        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        validarSuperusuari(scanner)

        //verificamos que salga el mensaje de éxito
        val salida = outputStream.toString()
        assertTrue(salida.contains("Has encertat la contrasenya!"))
    }

    @Test
    fun testContrasenyaIncorrectaTresVegades() {
        //simulamos 3 intentos fallidos
        val input = "error1\nerror2\nerror3\n"
        val inStream = ByteArrayInputStream(input.toByteArray())
        val scanner = Scanner(inStream)

        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        validarSuperusuari(scanner)

        //verificamos que al final no permita el acceso
        val salida = outputStream.toString()
        assertTrue(salida.contains("Accés denegat"))
    }
}