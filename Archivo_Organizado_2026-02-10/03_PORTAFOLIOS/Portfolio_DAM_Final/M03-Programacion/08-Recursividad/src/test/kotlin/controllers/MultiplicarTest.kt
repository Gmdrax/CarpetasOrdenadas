package controllers

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
 class MultiplicarTest {

@Test
 fun valorsPositius() {
  val expected=45
 assertEquals(expected,multiplicar(3,15))
 }

  @Test
  fun valorsNegatius() {
   val expected=45
   assertEquals(expected,multiplicar(-3,-15))
  }

  @Test
  //
  fun multiplicarPerZero() {
   val expected=0
   assertEquals(expected,multiplicar(15,0))
  }
}