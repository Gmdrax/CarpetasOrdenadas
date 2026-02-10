import java.util.Scanner
import java.util.Locale

// ==========================================
// 1. LECTURA Y CREACIÓN
// ==========================================

fun crearScanner(): Scanner {
    return Scanner(System.`in`).useLocale(Locale.US)
}

/**
 * Lee una línea completa de texto.
 * Útil para leer nombres compuestos o frases: "Juan Perez"
 */
fun leerFrase(scan: Scanner): String {
    // Asegúrate de haber hecho scan.nextLine() antes si venías de leer números
    return scan.nextLine()
}

/**
 * Lee una sola palabra (hasta el primer espacio).
 */
fun leerPalabra(scan: Scanner): String {
    return scan.next()
}

// ==========================================
// 2. PROPIEDADES BÁSICAS (Diapositiva: Properties)
// ==========================================

/**
 * Imprime información básica del String: Tamaño y último índice.
 * Basado en las propiedades .length y .lastIndex del temario.
 */
fun infoBasicaString(texto: String) {
    println("Texto: $texto")
    println("Longitud (length): ${texto.length}")
    println("Último índice (lastIndex): ${texto.lastIndex}") // Equivalente a length - 1
    println("Rango de índices (indices): ${texto.indices}") // Ej: 0..4
}

/**
 * Accede a un carácter específico de forma segura.
 * Evita que el programa falle si pides la posición 10 de una palabra de 5 letras.
 */
fun obtenerCaracterSeguro(texto: String, posicion: Int): Char {
    if (posicion in texto.indices) {
        return texto[posicion]
    } else {
        return ' ' // O devuelve un carácter nulo/vacío si falla
    }
}

// ==========================================
// 3. TRANSFORMACIÓN DE TEXTO (Diapositiva: Funcions)
// ==========================================

/**
 * Convierte a mayúsculas o minúsculas.
 * Uso: .uppercase() y .lowercase()
 */
fun transformarMayusMinus(texto: String, aMayusculas: Boolean): String {
    return if (aMayusculas) {
        texto.uppercase()
    } else {
        texto.lowercase()
    }
}

/**
 * Compara dos textos ignorando si están en mayúsculas o minúsculas.
 * Ej: "Patata" == "patata" -> true
 */
fun esIgualIgnorandoMayusculas(texto1: String, texto2: String): Boolean {
    return texto1.lowercase() == texto2.lowercase()
}

/**
 * Capitalizar: Pone la primera letra en mayúscula y el resto igual.
 */
fun capitalizarTexto(texto: String): String {
    if (texto.isEmpty()) return ""
    return texto.substring(0, 1).uppercase() + texto.substring(1)
}

/**
 * Limpia los espacios sobrantes alrededor del texto.
 * Uso: .trim() (quita inicio y final), .trimStart(), .trimEnd()
 */
fun limpiarEspacios(texto: String): String {
    return texto.trim() // "  hola  " -> "hola"
}

// ==========================================
// 4. BÚSQUEDA Y REEMPLAZO (Diapositiva: Funcions)
// ==========================================

/**
 * Reemplaza caracteres o palabras.
 * Uso: .replace(viejo, nuevo)
 */
fun reemplazarTexto(texto: String, buscar: String, poner: String): String {
    return texto.replace(buscar, poner)
}

/**
 * Extrae una parte del texto (subcadena).
 * Uso: .subSequence(inicio, fin) o .substring(inicio, fin)
 * Recuerda: El final es EXCLUSIVO (no se incluye).
 */
fun cortarTexto(texto: String, inicio: Int, fin: Int): String {
    if (inicio < 0 || fin > texto.length || inicio > fin) return ""
    return texto.substring(inicio, fin)
}

/**
 * Compara si dos textos son iguales (Contenido).
 */
fun sonIguales(texto1: String, texto2: String): Boolean {
    return texto1 == texto2
}

/**
 * [NUEVA] Busca si un texto contiene a otro ignorando mayúsculas/minúsculas.
 * Útil para: Ejercicio "Mosqueperro" (buscar palabras clave).
 */
fun contieneTexto(texto: String, buscar: String): Boolean {
    return texto.contains(buscar, ignoreCase = true)
}

// ==========================================
// 5. MANIPULACIÓN AVANZADA (Diapositiva: Split & CharArray)
// ==========================================

/**
 * Separa una frase en palabras sueltas dado un separador (ej: espacio).
 * Uso: .split(" ")
 * Devuelve una LISTA de palabras.
 */
fun separarEnPalabras(frase: String, separador: String): List<String> {
    return frase.split(separador)
}

/**
 * Convierte el String en un Array de caracteres para poder modificarlo pos a pos.
 * Uso: .toCharArray()
 */
fun modificarCaracter(texto: String, posicion: Int, nuevoChar: Char): String {
    val caracteres = texto.toCharArray()
    if (posicion in caracteres.indices) {
        caracteres[posicion] = nuevoChar
    }
    return String(caracteres)
}

/**
 * Intenta convertir un String a Entero de forma segura.
 */
fun textoANumeroSeguro(texto: String): Int {
    return try {
        texto.toInt()
    } catch (e: Exception) {
        -1
    }
}

// ==========================================
// 6. ITERACIÓN (Diapositiva: Ús)
// ==========================================

/**
 * Recorre el string letra a letra.
 */
fun imprimirLetraALetra(texto: String) {
    for (caracter in texto) {
        println(caracter)
    }
}

/**
 * Recorre el string usando sus índices.
 */
fun imprimirConPosiciones(texto: String) {
    for (i in texto.indices) {
        println("Posición $i: ${texto[i]}")
    }
}

// ==========================================
// 7. RECEPTES PER A EXERCICIS CLÀSSICS (EXÁMENES)
// ==========================================

/**
 * [EXERCICI PENJAT]
 * Oculta les lletres de 'secreto' que NO estiguin a 'letrasVisibles'.
 */
fun enmascararTexto(secreto: String, letrasVisibles: String): String {
    var resultado = ""
    for (letra in secreto) {
        if (letrasVisibles.contains(letra)) {
            resultado += letra
        } else {
            resultado += "*"
        }
    }
    return resultado
}

/**
 * [EXERCICI PENJAT]
 * Compta quantes lletres de l'intent NO estan a la paraula secreta.
 */
fun contarErrores(secreto: String, intento: String): Int {
    var errores = 0
    val intentoLimpio = intento.replace(" ", "")

    for (letra in intentoLimpio) {
        if (!secreto.contains(letra)) {
            errores++
        }
    }
    return errores
}

/**
 * [EXERCICI REVOLUCIÓ B/V]
 * Intercanvia lletres segons una lògica específica (b->v, v->b).
 */
fun intercambiarLetras(texto: String): String {
    return texto.map { letra ->
        when (letra) {
            'b' -> 'v'
            'v' -> 'b'
            'B' -> 'V'
            'V' -> 'B'
            else -> letra
        }
    }.joinToString("")
}

/**
 * [EXERCICI INICIALS MÚSICS]
 * Reemplaça l'última aparició de " i " per ", " per normalitzar llistes.
 */
fun normalizarListaConY(texto: String): String {
    val ultimoSeparador = " i "
    val indice = texto.lastIndexOf(ultimoSeparador)

    if (indice != -1) {
        val parte1 = texto.substring(0, indice)
        val parte2 = texto.substring(indice + ultimoSeparador.length)
        return "$parte1, $parte2"
    }
    return texto
}

/**
 * [EXERCICI INICIALS MÚSICS]
 * Neteja l'accent d'una vocal (Majúscula o minúscula).
 */
fun quitarAcento(caracter: Char): Char {
    return when (caracter) {
        'Á', 'À', 'á', 'à' -> 'A'
        'É', 'È', 'é', 'è' -> 'E'
        'Í', 'Ì', 'í', 'ì' -> 'I'
        'Ó', 'Ò', 'ó', 'ò' -> 'O'
        'Ú', 'Ù', 'ú', 'ù' -> 'U'
        else -> caracter.uppercaseChar()
    }
}

/**
 * [EXERCICI INICIALS MÚSICS]
 * Extreu les inicials d'una llista de noms separats per comes.
 */
fun obtenerIniciales(texto: String): String {
    val textoNormalizado = normalizarListaConY(texto)
    val nombres = textoNormalizado.split(", ")

    var iniciales = ""
    for (nombre in nombres) {
        if (nombre.isNotEmpty()) {
            val primeraLetra = nombre[0]
            iniciales += quitarAcento(primeraLetra)
        }
    }
    return iniciales
}

// ==========================================
// 8. JOCS DE PARAULES I LÒGICA AVANÇADA (NUEVO)
// ==========================================

/**
 * [EXERCICI VICENTE - WORD CHAIN]
 * Compara dues paraules i compta quantes lletres són diferents en la mateixa posició.
 * Important: Les paraules han de tenir la mateixa longitud.
 */
fun contarDiferenciasLetraALetra(palabra1: String, palabra2: String): Int {
    if (palabra1.length != palabra2.length) return -1 // Error de longitud

    var diferencias = 0
    for (i in palabra1.indices) {
        if (palabra1[i] != palabra2[i]) {
            diferencias++
        }
    }
    return diferencias
}

/**
 * [EXERCICI PARAULA MÉS LLARGA]
 * Troba quina és la paraula més llarga d'una frase.
 * Usa 'maxBy' que és molt potent per estalviar bucles.
 */
fun encontrarPalabraMasLarga(frase: String): String {
    val palabras = frase.split(" ") // O split(Regex(" "))
    // maxByOrNull torna la paraula que té la propietat (length) més gran
    return palabras.maxByOrNull { it.length } ?: ""
}

/**
 * [EXERCICI ASADOR - ANAGRAMAS]
 * Comprova si dues paraules tenen exactament les mateixes lletres (Anagrames).
 * Truc: Convertir a array, ordenar i tornar a convertir a string.
 * Exemple: "amor" i "roma" -> true
 */
fun esAnagrama(texto1: String, texto2: String): Boolean {
    val ordenado1 = texto1.toCharArray().sorted().joinToString("")
    val ordenado2 = texto2.toCharArray().sorted().joinToString("")
    return ordenado1 == ordenado2
}

/**
 * [EXERCICI ASADOR]
 * Comprova si la primera meitat d'una paraula és un anagrama de la segona meitat.
 * Útil per a palíndroms estranys o jocs de simetria.
 */
fun esMitadAnagrama(palabra: String): Boolean {
    val mitad = palabra.length / 2
    val primeraMitad = palabra.substring(0, mitad)

    // Si és impar, saltem la lletra del mig
    val inicioSegunda = if (palabra.length % 2 == 0) mitad else mitad + 1
    val segundaMitad = palabra.substring(inicioSegunda)

    return esAnagrama(primeraMitad, segundaMitad)
}

// ==========================================
// 9. FREQÜÈNCIA DE CARÀCTERS (EXERCICI SCRABBLE)
// ==========================================

/**
 * [EXERCICI SCRABBLE]
 * Crea un "histograma" o recompte de freqüència per a les lletres a-z.
 * Torna un array de mida 26 on la posició 0 és la 'a', la 1 la 'b', etc.
 * Vital per saber si pots formar una paraula amb unes fitxes donades.
 */
fun contarFrecuenciaLetras(texto: String): IntArray {
    val conteo = IntArray(26) // Array de 0s per a les 26 lletres angleses
    val textoLimpio = texto.lowercase()
    val alfabeto = "abcdefghijklmnopqrstuvwxyz"

    for (letra in textoLimpio) {
        val indice = alfabeto.indexOf(letra)
        if (indice != -1) {
            conteo[indice]++
        }
    }
    return conteo
}

/**
 * [EXERCICI SCRABBLE]
 * Comprova si pots formar una paraula donades unes fitxes disponibles (array de 26 ints).
 */
fun sePuedeFormarPalabra(palabra: String, fichasDisponibles: IntArray): Boolean {
    // 1. Comptem què necessita la paraula
    val fichasNecesarias = contarFrecuenciaLetras(palabra)

    // 2. Comparem amb el que tenim
    for (i in 0 until 26) {
        if (fichasNecesarias[i] > fichasDisponibles[i]) {
            return false // Necessitem més del que tenim
        }
    }
    return true
}