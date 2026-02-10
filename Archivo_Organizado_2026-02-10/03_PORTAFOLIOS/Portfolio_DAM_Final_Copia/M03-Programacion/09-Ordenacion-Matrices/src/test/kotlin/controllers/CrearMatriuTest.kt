package controllers

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
 class CrearMatriuTest {
  @Test
  fun dimensionsCorrectes() {
   val matriu = crearMatriu(5, 7)

   assertEquals(5, matriu.size)
   assertEquals(7, matriu[0].size)
  }

  @Test
  fun valorsBoN() {
   val matriu = crearMatriu(10, 10)

   for (row in matriu) {
    for (cell in row) {
     assertTrue(cell == 'B' || cell == 'N')
    }
   }
  }

  @Test
  fun noEsBuida() {
   val matriu = crearMatriu(3, 3)

   assertTrue(matriu.isNotEmpty())
   assertTrue(matriu[0].isNotEmpty())
  }
}