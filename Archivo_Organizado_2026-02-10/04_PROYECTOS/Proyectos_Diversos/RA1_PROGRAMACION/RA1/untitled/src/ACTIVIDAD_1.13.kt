import java.util.Scanner

//Escriu un programa que llegeixi un una temperatura i un augment d’aquest, el programa ha d’imprimir per pantalla quina és la
//temperatura amb l’augment aplicat.
fun main() {

    val scan = Scanner(System.`in`)

    var numero1 : Double = scan.nextDouble()
    var numero2 : Double = scan.nextDouble()


    println( "La temperatura actual es " + (numero1 + numero2) + "°" )

}

