import java.util.Scanner

//Fes un programa on, introduit el número de començals i el preu d'un sopar (que pot contenir cèntims), imprimeixi quan haurà de
//pagar cada començal.

fun main() {

    val scan = Scanner(System.`in`)

    //Rebem les dades de quants començals hi han.
    println("Cual es el numero de començals?")
    var numComen : Double = scan.nextDouble()
    //Rebem el preu de quant ha cosatat el sopar.
    println("Cual es el preu del sopar?")
    var preuSopar : Double = scan.nextDouble()

    //Defininm la variable preuFinal y dividim el preu del sopar entre els començals.
    var preuFinal = (preuSopar/numComen)

    //Mostrem el preu final del sopar per cada persona.
    println("El preu per cada comensal es de ${preuFinal}€" )

}

