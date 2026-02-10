package controllers

import org.example.controllers.validarMovimiento
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.example.controllers.cubo

class ValidacionTest {

    //Definimos el tablero limpio de 9x9 con una funcion auxiliar
    private fun crearTablero9x9(): Array<IntArray> = Array(9) { IntArray(9) }

    @Test
    fun moverseEnElCentro() {
        val tablero = crearTablero9x9()
        val esValido = validarMovimiento(tablero, cubo, 4, 4)
        assertTrue(esValido)
    }

    @Test
    fun detectarChoqueConParedDerecha() {
        val tablero = crearTablero9x9()
        //Tablero 9x9 = Índices 0..8
        //La columna 8 ocupa 8 y 9, la 9 está fuera.
        val esValido = validarMovimiento(tablero, cubo, 4, 8)
        assertFalse(esValido)
    }

    @Test
    fun detectarChoqueConsuelo() {
        val tablero = crearTablero9x9()
        //Fila 8: Ocupa 8 y 9, la 9 es suelo.
        val esValido = validarMovimiento(tablero, cubo, 8, 4)
        assertFalse(esValido)
    }

    @Test
    fun detectarColisionConOtraPieza() {
        val tablero = crearTablero9x9()
        //Ponemos un obstáculo
        tablero[8][8] = 2
        //Intentamos poner el cubo justo encima
        val esValido = validarMovimiento(tablero, cubo, 7, 7)
        assertFalse(esValido)
    }
}