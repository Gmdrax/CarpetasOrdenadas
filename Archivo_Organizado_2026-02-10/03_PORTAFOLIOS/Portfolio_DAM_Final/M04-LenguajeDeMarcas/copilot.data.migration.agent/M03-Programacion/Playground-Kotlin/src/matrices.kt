import java.util.Scanner
import java.util.Locale

// ==========================================
// 1. CREACIÓN DE MATRICES (Listas de Listas)
// ==========================================

/**
 * Crea una matriz vacía de N x M (Filas x Columnas) rellena de ceros.
 * Útil para inicializar tableros de juego o mapas.
 */
fun crearMatrizCeros(filas: Int, columnas: Int): MutableList<MutableList<Int>> {
    val matriz = mutableListOf<MutableList<Int>>()

    repeat(filas) {
        // Creamos una fila rellena de 0s
        val fila = MutableList(columnas) { 0 }
        matriz.add(fila)
    }
    return matriz
}

/**
 * Crea una matriz de Strings vacía (o con un carácter por defecto como ".").
 * Útil para el ejercicio de "Dibujar Rectangle" o "Patrones".
 */
fun crearMatrizString(filas: Int, columnas: Int, defecto: String): MutableList<MutableList<String>> {
    val matriz = mutableListOf<MutableList<String>>()
    repeat(filas) {
        val fila = MutableList(columnas) { defecto }
        matriz.add(fila)
    }
    return matriz
}

/**
 * Crea una matriz con datos iniciales fijos.
 * Ejemplo:
 * 1 2 3
 * 4 5 6
 */
fun crearMatrizFija(): MutableList<MutableList<Int>> {
    return mutableListOf(
        mutableListOf(1, 2, 3),
        mutableListOf(4, 5, 6),
        mutableListOf(7, 8, 9)
    )
}

// ==========================================
// 2. LECTURA Y ESCRITURA
// ==========================================

/**
 * Lee una matriz desde el teclado (primero filas, luego columnas).
 */
fun leerMatriz(scan: Scanner, filas: Int, columnas: Int): MutableList<MutableList<Int>> {
    val matriz = mutableListOf<MutableList<Int>>()

    for (i in 0 until filas) {
        val fila = mutableListOf<Int>()
        for (j in 0 until columnas) {
            // Leemos el valor y lo metemos en la fila
            val valor = scan.nextInt()
            fila.add(valor)
        }
        // Añadimos la fila completa a la matriz
        matriz.add(fila)
    }
    return matriz
}

/**
 * Imprime la matriz con formato de tabla (filas y columnas).
 */
fun imprimirMatrizBonita(matriz: MutableList<MutableList<Int>>) {
    for (fila in matriz) {
        // Imprimimos la fila entera separada por espacios
        println(fila.joinToString(" "))
    }
}

/**
 * Imprime una matriz de Strings (útil para dibujos).
 */
fun imprimirMatrizString(matriz: MutableList<MutableList<String>>) {
    for (fila in matriz) {
        println(fila.joinToString(" "))
    }
}

// ==========================================
// 3. ACCESO A DATOS (Filas y Columnas)
// ==========================================

/**
 * Accede a un valor concreto.
 * Recuerda: matriz[fila][columna]
 */
fun obtenerValorMatriz(matriz: MutableList<MutableList<Int>>, fila: Int, col: Int): Int {
    return matriz[fila][col]
}

/**
 * Modifica un valor concreto.
 */
fun modificarValorMatriz(matriz: MutableList<MutableList<Int>>, fila: Int, col: Int, nuevoValor: Int) {
    matriz[fila][col] = nuevoValor
}

// ==========================================
// 4. ALGORITMOS BÁSICOS (Sumas y Máximos Globales)
// ==========================================

/**
 * Suma TODOS los números de la matriz.
 */
fun sumarTotalMatriz(matriz: MutableList<MutableList<Int>>): Int {
    var suma = 0
    for (fila in matriz) {
        for (valor in fila) {
            suma += valor
        }
    }
    return suma
}

/**
 * Busca el número más grande de toda la matriz.
 * Devuelve solo el VALOR.
 */
fun obtenerMaximoMatriz(matriz: MutableList<MutableList<Int>>): Int {
    if (matriz.isEmpty()) return 0

    var maximo = matriz[0][0] // Asumimos que el primero es el mayor

    for (fila in matriz) {
        for (valor in fila) {
            if (valor > maximo) {
                maximo = valor
            }
        }
    }
    return maximo
}

// ==========================================
// 5. DIAGONALES (Muy típico de examen)
// ==========================================

/**
 * Obtiene los elementos de la DIAGONAL PRINCIPAL (De arriba-izq a abajo-der).
 * Solo funciona si la matriz es cuadrada (mismas filas que columnas).
 * Lógica: La posición es siempre [i][i] (0,0), (1,1), (2,2)...
 */
fun obtenerDiagonalPrincipal(matriz: MutableList<MutableList<Int>>): List<Int> {
    val diagonal = mutableListOf<Int>()
    val tamaño = matriz.size // Número de filas

    for (i in 0 until tamaño) {
        // [i][i] es el truco
        diagonal.add(matriz[i][i])
    }
    return diagonal
}

/**
 * Obtiene la DIAGONAL SECUNDARIA (De arriba-der a abajo-izq).
 * Lógica: La columna es (tamaño - 1 - fila).
 * Ejemplo 3x3: (0,2), (1,1), (2,0)
 */
fun obtenerDiagonalSecundaria(matriz: MutableList<MutableList<Int>>): List<Int> {
    val diagonal = mutableListOf<Int>()
    val n = matriz.size

    for (i in 0 until n) {
        val columna = n - 1 - i
        diagonal.add(matriz[i][columna])
    }
    return diagonal
}

// ==========================================
// 6. COORDENADAS Y VECINOS (Nivel Avanzado)
// ==========================================

/**
 * Busca un número y devuelve sus coordenadas (Fila, Columna).
 * Devuelve Pair(-1, -1) si no lo encuentra.
 * Útil para el ejercicio "Buscar K".
 */
fun buscarCoordenadas(matriz: MutableList<MutableList<Int>>, buscar: Int): Pair<Int, Int> {
    for (i in matriz.indices) { // Recorre filas
        for (j in matriz[i].indices) { // Recorre columnas de esa fila
            if (matriz[i][j] == buscar) {
                return Pair(i, j) // ¡Encontrado!
            }
        }
    }
    return Pair(-1, -1)
}

/**
 * [BUSCAMINAS] Cuenta cuántos vecinos (arriba, abajo, lados) cumplen una condición.
 * Útil para: "Cuenta cuántos 1 hay alrededor de la posición X,Y".
 */
fun contarVecinos(matriz: MutableList<MutableList<Int>>, fila: Int, col: Int, valorBuscado: Int): Int {
    var contador = 0

    // Definimos los 8 movimientos posibles (y el centro 0,0 que saltaremos)
    // Recorremos desde la fila anterior (i-1) a la posterior (i+1)
    for (i in fila - 1..fila + 1) {
        for (j in col - 1..col + 1) {

            // 1. Comprobar que NO nos salimos del tablero (índices válidos)
            if (i >= 0 && i < matriz.size && j >= 0 && j < matriz[0].size) {

                // 2. Comprobar que NO somos nosotros mismos (el centro)
                if (!(i == fila && j == col)) {

                    // 3. Comprobar si es el valor que buscamos
                    if (matriz[i][j] == valorBuscado) {
                        contador++
                    }
                }
            }
        }
    }
    return contador
}

// ==========================================
// 7. OPERACIONES POR FILAS Y COLUMNAS
// ==========================================

/**
 * [EXERCICI SUMAR K] Suma todos los elementos de una FILA específica.
 */
fun sumarFila(matriz: MutableList<MutableList<Int>>, numFila: Int): Int {
    // Protección por si la fila no existe
    if (numFila !in matriz.indices) return 0

    // sum() es una función nativa de listas
    return matriz[numFila].sum()
}

/**
 * [EXERCICI SUMAR K] Suma todos los elementos de una COLUMNA específica.
 * Requiere recorrer todas las filas y coger el elemento 'numCol'.
 */
fun sumarColumna(matriz: MutableList<MutableList<Int>>, numCol: Int): Int {
    var suma = 0
    for (fila in matriz) {
        // Protección por si la columna no existe en esta fila
        if (numCol in fila.indices) {
            suma += fila[numCol]
        }
    }
    return suma
}

/**
 * [EXERCICI MITJANES] Calcula la media (entera) de CADA fila.
 * Devuelve una lista con las medias.
 */
fun calcularPromediosPorFila(matriz: MutableList<MutableList<Int>>): List<Int> {
    val promedios = mutableListOf<Int>()

    for (fila in matriz) {
        if (fila.isNotEmpty()) {
            val media = fila.sum() / fila.size
            promedios.add(media)
        } else {
            promedios.add(0)
        }
    }
    return promedios
}

// ==========================================
// 8. BÚSQUEDA Y MODIFICACIÓN AVANZADA
// ==========================================

/**
 * [EXERCICI REEMPLAZAR] Busca todas las apariciones de un número y las cambia por otro.
 * Modifica la matriz original directamente.
 */
fun reemplazarTodosEnMatriz(matriz: MutableList<MutableList<Int>>, buscar: Int, reemplazo: Int) {
    for (i in matriz.indices) {
        for (j in matriz[i].indices) {
            if (matriz[i][j] == buscar) {
                matriz[i][j] = reemplazo
            }
        }
    }
}

/**
 * [EXERCICI POSICIÓ MÀXIM] Busca DÓNDE está el número más grande.
 * Devuelve un Pair(Fila, Columna) con la posición del máximo.
 */
fun obtenerPosicionMaximo(matriz: MutableList<MutableList<Int>>): Pair<Int, Int> {
    if (matriz.isEmpty()) return Pair(-1, -1)

    var maximo = matriz[0][0]
    var filaMax = 0
    var colMax = 0

    for (i in matriz.indices) {
        for (j in matriz[i].indices) {
            if (matriz[i][j] > maximo) {
                maximo = matriz[i][j]
                filaMax = i
                colMax = j
            }
        }
    }
    return Pair(filaMax, colMax)
}

// ==========================================
// 9. TRANSFORMACIONES GLOBALES
// ==========================================

/**
 * [EXERCICI AUGMENT PREUS] Multiplica TODOS los elementos de la matriz por un número.
 * Modifica la matriz original directamente.
 */
fun multiplicarMatrizPorEscalar(matriz: MutableList<MutableList<Int>>, escalar: Int) {
    for (i in matriz.indices) {
        for (j in matriz[i].indices) {
            matriz[i][j] = matriz[i][j] * escalar
        }
    }
}

/**
 * [EXERCICI SUMA MATRIUS] Suma dos matrices (A y B) y devuelve una NUEVA matriz resultado.
 * Asume que ambas matrices tienen el mismo tamaño.
 */
fun sumarDosMatrices(matrizA: MutableList<MutableList<Int>>, matrizB: MutableList<MutableList<Int>>): MutableList<MutableList<Int>> {
    val resultado = mutableListOf<MutableList<Int>>()

    // Asumimos que A y B tienen las mismas dimensiones
    val filas = matrizA.size

    for (i in 0 until filas) {
        val filaA = matrizA[i]
        val filaB = matrizB[i]
        val filaNueva = mutableListOf<Int>()

        for (j in 0 until filaA.size) {
            // Sumamos elemento a elemento
            filaNueva.add(filaA[j] + filaB[j])
        }
        resultado.add(filaNueva)
    }
    return resultado
}

// ==========================================
// 10. DIBUJO Y PATRONES
// ==========================================

/**
 * [EXERCICI DIBUIXA RECTANGLE] Rellena un área rectangular con "X" y el resto con ".".
 * Devuelve una nueva matriz de Strings.
 * f1, c1: Esquina superior izquierda.
 * f2, c2: Esquina inferior derecha.
 */
fun generarMatrizDibujo(filas: Int, columnas: Int, f1: Int, c1: Int, f2: Int, c2: Int): MutableList<MutableList<String>> {
    val matriz = crearMatrizString(filas, columnas, ".")

    for (i in 0 until filas) {
        for (j in 0 until columnas) {
            // Comprobamos si (i, j) está dentro de los límites del rectángulo
            if (i >= f1 && i <= f2 && j >= c1 && j <= c2) {
                matriz[i][j] = "X"
            }
        }
    }
    return matriz
}

// ==========================================
// 11. ACCESO RELATIVO SEGURO (Spiderman)
// ==========================================

/**
 * [EXERCICI SPIDERMAN] Obtiene el valor de una casilla relativa (Arriba, Abajo, etc.).
 * Si la casilla se sale del tablero, devuelve un valor por defecto (ej: "NO").
 * * Uso:
 * - Arriba: deltaFila = -1, deltaCol = 0
 * - Abajo:  deltaFila = +1, deltaCol = 0
 */
fun obtenerVecinoRelativo(
    matriz: MutableList<MutableList<String>>,
    filaOrigen: Int,
    colOrigen: Int,
    deltaFila: Int,
    deltaCol: Int,
    valorPorDefecto: String = "NO"
): String {
    val nuevaFila = filaOrigen + deltaFila
    val nuevaCol = colOrigen + deltaCol

    // Comprobamos si la nueva posición es válida
    if (nuevaFila >= 0 && nuevaFila < matriz.size &&
        nuevaCol >= 0 && nuevaCol < matriz[0].size) {
        return matriz[nuevaFila][nuevaCol]
    }

    return valorPorDefecto
}

// ==========================================
// 12. DETECCIÓN DE PATRONES EN JUEGOS (3 Gats)
// ==========================================

/**
 * [EXERCICI 3 GATS] Comprueba si hay una línea de 'longitud' elementos iguales
 * empezando en (fila, col) y siguiendo una dirección (dF, dC).
 */
fun hayLinea(
    matriz: MutableList<MutableList<Int>>,
    fila: Int,
    col: Int,
    dF: Int,
    dC: Int,
    longitud: Int,
    valorBuscado: Int
): Boolean {
    // Verificamos si cabemos en el tablero
    // La última casilla será fila + (longitud-1)*dF
    val filaFinal = fila + (longitud - 1) * dF
    val colFinal = col + (longitud - 1) * dC

    // Si nos salimos, devolvemos false directamente
    if (filaFinal < 0 || filaFinal >= matriz.size || colFinal < 0 || colFinal >= matriz[0].size) {
        return false
    }

    // Comprobamos todas las casillas de la línea
    for (k in 0 until longitud) {
        if (matriz[fila + k * dF][col + k * dC] != valorBuscado) {
            return false
        }
    }

    return true
}

// ==========================================
// 13. PATRONES MATEMÁTICOS Y VISUALES (NUEVO)
// ==========================================

/**
 * [EXERCICI IDENTITAT] Crea una matriz identidad de NxN.
 * Tiene '1' en la diagonal principal y '0' en el resto.
 */
fun crearMatrizIdentidad(n: Int): MutableList<MutableList<Int>> {
    val matriz = crearMatrizCeros(n, n)
    for (i in 0 until n) {
        matriz[i][i] = 1
    }
    return matriz
}

/**
 * [EXERCICI VORES I DIAGONALS] Crea una matriz con 'X' en bordes y diagonales, '.' en el resto.
 * Patrón "Bandera del Reino Unido".
 */
fun crearMatrizConBordesYDiagonales(n: Int): MutableList<MutableList<String>> {
    val matriz = crearMatrizString(n, n, ".")

    for (i in 0 until n) {
        for (j in 0 until n) {
            // Condiciones: Bordes (i=0, i=n-1, j=0, j=n-1) y Diagonales (i=j, i+j=n-1)
            val esBorde = (i == 0 || i == n - 1 || j == 0 || j == n - 1)
            val esDiagonal = (i == j || i + j == n - 1)

            if (esBorde || esDiagonal) {
                matriz[i][j] = "X"
            }
        }
    }
    return matriz
}

// ==========================================
// 14. TRANSFORMACIONES ESTRUCTURALES (NUEVO)
// ==========================================

/**
 * [EXERCICI TRANSPOSADA] Invierte filas por columnas.
 * La fila 0 pasa a ser la columna 0, etc.
 */
fun transponerMatriz(matriz: MutableList<MutableList<Int>>): MutableList<MutableList<Int>> {
    if (matriz.isEmpty()) return mutableListOf()

    val filasOrig = matriz.size
    val colsOrig = matriz[0].size

    // La nueva matriz tendrá dimensiones invertidas
    val nuevaMatriz = mutableListOf<MutableList<Int>>()

    for (j in 0 until colsOrig) { // Recorremos columnas originales (serán nuevas filas)
        val nuevaFila = mutableListOf<Int>()
        for (i in 0 until filasOrig) { // Recorremos filas originales
            nuevaFila.add(matriz[i][j])
        }
        nuevaMatriz.add(nuevaFila)
    }
    return nuevaMatriz
}

// ==========================================
// 15. SIMULACIÓN Y AUTÓMATAS (NUEVO)
// ==========================================

/**
 * [EXERCICI JOC DE LA VIDA] Calcula el siguiente estado de una matriz de 0s y 1s.
 * Regla simplificada (Examen): Si tiene 2 o 3 vecinos vivos -> 1, si no -> 0.
 * IMPORTANTE: Se necesita usar 'contarVecinos' de la sección 6.
 */
fun siguienteGeneracionJuegoVida(tableroActual: MutableList<MutableList<Int>>): MutableList<MutableList<Int>> {
    val filas = tableroActual.size
    val columnas = tableroActual[0].size

    // Creamos el tablero nuevo vacío
    val tableroSiguiente = crearMatrizCeros(filas, columnas)

    for (i in 0 until filas) {
        for (j in 0 until columnas) {
            // Contamos los "1" alrededor
            val vecinosVivos = contarVecinos(tableroActual, i, j, 1)

            // Aplicamos la regla del ejercicio
            if (vecinosVivos == 2 || vecinosVivos == 3) {
                tableroSiguiente[i][j] = 1
            } else {
                tableroSiguiente[i][j] = 0
            }
        }
    }
    return tableroSiguiente
}

// ==========================================
// 16. LÓGICA DE JUEGOS (Bloqueos y Patrones) (NUEVO)
// ==========================================

/**
 * [EXERCICI FANTASMES] Comprueba si una posición está "atrapada" por obstáculos.
 * Verifica Arriba, Abajo, Izquierda y Derecha.
 * Se considera bloqueada si hay pared (límite matriz) o un obstáculo (valor 1).
 */
fun estaBloqueadoEnCruz(matriz: MutableList<MutableList<Int>>, fila: Int, col: Int): Boolean {
    val filas = matriz.size
    val columnas = matriz[0].size

    // Check Arriba
    val arribaBloqueado = (fila - 1 < 0) || (matriz[fila - 1][col] == 1)
    // Check Abajo
    val abajoBloqueado = (fila + 1 >= filas) || (matriz[fila + 1][col] == 1)
    // Check Izquierda
    val izqBloqueado = (col - 1 < 0) || (matriz[fila][col - 1] == 1)
    // Check Derecha
    val derBloqueado = (col + 1 >= columnas) || (matriz[fila][col + 1] == 1)

    return arribaBloqueado && abajoBloqueado && izqBloqueado && derBloqueado
}

/**
 * [EXERCICI TRAVOLTA] Busca un número 'n' que tenga 't' a su izquierda y a su derecha.
 * Devuelve el número encontrado (como String) o "NO".
 * Recorre evitando los bordes laterales (col 1 a col-2).
 */
fun buscarNumeroEntreDos(matriz: MutableList<MutableList<Int>>, valorLateral: Int): String {
    val filas = matriz.size
    val columnas = matriz[0].size

    for (i in 0 until filas) {
        // Empezamos en columna 1 y acabamos en penúltima
        for (j in 1 until columnas - 1) {
            val izq = matriz[i][j - 1]
            val der = matriz[i][j + 1]

            if (izq == valorLateral && der == valorLateral) {
                return matriz[i][j].toString()
            }
        }
    }
    return "NO"
}