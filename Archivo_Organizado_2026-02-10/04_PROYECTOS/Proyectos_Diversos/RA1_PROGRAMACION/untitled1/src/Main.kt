import java.util.Scanner

//codigo simular un juego de piedra papel o tijera con numeros
fun main() {

    val scan = Scanner(System.`in`)

    //leemos el numero que ha peusto cada jugador
    var jugador1: Int = scan.nextInt()
    var jugador2: Int = scan.nextInt()

    val PIEDRA = 1
    val PAPEl = 2
    val TIJERAS = 3

    when (jugador1 == jugador2){
        in 1..3 -> println("EMPAT")
    }
}
