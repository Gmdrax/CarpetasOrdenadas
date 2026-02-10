import java.util.Scanner

//Feu un programa que rebi una temperatura en graus Celsius i la converteixi en graus Fahrenheit
fun main() {

    val scan = Scanner(System.`in`)

    var numero1 : Double = scan.nextDouble()


    println( (numero1 * 9/5) + 32)

}

