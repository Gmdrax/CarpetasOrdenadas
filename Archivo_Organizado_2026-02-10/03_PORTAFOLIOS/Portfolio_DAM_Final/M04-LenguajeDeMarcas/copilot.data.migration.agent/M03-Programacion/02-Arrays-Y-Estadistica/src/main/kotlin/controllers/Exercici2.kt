package controllers
import java.util.Scanner
import utilities.*

fun main(){
    var resultat = incrementarNumero(3,2)
    println(resultat)
}

fun incrementarNumero(num: Int, quantitat: Int) {
    /*
    num += quantitat
    */
    // Intentem incrementar el número:
    // num += quantitat no funciona
    //En Kotlin, els paràmetres d'una funció són no es poden modificar
    //Això vol dir que no podem modificar 'num' dins de la funció.
    //a no ser que sigui un objecte

    //si volem modificar hauriem de crear un variable dins y fora de funcio per igualar
}
