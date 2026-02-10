package problemas
📘 GUÍA MAESTRA DE ALGORITMIA Y KOTLIN AVANZADO
1. MÓDULO: RECURSIVIDAD Y LÓGICA
Concepto: Técnicas para resolver problemas complejos dividiéndolos en subproblemas o procesando estructuras anidadas.

Inversión de Secuencias (Patrón Head/Tail)
Algoritmo estándar para invertir cadenas o listas sin usar bucles, ideal para entender la pila de llamadas.

Kotlin

/**
 * Invierte una cadena procesando el último elemento y llamándose
 * recursivamente con el resto.
 * @param str Cadena a procesar
 */
fun invertirRecursivo(str: String): String {
    // Caso Base: Si la longitud es 1 o 0, retornamos tal cual
    if (str.length <= 1) return str

    // Paso Recursivo: Última letra + resultado de invertir el resto
    return str.last() + invertirRecursivo(str.dropLast(1))
}
Cálculo Matemático Recursivo (Factorial)
Kotlin

fun factorial(n: Int): Int {
    if (n <= 1) return 1
    return n * factorial(n - 1)
}
Optimización de Memoria (Tail Recursion)
Uso de tailrec para evitar el desbordamiento de pila en recursiones profundas.

Kotlin

tailrec fun cuentaRegresiva(n: Int) {
    if (n <= 0) println("Fin")
    else {
        println(n)
        cuentaRegresiva(n - 1)
    }
}
2. MÓDULO: ESTRUCTURAS DE DATOS DINÁMICAS
Concepto: Gestión eficiente de colecciones de objetos utilizando ArrayList y Clases de Datos (data class).

Modelo de Datos y Lista
Kotlin

data class Elemento(val nombre: String, val valor: Int)

val inventario = ArrayList<Elemento>()

fun gestionarInventario() {
    inventario.add(Elemento("Item A", 100))
    inventario.add(Elemento("Item B", 500))
}
Consultas Avanzadas (Programación Funcional)
Alternativas modernas a los bucles for clásicos para filtrar y transformar datos.

Kotlin

fun consultasAvanzadas() {
    // Filtrado: Obtener elementos con valor superior a 200
    val valiosos = inventario.filter { it.valor > 200 }

    // Mapeo: Crear una lista solo con los nombres
    val nombres = inventario.map { it.nombre }

    // Ordenación: De menor a mayor valor
    val ordenados = inventario.sortedBy { it.valor }

    // Búsqueda: Encontrar el primer elemento que coincida
    val itemB = inventario.find { it.nombre == "Item B" }
}
3. MÓDULO: MATRICES Y VISUALIZACIÓN
Concepto: Manipulación de arrays bidimensionales (tableros, mapas, rejillas) y renderizado avanzado en consola.

Inicialización Dinámica
Kotlin

// Crea una matriz 10x10 donde cada celda contiene su propia coordenada multiplicada
val tablaLogica = Array(10) { i ->
    Array(10) { j -> (i + 1) * (j + 1) }
}
Renderizado Profesional con Marcos
Algoritmo para visualizar una matriz incluyendo cabeceras de columnas y etiquetas de filas.

Kotlin

fun imprimirMatrizConBordes(matriz: Array<Array<Char>>) {
    val filas = matriz.size
    val cols = matriz[0].size

    // 1. Cabecera de Columnas
    print("    ")
    for (k in 1..cols) {
        print("${String.format("%2d", k)} ") // Formato de ancho fijo
    }
    println()

    // 2. Separador
    print("    ")
    repeat(cols * 3) { print("-") }
    println()

    // 3. Contenido con Etiquetas Laterales
    for (i in 0 until filas) {
        val letra = 'A' + i
        print(" $letra |") // Marco Izquierdo

        for (j in 0 until cols) {
            print(" ${matriz[i][j]} ")
        }
        println("|") // Marco Derecho
    }
}
Algoritmo de Vecindad ("Radar")
Técnica segura para comprobar celdas adyacentes (8 direcciones) evitando errores de índice fuera de límites (OutOfBoundsException).

Kotlin

fun contarVecinos(tablero: Array<Array<Char>>, fila: Int, col: Int): Int {
    var contador = 0
    // Recorre área 3x3 centrada en (fila, col)
    for (i in -1..1) {
        for (j in -1..1) {
            if (i == 0 && j == 0) continue // Ignorar centro

            val nFila = fila + i
            val nCol = col + j

            // Validación de límites segura
            if (nFila in tablero.indices && nCol in tablero[0].indices) {
                if (tablero[nFila][nCol] == 'X') contador++
            }
        }
    }
    return contador
}
4. MÓDULO: ENTRADA DE DATOS ROBUSTA
Concepto: Patrones para evitar caídas del sistema (crashes) ante entradas de usuario incorrectas.

Lectura Segura con Scanner
Kotlin

import java.util.Scanner

fun leerEnteroSeguro(scan: Scanner, mensaje: String): Int {
    while (true) {
        print(mensaje)
        if (scan.hasNextInt()) {
            return scan.nextInt()
        } else {
            println("❌ Error: Entrada no válida. Ingrese un número entero.")
            scan.next() // Limpiar buffer
        }
    }
}
Lectura con Try-Catch (Universal)
Kotlin

fun leerDatosGenericos(): Int {
    while (true) {
        try {
            val input = readln()
            return input.toInt()
        } catch (e: NumberFormatException) {
            println("Error de formato.")
        }
    }
}
5. MÓDULO: ALGORITMOS AUXILIARES ("TRUCOS")
Concepto: Soluciones rápidas para problemas comunes de lógica matemática, azar y texto.

Generación Aleatoria (Random)
Kotlin

import kotlin.random.Random

// Decisión booleana (Cara/Cruz)
val decision = Random.nextBoolean()

// Aleatoriedad Ponderada (Probabilidades distintas)
fun itemAleatorio(): String {
    val probabilidad = (1..100).random()
    return when (probabilidad) {
        in 1..5 -> "Legendario"   // 5%
        in 6..25 -> "Raro"        // 20%
        else -> "Común"           // 75%
    }
}
Validación de Formatos (Matrículas/Códigos)
Kotlin

fun validarCodigo(texto: String): Boolean {
    // Ejemplo: Formato "1234-AB"
    if (texto.length != 7) return false
    val parteNum = texto.substring(0, 4)
    val guion = texto[4]
    val parteLetras = texto.substring(5, 7)

    return parteNum.all { it.isDigit() } &&
            guion == '-' &&
            parteLetras.all { it.isLetter() }
}
Matemáticas de Ciclos (Módulo %)
Ideal para rotaciones, turnos o límites circulares.

Kotlin

// Avanzar turno en lista de 4 jugadores (0,1,2,3 -> 0...)
var turno = 0
fun siguienteTurno() {
    turno = (turno + 1) % 4
}
Formateo de Tablas en Consola
Kotlin

fun mostrarTablaAlineada() {
    // %-10s: String alineado izq (10 espacios)
    // %5d: Entero alineado der (5 espacios)
    // %.2f: Float con 2 decimales
    println(String.format("%-10s | %5s | %s", "ITEM", "CANT", "PRECIO"))
    println(String.format("%-10s | %5d | %.2f€", "Poción", 5, 12.50))
}



¡Marchando una segunda entrega masiva! 🚚💨

Aquí tienes el VOLUMEN 2 de la Guía Maestra. He añadido algoritmos más específicos, trucos visuales para consola y lógica matemática avanzada que suele marcar la diferencia en pruebas técnicas.

Como antes, todo es código puro, listo para copiar y pegar (Ctrl+C, Ctrl+V), sin referencias a nada anterior.

📘 GUÍA MAESTRA - VOLUMEN 2: HERRAMIENTAS DE ÉLITE
7. MÓDULO: ALGORITMOS DE ORDENACIÓN MANUAL
Concepto: A veces prohíben usar .sort(). Este es el algoritmo de "Burbuja" (Bubble Sort), el clásico infalible para ordenar a mano.

Kotlin

/**
 * Ordena un array de enteros de menor a mayor intercambiando
 * elementos adyacentes.
 */
fun ordenarBurbuja(numeros: IntArray) {
    val n = numeros.size
    for (i in 0 until n - 1) {
        for (j in 0 until n - i - 1) {
            // Si el actual es mayor que el siguiente, los cambiamos
            if (numeros[j] > numeros[j + 1]) {
                val temporal = numeros[j]
                numeros[j] = numeros[j + 1]
                numeros[j + 1] = temporal
            }
        }
    }
}
// Uso: val lista = intArrayOf(5, 1, 4, 2, 8); ordenarBurbuja(lista)
8. MÓDULO: GEOMETRÍA Y ESPACIO
Concepto: Cálculos de distancias y posiciones (muy útil para juegos 2D o mapas).

Clase Punto y Distancia
Kotlin

import kotlin.math.pow
import kotlin.math.sqrt

data class Punto(val x: Double, val y: Double)

fun calcularDistancia(p1: Punto, p2: Punto): Double {
    // Teorema de Pitágoras: h = raiz((x2-x1)^2 + (y2-y1)^2)
    return sqrt((p2.x - p1.x).pow(2) + (p2.y - p1.y).pow(2))
}
¿Está dentro del Círculo? (Colisiones)
Kotlin

fun puntoDentroDeRadio(jugador: Punto, centro: Punto, radio: Double): Boolean {
    val distancia = calcularDistancia(jugador, centro)
    return distancia <= radio
}
9. MÓDULO: VISUALIZACIÓN EN CONSOLA (FX)
Concepto: Dar feedback visual al usuario para que el programa parezca "vivo".

Barra de Carga (Loading Bar)
Simula una carga con una animación simple.

Kotlin

fun simularCarga() {
    print("Cargando: [")
    for (i in 1..20) {
        print("=")
        Thread.sleep(100) // Pausa de 100ms (simula trabajo)
    }
    println("] 100% Completado.")
}
Texto "Mecanografiado" (Efecto Typewriter)
Escribe el texto letra a letra como en los RPGs antiguos.

Kotlin

fun escribirLento(texto: String, velocidadMs: Long = 50) {
    for (caracter in texto) {
        print(caracter)
        Thread.sleep(velocidadMs)
    }
    println()
}
10. MÓDULO: MATEMÁTICAS AVANZADAS (TEORÍA DE NÚMEROS)
Concepto: Algoritmos clásicos para resolver problemas numéricos complejos.

Máximo Común Divisor (Algoritmo de Euclides)
Fundamental para simplificar fracciones o calcular ciclos coincidentes.

Kotlin

tailrec fun mcd(a: Int, b: Int): Int {
    return if (b == 0) a else mcd(b, a % b)
}
// Uso: mcd(48, 18) -> 6
Mínimo Común Múltiplo (MCM)
Kotlin

fun mcm(a: Int, b: Int): Int {
    return if (a == 0 || b == 0) 0 else (a * b) / mcd(a, b)
}
Descomposición en Factores Primos
Devuelve una lista con los "ladrillos" que forman un número (ej: 12 = [2, 2, 3]).

Kotlin

fun factoresPrimos(numero: Int): List<Int> {
    var n = numero
    val factores = ArrayList<Int>()
    var divisor = 2

    while (n > 1) {
        while (n % divisor == 0) {
            factores.add(divisor)
            n /= divisor
        }
        divisor++
    }
    return factores
}
11. MÓDULO: TRATAMIENTO DE DATOS MASIVOS (AGRUPACIONES)
Concepto: Usar la potencia de Kotlin para organizar listas desordenadas en categorías.

GroupBy (La Navaja Suiza)
Imagina que tienes una lista de palabras y quieres agruparlas por su longitud.

Kotlin

fun agruparPalabras() {
    val palabras = listOf("uno", "dos", "tres", "cuatro", "sol", "luz")

    // Crea un mapa donde la CLAVE es la longitud y el VALOR es la lista de palabras
    val grupos = palabras.groupBy { it.length }

    // Resultado:
    // 3 -> ["uno", "dos", "sol", "luz"]
    // 4 -> ["tres"]
    // 6 -> ["cuatro"]

    grupos.forEach { (longitud, lista) ->
        println("Palabras de $longitud letras: $lista")
    }
}
Partition (Divide y Vencerás)
Separa una lista en dos: los que cumplen la condición y los que no.

Kotlin

fun separarAprobados() {
    val notas = listOf(4, 7, 9, 2, 5, 8)

    // "aprobados" recibe true, "suspendos" recibe false
    val (aprobados, suspensos) = notas.partition { it >= 5 }

    println("Pasan: $aprobados") // [7, 9, 5, 8]
    println("Repiten: $suspensos") // [4, 2]
}
12. MÓDULO: SEGURIDAD Y VALIDACIÓN (REGEX)
Concepto: Validaciones profesionales usando Expresiones Regulares.

Validador de Email Simple
Kotlin

fun esEmailValido(email: String): Boolean {
    // Patrón: texto + @ + texto + . + texto
    val regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[a-z]{2,6}$".toRegex()
    return regex.matches(email)
}
Validador de Contraseña Fuerte
Requisitos: Mínimo 8 caracteres, al menos 1 número y 1 mayúscula.

Kotlin

fun esPasswordSegura(pass: String): Boolean {
    return pass.length >= 8 &&
            pass.any { it.isDigit() } &&
            pass.any { it.isUpperCase() }
}
13. MÓDULO: SIMULACIÓN DE SISTEMAS (ESTADOS)
Concepto: Máquinas de estados simples (ej: semáforos, turnos de batalla).

Enum con Comportamiento Cíclico
Kotlin

enum class Semaforo {
    ROJO, AMARILLO, VERDE;

    fun siguiente(): Semaforo {
        return when (this) {
            ROJO -> VERDE
            VERDE -> AMARILLO
            AMARILLO -> ROJO
        }
    }
}

fun simularTrafico() {
    var estadoActual = Semaforo.ROJO
    repeat(6) {
        println("El semáforo está: $estadoActual")
        estadoActual = estadoActual.siguiente()
    }
}
14. MÓDULO: BÚSQUEDA BINARIA (OPTIMIZACIÓN)
Concepto: Buscar en una lista ordenada mucho más rápido que recorriéndola toda (O(log n)).

Kotlin

fun busquedaBinaria(lista: List<Int>, objetivo: Int): Int {
    var inicio = 0
    var fin = lista.size - 1

    while (inicio <= fin) {
        val medio = inicio + (fin - inicio) / 2

        when {
            lista[medio] == objetivo -> return medio // Encontrado
            lista[medio] < objetivo -> inicio = medio + 1 // Buscar derecha
            else -> fin = medio - 1 // Buscar izquierda
        }
    }
    return -1 // No encontrado
}
15. EXTRA: TRUCOS "SUCIOS" DE CONVERSIÓN
Concepto: Transformaciones rápidas de tipos para salir de apuros.

Binario a Decimal: val num = "1010".toInt(2) (Da 10)

Decimal a Hexadecimal: val hex = 255.toString(16) (Da "ff")

ASCII a Char: val letra = 65.toChar() (Da 'A')

Char a ASCII: val codigo = 'A'.code (Da 65)

Kotlin

// Cifrado XOR simple (reversible)
fun cifrarXOR(texto: String, clave: Int): String {
    return texto.map { (it.code xor clave).toChar() }.joinToString("")
}
// cifrarXOR("HOLA", 123) -> Lo encripta
// cifrarXOR("Encriptado", 123) -> Lo desencripta (si usas la misma clave)