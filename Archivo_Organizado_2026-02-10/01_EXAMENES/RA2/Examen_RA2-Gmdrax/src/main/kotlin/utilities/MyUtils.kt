package utilities

import java.util.Scanner


/**
 * lee un entero del teclado comprobamndo errores varios
 * @param scanner datos del usario.
 * @return El número entero válido.
 */
fun leerEntero(scanner: Scanner,): Int {
    var numero = 0
    var esValido = false

    while (esValido == false) {

        if (scanner.hasNextInt()) {
            numero = scanner.nextInt()
            esValido = true
        } else {
            println("Error: Tienes que poner un número.")
            scanner.next()
        }
    }
    return numero
}

/**
 * lee un entero del teclado comprobamndo errores varios
 * @param scanner datos del usario.
 * @param mensaje pregunta al usario.
 * @return El número entero válido.
 */
fun leerEnteroConMensaje(scanner: Scanner,msg: String): Int {
    var numero = 0
    var esValido = false

    while (esValido == false) {
        println(msg)
        if (scanner.hasNextInt()) {
            numero = scanner.nextInt()
            esValido = true
        } else {
            println("Error: Tienes que poner un número.")
            scanner.next()
        }
    }
    return numero
}

