package controllers

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class CalcularmediaTest {

    @Test
    fun  Calcularmedia(){

        val esperat = 4000.00
        //aqui tendra que ir los datos del los videos pero de la manera que he echo el codigo no consigo un menera de implementarlo
        val real = calcularmedia(ArrayList<Video>)
        assertEquals(real,esperat)
    }

    @Test
    fun Calcularmedia0() {

        val esperat = 0
        //aqui tendra que ir los datos del los videos pero de la manera que he echo el codigo no consigo un menera de implementarlo
        val real = calcularmedia(ArrayList<Video>)
        assertEquals(real,esperat)
    }

    @Test
    fun calucularMediaAlta() {

        val esperat = 7356423987
        //aqui tendra que ir los datos del los videos pero de la manera que he echo el codigo no consigo un menera de implementarlo
        val real = calcularmedia(ArrayList<Video>)
        assertEquals(real,esperat)
    }



}