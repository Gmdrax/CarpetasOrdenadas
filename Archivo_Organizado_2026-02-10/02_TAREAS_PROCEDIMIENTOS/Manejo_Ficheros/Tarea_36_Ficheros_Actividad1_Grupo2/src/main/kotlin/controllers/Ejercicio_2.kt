package controllers
import java.io.File
import java.util.Scanner

/**
 *
 * inicializa el fichero y procesa las entradas del usuario permitiendo guardar texto
 * o borrar el contenido si se introduce el comando @ESBORRA.
 *
 */
fun main() {
    val fichero = File("textos.txt")
    val scan = Scanner(System.`in`)
    var continuar = true

    inicializarFichero(fichero)

    println("Frases para guardar (Ejercicio 2 - incluye @ESBORRA):")

    while (continuar) {
        val entrada = scan.nextLine()
        continuar = procesarEntradaConBorrado(entrada, fichero)
    }
}

/**
 * verifica si el fichero existe y de lo contrario lo crea.
 * @param fichero el objeto File que representa el archivo a comprobar o crear.
 *
 */
fun inicializarFichero(fichero: File) {
    if (fichero.exists()) {
        println("El fichero existe")
    } else {
        fichero.createNewFile()
        println("Creando fichero...")
    }
}

/**
 * procesa la entrada del usuario gestionando la escritura o el borrado del fichero.
 * si la entrada es "@ESBORRA", se vacía el archivo y se detiene el bucle.
 * si la entrada está vacía, se detiene el bucle.
 * en caso contrario, se añade el texto al archivo.
 * @param entrada texto introducido por el usuario.
 * @param fichero archivo sobre el que se opera.
 * @return true para continuar la ejecución false para detenerla.
 *
 */
fun procesarEntradaConBorrado(entrada: String, fichero: File): Boolean {
    // Si está vacío o es el comando de borrar, paramos (según lógica original)
    if (entrada.isEmpty()) return false

    if (entrada == "@ESBORRA") {
        esborrarFichero(fichero)
        return false // Paramos tras borrar
    } else {
        // Reutilizamos la lógica de guardar frase del Ejercicio 1
        fichero.appendText(entrada + "\n")
        return true
    }
}

/**
 * borra todo el contenido del fichero especificado sobrescribiéndolo con una cadena vacía.
 * @param fichero el archivo cuyo contenido será eliminado.
 *
 */
fun esborrarFichero(fichero: File) {
    fichero.writeText("")
    println("Contenido borrado.")
}