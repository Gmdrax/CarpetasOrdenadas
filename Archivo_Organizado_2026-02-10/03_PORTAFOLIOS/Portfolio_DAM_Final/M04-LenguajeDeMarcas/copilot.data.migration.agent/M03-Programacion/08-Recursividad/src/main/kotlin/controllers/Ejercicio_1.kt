package org.example.ejercicios




/**
 * Funció principal que executa els tests de verificació.
 * Compara els resultats de les versions recursives i iteratives.
 *
 * @author Leo , Joel y Gerard
 * @since 17/12/2025
 */
fun main() {

    println("Test m1")
    println("Recursiva (5): ${m1_recursiva(5)}")
    println("Iterativa (5): ${m1_iterativa(5)}")


    println("Test m2")
    println("Recursiva (x=2.0, n=4): ${m2_recursiva(2.0, 4)}")
    println("Iterativa (x=2.0, n=4): ${m2_iterativa(2.0, 4)}")

    println("Test m3")
    println("Recursiva (32): ${m3_recursiva(32)}")
    println("Iterativa (32): ${m3_iterativa(32)}")


    println("Test m4")
    println("Recursiva (1234): ${m4_recursiva(1234)}")
    println("Iterativa (1234): ${m4_iterativa(1234)}")
}


/**
 * Calcula el factorial d'un número de manera recursiva.
 *
 * @param n El número del qual calcular el factorial.
 * @return El factorial de n.
 * @author Leo , Joel y Gerard
 * @since 17/12/2025
 */
fun m1_recursiva(n: Int): Int {
    if (n == 0) return 1
    return n * m1_recursiva(n - 1)
}

/**
 * Calcula el factorial d'un número de manera iterativa.
 *
 * @param n El número del qual calcular el factorial.
 * @return El factorial de n.
 * @author Leo , Joel y Gerard
 * @since 17/12/2025
 */
fun m1_iterativa(n: Int): Int {
    var resultado = 1

    //bucle desde 1 hasta n
    for (i in 1..n) {
        //multiplicamos el acumulado
        resultado *= i
    }
    return resultado
}


/**
 * Calcula la suma dels nombres des de n fins a 1 de manera recursiva.
 *
 * @param x Paràmetre Double (no utilitzat en la lògica, mantingut per signatura).
 * @param n El número des del qual començar la suma descendent.
 * @return La suma de 1 a n.
 * @author Leo , Joel y Gerard
 * @since 17/12/2025
 */
fun m2_recursiva(x: Double, n: Int): Int {
    if (n == 0) return 0
    return n + m2_recursiva(x, n - 1)
}

/**
 * Calcula la suma dels nombres des de n fins a 1 de manera iterativa.
 *
 * @param x Paràmetre Double (no utilitzat).
 * @param n El número des del qual començar la suma.
 * @return La suma de 1 a n.
 * @author Leo , Joel y Gerard
 * @since 17/12/2025
 */
fun m2_iterativa(x: Double, n: Int): Int {
    var resultado = 0

    //bucle descendente desde n hasta 1
    for (i in n downTo 1) {
        //sumamos i al resultado
        resultado += i
    }
    return resultado
}

/**
 * Calcula el logaritme enter en base 2 d'un número de manera recursiva.
 * (Quantes vegades es pot dividir per 2).
 *
 * @param n El número a calcular.
 * @return El logaritme en base 2 (part entera).
 * @author Leo , Joel y Gerard
 * @since 17/12/2025
 */
fun m3_recursiva(n: Int): Int {
    if (n < 2) return 0
    return 1 + m3_recursiva(n / 2)
}


/**
 * Calcula el logaritme enter en base 2 d'un número de manera iterativa.
 *
 * @param n El número a calcular.
 * @return El logaritme en base 2 (part entera).
 * @author Leo , Joel y Gerard
 * @since 17/12/2025
 */
fun m3_iterativa(n: Int): Int {
    var resultado = 0
    var X = n

    //mientras sea mayor o igual a 2
    while (X >= 2) {
        //dividimos entre 2
        X /= 2
        //incrementamos el contador
        resultado++
    }
    return resultado
}



/**
 * Calcula la suma dels dígits d'un número enter de manera recursiva.
 *
 * @param n El número del qual sumar els dígits.
 * @return La suma dels seus dígits.
 * @author Leo , Joel y Gerard
 * @since 17/12/2025
 */
fun m4_recursiva(n: Int): Int {
    if (n == 0) return 0
    return m4_recursiva(n / 10) + n % 10
}


/**
 * Calcula la suma dels dígits d'un número enter de manera iterativa.
 *
 * @param n El número del qual sumar els dígits.
 * @return La suma dels seus dígits.
 * @author Leo , Joel y Gerard
 * @since 17/12/2025
 */
fun m4_iterativa(n: Int): Int {
    var resultado = 0

    var X = n

    //mientras queden digitos
    while (X != 0) {
        //sumamos el ultimo digito
        resultado += X % 10
        //quitamos el ultimo digito
        X /= 10
    }
    return resultado
}