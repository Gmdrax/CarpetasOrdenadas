package controllers
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class BuidarSalaTest {
    @Test
    fun buidar_1 (){
        val input = Array<Array<String>>(20){ Array(15){"X"} }
        val esperado = Array<Array<String>>(20){ Array(15){"_"} }
        buidarSala(input)
        assertArrayEquals(esperado, input)
    }
    @Test
    fun buidar_2 (){
        val input = Array<Array<String>>(20){ Array(15){"a"} }
        val esperado = Array<Array<String>>(20){ Array(15){"_"} }
        buidarSala(input)
        assertArrayEquals(esperado, input)
    }
    @Test
    fun buidar_3 (){
        val input = Array<Array<String>>(15){ Array(10){"X"} }
        val esperado = Array<Array<String>>(15){ Array(10){"_"} }
        buidarSala(input)
        assertArrayEquals(esperado, input)
    }

}