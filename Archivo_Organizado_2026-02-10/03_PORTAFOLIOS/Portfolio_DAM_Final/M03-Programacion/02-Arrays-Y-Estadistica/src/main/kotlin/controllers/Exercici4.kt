package controllers

import java.util.Scanner
import utilities.*

/**
 * Comprova si la cadena 'b' és prefix de la cadena 'a'.
 *
 * @param a La cadena principal on buscarem.
 * @param b La cadena que volem comprovar si és al principi.
 * @return Retorna true si 'a' comença amb 'b', o false en cas contrari.
 */
fun esPrefix(a: String, b: String): Boolean {

    //utilitzem la funció nativa de kotlin per veure si comença per b
    return a.startsWith(b)
}

fun main() {
    var scan = Scanner(System.`in`)

    //llegim la primera paraula
    var paraulaA = scan.next()

    //llegim la segona paraula (b), que és el possible prefix
    var paraulaB = scan.next()

    //cridem la funció i guardem el resultat (boolean)
    var resultat = esPrefix(paraulaA, paraulaB)

    //imprimim el resultat (true o false)
    println(resultat)
}