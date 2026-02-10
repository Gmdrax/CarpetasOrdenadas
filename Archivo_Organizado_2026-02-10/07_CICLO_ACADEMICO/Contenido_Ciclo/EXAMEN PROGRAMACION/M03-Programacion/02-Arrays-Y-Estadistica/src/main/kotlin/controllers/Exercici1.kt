package controllers
import java.util.Scanner
import utilities.*

fun main(){
    val scan = Scanner(System.`in`)

    //llegir array de float
    val arrFloat = llegirFloats(scan)

    //fer la mitjana
    val result = mitjana(arrFloat)

    //resultat
    println("La mitjana es: $result")
}