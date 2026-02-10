package utilities
import java.util.Scanner

/**
 * readInt()
 * llegeix un numero introduit per usuari
 *
 * @param scanner Scanner
 * @param log Missatge per usuari
 * @param min El minim de valor que admite
 * @return numero int llegit
 */
fun readInt(scanner: Scanner, log: String, min: Int): Int {
    var correcte = false
    var sortida = 0
    //Hasta que no sea un valor valido continuara leyendo
    while (!correcte) {
        print(log)
        var num = scanner.next()
        if (num.toIntOrNull()!=null) { //si es posible convertir en numero, i mes gran que minim
            sortida = num.toInt()
            if (sortida>min) correcte = true
        }
    }
    return sortida
}

/**
 * llegirFloats()
 * llegir una sequencia de numeros com a floats
 *
 * @param scanner Scanner
 * @return retorna array de Float
 */
fun llegirFloats(scanner: Scanner): Array<Float> {
    println("Quants numeros vols: ")
    var size = scanner.next()
    var num = 0
    if (size.toIntOrNull() != null) {
        num = size.toInt()
        // Ara que ja sabem num, creem l'array
        var numeros = Array<Float>(num) { 0f }
        println("Introdueix la sequencia de numeros que vols calcular separat per espai: ")
        for (i in 0 until num) {
            numeros[i] = scanner.nextFloat()
        }
        return numeros
    } else { //Si el tamany que introduce no es un Int
        println("No se ha podido leer, introduce de nuevo")
        return llegirFloats(scanner)
    }
}


/**
 * mitjana()
 * calcula la mitjana de un array
 *
 * @param num Array de numeros Float
 * @return Resultat de mitjana en Float
 */
fun mitjana (num:Array<Float>) : Float{
    val size = num.size
    val result = sumaArrayFloat(num) / size
    return result
}

/**
 * sumaArrayFloat()
 * suma elements de un Array Float
 *
 * @param num Array de numeros en Float
 * @return Total
 */
fun sumaArrayFloat(nums: Array<Float>): Float{
    var resultat = 0f
    for (i in nums){
        resultat+=i
    }
    return resultat
}