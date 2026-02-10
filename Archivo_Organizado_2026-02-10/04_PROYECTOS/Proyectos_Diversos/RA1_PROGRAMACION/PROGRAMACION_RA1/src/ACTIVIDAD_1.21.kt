import java.util.Scanner

//Fes un programa que rebi tres nombres enters i torni si són iguals o no
fun main() {

    val scan = Scanner(System.`in`)

    var numero1 : Int = scan.nextInt()

    var numero2 : Int = scan.nextInt()

    var numero3 : Int = scan.nextInt()

    println( numero1 == numero2 && numero2 == numero3 && numero3 == numero1 )
}
