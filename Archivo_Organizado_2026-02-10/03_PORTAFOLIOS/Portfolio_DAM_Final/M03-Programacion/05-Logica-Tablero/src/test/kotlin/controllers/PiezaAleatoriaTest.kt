import org.example.controllers.cubo
import org.example.controllers.eleHorizontal
import org.example.controllers.eleVertical
import org.example.controllers.palo
import org.example.controllers.piezaAleatoria
import kotlin.test.DefaultAsserter.assertNotNull
import kotlin.test.DefaultAsserter.assertTrue
import kotlin.test.Test

class TetrisTest {

    @Test
    fun piezaAleatoriaRetornarSiempreUnaDeLasPiezasValidas() {
        //Lista de referencias a las piezas esperadas
        val piezasPosibles = listOf(cubo, eleHorizontal, eleVertical, palo)
        //Ejecutamos la prueba varias veces para asegurar estabilidad dado que es aleatorio
        repeat(20) {
            val resultado = piezaAleatoria()
            assertNotNull("La pieza no debe ser nula", resultado)
            /* Verificamos que el resultado sea exactamente una de las piezas definidas.
            Usamos 'any' con === si son objetos únicos, o contentDeepEquals si son arrays nuevos cada vez.*/
            val esPiezaValida = piezasPosibles.any { it === resultado || it.contentDeepEquals(resultado) }
            assertTrue("La función retornó una pieza desconocida", esPiezaValida)
        }
    }

    @Test
    fun piezaAleatoriaDebeGenerarVariedad () {
        val resultadosVistos = mutableSetOf<Any>()
        /* Ejecutamos 100 veces. Estadísticamente es casi imposible que salga siempre la misma. Si el Random funciona bien (probabilidad de 1 en 4^99). */
        repeat(100) {
            resultadosVistos.add(piezaAleatoria())
        }
        assertTrue("Debería haber generado al menos 2 tipos de piezas distintos", resultadosVistos.size > 1)
    }
}