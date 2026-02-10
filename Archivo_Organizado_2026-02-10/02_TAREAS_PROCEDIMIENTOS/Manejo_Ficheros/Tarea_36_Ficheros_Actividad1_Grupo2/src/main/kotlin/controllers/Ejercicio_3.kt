package controllers

import utilities.agregarLineaAlPrincipio
import utilities.mostrarFichero
import utilities.mostrarLineaConcreta
import java.io.File
import java.util.Scanner

/**
 *
 * gestiona el menú de comandos y funciones
 * las acciones a funciones de utilidad.
 *
 */
fun main() {
    val fichero = File("textos.txt")
    val scan = Scanner(System.`in`)
    var continuar = true

    inicializarFichero(fichero)

    println("Frases para guardar: ")

    while (continuar) {
        val entrada = scan.nextLine()
        continuar = procesarEntradaCompleta(entrada, fichero, scan)
    }
}

/**
 * procesa la entrada del usuario usa la acción correspondiente según el comando que se le ponga
 * @ESBORRA: borra el contenido del fichero.
 * @MOSTRAR: muestra todo el contenido del fichero.
 * @MOSTRARLINIAS: pide y muestra una línea específica.
 * @NOVALINIA: inserta una línea al principio del archivo.
 *
 * @param entrada el comando o texto introducido por el usuario.
 * @param fichero el archivo sobre el que se realizan las acciones.
 * @param scan el scanner para leer inputs adicionales si el comando lo requiere.
 * @return true si se escribió texto normal y se debe continuar false si se ejecutó un comando especial o la entrada estaba vacía.
 *
 */
fun procesarEntradaCompleta(entrada: String, fichero: File, scan: Scanner): Boolean {
    if (entrada.isEmpty()) return false

    when (entrada) {
        "@ESBORRA" -> {
            esborrarFichero(fichero)
            return false
        }
        "@MOSTRAR" -> {
            mostrarFichero(fichero)
            return false
        }
        "@MOSTRARLINIAS" -> {
            mostrarLineaConcreta(fichero, scan)
            return false
        }
        "@NOVALINIA" -> {
            agregarLineaAlPrincipio(fichero, scan)
            return false
        }
        else -> {
            fichero.appendText(entrada + "\n")
            return true
        }
    }
}