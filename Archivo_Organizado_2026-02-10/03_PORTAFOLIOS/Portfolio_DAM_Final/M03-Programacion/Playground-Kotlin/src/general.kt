import java.util.Scanner
import java.util.Locale
import kotlin.math.sqrt
import kotlin.math.abs

// =================================================================
// NIVEL 1: LECTURA Y UTILIDADES BÁSICAS
// =================================================================

fun crearScanner(): Scanner {
    return Scanner(System.`in`).useLocale(Locale.US)
}

fun leerIntSeguro(scan: Scanner): Int {
    return if (scan.hasNextInt()) {
        scan.nextInt()
    } else {
        scan.next()
        -1
    }
}

fun limpiarBuffer(scan: Scanner) {
    if (scan.hasNextLine()) scan.nextLine()
}

// =================================================================
// NIVEL 2: NÚMEROS Y MATEMÁTICAS (Ampliadas)
// =================================================================

fun esPrimo(numero: Int): Boolean {
    if (numero <= 1) return false
    for (i in 2..sqrt(numero.toDouble()).toInt()) {
        if (numero % i == 0) return false
    }
    return true
}

fun esPar(numero: Int): Boolean {
    return numero % 2 == 0
}

fun obtenerDigitos(numero: Int): List<Int> {
    return numero.toString().map { it.digitToInt() }
}

/**
 * [NUEVA] Calcula el Máximo Común Divisor (MCD) de dos números.
 * Algoritmo de Euclides (Clásico de examen).
 */
fun mcd(a: Int, b: Int): Int {
    var num1 = a
    var num2 = b
    while (num2 != 0) {
        val temp = num2
        num2 = num1 % num2
        num1 = temp
    }
    return num1
}

/**
 * [NUEVA] Calcula el factorial de un número (n!).
 * Ej: 5! = 5 * 4 * 3 * 2 * 1 = 120
 */
fun factorial(n: Int): Long {
    var resultado: Long = 1
    for (i in 1..n) {
        resultado *= i
    }
    return resultado
}

/**
 * [NUEVA] Serie de Fibonacci. Devuelve una lista con los N primeros números.
 * Ej: 5 -> [0, 1, 1, 2, 3]
 */
fun fibonacci(n: Int): List<Int> {
    val lista = mutableListOf(0, 1)
    if (n <= 2) return lista.take(n)

    for (i in 2 until n) {
        lista.add(lista[i-1] + lista[i-2])
    }
    return lista
}

// =================================================================
// NIVEL 3: STRINGS (Manipulación de Texto)
// =================================================================

fun contarVocales(texto: String): Int {
    val vocales = "aeiouAEIOUáéíóúÁÉÍÓÚ"
    var contador = 0
    for (letra in texto) {
        if (letra in vocales) contador++
    }
    return contador
}

fun esPalindromo(texto: String): Boolean {
    val limpio = texto.lowercase().replace(" ", "")
    return limpio == limpio.reversed()
}

fun esAnagrama(texto1: String, texto2: String): Boolean {
    val t1 = texto1.lowercase().toCharArray().sorted()
    val t2 = texto2.lowercase().toCharArray().sorted()
    return t1 == t2
}

fun quitarAcentos(texto: String): String {
    var resultado = texto
    val originales = "áéíóúÁÉÍÓÚ"
    val sinAcento = "aeiouAEIOU"
    for (i in originales.indices) {
        resultado = resultado.replace(originales[i], sinAcento[i])
    }
    return resultado
}

/**
 * [NUEVA] Comprueba si un String es un número válido.
 * Útil para validar entradas de usuario.
 */
fun esNumeroValido(texto: String): Boolean {
    return texto.toIntOrNull() != null
}

/**
 * [NUEVA] Cifrado César básico.
 * Desplaza cada letra N posiciones. (a -> c con shift 2).
 */
fun cifradoCesar(texto: String, shift: Int): String {
    return texto.map { char ->
        if (char.isLetter()) {
            val base = if (char.isUpperCase()) 'A' else 'a'
            // Fórmula mágica del cifrado circular
            val desplazado = (char - base + shift) % 26 + base.code
            desplazado.toChar()
        } else {
            char // Si no es letra, se deja igual
        }
    }.joinToString("")
}

// =================================================================
// NIVEL 4: LISTAS (Arrays y Algoritmos)
// =================================================================

fun eliminarDuplicadosManual(lista: List<Int>): List<Int> {
    val unicos = mutableListOf<Int>()
    for (elemento in lista) {
        if (elemento !in unicos) {
            unicos.add(elemento)
        }
    }
    return unicos
}

fun rotarListaDerecha(lista: MutableList<Int>) {
    if (lista.isEmpty()) return
    val ultimo = lista.removeAt(lista.lastIndex)
    lista.add(0, ultimo)
}

fun rachaMasLarga(lista: List<Int>): Int {
    if (lista.isEmpty()) return 0
    var maxRacha = 1
    var rachaActual = 1

    for (i in 0 until lista.size - 1) {
        if (lista[i] == lista[i+1]) {
            rachaActual++
        } else {
            if (rachaActual > maxRacha) maxRacha = rachaActual
            rachaActual = 1
        }
    }
    if (rachaActual > maxRacha) maxRacha = rachaActual
    return maxRacha
}

fun existeSumaDos(listaOrdenada: List<Int>, objetivo: Int): Boolean {
    var izquierda = 0
    var derecha = listaOrdenada.size - 1

    while (izquierda < derecha) {
        val suma = listaOrdenada[izquierda] + listaOrdenada[derecha]
        if (suma == objetivo) return true
        if (suma < objetivo) izquierda++
        else derecha--
    }
    return false
}

/**
 * [NUEVA] Invierte una lista MANUALMENTE (sin usar .reversed()).
 * Muy típico para ver si sabes usar bucles decrecientes.
 */
fun invertirListaManual(lista: List<Int>): List<Int> {
    val invertida = mutableListOf<Int>()
    // Recorremos desde el final (size-1) hasta 0
    for (i in lista.size - 1 downTo 0) {
        invertida.add(lista[i])
    }
    return invertida
}

/**
 * [NUEVA] Busca el SEGUNDO número más grande.
 * Útil cuando el primero puede estar repetido o descartado.
 */
fun segundoMayor(lista: List<Int>): Int? {
    if (lista.size < 2) return null
    // Truco rápido: Ordenar descendente, quitar duplicados y coger el segundo
    val unicosOrdenados = lista.distinct().sortedDescending()
    return if (unicosOrdenados.size >= 2) unicosOrdenados[1] else null
}

/**
 * [NUEVA] Cuenta la frecuencia de cada elemento (Histograma).
 * Devuelve un Map: { 5=2, 3=1 } (El 5 sale 2 veces, el 3 sale 1).
 */
fun contarFrecuencias(lista: List<Int>): Map<Int, Int> {
    val frecuencias = mutableMapOf<Int, Int>()
    for (num in lista) {
        // Si existe le suma 1, si no, pone 1
        frecuencias[num] = (frecuencias[num] ?: 0) + 1
    }
    return frecuencias
}

// =================================================================
// NIVEL 5: MATRICES (Listas de Listas - EL JEFE FINAL)
// =================================================================

fun crearMatriz(filas: Int, cols: Int): MutableList<MutableList<Int>> {
    val matriz = mutableListOf<MutableList<Int>>()
    repeat(filas) {
        matriz.add(MutableList(cols) { 0 })
    }
    return matriz
}

fun sumarDiagonal(matriz: List<List<Int>>): Int {
    var suma = 0
    for (i in matriz.indices) {
        suma += matriz[i][i]
    }
    return suma
}

fun contarVecinos(matriz: List<List<Int>>, fila: Int, col: Int, valorBuscado: Int): Int {
    var contador = 0
    val filas = matriz.size
    val cols = matriz[0].size
    for (i in fila - 1..fila + 1) {
        for (j in col - 1..col + 1) {
            if (i in 0 until filas && j in 0 until cols) {
                if (!(i == fila && j == col)) {
                    if (matriz[i][j] == valorBuscado) contador++
                }
            }
        }
    }
    return contador
}

fun esSimetrica(matriz: List<List<Int>>): Boolean {
    val n = matriz.size
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (matriz[i][j] != matriz[j][i]) return false
        }
    }
    return true
}

/**
 * [NUEVA] Transponer Matriz.
 * Convierte filas en columnas. (Lo que estaba en [i][j] pasa a [j][i]).
 */
fun transponerMatriz(matriz: List<List<Int>>): MutableList<MutableList<Int>> {
    val filas = matriz.size
    val cols = matriz[0].size
    val nueva = crearMatriz(cols, filas) // Ojo: dimensiones al revés

    for (i in 0 until filas) {
        for (j in 0 until cols) {
            nueva[j][i] = matriz[i][j]
        }
    }
    return nueva
}

/**
 * [NUEVA] Comprueba si es una Matriz Identidad.
 * (1 en la diagonal principal, 0 en el resto).
 */
fun esIdentidad(matriz: List<List<Int>>): Boolean {
    val n = matriz.size
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (i == j) {
                if (matriz[i][j] != 1) return false // Diagonal debe ser 1
            } else {
                if (matriz[i][j] != 0) return false // Resto debe ser 0
            }
        }
    }
    return true
}

/**
 * [NUEVA] Obtiene el borde de la matriz.
 * Devuelve una lista con los elementos del marco exterior.
 */
fun obtenerBorde(matriz: List<List<Int>>): List<Int> {
    val borde = mutableListOf<Int>()
    val filas = matriz.size
    val cols = matriz[0].size

    for (i in 0 until filas) {
        for (j in 0 until cols) {
            // Si es primera/última fila O primera/última columna
            if (i == 0 || i == filas - 1 || j == 0 || j == cols - 1) {
                borde.add(matriz[i][j])
            }
        }
    }
    return borde
}

// =================================================================
// NIVEL 6: DATA CLASSES (Objetos y Filtrado)
// =================================================================

data class Item(val nombre: String, val precio: Double, val cantidad: Int)

fun filtrarBaratos(items: List<Item>, precioMax: Double): List<Item> {
    return items.filter { it.precio <= precioMax }
}

fun calcularValorInventario(items: List<Item>): Double {
    return items.sumOf { it.precio * it.cantidad }
}

fun itemMasCaro(items: List<Item>): Item? {
    return items.maxByOrNull { it.precio }
}

/**
 * [NUEVA] Agrupar objetos por una propiedad.
 * Ej: Agrupar items por nombre (si hay repetidos).
 */
fun agruparPorNombre(items: List<Item>): Map<String, List<Item>> {
    // groupBy crea un mapa donde la clave es el nombre y el valor la lista de items
    return items.groupBy { it.nombre }
}

// =================================================================
// MAIN PARA PROBARLO TODO
// =================================================================
/*
fun main() {
    // --- Pruebas Matemáticas ---
    println("MCD de 12 y 18: ${mcd(12, 18)}") // 6
    println("Fibonacci 6: ${fibonacci(6)}")   // [0, 1, 1, 2, 3, 5]

    // --- Pruebas Strings ---
    println("César (+1): ${cifradoCesar("Hola", 1)}") // Ipmb

    // --- Pruebas Listas ---
    val lista = listOf(10, 20, 10, 5, 30)
    println("Segundo mayor: ${segundoMayor(lista)}") // 20
    println("Frecuencias: ${contarFrecuencias(lista)}") // {10=2, 20=1, 5=1, 30=1}

    // --- Pruebas Matrices ---
    val matrizId = listOf(
        listOf(1, 0, 0),
        listOf(0, 1, 0),
        listOf(0, 0, 1)
    )
    println("Es identidad? ${esIdentidad(matrizId)}") // true
}
*/