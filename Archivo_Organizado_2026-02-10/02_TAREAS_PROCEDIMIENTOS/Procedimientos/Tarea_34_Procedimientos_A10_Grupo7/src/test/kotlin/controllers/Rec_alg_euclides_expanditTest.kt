package controllers

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class Rec_alg_euclides_expanditTest {
    //El MCD de 4 i 2 hauria de ser 2.
    @Test
    fun Test1() {
        var expected: Int = 2
        assertEquals(expected, rec_alg_euclides_expandit(4,2), "El MCD de 4 i 2 hauria de ser 2.")
    }
    //El MCD de 500 i 500 hauria de ser 500.
    @Test
    fun Test2() {
        var expected: Int = 500
        assertEquals(expected, rec_alg_euclides_expandit(500,500), "El MCD de 500 i 500 hauria de ser 500.")
    }
    //El MCD de 17 i 30 hauria de ser 1.
    @Test
    fun Test3() {
        var expected: Int = 1
        assertEquals(expected, rec_alg_euclides_expandit(17,30), "El MCD de 17 i 30 hauria de ser 1.")
    }
    //El MCD de -4 i -2 hauria de ser 2.
    @Test
    fun Test4() {
        var expected: Int = 2
        assertEquals(expected, rec_alg_euclides_expandit(4,2), "El MCD de -4 i -2 hauria de ser 2.")
    }
    //El MCD de -500 i 500 hauria de ser 500.
    @Test
    fun Test5() {
        var expected: Int = 500
        assertEquals(expected, rec_alg_euclides_expandit(500,500), "El MCD de -500 i 500 hauria de ser 500.")
    }
    //El MCD de 17 i 0 hauria de ser 0.
    @Test
    fun Test6() {
        var expected: Int = 1
        assertEquals(expected, rec_alg_euclides_expandit(17,30), "El MCD de 17 i 0 hauria de ser 0.")
    }
}