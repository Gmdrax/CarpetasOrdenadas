package controllers
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows

class ReservarButacaTest {
    @Test
    fun reserva_1(){
        val sala = Array(20){ Array(15){"_"} }
        val fila = -1
        val columna = 10

        assertThrows<ArrayIndexOutOfBoundsException> {
            reservarButaca(sala, fila, columna)
        }
    }
    @Test
    fun reserva_2(){
        val sala = Array(20){ Array(15){"_"} }
        val fila = 2
        val columna = 10
        val espect = Array(20){ Array(15){"_"} }
        espect[fila][columna]= "X"
        reservarButaca(sala, fila, columna)
        assertEquals("X", sala[fila][columna])

    }
    @Test
    fun reserva_3(){
        val sala = Array(20){ Array(15){"_"} }
        val fila = 18
        val columna = 10
        val espect = Array(20){ Array(15){"_"} }
        espect[fila][columna]= "X"
        reservarButaca(sala, fila, columna)
        assertEquals("X", sala[fila][columna])

    }
}