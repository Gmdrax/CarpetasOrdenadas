import java.util.Scanner

//Per poder fer un estudi de la ventilació d'una aula necessitem poder calcular la quantitat d'aire que hi cap en una habitació.
//Llegeix les 3 dimensions de l'aula i imprimeix per pantalla quin volum té.
fun main() {

    val scan = Scanner(System.`in`)

    var numero1 : Double = scan.nextDouble()
    var numero2 : Double = scan.nextDouble()
    var numero3 : Double = scan.nextDouble()

    println( numero1 * numero2 * numero3 )

}

