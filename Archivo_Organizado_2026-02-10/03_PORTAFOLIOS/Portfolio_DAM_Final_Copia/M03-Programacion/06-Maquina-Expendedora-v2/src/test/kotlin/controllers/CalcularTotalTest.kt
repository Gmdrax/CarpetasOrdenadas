package org.example.controllers

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CalcularTotalTest {

    //Funció auxiliar per crear bitllets ràpidament per als tests
    private fun bitlletStub(preu: Double): DadesBitllet {
        return DadesBitllet("Test", 1, preu)
    }

    /**
     * Verifica que la funció suma correctament un array amb diversos bitllets.
     */
    @Test
    fun sumaCorrectaDeVariosBilletes() {
        //Creem un array de mida 3 (el màxim permès al programa)
        val cistella: Array<DadesBitllet?> = arrayOfNulls(3)

        //Omplim l'array manualment
        cistella[0] = bitlletStub(10.50)
        cistella[1] = bitlletStub(2.25)
        cistella[2] = bitlletStub(5.00)

        //Indiquem que hem omplert 3 posicions
        val total = sumarPreusCistella(cistella, 3)

        //Validem el resultat
        assertEquals(17.75, total, 0.001, "La suma de 10.50 + 2.25 + 5.00 ha de ser 17.75")
    }

    /**
     * Verifica que si li diem que hi ha 0 bitllets, la suma és 0, encara que l'array sigui null.
     */
    @Test
    fun cistellaBuidaRetornaZero() {
        val cistella: Array<DadesBitllet?> = arrayOfNulls(3)

        //Passem 0 com a quantitat d'elements vàlids
        val total = sumarPreusCistella(cistella, 0)

        assertEquals(0.0, total, 0.001, "Una cistella sense elements ha de sumar 0.0")
    }

    /**
     * Verifica que si l'array té elements però li diem que només en sumi 1, només suma el primer.
     */
    @Test
    fun sumaParcialCorrecta() {
        val cistella: Array<DadesBitllet?> = arrayOfNulls(3)
        cistella[0] = bitlletStub(10.0)
        cistella[1] = bitlletStub(50.0) //Aquest no s'hauria de sumar si passem count = 1

        val total = sumarPreusCistella(cistella, 1)

        assertEquals(10.0, total, 0.001, "Si indiquem que hi ha 1 bitllet, només ha de sumar el primer")
    }
}