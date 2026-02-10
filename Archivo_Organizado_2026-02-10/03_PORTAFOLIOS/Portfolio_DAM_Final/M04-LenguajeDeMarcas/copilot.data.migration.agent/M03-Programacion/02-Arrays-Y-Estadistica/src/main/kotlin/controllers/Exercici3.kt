package controllers
import java.util.Scanner
import utilities.*

/**
 * Incrementa cada posició de l'array en la quantitat indicada.
 *
 * Aquesta funció modifica directament l'array original passat per paràmetre.
 *
 * @param nums Array d'enters que es modificarà.
 * @param quantitat Valor enter a sumar a cada element (pot ser negatiu).
 */
fun incrementarArray(nums: Array<Int>, quantitat: Int) {

    //Recorregut per índex per modificar el contingut de l'array original
    for (i in nums.indices) {
        nums[i] = nums[i] + quantitat
    }
}

/**
 * Llegeix un array d'enters des de l'Scanner.
 *
 * @param scan L'objecte Scanner per llegir l'entrada.
 * @return Un array d'Int amb els valors llegits. Si falla, retorna un array buit.
 */
fun readArrayInt(scan: Scanner): Array<Int> {
    //llegim la mida
    if (scan.hasNextInt()) {

        //llegim la mida del array
        val mida = scan.nextInt()

        //creem el array
        val array = Array(mida) { 0 }

        // llegim els elements un a un
        for (i in 0 until mida) {
            if (scan.hasNextInt()) {
                array[i] = scan.nextInt()
            }
        }
        return array
    }
    return emptyArray()
}




fun main(){
    var scan  = Scanner(System.`in`)

    //leemos los numeros del array
    val nums = readArrayInt(scan)

    //leemos la cantidad
    var quantitat = scan.nextInt()

    //usamos la funciona para incrementar el array
    incrementarArray(nums, quantitat)

    //mostramos el resultado
    println(nums.contentToString())

}