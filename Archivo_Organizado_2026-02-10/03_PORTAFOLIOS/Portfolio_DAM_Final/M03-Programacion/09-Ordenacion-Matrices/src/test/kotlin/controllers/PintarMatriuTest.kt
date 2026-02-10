package controllers

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
 class PintarMatriuTest {
  @Test
  fun unaCasella() {
   val matriu = arrayOf(
    charArrayOf('B', 'N'),
    charArrayOf('N', 'N')
   )

   pintarMatriu(matriu, Coordenades(0, 0), 'V')

   assertEquals('V', matriu[0][0])
   assertEquals('N', matriu[0][1])
  }

  @Test
  fun pintaTotaLaZonaConnectada() {
   val matriu = arrayOf(
    charArrayOf('B', 'B', 'N'),
    charArrayOf('B', 'N', 'N'),
    charArrayOf('B', 'B', 'N')
   )

   pintarMatriu(matriu, Coordenades(0, 0), 'G')

   assertEquals('G', matriu[0][0])
   assertEquals('G', matriu[0][1])
   assertEquals('G', matriu[1][0])
   assertEquals('G', matriu[2][0])
   assertEquals('G', matriu[2][1])

   assertEquals('N', matriu[0][2])
  }

  @Test
  fun colorCorrecte() {
   val matriu = arrayOf(
    charArrayOf('B', 'B'),
    charArrayOf('N', 'B')
   )

   pintarMatriu(matriu, Coordenades(0, 0), 'V')

   assertEquals('V', matriu[0][0])
   assertEquals('V', matriu[0][1])
   assertEquals('N', matriu[1][0])
   assertEquals('V', matriu[1][1])
  }
}