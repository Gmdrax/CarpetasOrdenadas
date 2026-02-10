import java.util.Scanner

/**
 * Función 1: REEMPLAZAR VALORES
 * Útil para: No tener que escribir el bucle if/else cada vez.
 * Modifica el array original directamente.
 */
fun reemplazarEnArray(numeros: Array<Int>, buscar: Int, reemplazo: Int) {
    for (i in numeros.indices) {
        if (numeros[i] == buscar) {
            numeros[i] = reemplazo
        }
    }
}

/**
 * Función 2: LECTURA RÁPIDA DE ARRAY
 * Útil para: Ahorrar líneas de código al principio de los ejercicios.
 * Lee N enteros del Scanner y te devuelve el array listo.
 */
fun leerArrayInt(scan: Scanner, cantidad: Int): Array<Int> {
    val array = Array<Int>(cantidad) { 0 }
    for (i in 0 until cantidad) {
        array[i] = scan.nextInt()
    }
    return array
}

/**
 * Función: LEER ARRAY DE FRASES
 * Útil para: Crear y rellenar arrays de texto sin líos de sintaxis.
 *
 * PRECAUCIÓN: Si antes de usar esta función has leído un número (nextInt),
 * recuerda poner un scan.nextLine() suelto en tu main para limpiar el buffer
 * antes de llamar a esta función.
 */
fun leerArrayString(scan: Scanner, cantidad: Int): Array<String> {
    // Inicialización correcta de Array de Strings (que suele olvidarse)
    val array = Array<String>(cantidad) { "" }

    for (i in 0 until cantidad) {
        array[i] = scan.nextLine()
    }

    return array
}

/**
 * Función: SUMAR VALOR A TODOS (Modifica el array)
 * Útil para: Cuando el ejercicio pide modificar los datos, no solo mostrarlos.
 * Modifica el array original directamente.
 */
fun sumarValorAArray(numeros: Array<Int>, cantidadASumar: Int) {
    for (i in numeros.indices) {
        numeros[i] = numeros[i] + cantidadASumar // O numeros[i] += cantidadASumar
    }
}

/**
 * Función: EXISTE CERCANO O IGUAL
 * Comprueba si en el array existe el número de referencia,
 * o el número +1, o el número -1.
 *
 * Ventaja: Usa 'return true' para salir del bucle en cuanto lo encuentra
 * (más rápido que recorrer todo el array).
 */
fun existeCercano(numeros: Array<Int>, referencia: Int): Boolean {
    for (numero in numeros) {
        // Chequeamos las 3 condiciones: igual, uno más o uno menos
        if (numero == referencia ||
            numero == referencia + 1 ||
            numero == referencia - 1) {
            return true // ¡Lo encontramos! Salimos inmediatamente.
        }
    }
    return false // Si termina el bucle y no salió antes, es que no hay ninguno.
}

/**
 * Función extra: IMPRIMIR SI/NO
 * Útil para: Ahorrarte escribir el if/else típico de los exámenes.
 */
fun imprimirSiNo(condicion: Boolean) {
    if (condicion) {
        println("SI")
    } else {
        println("NO")
    }
}

/**
 * Función: LEER ARRAY DE DOUBLES
 * Útil para: Leer notas, precios, temperaturas, etc.
 * IMPORTANTE: El Scanner debe tener .useLocale(Locale.US) si los datos vienen con puntos (3.5).
 */
fun leerArrayDouble(scan: Scanner, cantidad: Int): Array<Double> {
    val array = Array<Double>(cantidad) { 0.0 }
    for (i in 0 until cantidad) {
        array[i] = scan.nextDouble()
    }
    return array
}

/**
 * Función: POSICIÓN DEL MAYOR (1-based)
 * Devuelve la posición (empezando por 1) del número más alto.
 * * NOTA IMPORTANTE PARA EL EXAMEN:
 * - Si usas (numeros[i] > maximo), se queda con el PRIMERO que encuentra en caso de empate.
 * - Si usas (numeros[i] >= maximo), se queda con el ÚLTIMO que encuentra en caso de empate.
 */
fun obtenerPosicionDelMayor(numeros: Array<Int>): Int {
    if (numeros.isEmpty()) return 0 // Protección por si el array está vacío

    var maximo = numeros[0]
    var posicionMaximo = 0 // Guardamos el índice real (0, 1, 2...)

    // Recorremos usando indices directamente
    for (i in numeros.indices) {
        if (numeros[i] > maximo) {
            maximo = numeros[i]
            posicionMaximo = i
        }
    }

    // Devolvemos +1 porque el ejercicio pedía posición humana (1, 2, 3...), no de array
    return posicionMaximo + 1
}

/**
 * Función: OBTENER EL VALOR MÁXIMO
 * Útil si solo te piden "La nota más alta" y no "Quién la sacó".
 */
fun obtenerValorMayor(numeros: Array<Int>): Int {
    if (numeros.isEmpty()) return 0

    var maximo = numeros[0]
    for (num in numeros) {
        if (num > maximo) {
            maximo = num
        }
    }
    return maximo
}

/**
 * Función: OBTENER EL MÍNIMO
 * Lo mismo pero para buscar el menor.
 */
fun obtenerValorMenor(numeros: Array<Int>): Int {
    if (numeros.isEmpty()) return 0

    var minimo = numeros[0]
    for (num in numeros) {
        if (num < minimo) {
            minimo = num
        }
    }
    return minimo
}






































// EJEMPLO DE USO EN TU MAIN:
/*
fun main() {
    val scan = Scanner(System.`in`)
    val Nveces = scan.nextInt()

    repeat(Nveces) {
        val cantidad = scan.nextInt()

        // 1. Usamos la función de lectura
        val numeros = leerArrayInt(scan, cantidad)

        val valorBusqueda = scan.nextInt() // Antes lo llamabas 'posicion'
        val nuevoValor = scan.nextInt()

        // 2. Usamos la función de reemplazo
        reemplazarEnArray(numeros, valorBusqueda, nuevoValor)

        // Imprimir rápido
        println(numeros.joinToString(" "))
    }
}
*/