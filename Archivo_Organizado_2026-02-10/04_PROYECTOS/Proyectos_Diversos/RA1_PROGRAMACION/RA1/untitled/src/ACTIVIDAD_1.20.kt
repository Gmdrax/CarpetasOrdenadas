import java.util.Scanner

//Fes un programa que rebi dos nombres decimals i torni si són iguals o no
fun main() {

    val scan = Scanner(System.`in`)

    var numero1 : Double = scan.nextDouble()
    var numero2 : Double = scan.nextDouble()
    var resultado : Boolean

    if ( numero1 == numero2 ){
        resultado = true
    }

    else {
        resultado = false
    }

    println( resultado )
}
