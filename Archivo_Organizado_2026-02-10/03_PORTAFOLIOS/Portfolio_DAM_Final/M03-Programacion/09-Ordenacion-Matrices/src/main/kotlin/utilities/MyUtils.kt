package utilities

import java.util.Scanner

val sc= Scanner(System.`in`)

/**Funció per demanar un enter
 *
 * @param String En aquest paràmetre has d'escriure un missatge a l'usuari.
 * @return Int - Retorna el numero ingressat en cas de ser un enter.
 * @author Gerard, Joel, Leo
 */
fun demanarEnter(msg: String): Int {
    println(msg)
    var esCorrecte: Boolean = false
    var resultat: Int = 0
    //Fem un bucle per només llegir si el número és un enter.
    while (!esCorrecte) {
        if (sc.hasNextInt()) {
            esCorrecte = true
            resultat = sc.nextInt()
        } else {
            sc.next()
            println("Això no es un enter")
        }
    }
    return resultat
}