package controllers
import utilities.mostrarResultatString
import utilities.obrirScanner
import utilities.roman
import utilities.tancarScanner
import java.util.Scanner

fun main() {
    //Obrim l'escàner
    val sc : Scanner = obrirScanner()
    //Funció per convertir un nombre a números romans
    val numeroRoman = roman("Introdueix el nombre que vulguis convertir a números romans: ")
    val mostrarNumeroRoman = mostrarResultatString(numeroRoman)
    //Tanquem l'escàner
    tancarScanner(sc)
}