package utilities

import java.io.File
import java.util.Scanner


/**
 * borra el contenido del archivo especificado.
 * sobrescribe el archivo con una cadena vacía.
 * @param fichero archivo a limpiar.
 *
 */
fun esborrarFichero(fichero: File) {
    fichero.writeText("")
}

/**
 * comprueba si el archivo existe, informando al usuario. Si no existe, lo crea.
 * @param fichero archivo a inicializar.
 *
 */
fun inicializarFichero(fichero: File) {
    if (fichero.exists()) println("El fichero existe")
    else { fichero.createNewFile(); println("Creando fichero...") }
}

/**
 * imprime todas las líneas contenidas en el archivo.
 * @param fichero archivo a leer.
 *
 */
fun mostrarFichero(fichero: File) {
    if (fichero.exists()) {
        fichero.forEachLine { println(it) }
    }
}

/**
 * solicita al usuario un número de línea y muestra el contenido de esa línea específica del archivo.
 * si la línea no existe o el número no es válido, informa al usuario.
 * @param fichero archivo del cual leer la línea.
 * @param scan scanner para leer el número de línea introducido por el usuario.
 *
 */
fun mostrarLineaConcreta(fichero: File, scan: Scanner) {
    println("Quina línia vols?: ")
    if (scan.hasNextInt()) {
        val numeroLinia = scan.nextInt()
        scan.nextLine() // Limpiar buffer

        val resultat = fichero.useLines { lines ->
            lines.drop(numeroLinia - 1).firstOrNull()
        }
        if (resultat != null) println(resultat) else println("No existeix la línia")
    }
}

/**
 * solicita un texto al usuario y lo inserta al principio del archivo conservando el contenido anterior.
 * lee el contenido actual, coloca el nuevo texto al inicio y reescribe todo el archivo.
 * @param fichero archivo a modificar.
 * @param scan scanner para leer el nuevo texto a insertar.
 *
 */
fun agregarLineaAlPrincipio(fichero: File, scan: Scanner) {
    println("Posa el text: ")
    val texNou = scan.nextLine()
    val contenidoActual = if (fichero.exists()) fichero.readText() else ""
    fichero.writeText("$texNou\n$contenidoActual")
}