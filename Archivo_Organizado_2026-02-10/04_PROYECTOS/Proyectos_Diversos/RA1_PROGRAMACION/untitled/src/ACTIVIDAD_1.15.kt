import java.util.Scanner

//Fes un programa que afegeixi 1 segon un nombre de segons determinat.
fun main() {

    val scan = Scanner(System.`in`)

    var numero1 : Int = scan.nextInt()
    var numero2 = (numero1+1) %60

    println(numero2)

}

