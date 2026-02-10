import java.util.Scanner

//Fes un programa que rebi el valor del nivell de riure de 5 persones i comprovi si la dita és certa.
fun main() {

    val scan = Scanner(System.`in`)

    var lletra : Char = scan.next().single()

    var resultado : Boolean

    if ( lletra > 'a' ) {
        resultado = true
    }


    else {
        resultado = false
    }

    println( resultado )
}
