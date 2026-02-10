package utilities

import org.example.controllers.Punt
import java.util.Locale
import java.util.Scanner

/**
 * Crea y devuelve un objeto [Scanner] configurado con el locale del Reino Unido.
 *
 * Esta función centraliza la creación del scanner para evitar duplicación de código
 * y asegurar que siempre se utilice el mismo formato numérico.
 *
 * @author Trinidad
 *
 * @return [Scanner] Un scanner listo para leer desde la entrada estándar.
 */
fun abrirScanner(): Scanner {
    val scan: Scanner = Scanner(System.`in`).useLocale(Locale.UK)
    return scan
}

/**
 * Cierra un objeto [Scanner] previamente abierto.
 *
 * Es recomendable cerrar el scanner al final del programa para liberar recursos.
 *
 * @author Trinidad
 *
 * @param scan El scanner que se desea cerrar.
 * @return Unit No devuelve ningún valor; simplemente cierra el scanner.
 */

fun cerrarScanner(scan: Scanner) {
    scan.close()
}


/**
 * Muestra por pantalla las coordenadas de un punto con formato de 6 decimales.
 *
 * @author Gerard
 *
 * @param punto El objeto [Punt] cuyas coordenadas deben mostrarse.
 * @return Unit No devuelve ningún valor; solo imprime en pantalla.
 */
fun mostraPunt(punto: Punt) {
    //mostramos el punto en el formato que nos ha pedido
    println("%.6f".format(Locale.US, punto.x))
    println("%.6f".format(Locale.US, punto.y))
}

/**
 * Desplaza un punto en el plano sumando los valores indicados a sus coordenadas.
 *
 * @author Gerard
 *
 * @param punto El punto original que se desea mover.
 * @param xcogida Cantidad a sumar a la coordenada X del punto.
 * @param ycogida Cantidad a sumar a la coordenada Y del punto.
 *
 * @return Unit No devuelve ningún valor; imprime por pantalla las nuevas coordenadas del punto.
 */
fun moverPunto(punto: Punt, xcogida: Float, ycogida: Float) {
    //sumamos los puntos que nos ha dado el usuario y mostramos el resultado
    val xresultado = punto.x + xcogida
    val yresultado = punto.y + ycogida
    val puntoResultante = Punt(xresultado, yresultado)
    mostraPunt(puntoResultante)
}

/**
 * Escala un punto multiplicando sus coordenadas por un valor dado.
 *
 * @author Gerard
 *
 * @param punto El punto original que se desea escalar.
 * @param escalar Factor por el cual se multiplicarán las coordenadas del punto.
 *
 * @return Unit No devuelve ningún valor; imprime por pantalla las coordenadas escaladas.
 */
fun escalarPunto(punto: Punt, escalar: Float) {
    //hacemos un escalar de los puntos
    val xresultado = punto.x * escalar
    val yresultado = punto.y * escalar
    val puntoResultante = Punt(xresultado, yresultado)
    mostraPunt(puntoResultante)
}

/**
 * Verifica si un punto es igual a otro comparando sus coordenadas.
 *
 * Compara las coordenadas del punto recibido con las coordenadas proporcionadas.
 * Si ambas coinciden exactamente, se imprime `"Son iguales"`, en caso contrario `"No son iguales"`.
 *
 * @author Gerard
 *
 * @param punto El punto original que se usará para comparar.
 * @param segundaX Coordenada X del segundo punto a comparar.
 * @param segundaY Coordenada Y del segundo punto a comparar.
 *
 * @return Unit No devuelve ningún valor; solo imprime si los puntos son iguales o no.
 */
fun verificarPuntoIgual(punto: Punt, segundaX: Float, segundaY: Float) {
    //verificamos si el puntos es igual en los dos casos que no han dado
    if (punto.x == segundaX && punto.y == segundaY)
        //si son iguales hacemos un print del mensaje
        println("Son iguales")
    else
        //si no son iguales hacemos otro print
        println("No son iguales")
}

/**
 * Imprime un mensaje por pantalla.
 *
 * Esta función centraliza el uso de `println()`
 * para facilitar cambios futuros (por ejemplo, añadir formato o logs).
 *
 * @author Trinidad
 *
 * @param mensaje El texto que se mostrará en pantalla.
 */
fun imprimirMensaje(mensaje: String) {
    println(mensaje)
}
