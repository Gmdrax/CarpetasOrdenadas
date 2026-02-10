package controllers
import utilities.*
import java.util.Locale
import java.util.Scanner
import kotlin.math.abs

/**
 * main()
 * programa que calculara la area de un triangle
 *
 * @date 27/11/2025
 */
fun main() {
    val sc = Scanner(System.`in`).useLocale(Locale.UK)
    //llegir valos de entrada
    var num1 = readInt(sc, "Introduce el primer numero: ",0)
    var num2 = readInt(sc, "Introduce el segundo numero: ",0)
    var num3 = readInt(sc, "Introduce el tercer numero: ",0)
    //si pot formar mostrara la area i en cas contrari -1
    if (potFormaTriangle(num1, num2, num3)){
        println("Area es: ${areaTriangle(num1, num2, num3)}")
    } else println(-1)
    sc.close()
}

/**
 * potFormaTriangle()
 * Mira si amb els numeros que tenim es por formar un triangle o no
 *
 * @param n1 numero 1
 * @param n2 numero 2
 * @param n3 numero 3
 * @return Boolean de si es correcte o no
 */
fun potFormaTriangle(n1: Int, n2: Int, n3: Int): Boolean{
    var siForma = false
    //si cumpleix la condicio es posara true
    if ((abs(n1-n3)<n2 && n2<(n1+n3))){
        siForma = true
    }
    return siForma
}