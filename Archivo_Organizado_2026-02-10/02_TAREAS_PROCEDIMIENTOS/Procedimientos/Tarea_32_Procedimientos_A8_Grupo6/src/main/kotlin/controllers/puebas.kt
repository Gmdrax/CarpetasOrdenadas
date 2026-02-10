package controllers

import java.util.Scanner
import kotlin.random.Random

/**
 * Funcio principal que inicialitza el tauler del joc i comenca el joc.
 *
 * @author Usman i Diego
 * @since 10/12/2025
 */
fun main() {
    val scanner = Scanner(System.`in`)
    val tauler = crearTauler(scanner)
    executarJoc(tauler, scanner)
}

/**
 * Crea el tauler de joc basant-se en l'amplada i alçada especificades.
 *
 * @param scanner El scanner utilitzat per llegir les entrades de l'usuari.
 * @return Un array bidimensional representant el tauler de joc amb l'amplada i alçada especificades.
 * @author Usman i Diego
 * @since 10/12/2025
 */
fun crearTauler(scanner: Scanner): Array<BooleanArray> {
    println("Amplada:")
    val amplada = scanner.nextInt()
    println("Alçada:")
    val alcada = scanner.nextInt()
    return Array(alcada) { BooleanArray(amplada) { false } }
}

/**
 * Executa el bucle del joc on les peces es generen aleatòriament i es mouen.
 * El joc continua fins que es compleix la condició de "game over".
 *
 * @param tauler El tauler de joc on es col·loquen les peces.
 * @param scanner El scanner utilitzat per llegir les accions de l'usuari.
 * @author Usman i Diego
 * @since 10/12/2025
 */
fun executarJoc(tauler: Array<BooleanArray>, scanner: Scanner) {
    var jocAcabat = false
    val pecesAnteriors = mutableListOf<Array<BooleanArray>>()
    while (!jocAcabat) {
        val peca = generarPecaAleatoria()
        pecesAnteriors.add(peca)
        mostrarTipusDePeca(peca)
        mostrarTauler(tauler)
        gestionarMoviments(tauler, peca, scanner) // Passant el scanner aquí
        if (comprovarLinies(tauler)) eliminarLinies(tauler)
        jocAcabat = esJocAcabat(tauler)
    }
    println("El joc ha acabat! El tauler ha arribat al límit superior.")
}

/**
 * Genera una peca aleatòria dels tipus disponibles (C, L, T, I).
 *
 * @return Un array bidimensional representant la peca generada.
 * @author Usman i Diego
 * @since 10/12/2025
 */
fun generarPecaAleatoria(): Array<BooleanArray> {
    return when (Random.nextInt(0, 4)) {
        0 -> pecaC()
        1 -> pecaL()
        2 -> pecaT()
        3 -> pecaI()
        else -> throw IllegalStateException("Error en generacio de peca")
    }
}

/**
 * Gestiona el moviment de la peca al tauler de joc.
 * L'usuari pot moure la peca a l'esquerra, a la dreta o deixar-la caure.
 *
 * @param tauler El tauler de joc on es mourà la peca.
 * @param peca La peca actual que es mou.
 * @param scanner El scanner utilitzat per llegir les accions de l'usuari.
 * @author Usman i Diego
 * @since 10/12/2025
 */
fun gestionarMoviments(tauler: Array<BooleanArray>, peca: Array<BooleanArray>, scanner: Scanner) {
    var posicio = tauler[0].size / 2
    var continuarMovent = true

    while (continuarMovent) {
        mostrarTaulerAmbPeca(tauler, peca, posicio) // Mostrar el tauler amb la peça en la seva posició actual
        val accio = demanarAccio(scanner)
        when (accio) {
            1 -> posicio = moureEsquerra(posicio) // Moure cap a l'esquerra
            2 -> posicio = moureDreta(posicio, tauler[0].size) // Moure cap a la dreta
            3 -> {
                continuarMovent = false // Deixar caure la peça
                ferCaureLesPeces(tauler, peca, posicio)
            }
        }
    }
}

/**
 * Mostra el tauler amb la peça a la seva posició actual.
 *
 * @param tauler El tauler de joc.
 * @param peca La peca que es vol mostrar.
 * @param posicio La posició horitzontal de la peça.
 * @author Usman i Diego
 * @since 10/12/2025
 */
fun mostrarTaulerAmbPeca(tauler: Array<BooleanArray>, peca: Array<BooleanArray>, posicio: Int) {
    // Crea una còpia del tauler per mostrar la peça temporalment
    val taulerTemporal = Array(tauler.size) { tauler[it].copyOf() }

    // Inserir la peça al tauler temporal
    for (fila in peca.indices) {
        for (columna in peca[fila].indices) {
            if (peca[fila][columna]) {
                val filaTauler = fila
                val columnaTauler = columna + posicio
                if (filaTauler in taulerTemporal.indices && columnaTauler in taulerTemporal[filaTauler].indices) {
                    taulerTemporal[filaTauler][columnaTauler] = true
                }
            }
        }
    }

    // Mostrar el tauler temporal
    println("Tauler amb la peça en moviment:")
    for (fila in taulerTemporal) {
        println(fila.joinToString(" ") { if (it) "x" else "-" })
    }
    println()
}


/**
 * Crea una peca en forma de "C" (quadrada de 2x2).
 *
 * @return Un array bidimensional representant una peca en forma de "C".
 * @author Usman i Diego
 * @since 10/12/2025
 */
fun pecaC(): Array<BooleanArray> {
    return arrayOf(
        booleanArrayOf(true, true),
        booleanArrayOf(true, true)
    )
}

/**
 * Crea una peca en forma de "L" (3x2 amb una part extendida).
 *
 * @return Un array bidimensional representant una peca en forma de "L".
 * @author Usman i Diego
 * @since 10/12/2025
 */
fun pecaL(): Array<BooleanArray> {
    return arrayOf(
        booleanArrayOf(true),
        booleanArrayOf(true, true, true)
    )
}

/**
 * Crea una peca en forma de "T" (3x2 amb una part central).
 *
 * @return Un array bidimensional representant una peca en forma de "T".
 * @author Usman i Diego
 * @since 10/12/2025
 */
fun pecaT(): Array<BooleanArray> {
    return arrayOf(
        booleanArrayOf(false, true),
        booleanArrayOf(false, true),
        booleanArrayOf(true, true)
    )
}

/**
 * Crea una peca en forma d'"I" (columna de 4x1).
 *
 * @return Un array bidimensional representant una peca en forma d'"I".
 * @author Usman i Diego
 * @since 10/12/2025
 */
fun pecaI(): Array<BooleanArray> {
    return arrayOf(
        booleanArrayOf(true),
        booleanArrayOf(true),
        booleanArrayOf(true),
        booleanArrayOf(true)
    )
}

/**
 * Mostra el tipus de peca generada a la consola.
 *
 * @param peca La peca que es vol mostrar.
 * @author Usman i Diego
 * @since 10/12/2025
 */
fun mostrarTipusDePeca(peca: Array<BooleanArray>) {
    println("Tipus de peca generada:")
    for (fila in peca) {
        println(fila.joinToString("") { if (it) "x" else " " })
    }
}

/**
 * Demana una acció a l'usuari per moure la peca.
 *
 * @param scanner El scanner utilitzat per llegir l'entrada de l'usuari.
 * @return El valor de l'acció seleccionada per l'usuari.
 * @author Usman i Diego
 * @since 10/12/2025
 */
fun demanarAccio(scanner: Scanner): Int {
    println("Selecciona una acció: 1:Esquerra / 2:Dreta / 3:Deixar caure")
    return scanner.nextInt() // Usamos nextInt() per llegir l'acció
}

/**
 * Mou la peca cap a l'esquerra si és possible.
 *
 * @param posicio La posició actual de la peca.
 * @return La nova posició de la peca després del moviment.
 * @author Usman i Diego
 * @since 10/12/2025
 */
fun moureEsquerra(posicio: Int): Int {
    return if (posicio > 0) posicio - 1 else posicio
}

/**
 * Mou la peca cap a la dreta si és possible.
 *
 * @param posicio La posició actual de la peca.
 * @param ampladaTauler L'amplada del tauler.
 * @return La nova posició de la peca després del moviment.
 * @author Usman i Diego
 * @since 10/12/2025
 */
fun moureDreta(posicio: Int, ampladaTauler: Int): Int {
    return if (posicio < ampladaTauler - 1) posicio + 1 else posicio
}

/**
 * Fa caure les peces fins que no poden caure més, i les col·loca al tauler.
 *
 * @param tauler El tauler de joc on es col·locarà la peca.
 * @param peca La peca que s'ha de fer caure.
 * @param posicio La posició horitzontal de la peca.
 * @author Usman i Diego
 * @since 10/12/2025
 */
fun ferCaureLesPeces(tauler: Array<BooleanArray>, peca: Array<BooleanArray>, posicio: Int) {
    var desplacamentVertical = 0
    while (potCaure(tauler, peca, desplacamentVertical, posicio)) {
        desplacamentVertical++
    }
    // Comprovar si la peça sobrepassa el límit superior
    if (desplacamentVertical - 1 < 0) {
        println("La peça ha sobrepassat el límit superior. El joc ha acabat!")
        System.exit(0) // Finalitzar el programa
    }
    colLocarAlTauler(tauler, peca, desplacamentVertical - 1, posicio)
}

/**
 * Comprova si la peca pot continuar caient en la posició indicada.
 *
 * @param tauler El tauler de joc.
 * @param peca La peca que s'ha de verificar.
 * @param desplaçamentVertical La distància vertical des de la qual es vol caure la peca.
 * @param posicio La posició horitzontal de la peca.
 * @return Si la peca pot continuar caient o no.
 * @author Usman i Diego
 * @since 10/12/2025
 */
fun potCaure(tauler: Array<BooleanArray>, peca: Array<BooleanArray>, desplaçamentVertical: Int, posicio: Int): Boolean {
    for (indexFila in peca.indices) {
        for (indexColumna in peca[indexFila].indices) {
            if (peca[indexFila][indexColumna]) {
                val filaTauler = indexFila + desplaçamentVertical
                val columnaTauler = indexColumna + posicio
                if (filaTauler >= tauler.size || columnaTauler !in tauler[filaTauler].indices || tauler[filaTauler][columnaTauler]) {
                    return false
                }
            }
        }
    }
    return true
}

/**
 * Col·loca la peca al tauler en la posició especificada.
 *
 * @param tauler El tauler de joc on es col·locarà la peca.
 * @param peca La peca que s'ha de col·locar.
 * @param desplaçamentVertical La distància vertical on col·locar la peca.
 * @param posicio La posició horitzontal on col·locar la peca.
 * @author Usman i Diego
 * @since 10/12/2025
 */
fun colLocarAlTauler(tauler: Array<BooleanArray>, peca: Array<BooleanArray>, desplaçamentVertical: Int, posicio: Int) {
    for (indexFila in peca.indices) {
        for (indexColumna in peca[indexFila].indices) {
            if (peca[indexFila][indexColumna]) {
                tauler[indexFila + desplaçamentVertical][indexColumna + posicio] = true
            }
        }
    }
}

/**
 * Mostra el tauler de joc actual a la consola.
 *
 * @param tauler El tauler de joc que es vol mostrar.
 * @author Usman i Diego
 * @since 10/12/2025
 */
fun mostrarTauler(tauler: Array<BooleanArray>) {
    for (fila in tauler) {
        println(fila.joinToString(" ") { if (it) "x" else "-" })
    }
    println()
}

/**
 * Comprova si hi ha alguna línia completa al tauler.
 *
 * @param tauler El tauler de joc.
 * @return True si hi ha almenys una línia completa, false en cas contrari.
 * @author Usman i Diego
 * @since 10/12/2025
 */
fun comprovarLinies(tauler: Array<BooleanArray>): Boolean {
    return tauler.any { fila -> fila.all { it } }
}

/**
 * Elimina les línies completes del tauler i fa que les peces restants caiguin cap avall.
 *
 * @param tauler El tauler de joc.
 * @author Usman i Diego
 * @since 10/12/2025
 */
fun eliminarLinies(tauler: Array<BooleanArray>) {
    val amplada = tauler[0].size
    val filesRestants = mutableListOf<BooleanArray>()

    // Mantén solo las filas incompletas (que no están llenas)
    for (fila in tauler) {
        if (!fila.all { it }) {
            filesRestants.add(fila)
        }
    }

    // Añadir filas vacías al principio para mantener la misma altura del tablero
    while (filesRestants.size < tauler.size) {
        filesRestants.add(0, BooleanArray(amplada) { false })
    }

    // Actualizar el tablero con las filas reorganizadas
    for (i in tauler.indices) {
        tauler[i] = filesRestants[i]
    }
}


/**
 * Comprova si el joc ha acabat, és a dir, si el tauler ha arribat al límit superior
 * o alguna peça intenta sobrepassar els límits del tauler.
 *
 * @param tauler El tauler de joc.
 * @return True si el joc ha acabat, false en cas contrari.
 * @author Usman i Diego
 * @since 10/12/2025
 */
fun esJocAcabat(tauler: Array<BooleanArray>): Boolean {
    // Comprovar si alguna fila per sobre del tauler està ocupada
    return tauler[0].any { it } // Si la primera fila té alguna peça, el joc s'ha acabat
}