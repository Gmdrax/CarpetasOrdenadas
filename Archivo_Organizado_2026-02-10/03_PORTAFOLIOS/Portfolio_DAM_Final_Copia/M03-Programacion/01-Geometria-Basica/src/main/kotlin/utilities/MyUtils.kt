package utilities
import kotlin.math.sqrt
import java.util.Scanner

/**
 * readInt()
 * llegeix un numero introduit per usuari
 *
 * @param scanner Scanner
 * @param log Missatge per usuari
 * @param min El minim de valor que admite
 * @return numero int llegit
 */
fun readInt(scanner: Scanner, log: String, min: Int): Int {
    var correcte = false
    var sortida = 0
    //Hasta que no sea un valor valido continuara leyendo
    while (!correcte) {
        print(log)
        var num = scanner.next()
        if (num.toIntOrNull()!=null) { //si es posible convertir en numero, i mes gran que minim
            sortida = num.toInt()
            if (sortida>min) correcte = true
        }
    }
    return sortida
}

/**
 * areaTriangle()
 * Calcula la area de un triangle aprtir dels costats
 *
 * @param num1 numero 1
 * @param num2 numero 2
 * @param num3 numero 3
 * @return retorna el resultat de area en double
 */
fun areaTriangle(num1: Int, num2: Int, num3: Int): Double {
    //calcula la area
    var s: Double = (num1 + num2 + num3) / 2.0
    var area = sqrt(s*(s-num1)*(s-num2)*(s-num3))
    return area
}
/**
 * Funció que incrementa un número amb una quantitat donada.
 *
 * @param numero El número inicial que volem incrementar.
 * @param quantitat La quantitat amb la qual s'incrementarà el número.
 * @return El resultat de la suma entre el número inicial i la quantitat.
 */

fun IncrementarNumero(numero: Int, quantitat: Int): Int {
    return numero + quantitat
}
