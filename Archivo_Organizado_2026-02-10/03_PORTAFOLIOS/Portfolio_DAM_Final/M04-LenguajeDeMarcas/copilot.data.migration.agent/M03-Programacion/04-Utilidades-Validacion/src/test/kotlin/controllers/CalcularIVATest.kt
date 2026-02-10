import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.example.controllers.calcularIVA

class CalculoIvaTest {

    /**
     * Test 1: Comprova l'IVA General actual (p.ex. 2023).
     * Segons la taula, a partir del 15-07-2012 l'IVA General és del 21%.
     * 100 + 21% = 121.
     */
    @Test
    fun testCalcularIVAGeneralActual() {
        val preu = 100.0f
        val tipus = "General"
        val data = "01-01-2023"

        val resultatEsperat = 121.0f
        val resultatObtingut = calcularIVA(preu, tipus, data)

        assertEquals(resultatEsperat, resultatObtingut, 0.01f)
    }

    /**
     * Test 2: Comprova un IVA històric (p.ex. any 2000).
     * Segons la taula, el 2000 (tram 1995) l'IVA General era del 16%.
     * 100 + 16% = 116.
     */
    @Test
    fun testCalcularIVAGeneralAntic() {
        val preu = 100.0f
        val tipus = "General"
        val data = "01-01-2000"

        val resultatEsperat = 116.0f
        val resultatObtingut = calcularIVA(preu, tipus, data)

        assertEquals(resultatEsperat, resultatObtingut, 0.01f)
    }

    /**
     * Test 3: Comprova l'IVA Exempt (0%).
     * Independentment de la data, l'exempt és 0.
     * 100 + 0% = 100.
     */
    @Test
    fun testCalcularIVAExempt() {
        val preu = 50.0f
        val tipus = "Exempt"
        val data = "10-10-2023"

        val resultatEsperat = 50.0f
        val resultatObtingut = calcularIVA(preu, tipus, data)

        assertEquals(resultatEsperat, resultatObtingut, 0.01f)
    }
}