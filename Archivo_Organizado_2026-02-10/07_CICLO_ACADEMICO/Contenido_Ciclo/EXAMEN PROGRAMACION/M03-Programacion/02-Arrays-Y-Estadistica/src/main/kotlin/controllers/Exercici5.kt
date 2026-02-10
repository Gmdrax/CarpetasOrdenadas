import java.util.Scanner

/**
 * sumaElements()
 * Funció que retorna en un enter la suma dels elements d’un vector d’enters.
 *
 * @param nums Array d'enters (Int) que volem sumar.
 * @return La suma total dels elements de l'array com a enter (Int).
 */
fun sumaElements(nums: Array<Int>): Int {
    var suma = 0
    for (num in nums) {
        suma += num
    }
    return suma
}

fun main() {
    val scanner = Scanner(System.`in`)

    if (scanner.hasNextInt()) {
        val mida = scanner.nextInt()
        val nums = Array(mida) { 0 }

        for (i in 0 until mida) {
            if (scanner.hasNextInt()) {
                nums[i] = scanner.nextInt()
            }
        }

        // Cridem a la funció
        val resultat = sumaElements(nums)

        //Mostrem el resultat
        println("$resultat")
    } else {
        println("Entrada no vàlida.")
    }
}