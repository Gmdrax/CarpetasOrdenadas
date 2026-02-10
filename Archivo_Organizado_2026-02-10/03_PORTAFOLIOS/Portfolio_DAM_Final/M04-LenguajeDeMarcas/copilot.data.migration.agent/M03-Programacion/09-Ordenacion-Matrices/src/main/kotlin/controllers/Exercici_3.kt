package controllers

/**
 * mergeSort
 * Funció que separa un array en dues mitads de manera recursiva fins arribar a separar l'array en peces individuals per després ordenar cada separació
 *
 * @param arr L'array que es vol separar.
 * @return L'array ordenat.
 * @author Gerard, Joel, Leo
 */
fun mergeSort(arr: IntArray): IntArray{
    //Cas Base, l'array ha arribat al tamany mínim, i per tant es pot retornar
    if (arr.size <= 1){
        return arr
    }
    //Es calcula la posició de la mitad de l'array
    val mitad: Int = arr.size/2
    //Es parteix l'array en dos arrays
    var left: IntArray = arr.sliceArray(0 until mitad)
    var right: IntArray = arr.sliceArray(mitad until arr.size)
    //Cas Recursiu, es crida a merge per ordenar amb els valors de la crida a mergeSort de left i right
    return merge(mergeSort(left), mergeSort(right))
}

/**
 * merge
 * Funció que compara dos arrays ordenats i crea un sol array resultant d'ordenar els dos arrays junts.
 *
 * @param left El primer array.
 * @param right El segon array.
 * @return L'array resultant
 * @author Gerard, Joel, Leo
 */
fun merge(left: IntArray, right: IntArray): IntArray{
    //Es declaren dos iteradors per iterar left i right
    var leftIndex: Int = 0
    var rightIndex: Int = 0
    //Es declara un array de la mida de l'array resultant de combinar left i right
    val ordenat: IntArray = IntArray (left.size + right.size)
    //S'iteren els dos arrays per ordenar-los comparant a cada iteració les dues primeres posicions dels arrays.
    for (ordenatIndex in 0 until ordenat.size){
        when{
            leftIndex >= left.size -> ordenat[ordenatIndex] = right[rightIndex++]
            rightIndex >= right.size -> ordenat[ordenatIndex] = left[leftIndex++]
            left[leftIndex] <= right[rightIndex] -> ordenat[ordenatIndex] = left[leftIndex++]
            else -> ordenat[ordenatIndex] = right[rightIndex++]
        }
    }
    return ordenat
}

fun main(){
}