import java.util.Scanner

//Fes un programa que rebi dos nombres enters i imprimeixi true si el primer és major que el segon, false en cap altre cas.
fun main() {

    val scan = Scanner(System.`in`)

    var numero1 : Int = scan.nextInt()
    var numero2 : Int = scan.nextInt()

    println( numero1 > numero2)
}
