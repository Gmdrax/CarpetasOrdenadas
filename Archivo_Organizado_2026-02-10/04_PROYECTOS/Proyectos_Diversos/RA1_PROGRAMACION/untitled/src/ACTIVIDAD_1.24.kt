import java.util.Scanner

//Fes un programa que rebi el valor del nivell de riure de 5 persones i comprovi si la dita és certa.
fun main() {

    val scan = Scanner(System.`in`)

    var numero = scan.next().single()

    println( numero >= '0' && numero <= '9' )
}
