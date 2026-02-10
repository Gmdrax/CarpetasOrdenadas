package controllers

import utilities.obrirScanner
import utilities.tancarScanner
import utilities.validarSuperusuari
import java.util.Scanner

const val PASSWORD_CORRECTE = "Estrellita444"


fun main() {
    //Obrim l'escàner
    val sc : Scanner = obrirScanner()
    //Funció per comprovar fins a 3 cops si hem entrat la contrasenya correcta
    val contrasenya = validarSuperusuari(sc)
    //Tanquem l'escàner
    tancarScanner(sc)
}