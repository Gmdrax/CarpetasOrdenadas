package controllers

import org.example.controllers.invertirFrase
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class InvertirFraseTest {

    @Test
    fun  frasenormal(){

        val esperat = "aloh"
        val real = invertirFrase("hola")
        assertEquals(real,esperat)
    }

    @Test
    fun frasecorta() {

        val esperat = "a"
        val real = invertirFrase("a")
        assertEquals(real,esperat)
    }

    @Test
    fun fraseConNumero() {

        val esperat = "k2"
        val real = invertirFrase("2k")
        assertEquals(real,esperat)
    }

}