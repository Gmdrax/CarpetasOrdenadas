package controllers

import org.example.controllers.eliminarFilaYBajarlas
import org.junit.jupiter.api.Assertions.*
import kotlin.test.Test

class EliminarFilaYBajarlasTest {

    /*La función normalmente funciona copiando la fila superior a la actual (tablero[k] = tablero[k-1]).
    Si pedimos borrar la fila 0, no existe la fila -1. El test verifica que downTo está bien programado para no ejecutarse en este caso, y que simplemente se limpia la fila 0 sin errores de índice. */
    @Test
    fun eliminarFilaYBajarlasConFila0() {
        //Tablero con valores distintos en cada fila
        val tablero = arrayOf(
            intArrayOf(9, 9, 9), //Fila a eliminar
            intArrayOf(1, 1, 1),
            intArrayOf(2, 2, 2)
        )

        eliminarFilaYBajarlas(tablero, 0)

        //La fila 0 debe quedar vacía (ceros)
        //Las filas inferiores deben quedar intactas porque no hay gravedad que las empuje
        val esperado = arrayOf(
            intArrayOf(0, 0, 0), //Limpia
            intArrayOf(1, 1, 1),
            intArrayOf(2, 2, 2)
        )

        assertArrayEquals(esperado, tablero, "Falló al eliminar la primera fila: o dio error o movió lo que no debía.")
    }

    //Verifica que al eliminar la última fila, absolutamente todas las filas superiores deben descender un escalón
    @Test
    fun eliminarFilaYBajarlasConUltimaFila() {
        //Tablero de 3x3
        val tablero = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(2, 2, 2),
            intArrayOf(3, 3, 3)  //Fila a eliminar
        )

        //Eliminamos la última fila
        eliminarFilaYBajarlas(tablero, 2)

        //Verificamos el desplazamiento
        val esperado = arrayOf(
            intArrayOf(0, 0, 0), //Nueva fila generada por arriba
            intArrayOf(1, 1, 1), //Bajó de la 0 a la 1
            intArrayOf(2, 2, 2)  //Bajó de la 1 a la 2
        )

        assertArrayEquals(esperado, tablero, "Falló la cascada: las filas superiores no bajaron correctamente.")
    }

    //Verifica que las filas debajo de la eliminada no se mueven
    @Test
    fun respetaLasFilasInferiores() {
        // GIVEN
        val tablero = arrayOf(
            intArrayOf(1, 1, 1), //Debe bajar
            intArrayOf(2, 2, 2), //A eliminar
            intArrayOf(3, 3, 3), //No debe moverse
            intArrayOf(4, 4, 4)  //No debe moverse
        )

        //Eliminamos la fila 1
        eliminarFilaYBajarlas(tablero, 1)

        val esperado = arrayOf(
            intArrayOf(0, 0, 0), //Nueva
            intArrayOf(1, 1, 1), //Bajó
            intArrayOf(3, 3, 3),
            intArrayOf(4, 4, 4)
        )

        assertArrayEquals(esperado, tablero, "Se movieron filas que estaban debajo de la eliminada, rompiendo la base.")
    }
}