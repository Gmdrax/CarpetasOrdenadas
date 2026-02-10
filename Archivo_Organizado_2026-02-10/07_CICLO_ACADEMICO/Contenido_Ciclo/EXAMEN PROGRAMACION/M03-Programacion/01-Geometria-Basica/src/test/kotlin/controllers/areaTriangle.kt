package utilities

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class AreaTriangleTest {

    @Test
    fun testAreaEstandar() {
        //triángulo 3, 4, 5
        assertEquals(6.0, areaTriangle(3, 4, 5), 0.01)
    }

    @Test
    fun testAreaEquilatero() {
        //todos los lados 3
        assertEquals(3.897, areaTriangle(3, 3, 3), 0.001)
    }

    @Test
    fun testAreaIsosceles() {
        //5, 5, 6
        assertEquals(12.0, areaTriangle(5, 5, 6))
    }
}