import java.util.Scanner

//Fes un programa que rebi dos nombres enters i imprimeixi true si el primer és major que el segon, false en cap altre cas.
fun main() {

    val scan = Scanner(System.`in`)

    var numero1 : Double = scan.nextDouble()
    var numero2 : Double = scan.nextDouble()
    var resultado : Boolean

    if ( numero1 > numero2 ){
        resultado = true
    }

    else {
        resultado = false
    }

    println( resultado )
}
