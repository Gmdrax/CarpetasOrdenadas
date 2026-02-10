import java.util.Scanner

//Fes un programa que afegeixi 1 segon un nombre de segons determinat.
fun main() {

    val scan = Scanner(System.`in`)

    var numero1 : Double = scan.nextDouble()
    var resultado : Boolean

    if ( numero1 <= 18 ){
        resultado = false
    }

    else {
        resultado = true
    }

    println( resultado )
}

