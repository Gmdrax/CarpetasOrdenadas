import java.util.Scanner

//Llegeix el preu original i el preu actual i imprimeix el descompte (en %).

fun main() {

    val scan = Scanner(System.`in`)


    println("cual es el preu original")
    var preuOriginal = scan.nextDouble()
    println("cual es el preu actual?")
    var preuActual = scan.nextDouble()



    println("${(100 - (preuActual * 100) / preuOriginal)} %")

}


