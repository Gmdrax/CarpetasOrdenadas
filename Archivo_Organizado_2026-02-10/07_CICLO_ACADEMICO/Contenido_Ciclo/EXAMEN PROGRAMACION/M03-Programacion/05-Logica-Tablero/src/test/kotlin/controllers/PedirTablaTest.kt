import org.example.controllers.pedirTabla
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.util.Scanner

class InputTest {

    @Test
    fun pedirTablaLeeCorrectamenteFilasYColumnasDelInput() {
        //Simulamos que el usuario escribe 10 y 20 (el \n simula la tecla enter)
        val entradaSimulada = "10\n20\n"
        val scannerFalso = Scanner(entradaSimulada)
        //La función imprimirá las preguntas en consola, pero leerá de nuestro String
        val resultado = pedirTabla(scannerFalso)
        //Verificamos que capturó los números en el orden correcto
        assertEquals(10, resultado.filas, "El primer número debe ser las filas")
        assertEquals(20, resultado.columnas, "El segundo número debe ser las columnas")
    }

    @Test
    fun funcionaConEspaciosEnVezDeEnters() {
        //Scanner también acepta espacios como separadores
        val entradaSimulada = "9 9"
        val scannerFalso = Scanner(entradaSimulada)
        val resultado = pedirTabla(scannerFalso)
        assertEquals(9, resultado.filas)
        assertEquals(9, resultado.columnas)
    }
}