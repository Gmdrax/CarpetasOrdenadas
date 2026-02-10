import java.util.Scanner

//Fes un programa on, introduit el número de començals i el preu d'un sopar (que pot contenir cèntims), imprimeixi quan haurà de
//pagar cada començal.
fun main() {

    val scan = Scanner(System.`in`)

    var gente : Double = scan.nextDouble()
    var precio : Double = scan.nextDouble()


    println( "" + (precio/gente) + "€" )

}

