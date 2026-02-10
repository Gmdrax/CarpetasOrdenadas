package utilities

import java.util.Scanner

//TODO: Implement methods
fun readSomething(){
    TODO()
}


fun mostrarResultat(resultat: Int) {
    //Mostrar resultat
    println("El resultat és: $resultat")
}

fun calcularQuadrat(num: Int): Int {
    var resultat: Int

    resultat = num * num

    return resultat
}

fun abrirScanner(): Scanner {
    var scan: Scanner = Scanner(System.`in`)
    return scan
}

fun cerrarScanner(scan: Scanner) {
    scan.close()
}