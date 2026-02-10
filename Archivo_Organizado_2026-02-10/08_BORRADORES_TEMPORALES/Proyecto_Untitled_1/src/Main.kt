import java.util.Scanner
import java.util.Locale

//Entrada
//L'entrada comença amb un número N que indica el nombre de productes comprats.
//A continuació vindran N línies on tindrem el nom del producte (String) i el preu del producte (float) que hem comprat
//Finalment tindrem una línia amb el nom del producte que volem comprovar.

//Sortida
//Si no trobem el producte li direm "NO N'HI HAVIA"
//Si trobem el producte li direm "SI, M'HA COSTAT " seguit del preu i, si no és el primer producte en ordre alfabètic,
//seguirem amb "I TAMBE TINC " producte " A " preu , amb la informació del producte anterior en ordre alfabètic

data class Producte(
    val nom: String,
    val preu: Float
)

fun main() {
    val scanner = Scanner(System.`in`).useLocale(Locale.US)

    //lemos el numero de repeticiones
    val numRepeticions = scanner.nextInt()

    //creamos un lista para guardar todos los datos
    val llistaProductes = mutableListOf<Producte>()

    //leemos el precio y le nombre y lo metemos en la lista
    repeat(numRepeticions) {
        val nom = scanner.next()
        val preu = scanner.nextFloat()
        llistaProductes.add(Producte(nom, preu))

    }

    val PalabraaBuscar = scanner.nextLine()

    if (llistaProductes == PalabraaBuscar)

    //mostramos los resultados en pantalla
    println("SI, M'HA COSTAT ${resultado.preu}")
}