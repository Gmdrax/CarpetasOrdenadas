package controllers

import org.example.controllers.comprobarFilas
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ComprobarFilasTest {

    //El jugador completa una línea en el fondo del tablero
    @Test
    fun  eliminaLaFilaDelFondo() {
        //Tablero de 4x4 donde la última fila está llena y debe borrarse
        val tablero = arrayOf(
            intArrayOf(0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0),
            intArrayOf(2, 2, 2, 2), //Esta fila debería caer al suelo
            intArrayOf(1, 1, 1, 1)  //Esta fila debe desaparecer
        )

        comprobarFilas(tablero)

        val esperado = arrayOf(
            intArrayOf(0, 0, 0, 0), //Se genera una nueva fila vacía arriba del todo
            intArrayOf(0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0),
            intArrayOf(2, 2, 2, 2)  //Los 2s han bajado de la fila 2 a la 3 (el nuevo suelo)
        )

        assertArrayEquals(esperado, tablero, "La última fila no se eliminó o la gravedad falló.")
    }

    /*Si borramos la fila 0, la lógica estándar de "copiar la fila anterior" (fila -1) provocaría un error
    de 'IndexOutOfBounds'. La función debe ser capaz de detectar que es el techo y simplemente limpiarlo con ceros nuevos en lugar de intentar bajar algo. */
    @Test
    fun eliminaLaPrimeraFila() {
        //Tablero donde la fila 0 està llena
        val tablero = arrayOf(
            intArrayOf(1, 1, 1, 1), //Fila 0 llena
            intArrayOf(2, 0, 0, 0),
            intArrayOf(0, 3, 0, 0),
            intArrayOf(0, 0, 0, 0)
        )

        comprobarFilas(tablero)

        //La fila 0 debe ser sustituida por ceros nuevos. Las filas inferiores (1, 2, 3) NO deben moverse porque no hay huecos debajo de ellas
        val esperado = arrayOf(
            intArrayOf(0, 0, 0, 0), //Nueva vacía generada manualmente por la función
            intArrayOf(2, 0, 0, 0),
            intArrayOf(0, 3, 0, 0),
            intArrayOf(0, 0, 0, 0)
        )

        assertArrayEquals(esperado, tablero, "El borrado de la fila superior (índice 0) falló o intentó acceder a índices negativos.")
    }

    //Verificamos que la eliminación de filas es selectiva. Solo deben caer las filas que están por encima de la eliminada. Las filas que están por debajo deben quedarse quietas
    @Test
    fun `test comprobarFilas elimina una fila intermedia`() {
        //Tablero con una fila llena en medio
        val tablero = arrayOf(
            intArrayOf(0, 0, 5, 0), //Pieza flotando arriba
            intArrayOf(0, 0, 5, 0), //Pieza flotando arriba
            intArrayOf(1, 1, 1, 1), //Fila llena a eliminar
            intArrayOf(2, 0, 2, 0)  //Fila base con huecos
        )

        comprobarFilas(tablero)

        val esperado = arrayOf(
            intArrayOf(0, 0, 0, 0), //Nueva fila entrando por arriba
            intArrayOf(0, 0, 5, 0), //Bajó una posición
            intArrayOf(0, 0, 5, 0), //Bajó una posición
            intArrayOf(2, 0, 2, 0)  //Se mantiene igual sosteniendo la estructura
        )

        assertArrayEquals(esperado, tablero, "La eliminación intermedia afectó incorrectamente a la base o no bajó la parte superior.")
    }
}