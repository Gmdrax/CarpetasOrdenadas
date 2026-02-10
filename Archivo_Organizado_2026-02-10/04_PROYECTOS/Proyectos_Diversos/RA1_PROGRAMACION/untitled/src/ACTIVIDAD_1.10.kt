import java.util.Scanner

//Llegeix el diàmetre d'una pizza rodona i imprimeix la seva superfície. Pots usar Math.PI per escriure el valor de Pi.
fun main() {

    val scan = Scanner(System.`in`)

    var numero1 : Double = scan.nextDouble()


    println( Math.PI * ((numero1/2) * (numero1/2)) )

}

