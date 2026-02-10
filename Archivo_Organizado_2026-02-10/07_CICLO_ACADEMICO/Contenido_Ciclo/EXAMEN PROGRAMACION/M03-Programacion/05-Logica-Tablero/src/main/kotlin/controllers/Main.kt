package org.example.controllers

import java.util.Scanner
import kotlin.random.Random

/**
 * Función principal de entrada a la aplicación.
 *
 * Se encarga de inicializar el escáner, configurar el tablero y gestionar el bucle principal del juego.
 * Controla la generacion de piezas, moverlas y detectar el fin del juego.
 *
 * @author Gerard y Noa
 * @since 09/12/2025
 */

data class Dimensiones(val filas: Int, val columnas: Int)

fun main() {
    val scan = obrirScanner()

    //Configuración inicial
    val dim = pedirTabla(scan)
    val tablero = Array(dim.filas) { IntArray(dim.columnas) }

    //Iniciar el bucle del juego
    jugarPartida(scan, tablero, dim)

    tancarScanner(scan)
}

/**
 * Funció per obrir l'escàner
 *
 * @author Gerard y Noa
 * @since 09/12/2025
 */
fun obrirScanner() : Scanner {
    val sc : Scanner = Scanner(System.`in`)
    return sc
}

/**
 * Funció per tancar l'escàner
 *
 * @author Gerard y Noa
 * @since 09/12/2025
 */
fun tancarScanner(sc:Scanner) {
    sc.close()
}

//Data class con el estado del juego
data class EstadoJuego(
    val pieza: Array<IntArray>,
    val fila: Int,
    val columna: Int,
    val esActivo: Boolean
)

/**
 * Guarda lo que cambia en cada turno
 *
 * @author Gerard y Noa
 * @since 10/12/2025
 */
fun procesarAccion(accion: Int, estado: EstadoJuego, tablero: Array<IntArray>, dim: Dimensiones): EstadoJuego {
    //desempaquetamos los valores actuales
    val (pieza, fila, col, activo) = estado

    return when (accion) {
        1, 2 -> {
            //calculamos la nueva columna (la función intentarMoverLateral ya existe en tu código)
            val nuevaCol = intentarMoverLateral(tablero, pieza, fila, col, accion)
            //devolvemos una copia del estado solo con la columna cambiada
            estado.copy(columna = nuevaCol)
        }
        3 -> {
            //lógica de caída fuerte
            val filaFondo = bajarPiezaAlFondo(tablero, pieza, fila, col)
            colocarPieza(tablero, pieza, filaFondo, col)
            comprobarFilas(tablero)

            //preparamos la siguiente pieza
            val nuevaPieza = piezaAleatoria()
            val nuevaFila = 0
            val nuevaCol = (dim.columnas - nuevaPieza[0].size) / 2

            //verificamos si al nacer ya choca (Game Over)
            if (hayColision(tablero, nuevaPieza, nuevaFila, nuevaCol)) {
                mostrarGameOver(tablero)
                estado.copy(esActivo = false)
            } else {
                //todo bien, devolvemos el estado reiniciado para la nueva pieza
                estado.copy(pieza = nuevaPieza, fila = nuevaFila, columna = nuevaCol)
            }
        }
        4 -> estado.copy(esActivo = false) //salir
        else -> estado //acción no válida i entonces no cambiamos nada
    }
}

/**
 * Contiene el bucle principal para jugar. Gestiona el estado de las variables y los turnos.
 * Delega las acciones especificas a funciones auxiliares para mantener el codigo limpio.
 *
 * @author Gerard y Noa
 * @since 09/12/2025
 */
fun jugarPartida(scan: Scanner, tableroBase: Array<IntArray>, dim: Dimensiones) {
    //inicializamos el estado inicial con una pieza aleatoria
    val piezaInicial = piezaAleatoria()
    var estado = EstadoJuego(
        pieza = piezaInicial,
        fila = 0,
        columna = (dim.columnas - piezaInicial[0].size) / 2,
        esActivo = true
    )

    //bucle principal: mientras el juego esté activo, seguimos jugando
    while (estado.esActivo) {
        //mostramos el estado actual del juego por pantalla
        mostrarEstadoJuego(tableroBase, estado.pieza, estado.fila, estado.columna)

        //pedimos al usuario qué acción quiere realizar
        val accionJugador = demanarAccio(scan)

        //procesamos la acción y actualizamos el estado del juego
        estado = procesarAccion(accionJugador, estado, tableroBase, dim)
    }
}

/**
 * Intenta mover la pieza a los lados. Si es válido devuelve la nueva columna, si no, devuelve la antigua.
 *
 * @param tablero Tablero actual
 * @param pieza Pieza actual
 * @param fila Fila actual
 * @param columna Columna actual
 * @param direccion Direccion (1 o 2)
 * @return La nueva columna o la misma si no se puede mover
 * @author Gerard y Noa
 * @since 10/12/2025
 */
fun intentarMoverLateral(tablero: Array<IntArray>, pieza: Array<IntArray>, fila: Int, columna: Int, direccion: Int): Int {
    //calculamos la columna tentativa según la dirección indicada
    val nuevaCol = calcularNuevaColumna(columna, direccion)

    //verificamos si la pieza cabe en esa nueva posición sin chocar
    if (validarMovimiento(tablero, pieza, fila, nuevaCol)) {
        //si es válido, confirmamos el movimiento devolviendo la nueva columna
        return nuevaCol
    } else {
        //si choca, cancelamos el movimiento devolviendo la columna original
        return columna
    }
}

/**
 * Calcula la fila más baja posible donde la pieza puede caer sin chocar con nada.
 *
 * @param tablero Tablero actual
 * @param pieza Pieza a bajar
 * @param f Fila inicial
 * @param c Columna actual
 * @return La fila final donde se detiene
 * @author Gerard y Noa
 * @since 10/12/2025
 */
fun bajarPiezaAlFondo(tablero: Array<IntArray>, pieza: Array<IntArray>, f: Int, c: Int): Int {
    var filaActual = f
    //mientras podamos bajar mas sin chocar, aumentamos la fila
    while (validarMovimiento(tablero, pieza, filaActual + 1, c)) {
        filaActual++
    }
    return filaActual
}

/**
 * Comprueba si la pieza choca en la posicion dada (usado principalmente para detectar Game Over al nacer).
 *
 * @author Gerard y Noa
 * @since 10/12/2025
 */
fun hayColision(tablero: Array<IntArray>, pieza: Array<IntArray>, f: Int, c: Int): Boolean {
    //si el movimiento no es valido, es que hay colision
    return !validarMovimiento(tablero, pieza, f, c)
}

/**
 * Agrupa toda la lógica visual: Copia el tablero, pone la pieza flotante y dibuja.
 *
 * @author Gerard y Noa
 * @since 09/12/2025
 */
fun mostrarEstadoJuego(tableroBase: Array<IntArray>, pieza: Array<IntArray>, fila: Int, columna: Int) {
    //creamos una copia del tablero para no modificar el original con la pieza en movimiento
    val frameVisual = copiarTablero(tableroBase)

    //pintamos la pieza en la copia visual en su posición actual
    colocarPieza(frameVisual, pieza, fila, columna)

    //imprimimos un salto de línea y el frame final coloreado
    println()
    printPicture(frameVisual)
}
/**
 * Muestra el mensaje de fin de partida y el estado final del tablero.
 *
 * @author Gerard y Noa
 * @since 09/12/2025
 */
fun mostrarGameOver(tableroFinal: Array<IntArray>) {
    println()
    println("-----FIN DE LA PARTIDA SE HA LLENADO EL TABLERO-----")
    println()
    printPicture(tableroFinal)
}

/**
 * Comprueba todas las filas del tablero. Si encuentra una llena, la elimina y baja las superiores.
 *
 * @param tablero El tablero a revisar
 * @author Gerard y Noa
 * @since 10/12/2025
 */
fun comprobarFilas(tablero: Array<IntArray>) {
    //empezamos desde abajo del todo
    var filaActual = tablero.size - 1

    while (filaActual >= 0) {
        if (estaFilaLlena(tablero[filaActual])) {
            //eliminamos la fila y bajamos el resto
            eliminarFilaYBajarlas(tablero, filaActual)
            println("¡Fila $filaActual eliminada!")
            //no decrementamos filaActual porque lo de arriba ha bajado a esta posición y hay que revisarlo
        } else {
            filaActual--
        }
    }
}

/**
 * Verifica si una fila no tiene huecos vacios (ceros).
 *
 * @param fila La fila a comprobar
 * @return true si esta llena
 * @author Gerard y Noa
 * @since 10/12/2025
 */
fun estaFilaLlena(fila: IntArray): Boolean {
    //si no contiene 0 significa que esta llena
    return !fila.contains(0)
}

/**
 * Elimina una fila especifica y mueve todas las filas superiores hacia abajo.
 * Rellena la fila superior con ceros nuevos.
 *
 * @param tablero
 * @param filaEliminada Indice de la fila a borrar
 * @author Gerard y Noa
 * @since 10/12/2025
 */
fun eliminarFilaYBajarlas(tablero: Array<IntArray>, filaEliminada: Int) {
    //movemos todo hacia abajo desde la fila eliminada
    for (k in filaEliminada downTo 1) {
        tablero[k] = tablero[k - 1].clone()
    }
    //limpiamos la fila superior creando un array nuevo de ceros
    tablero[0] = IntArray(tablero[0].size) { 0 }
}

/**
 * Valida si una pieza puede posicionarse en unas coordenadas específicas sin colisionar.
 *
 * Comprueba dos cosas:
 * 1. Que la pieza no se salga de los límites del array (paredes y suelo).
 * 2. Que la pieza no se superponga con celdas que ya tienen valor (!= 0) en el tablero.
 *
 * @param tablero La matriz actual del juego.
 * @param pieza La matriz de la pieza que se intenta mover.
 * @param fila La coordenada fila superior izquierda.
 * @param col La coordenada columna superior izquierda.
 * @return `true` si el movimiento es válido.
 * @author Gerard y Noa
 * @since 09/12/2025
 */
fun validarMovimiento(tablero: Array<IntArray>, pieza: Array<IntArray>, fila: Int, col: Int): Boolean {
    //recorremos la matriz de la pieza
    for (i in pieza.indices) {
        for (j in pieza[i].indices) {
            //solo verificamos si la celda de la pieza no es un hueco vacío
            if (pieza[i][j] != 0) {
                //calculamos la posición absoluta en el tablero
                val fTablero = fila + i
                val cTablero = col + j

                //verificamos si nos salimos de los límites del tablero (abajo, izquierda o derecha)
                if (fTablero >= tablero.size || cTablero < 0 || cTablero >= tablero[0].size) {
                    return false
                }
                //verificamos si ya hay una pieza ocupando esa posición (valor distinto de 0)
                if (fTablero >= 0 && tablero[fTablero][cTablero] != 0) {
                    return false
                }
            }
        }
    }
    //si no hemos chocado con nada, el movimiento es válido
    return true
}


/**
 * Crea una copia profunda (Deep Copy) del tablero de juego.
 * Es esencial para el renderizado visual sin alterar el tablero logico.
 *
 * @param original El tablero base actual.
 * @return Una nueva instancia de `Array<IntArray>` idéntica.
 * @author Gerard y Noa
 * @since 09/12/2025
 */
fun copiarTablero(original: Array<IntArray>): Array<IntArray> {
    //creamos una nueva matriz vacía con las mismas dimensiones
    val copia = Array(original.size) { IntArray(original[0].size) }

    //recorremos todas las filas del tablero original
    for (i in original.indices) {
        //clonamos cada fila individualmente para evitar referencias compartidas
        copia[i] = original[i].clone()
    }
    //devolvemos la copia independiente
    return copia
}

/**
 * Solicita al usuario las dimensiones del tablero a través de la consola.
 *
 * @param scan El objeto Scanner.
 * @return Un objeto Dimensiones con filas y columnas.
 * @author Gerard y Noa
 * @since 09/12/2025
 */
fun pedirTabla(scan: Scanner): Dimensiones {
    //pedimos el número de filas al usuario
    println("Introduce el numero de filas del tablero: ")
    val filas = scan.nextInt()

    //pedimos el número de columnas al usuario
    println("Introduce el numero de columnas del trablero: ")
    val columnas = scan.nextInt()

    //devolvemos el objeto dimensiones con los valores leídos
    return Dimensiones(filas, columnas)
}
/**
 * Calcula la nueva posición horizontal de la pieza basada en la dirección elegida.
 *
 * @param columnaActual La posición actual de la columna.
 * @param direccion El entero que representa la dirección (1 izq, 2 der).
 * @return El nuevo índice de columna.
 * @author Gerard y Noa
 * @since 09/12/2025
 */
fun calcularNuevaColumna(columnaActual: Int, direccion: Int): Int {
    //si la dirección es 1, restamos una posición para ir a la izquierda
    if (direccion == 1) return columnaActual - 1
    //si la dirección es 2, sumamos una posición para ir a la derecha
    if (direccion == 2) return columnaActual + 1
    //si la dirección no es válida, devolvemos la misma columna sin cambios
    return columnaActual
}

/**
 * "Estampa" o dibuja una pieza sobre un tablero dado en las coordenadas especificadas.
 *
 * @param tablero El tablero donde se pintará la pieza.
 * @param pieza La matriz de la pieza a colocar.
 * @param filaPos La fila inicial.
 * @param colPos La columna inicial.
 * @author Gerard y Noa
 * @since 09/12/2025
 */
fun colocarPieza(tablero: Array<IntArray>, pieza: Array<IntArray>, filaPos: Int, colPos: Int) {
    //recorremos la matriz de la pieza para copiar sus valores
    for (i in pieza.indices) {
        for (j in pieza[i].indices) {
            //solo procesamos si la celda de la pieza tiene contenido (no es aire/0)
            if (pieza[i][j] != 0) {
                //calculamos las coordenadas absolutas en el tablero
                val filaTablero = filaPos + i
                val colTablero = colPos + j

                //solo pintamos si la coordenada cae dentro de los límites válidos del tablero
                if (filaTablero in tablero.indices && colTablero in tablero[0].indices) {
                    //asignamos el valor de la pieza a la celda del tablero
                    tablero[filaTablero][colTablero] = pieza[i][j]
                }
            }
        }
    }
}

/**
 * Muestra el menú de opciones y captura la elección del usuario.
 *
 * @param scanner El lector de entrada.
 * @return Un entero representando la acción.
 * @author Gerard y Noa
 * @since 09/12/2025
 */
fun demanarAccio(scanner: Scanner): Int {
    //pedimos la accion que queremos hacer
    println("Selecciona una acció: 1:Esquerra | 2:Dreta | 3:Deixar caure | 4:Sortir")
    return scanner.nextInt()
}


val cubo = arrayOf(
    intArrayOf(1, 1),
    intArrayOf(1, 1)
)

val palo = arrayOf(
    intArrayOf(2),
    intArrayOf(2),
    intArrayOf(2),
    intArrayOf(2)
)

val eleHorizontal = arrayOf(
    intArrayOf(0, 0, 3),
    intArrayOf(3, 3, 3)
)

val eleVertical = arrayOf(
    intArrayOf(4, 0),
    intArrayOf(4, 0),
    intArrayOf(4, 4)
)

/**
 * Genera una pieza de juego aleatoria seleccionando entre las formas disponibles.
 *
 * @return Una matriz que representa la pieza.
 * @author Gerard y Noa
 * @since 09/12/2025
 */
fun piezaAleatoria(): Array<IntArray> {
    //generamos un numero random para definir que pieza toca
    val numeroRandom = Random.nextInt(0, 4)
    return when (numeroRandom) {
        0 -> cubo
        1 -> eleHorizontal
        2 -> eleVertical
        3 -> palo
        else -> cubo
    }
}

/**
 * Renderiza el estado actual del juego en la consola utilizando códigos de escape ANSI.
 * Utiliza colores neon sobre fondo gris oscuro.
 *
 * @param frame La matriz del tablero a imprimir.
 * @author Gerard y Noa
 * @since 09/12/2025
 */
fun printPicture(frame: Array<IntArray>) {

    for (f in frame.indices) {
        //imprimimos numero de fila

        for (c in frame[f].indices) {
            //pintamos el bloque segun su color delegando a funcion auxiliar
            imprimirBloqueColoreado(frame[f][c])
        }
        println()
    }
}


/**
 * Imprime un bloque de 3 espacios con el color de fondo correspondiente al valor.
 * Usa colores brillantes (High Intensity) para mejor contraste.
 *
 * @param valor El valor de la celda (0=vacio, 1=cubo, etc)
 * @author Gerard y Noa
 * @since 10/12/2025
 */
fun imprimirBloqueColoreado(valor: Int) {
    val RESET = "\u001b[0m"
    val bloque = "   "

    val color = when (valor) {
        0 -> "\u001B[100m" //gris oscuro (Fondo)
        1 -> "\u001b[103m" //amarillo Neon
        2 -> "\u001b[101m" //rojo Neon
        3 -> "\u001b[102m" //verde Neon
        4 -> "\u001b[104m" //azul Neon
        else -> "\u001B[100m"
    }

    print(color + bloque + RESET)
}