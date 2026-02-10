import java.util.Scanner

//Fes un programa que rebi el valor del nivell de riure de 5 persones i comprovi si la dita és certa.
fun main() {

    val scan = Scanner(System.`in`)

    var lletra : Char = scan.next().single()

    println( lletra >= 'A' && lletra <= 'Z'|| lletra == 'a' && lletra <= 'z')
}
