package controllers

/**
 * rec_alg_euclides
 * Función que calcula el máximo común divisor de dos números mayores que 0.
 *
 * @param primerNre El primer número introducido.
 * @param segonNre El segundo número introducido.
 * @return El máximo común divisor de los dos números.
 * @author Gerard, Joel, Leo
 */
fun rec_alg_euclides (primerNre: Int, segonNre: Int): Int{
    //Poso el maximComuDivisor a 1 perque es el valor del MCD en cas de que no hi hagin divisors en comú.
    var maximComuDivisor = 1
    //Aplico l'algoritme d'euclides
    if (primerNre == segonNre) maximComuDivisor = primerNre
    else if (primerNre > segonNre) maximComuDivisor = rec_alg_euclides(primerNre - segonNre, segonNre)
    else maximComuDivisor = rec_alg_euclides(primerNre, segonNre - primerNre)
    //Retorno el maximComuDivisor
    return maximComuDivisor
}

/**
 * rec_alg_euclides_expandit
 * Función que calcula el máximo común divisor de dos números sin importar si son positivos o negativos.
 *
 * @param primerNre El primer número introducido.
 * @param segonNre El segundo número introducido.
 * @return El máximo común divisor de los dos números, 1 en caso de no tener divisores en común o 0.
 * @author Gerard, Joel, Leo
 */
fun rec_alg_euclides_expandit (primerNre: Int, segonNre: Int): Int{
    //Poso el maximComuDivisor a 1 perque es el valor del MCD en cas de que no hi hagin divisors en comú.
    var maximComuDivisor = 1
    //Declaro dues variables per a poder utilitzar el valor absolut de primerNre i segonNre
    var primer: Int = primerNre
    var segon: Int = segonNre
    if (primerNre < 0) primer = primerNre * -1
    if (segonNre < 0) segon = segonNre * -1
    //Nomes aplico l'algoritme d'euclides si primer i segon son diferents de 0 en cas contrari poso el maximComuDivisor a 0
    if (primer != 0 && segon != 0){
        if (primer == segon) maximComuDivisor = primer
        else if (primer > segon) maximComuDivisor = rec_alg_euclides(primer - segon, segon)
        else maximComuDivisor = rec_alg_euclides(primer, segon - primer)
    }
    else maximComuDivisor = 0
    //Retorno el maximComuDivisor
    return maximComuDivisor
}

fun main(){
}