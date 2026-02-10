import java.util.Scanner

//Fes un programa que rebi el valor del nivell de riure de 5 persones i comprovi si la dita és certa.
fun main() {

    val scan = Scanner(System.`in`)

    var lletra = scan.next().lowercase()

    var lletra2 = scan.next().uppercase()

    println( lletra2 >= "A" && lletra2 <= "Z"|| lletra == "a" && lletra <= "z")
}
