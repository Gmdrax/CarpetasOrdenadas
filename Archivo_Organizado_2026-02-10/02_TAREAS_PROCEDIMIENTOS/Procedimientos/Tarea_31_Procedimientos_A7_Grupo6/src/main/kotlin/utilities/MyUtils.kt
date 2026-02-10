package utilities
import controllers.PASSWORD_CORRECTE
import java.util.Scanner

/**
 * Funció per obrir l'escàner
 *
 * @return Scanner
 * @author Noa
 * @since 5/12/25
 */
fun obrirScanner() : Scanner {
    //Variable per obrir-lo
    val sc : Scanner = Scanner(System.`in`)
    //Retorna el resultat
    return sc
}

/**
 * Funció per obrir l'escàner
 *
 * @param sc
 * @author Noa
 * @since 5/12/25
 */
fun tancarScanner(sc:Scanner) {
    sc.close()
}

//Exercici 2

/**Funció per llegir un número enter entre l'1 i el 3999
 *
 * @param sc
 * @param msg
 * @return Int
 * @author Noa
 * @since 5/12/25
 */
fun demanarNumeroEnterFinsAlQuatremil(sc: Scanner, msg: String = "Introdueix un número entre 1 i 3999: "): Int {
    //Variable que guardarà el número introduït, que comença sent null
    var numero: Int? = null
    //Bucle fins que l'usuari introdueixi un número correcte
    while (numero == null) {
        print(msg)
        //Comprovem si l'entrada és un enter
        if (sc.hasNextInt()) {
            val entrada = sc.nextInt()
            //Comprovem si l'enter està dins del rang permès
            if (entrada in 1..3999) {
                numero = entrada  //Si és vàlid el guardem
            } else {
                //Si no està dins del rang ho indiquem a l'usuari
                println("Error: el número ha d'estar entre 1 i 3999.")
            }
        } else {
            //Si l'entrada no és un enter, avisem l'usuari
            println("Error: has d'introduir un número enter.")
            sc.next() //Neteja l'entrada incorrecta
        }
    }
    //Retornem el número vàlid
    return numero
}

/**Funció per llegir un número enter (entre l'1 i el 3999) i retornar un String amb la seva conversió a números romans
 *
 * @param msg
 * @return String
 * @author Noa
 * @since 5/12/2025
 */
fun roman(msg: String): String {
    //Llegim un número entre 1 i 3999
    val numero = demanarNumeroEnterFinsAlQuatremil(sc = Scanner(System.`in`))
    //Llista de valors i símbols romans ordenats de major a menor
    val valors = listOf(1000 to "M", 900 to "CM", 500 to "D", 400 to "CD", 100 to "C",
        90 to "XC", 50 to "L", 40 to "XL", 10 to "X", 9 to "IX", 5 to "V", 4 to "IV", 1 to "I")
    //Fem servir una variable 'restant' per anar restant el valor encara no convertit
    var restant = numero
    //StringBuilder per anar construint el número romà de manera eficient
    val resultat = StringBuilder()
    //Bucle que recorre cada parella (valor decimal, símbol romà)
    for ((valor, simbol) in valors) {
        //Mentre el valor encara pendent de convertir sigui igual o superior al valor actual, afegim el símbol romà corresponent i restem aquest valor
        while (restant >= valor) {
            resultat.append(simbol)
            restant -= valor
        }
    }
    //Retornem el resultat final amb el número romà construït
    return resultat.toString()
}

/**Funció per imprimir un resultat String
 *
 * @param resultat
 * @author Noa
 * @since 5/12/2025
 */
fun mostrarResultatString (resultat: String) {
    println("El resultat és: $resultat")
}

//Exercici 3

/**Funció per demanar una contrasenya fins a 3 cops si no és correcta i comrpovar-la amb una constant interna
 *
 * @param sc
 * @author Noa
 * @since 5/12/2025
 */
fun validarSuperusuari(sc: Scanner) {
    var intents = 0
    var haEncertat = false
    //Mentre que no haguém passat de 3 intents preguntem la contrasenya
    while (intents < 3 && !haEncertat) {
        print("Introdueix la contrasenya: ")
        //Si hem entrat un text guardem l'entrada
        if (sc.hasNextLine()) {
            val entrada = sc.nextLine().trim()
            //Si l'entrada no és buida i és igual a la constant, indiquem a l'usuari que ha encertat la contrasenya, si no també ho indiquem i augmentem el número d'intents
            if (entrada.isNotEmpty()) {
                if (entrada == PASSWORD_CORRECTE) {
                    println("Has encertat la contrasenya!")
                    haEncertat = true
                } else {
                    println("Contrasenya incorrecta.")
                    intents++
                }
            } else {
                println("Error: la contrasenya no pot estar buida.")
                intents++
            }
        } else {
            println("Error d'entrada.")
            sc.next() //Neteja l'entrada incorrecta
            intents++
        }
    }
    //Si hem superat el número d'intents permessos també ho indiquem
    if (!haEncertat) {
        println("Has superat el nombre d'intents permesos. Accés denegat.")
    }
}


//Exercici 4

/**Funció per demanar un string
 *
 * @param sc
 * @param msg
 * @return String
 * @author Noa
 * @since 5/12/2025
 */
fun demanarString(sc: Scanner, msg: String = "Introdueix un text: "): String {
    //Variable que guardarà l'String introduït, que comença sent null
    var text: String? = null
    //Bucle fins que l'usuari introdueixi un string correcte
    while (text == null) {
        print(msg)
        //Comprovem si l'entrada és un enter
        if (sc.hasNextLine()) {
            val entrada = sc.nextLine().trim()
            //Comprovem que no sigui buida
            if (entrada.isNotEmpty()) {
                text = entrada //Si és vàlid el guardem
            } else {
                //Si és buida ho indiquem a l'usuari
                println("Error: el text no pot estar buit.")
            }
        } else {
            //Si no hi ha línia netegem i seguim
            println("Error: entrada no vàlida.")
            sc.next()
        }
    }
    //Retornem el número vàlid
    return text
}

/**Funció per centrar un text imaginant que l'allargada de la pantalla és de 80
 *
 * @author Noa
 * @since 5/12/2025
 */
fun titol() {
    //Demanem l'String
    val text = demanarString(sc = Scanner(System.`in`))
    val ampladaPantalla = 80
    //Calculem quants espais necessitem a l'esquerra per centrar el text fent l'amplada - l'allargada entre la meitat
    val espais = (ampladaPantalla - text.length) / 2
    //Si el text és més llarg que 80 el mostrem sense centrar
    if (espais <= 0) {
        println(text)
    } else {
        println(" ".repeat(espais) + text)
    }
}