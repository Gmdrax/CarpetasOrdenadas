package controllers

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class PotFormaTriangleTest{

    //probamos con un triángulo rectángulo(3, 4, 5) que sí debería formarse.
    @Test
    fun testPotFormaTriangleCasoValido() {
        val resultado = potFormaTriangle(3, 4, 5)
        assertTrue(resultado, "3, 4 y 5 deberían poder formar un triángulo")
    }


    //probamos con lados que no pueden cerrarse (1, 10, 2).
    @Test
    fun testPotFormaTriangleCasoInvalido() {
        val resultado = potFormaTriangle(1, 10, 2)
        assertFalse(resultado, "1, 10 y 2 NO deberían formar un triángulo")
    }


    //si la suma de dos lados es igual al tercero (1 + 2 = 3) nos salda una linea recta en teoria
    @Test
    fun testPotFormaTriangleCasoLimite() {
        val resultado = potFormaTriangle(1, 2, 3)
        assertFalse(resultado, "Si la suma de dos lados iguala al tercero, no es un triángulo")
    }
}