package controllers

import utilities.IncrementarNumero

/**
 * Función que incrementa un número con una cantidad determinada.
 *
 * @param numero El número inicial que se desea incrementar.
 * @param cantidad La cantidad que se sumará al número inicial.
 * @return El resultado de sumar el número con la cantidad indicada.
 */

fun main() {
    val resultado = IncrementarNumero(10, 5)
    println(resultado)
}
