import java.util.Scanner

//Fes un programa que rebi el valor del nivell de riure de 5 persones i comprovi si la dita és certa.
fun main() {

    val scan = Scanner(System.`in`)

    var numero1 : Int = scan.nextInt()
    var numero2 : Int = scan.nextInt()
    var numero3 : Int = scan.nextInt()
    var numero4 : Int = scan.nextInt()
    var numero5 : Int = scan.nextInt()

    println( numero5 > numero4 && numero3 > numero2 && numero2 > numero1 && numero4 > numero3 )
}
