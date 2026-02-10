package controllers
import java.util.Scanner
import utilities.*

fun main(){
    val scan = Scanner(System.`in`)
    val arrFloat = llegirFloats(scan)
    val result = mitjana(arrFloat)
    println("La mitjana es: $result")
}