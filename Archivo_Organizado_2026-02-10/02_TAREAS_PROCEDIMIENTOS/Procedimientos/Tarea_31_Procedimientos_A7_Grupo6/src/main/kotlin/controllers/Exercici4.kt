package controllers

import utilities.demanarString
import utilities.obrirScanner
import utilities.tancarScanner
import utilities.titol
import java.util.Scanner

fun main() {
    //Obrim l'escàner
    val sc : Scanner = obrirScanner()
    //Demanem el text que volem convertir l'imprimim centrat
    val titol = titol()
    //Tanquem l'escàner
    tancarScanner(sc)
}