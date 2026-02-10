import java.util.Scanner

//Fes un programa que rebi un valor booleà i et retorni el valor contrari
fun main() {

    val scan = Scanner(System.`in`)

    var numero1 : Boolean = scan.nextBoolean()
    var resultado : Boolean

    if ( numero1 ){
        resultado = false
    }

    else {
        resultado = true
    }

    println( resultado )
}
