package controllers

import org.example.controllers.Dimensiones
import org.example.controllers.EstadoJuego
import org.example.controllers.cubo
import org.example.controllers.procesarAccion
import org.junit.jupiter.api.Assertions.*
import kotlin.test.DefaultAsserter.assertNotNull
import kotlin.test.DefaultAsserter.assertTrue
import kotlin.test.Test

class JuegoTest {

    @Test
    fun procesarAccionConSalirYTerminaElJuego() {
        //configuración inicial
        val tablero = Array(20) { IntArray(10) }
        val dim = Dimensiones(20, 10)
        val estado = EstadoJuego(cubo, 0, 0, true)
        //ejecución
        val resultado = procesarAccion(4, estado, tablero, dim)
        //verificación
        assertFalse(resultado.esActivo)
    }

    @Test
    fun mantieneElEstadoSiLaAccionEsDesconocida() {
        val tablero = Array(20) { IntArray(10) }
        val dim = Dimensiones(20, 10)
        val estado = EstadoJuego(cubo, 5, 5, true)

        val resultado = procesarAccion(8, estado, tablero, dim)

        //comprueba el resultado
        assertEquals(estado, resultado)
    }

    @Test
    fun procesarAccionConCaidaReiniciaLaFilaDeLaNuevaPieza() {
        val tablero = Array(20) { IntArray(10) }
        val dim = Dimensiones(20, 10)
        val estado = EstadoJuego(cubo, 10, 5, true) //pieza a mitad de tablero

        //Nota: el test ejecutará tu lógica real de 'bajarPiezaAlFondo'. el tablero tiene que esté vacío para evitar errores.
        val resultado = procesarAccion(3, estado, tablero, dim)

        // La nueva pieza debe empezar arriba
        assertEquals(0, resultado.fila)
        // El juego debe seguir activo (a menos que haya Game Over inmediato)
        assertTrue(resultado.esActivo)
    }
}