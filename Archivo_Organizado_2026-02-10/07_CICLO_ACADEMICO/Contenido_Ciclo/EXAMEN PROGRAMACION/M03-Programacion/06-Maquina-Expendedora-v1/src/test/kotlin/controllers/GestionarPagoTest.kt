package org.example.controllers

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.util.Scanner
import java.util.Locale

class GestionarPagoTest {

    /**
     * Verifica que si paguem l'import exacte, no surt missatge de canvi.
     */
    @Test
    fun pagamentExacteSenseCanvi() {
        val originalOut = System.out
        val outContent = ByteArrayOutputStream()
        System.setOut(PrintStream(outContent))

        //Simulem escriure "2.0"
        val input = "2.0\n"
        val scan = Scanner(ByteArrayInputStream(input.toByteArray())).useLocale(Locale.US)

        gestionarEntradaDiners(scan, 2.0)

        System.setOut(originalOut)
        val sortida = outContent.toString()

        assertTrue(sortida.contains("Reculli el seu bitllet"), "Ha d'indicar recollir bitllet")
        assertTrue(!sortida.contains("canvi:"), "No ha d'oferir canvi si l'import és exacte")
    }

    /**
     * Verifica que si paguem de més, calcula i mostra el canvi.
     */
    @Test
    fun pagamentExcesiuAmbCanvi() {
        val originalOut = System.out
        val outContent = ByteArrayOutputStream()
        System.setOut(PrintStream(outContent))

        //Simulem escriure "50.0" per pagar un compte de 0.50
        val input = "50.0\n"
        val scan = Scanner(ByteArrayInputStream(input.toByteArray())).useLocale(Locale.US)

        gestionarEntradaDiners(scan, 0.50)

        System.setOut(originalOut)
        val sortida = outContent.toString()

        //Busquem el text "49.50" (el canvi)
        assertTrue(sortida.contains("49.50") || sortida.contains("49,50"), "Ha de tornar 49.50 de canvi")
    }
}