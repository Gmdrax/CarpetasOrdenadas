package org.example.controllers

import java.util.Scanner

/**
 * Representa un tram d'impost sobre el valor afegit (IVA) vigent a partir d'una data específica.
 *
 * @param dataInici Data d'inici de la vigència en format enter (AAAAMMDD).
 * @param general Percentatge de l'IVA general.
 * @param reduit Percentatge de l'IVA reduït.
 * @param superReduit Percentatge de l'IVA superreduït (pot ser 0 si no existia).
 * @param exempt Percentatge de l'IVA exempt (habitualment 0).
 * @author L'usuari
 * @since 1.0
 */
data class tramoIva(
    val dataInici: Int,
    val general: Int,
    val reduit: Int,
    val superReduit: Int,
    val exempt: Int
)

/**
 * Calcula el preu final d'un producte aplicant l'IVA corresponent segons la data i el tipus.
 *
 * Aquesta funció cerca en un històric de trams d'IVA per trobar el percentatge correcte
 * basant-se en la data proporcionada.
 *
 * @param preu El preu base del producte sense impostos.
 * @param tipusIva El tipus d'IVA a aplicar ("General", "Reduit", "Superreduit", "Exempt").
 * @param data La data de la compra en format text "DD-MM-AAAA".
 * @return El preu final amb l'impost sumat, com a Float.
 * @author L'usuari
 */
fun calcularIVA(preu: Float, tipusIva: String, data: String): Float {

    //separamos le fecha en partes por el -
    val partes = data.split("-")
    val dataEntera = (partes[2] + partes[1] + partes[0]).toInt()

    //creamos la lista con todos los datos que usaremos para calcular el iva
    val listaIvas = listOf(
        tramoIva(20120715, 21, 10, 4, 0),
        tramoIva(20100101, 18, 8, 4, 0),
        tramoIva(19950101, 16, 7, 4, 0),
        tramoIva(19930101, 15, 6, 3, 0),
        tramoIva(19920101, 15, 6, 0, 0),
        tramoIva(19860101, 12, 6, 0, 0)
    )

    var porcentajeAplicar = 0
    var encontrado = false

    //buscamos el tramo de iva que queremos segun lo que nos ha dado el usuario
    for (tramo in listaIvas) {
        if (dataEntera >= tramo.dataInici && !encontrado) {

            if (tipusIva == "General") porcentajeAplicar = tramo.general
            else if (tipusIva == "Reduit") porcentajeAplicar = tramo.reduit
            else if (tipusIva == "Superreduit") porcentajeAplicar = tramo.superReduit
            else if (tipusIva == "Exempt") porcentajeAplicar = tramo.exempt

            encontrado = true
        }
    }

    //calculemos el precio final
    val resultado = preu + (preu * porcentajeAplicar / 100)

    //devolvemos el resultado
    return resultado
}

/**
 * Funció principal d'entrada al programa.
 *
 * S'encarrega de gestionar la interacció amb l'usuari a través de la consola,
 * demanant les dades necessàries i mostrant el resultat final.
 */
fun main() {
    val scan = Scanner(System.`in`)

    //pedimos el precio de lo que ha se ha comprado
    println("introduce el precio:")
    val preu = scan.nextFloat()

    //pedimos la fecha de compra
    println("introduce la fecha de compra (DD-MM-AAAA):")
    val data = scan.next()

    //pedimos la usario el tipo de iva que se aplicara
    println("introduce el tipo de IVA (General, Reduit, Superreduit, Exempt):")
    val tipusIva = scan.next()

    //llamamos la funcion principal que nos calculara el iva
    val precioFinal = calcularIVA(preu, tipusIva, data)

    //mostramos el resultado
    println("el precio final con iva aplicado es: $precioFinal")
}