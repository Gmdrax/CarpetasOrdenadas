import java.util.Scanner

//Una web d'habitatges de lloguer ens ha proposat una ampliació. Volen mostrar l'àrea de les habitacions per llogar. Fes un
//programa que ens ajudi a calcular les dimensions d'una habitació. Llegeix l'amplada i la llargada en metres (enters) i mostra'n
//l'àrea.

fun main() {

    val scan = Scanner(System.`in`)

    var numero1 : Int = scan.nextInt()
    var numero2 : Int = scan.nextInt()

    println(numero1 * numero2)

}

