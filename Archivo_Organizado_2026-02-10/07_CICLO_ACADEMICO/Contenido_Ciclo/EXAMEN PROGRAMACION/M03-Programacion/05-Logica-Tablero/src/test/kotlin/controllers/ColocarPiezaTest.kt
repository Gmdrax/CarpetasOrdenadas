import org.example.controllers.colocarPieza
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ColocarPiezaTest {

    //Definimos el tablero limpio de 5x5 con una funcion auxiliar
    private fun tableroVacio() = Array(5) { IntArray(5) }

    @Test
    fun dibujaLaPiezaEnLaPosicionCorrecta() {
        val tablero = tableroVacio()
        //Palo horizontal de [2, 2]
        val pieza = arrayOf(intArrayOf(2, 2))
        //La colocamos en fila 2, columna 1
        colocarPieza(tablero, pieza, 2, 1)
        //Verificamos que se han pintado los 2s
        assertEquals(2, tablero[2][1])
        assertEquals(2, tablero[2][2])
        //Verificamos que el resto sigue vacío (ej. la celda de al lado)
        assertEquals(0, tablero[2][3])
    }

    @Test
    fun respetarLaTransparencia /*(los ceros de la pieza no borran el fondo)*/ () {
        val tablero = tableroVacio()
        //Manchamos el tablero, ponemos un 9 en (1,1)
        tablero[1][1] = 9
        //Creamos una pieza que tiene un hueco (0) justo donde está el 9
        val piezaConHueco = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(1, 1)
        )
        //Colocamos la pieza en (1,0). El 0 de la pieza (índice 0,1) cae sobre el 9 del tablero (1,1)
        colocarPieza(tablero, piezaConHueco, 1, 0)
        //El 9 debe seguir
        assertEquals(9, tablero[1][1], "El 0 de la pieza no debe sobrescribir el tablero")
        //Verificamos que el resto de la pieza sí se pintó
        assertEquals(1, tablero[1][0])
    }

    @Test
    fun ignoraPartesFueraDelTablero() {
        val tablero = tableroVacio() // 5x5
        //Pieza 2x2
        val pieza = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(1, 1)
        )
        //Caso 1: Salirse por la izquierda (col -1). Solo debería pintarse la columna derecha de la pieza en la col 0 del tablero
        colocarPieza(tablero, pieza, 0, -1)
        assertEquals(1, tablero[0][0]) //Se pintó lo que entraba
        //No hay assert de fallo porque si fallara, el test se pondría rojo automáticamente

        //Caso 2: Salirse por abajo (fila 4). La pieza ocupa fila 4 y 5. La 5 no existe.
        colocarPieza(tablero, pieza, 4, 3)
        assertEquals(1, tablero[4][3]) //La parte de arriba de la pieza entró y la parte de abajo se ignoró sin dar error
    }
}