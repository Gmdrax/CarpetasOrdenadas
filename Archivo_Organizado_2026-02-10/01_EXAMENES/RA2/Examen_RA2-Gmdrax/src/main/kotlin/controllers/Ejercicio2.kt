package controllers

import utilities.leerEntero
import java.util.Scanner

data class Video(
    val titol: String,
    val duradaMinuts: Int,
    val visualitzacions: Int
)

fun main() {

    //definimos una array par extraer los datos que se pondran en otra funcion
    val listaDeVideos = ArrayList<Video>()

    //definimos el escaner
    var scan = Scanner(System.`in`)

    //llamamos al menuo que tiene todas las funcionalidades
    menu(scan, listaDeVideos)

}


/**
 * Muestra el menu en pantalla para poder visulizar las opciones que tenemos
 *
 * @param titulo nombre del video.
 * @param durada duracion del video.
 * @param visitas numero de visitas del video
 * @param listaDeVideos lista con los datos a maniupular.
 *
 */

fun añadirVideo(titulo: String, durada: Int, visitas: Int, listaVideos: ArrayList<Video>) {

    //añadimos el los datos al array
    listaVideos.add(Video(titulo, durada, visitas))
    println("Añadido")


}

/**
 * Muestra el menu en pantalla para poder visulizar las opciones que tenemos
 *
 * @param scan scaner para poder elegeir opciones.
 * @param listaDeVideos lista con los datos a maniupular.
 *
 */

fun menu(scan: Scanner, listaDeVideos: ArrayList<Video>) {
    //declaramos la opcion a -1 para poder mostrar el menu con 0
    var opcion = -1
    while (opcion != 0) {
        println("MENU")
        println("1. Añadir vídeo")
        println("2. Ver media visitas")
        println("3. Ver vídeos top")
        println("0. Salir")

        opcion = leerEntero(scan)

        //en caso de que se elija la opcion 1 se añaden 3 vieos
        if (opcion == 1) {
            añadirVideo("video1", 20, 1000, listaDeVideos)
            añadirVideo("video2", 70, 4000, listaDeVideos)
            añadirVideo("video3", 10, 7000, listaDeVideos)

        }

        //enc aso de que se elija la opcion dos ejecutamos la funcion media para calcualara
        if (opcion == 2) {
            var media = calcularmedia(listaDeVideos)
            println(media)
        }

        //en caso de que se elija la opcion 3 creamo un top de visitas con los datos del usario llamando a la funcion de videoTop
        if (opcion == 3) {
            println("pon el numero de visitas: ")
            var numeroVisitas = scan.nextInt()
            var videoTop = videoConMasVisitas(numeroVisitas, listaDeVideos)
            println(videoTop)
        }
    }
}


/**
 * Muestra el menu en pantalla para poder visulizar las opciones que tenemos
 *
 *
 * @param listaDeVideos lista con los datos a maniupular.
 * @return Double numero con la media para que el usario la pueda ver
 *
 */
fun calcularmedia(listaVideos: ArrayList<Video>): Double {

    var sumaVisitas = 0

    //iteramos por los video y scamaos las visitas y las vamos sumando todas
    for (i in 0 until listaVideos.size) {
        sumaVisitas = sumaVisitas + listaVideos[i].visualitzacions

    }
    //declaramso media como double para que pueda tener decimales
    var media: Double

    //por ultimo cojemos la suma de todas la visitas de los videos y la dividimos por el numero de videos
    media = sumaVisitas.toDouble() / listaVideos.size

    return media

}

/**
 * entre el lisata de videos y el numero de visitas del usario muestra los que esta por enciam de ese numero
 *
 * @param numeroVisitasBase dato del usario de la visitas base de donde partir.
 * @param listaDeVideos lista con los datos a maniupular.
 *
 */
fun videoConMasVisitas(numeroVisitasBase: Int, listaVideos: ArrayList<Video>) {

    var visitas = numeroVisitasBase

    //iteramos por cada video comprobando que las visitas sea mayores a las que me ha dado el usario en caso de serlo lo mostramos con un print
    for (i in 0 until listaVideos.size) {
        if (listaVideos[i].visualitzacions >= visitas) {
            println(listaVideos[i].titol + " - " + listaVideos[i].visualitzacions)
        }

    }


}



