import java.util.Scanner
import java.util.Locale

// ==========================================
// 1. FUNCIONES DE LECTURA (Para empezar rápido)
// ==========================================

/**
 * [NUEVA] Crea el Scanner configurado correctamente para leer puntos decimales.
 * Úsalo al principio del main: val scan = crearScanner()
 */
fun crearScanner(): Scanner {
    return Scanner(System.`in`).useLocale(Locale.US)
}

/**
 * Lee N números enteros del teclado y devuelve un array lleno.
 * Úsalo para no escribir el bucle de lectura cada vez.
 */
fun leerArrayInt(scan: Scanner, cantidad: Int): Array<Int> {
    val array = Array<Int>(cantidad) { 0 }
    for (i in 0 until cantidad) {
        array[i] = scan.nextInt()
    }
    return array
}

/**
 * Lee N números decimales (Double).
 * RECUERDA: Usar scan.useLocale(Locale.US) en el main para evitar errores con puntos.
 */
fun leerArrayDouble(scan: Scanner, cantidad: Int): Array<Double> {
    val array = Array<Double>(cantidad) { 0.0 }
    for (i in 0 until cantidad) {
        array[i] = scan.nextDouble()
    }
    return array
}

/**
 * Lee N frases o palabras.
 * IMPORTANTE: Si antes leíste un número, pon un scan.nextLine() suelto antes de llamar a esto.
 */
fun leerArrayString(scan: Scanner, cantidad: Int): Array<String> {
    val array = Array<String>(cantidad) { "" }
    for (i in 0 until cantidad) {
        array[i] = scan.nextLine()
    }
    return array
}

// ==========================================
// 2. FUNCIONES DE BÚSQUEDA Y LÓGICA
// ==========================================

/**
 * Busca la PRIMERA posición (índice 0, 1, 2...) donde aparece un número.
 * Devuelve -1 si el número no está en el array.
 * NOTA: Es lo mismo que usar 'numeros.indexOf(buscar)', pero hecho a mano.
 */
fun buscarPosicionManual(numeros: Array<Int>, buscar: Int): Int {
    for (i in numeros.indices) {
        if (numeros[i] == buscar) {
            return i // Encontrado: devolvemos la posición inmediatamente
        }
    }
    return -1 // Si termina el bucle sin encontrarlo, devolvemos -1
}

/**
 * [NUEVA] Busca si una palabra existe en un array de texto.
 * Versión para Strings de la búsqueda básica.
 */
fun buscarPalabra(palabras: Array<String>, buscar: String): Boolean {
    for (palabra in palabras) {
        if (palabra == buscar) return true
    }
    return false
}

/**
 * [NUEVA] Comprueba si la ÚLTIMA palabra del array aparece repetida antes.
 * Útil para: Ejercicios donde el último elemento es la "clave" a buscar.
 * Recorre todo el array EXCEPTO el último para compararlo.
 */
fun seRepiteElUltimo(palabras: Array<String>): Boolean {
    if (palabras.isEmpty()) return false

    val referencia = palabras[palabras.size - 1] // El último

    // Recorremos hasta el PENÚLTIMO (size - 1) para no compararlo consigo mismo
    for (i in 0 until palabras.size - 1) {
        if (palabras[i] == referencia) {
            return true
        }
    }
    return false
}

/**
 * Comprueba si hay dos números IGUALES seguidos (ej: 5, 5).
 * Útil para: Detectar parejas, picos o mesetas en los datos.
 */
fun tieneRepetidosConsecutivos(numeros: Array<Int>): Boolean {
    // Si hay menos de 2 números, es imposible que haya repetidos seguidos
    if (numeros.size < 2) return false

    // Recorremos hasta el PENÚLTIMO (size - 1) para poder mirar el siguiente
    for (i in 0 until numeros.size - 1) {
        if (numeros[i] == numeros[i + 1]) {
            return true // Encontramos una pareja, salimos ya.
        }
    }
    return false
}

/**
 * Comprueba si el array está ordenado de menor a mayor.
 * Útil para: Saber si los datos tienen sentido o si necesitas ordenarlos.
 * Lógica: Si encuentro un número MAYOR que el siguiente, está desordenado.
 */
fun estaOrdenadoAscendente(numeros: Array<Int>): Boolean {
    if (numeros.size < 2) return true

    for (i in 0 until numeros.size - 1) {
        if (numeros[i] > numeros[i+1]) {
            return false // Encontramos uno desordenado
        }
    }
    return true
}

/**
 * Busca si existe un número igual, o sus vecinos inmediatos (+1 o -1).
 * Devuelve true en cuanto lo encuentra.
 */
fun existeCercano(numeros: Array<Int>, referencia: Int): Boolean {
    for (numero in numeros) {
        if (numero == referencia ||
            numero == referencia + 1 ||
            numero == referencia - 1) {
            return true
        }
    }
    return false
}

/**
 * Devuelve el valor en una posición de forma segura.
 * Si la posición no existe, devuelve -1 (evita que el programa explote).
 */
fun obtenerValorSeguro(numeros: Array<Int>, posicion: Int): Int {
    if (posicion >= 0 && posicion < numeros.size) {
        return numeros[posicion]
    } else {
        return -1
    }
}

/**
 * Imprime SI o NO según un booleano. Ahorra escribir el if/else.
 */
fun imprimirSiNo(condicion: Boolean) {
    if (condicion) println("SI") else println("NO")
}

// ==========================================
// 3. FUNCIONES DE MODIFICACIÓN (Cambian el array)
// ==========================================

/**
 * Busca todas las apariciones de un número y las cambia por otro.
 */
fun reemplazarEnArray(numeros: Array<Int>, buscar: Int, reemplazo: Int) {
    for (i in numeros.indices) {
        if (numeros[i] == buscar) {
            numeros[i] = reemplazo
        }
    }
}

/**
 * Suma una cantidad a TODOS los elementos del array.
 */
fun sumarValorAArray(numeros: Array<Int>, cantidadASumar: Int) {
    for (i in numeros.indices) {
        numeros[i] += cantidadASumar
    }
}

/**
 * Multiplica TODOS los elementos del array por un valor.
 * Modifica el array original directamente.
 */
fun multiplicarArrayPorValor(numeros: Array<Int>, multiplicador: Int) {
    for (i in numeros.indices) {
        numeros[i] *= multiplicador
    }
}

// ==========================================
// 4. FUNCIONES DE ESTADÍSTICA (Mayores/Menores/Conteos)
// ==========================================

/**
 * Cuenta cuántas veces aparece un número específico en el array.
 */
fun contarApariciones(numeros: Array<Int>, buscar: Int): Int {
    var contador = 0
    for (numero in numeros) {
        if (numero == buscar) {
            contador++
        }
    }
    return contador
}

/**
 * Cuenta cuántas parejas de números iguales seguidos hay.
 * Ejemplo: 1, 2, 2, 3, 4, 4, 4 -> Hay 3 parejas (2-2, 4-4 y 4-4)
 */
fun contarParejasConsecutivas(numeros: Array<Int>): Int {
    var contador = 0
    if (numeros.size < 2) return 0

    for (i in 0 until numeros.size - 1) {
        if (numeros[i] == numeros[i + 1]) {
            contador++
        }
    }
    return contador
}

/**
 * Calcula la diferencia entre el valor más grande y el más pequeño.
 * (También llamado "Rango").
 * Optimizado: Lo hace en una sola pasada (un solo bucle).
 */
fun calcularDiferenciaMaxMin(numeros: Array<Int>): Int {
    if (numeros.isEmpty()) return 0

    var maximo = numeros[0]
    var minimo = numeros[0]

    // Buscamos ambos a la vez para ahorrar tiempo
    for (num in numeros) {
        if (num > maximo) maximo = num
        if (num < minimo) minimo = num
    }

    return maximo - minimo
}

/**
 * Devuelve la POSICIÓN (empezando en 1) del número más alto.
 * Si hay empate, se queda con el primero que encontró.
 */
fun obtenerPosicionDelMayor(numeros: Array<Int>): Int {
    if (numeros.isEmpty()) return 0

    var maximo = numeros[0]
    var posicionMaximo = 0

    for (i in numeros.indices) {
        if (numeros[i] > maximo) {
            maximo = numeros[i]
            posicionMaximo = i
        }
    }
    return posicionMaximo + 1
}

/**
 * Devuelve el VALOR más alto del array.
 */
fun obtenerValorMayor(numeros: Array<Int>): Int {
    if (numeros.isEmpty()) return 0
    var maximo = numeros[0]
    for (num in numeros) {
        if (num > maximo) maximo = num
    }
    return maximo
}

/**
 * Devuelve el VALOR más bajo del array.
 */
fun obtenerValorMenor(numeros: Array<Int>): Int {
    if (numeros.isEmpty()) return 0
    var minimo = numeros[0]
    for (num in numeros) {
        if (num < minimo) minimo = num
    }
    return minimo
}

// ==========================================
// 5. FUNCIONES DE VISUALIZACIÓN (Formatos bonitos)
// ==========================================

/**
 * Imprime un array de decimales como porcentajes con 2 decimales.
 * Ejemplo: 0.33333 -> 33.33%
 */
fun imprimirPorcentajesBonitos(numeros: Array<Double>) {
    for (numero in numeros) {
        System.out.printf("%.2f%%\n", numero * 100)
    }
}

// ==========================================
// 6. ALGORITMOS AVANZADOS (Técnica "Dos Punteros")
// ==========================================

/**
 * Suma el primero con el último, el segundo con el penúltimo...
 * REQUISITO: Para que funcione como "Suma de Extremos", el array suele ordenarse antes.
 */
fun imprimirSumaExtremos(numeros: Array<Int>) {
    // Si el ejercicio pide sumar extremos (pequeño + grande), descomenta la siguiente línea:
    // numeros.sort()

    var inicio = 0
    var fin = numeros.size - 1

    while (inicio <= fin) {
        if (inicio == fin) {
            // Caso impar: queda un número suelto en medio
            print("${numeros[inicio]} ")
        } else {
            // Sumamos los dos extremos
            val suma = numeros[inicio] + numeros[fin]
            print("$suma ")
        }
        // Movemos los punteros hacia el centro
        inicio++
        fin--
    }
    println()
}

/**
 * Comprueba si un array es PALÍNDROMO (se lee igual al revés).
 * Ejemplo: [1, 2, 3, 2, 1] -> TRUE
 * Usa la misma técnica de dos punteros.
 */
fun esPalindromo(numeros: Array<Int>): Boolean {
    var inicio = 0
    var fin = numeros.size - 1

    while (inicio < fin) {
        if (numeros[inicio] != numeros[fin]) {
            return false // Si los extremos son diferentes, no es palíndromo
        }
        inicio++
        fin--
    }
    return true
}

// ==========================================
// 7. LÓGICA DE JUEGOS Y SIMULACIÓN
// ==========================================

/**
 * Calcula la siguiente posición en un tablero con "REBOTE".
 * Regla: Si te pasas de la meta, retrocedes el exceso.
 * Ejemplo: Estás en 6, meta es 8, sacas un 5.
 * Llegas a 11 (te pasas por 3). Posición final = 8 - 3 = 5.
 */
fun moverConRebote(posicionActual: Int, tirada: Int, meta: Int): Int {
    val destinoTeorico = posicionActual + tirada

    if (destinoTeorico == meta) {
        return meta // Llegas exacto
    } else if (destinoTeorico > meta) {
        val exceso = destinoTeorico - meta
        return meta - exceso // Rebote
    } else {
        return destinoTeorico // Movimiento normal
    }
}

// ==========================================
// 8. ZONA DE PRUEBAS (MAIN)
// ==========================================
/*
fun main() {
    // --- Ejemplo de uso rápido ---
    val scan = crearScanner()

    // 1. Probar lectura
    println("Introduce 3 números:")
    val numeros = leerArrayInt(scan, 3)

    // 2. Probar estadística
    println("El mayor es: ${obtenerValorMayor(numeros)}")

    // 3. Probar lógica avanzada (palíndromo)
    if (esPalindromo(numeros)) {
        println("Es palíndromo")
    } else {
        println("No es palíndromo")
    }

    // 4. Probar juego (Rebote)
    // Estás en casilla 6, quieres llegar a 8, sacas un 5
    val posFinal = moverConRebote(6, 5, 8)
    println("Si estoy en 6 y saco 5 (meta 8), acabo en: $posFinal") // Debería dar 5
}
*/