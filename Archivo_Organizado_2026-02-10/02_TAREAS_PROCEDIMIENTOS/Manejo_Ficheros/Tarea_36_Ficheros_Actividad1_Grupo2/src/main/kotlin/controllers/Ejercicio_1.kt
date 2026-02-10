package controllers

import java.io.File
import java.util.Scanner

/**
 *
 * se encarga de solicitar frases al usuario por consola y guardarlas en un fichero
 * hasta que se introduce una línea vacía.
 *
 */
fun main() {
    val fichero = File("textos.txt")
    val scan = Scanner(System.`in`)
    var continuar = true

    println("Frases para guardar (Ejercicio 1):")

    while (continuar) {
        val entrada = scan.nextLine()

        // La función decide si continuamos o paramos
        continuar = procesarEntradaBasica(entrada, fichero)
    }
}

/**
 * procesa la entrada del usuario para determinar si se debe guardar el texto o terminar la ejecución.
 * @param entrada el texto introducido por el usuario.
 * @param fichero el archivo donde se guardará el texto si es válido.
 * @return true si se debe continuar pidiendo frases false si la entrada estaba vacía y se debe detener.
 *
 */
fun procesarEntradaBasica(entrada: String, fichero: File): Boolean {
    if (entrada.isEmpty()) {
        return false
    } else {
        guardarFrase(fichero, entrada)
        return true
    }
}

/**
 * añade una frase al final del fichero especificado.
 * @param fichero el archivo en el que se escribirá el texto.
 * @param texto el contenido a añadir al archivo.
 *
 */
fun guardarFrase(fichero: File, texto: String) {
    fichero.appendText(texto + "\n")
}