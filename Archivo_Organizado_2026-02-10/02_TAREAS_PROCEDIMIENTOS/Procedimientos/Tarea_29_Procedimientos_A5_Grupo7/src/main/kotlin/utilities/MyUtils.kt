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
fun llegirFloats(scanner: Scanner): Array<Float>{
    println("Quants numeros vols: ")
    var size = scanner.next()
    var num = 0
    var arrF = Array<Float>(num){0f}
    if (size.toIntOrNull()!=null){
        num = size.toInt()
        println("Introdueix la sequencia de numeros que vols calcular separat per espai: ")
        var numeros = scanner.nextLine().split(" ")
        for (i in numeros){

        }

    }else{
        println("No se ha podido leer, introduce de nuevo")
        llegirFloats(scanner)
    }

    return arrF
}

/**
 * cpvFloat()
 * comprovacio Float
 *
 * @param numFloat numero de entrada
 * @return float
 */
fun cpvFloat(numFloat: String): Float{
    var result = 0f
    if (numFloat.toFloatOrNull()!=null){
        result = numFloat.toFloat()
        return result
    }
    return result
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