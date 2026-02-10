import utilities.leerEnteroConMensaje
import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    //creamos el array principal
    val matriz = Array(20) { Array(13) { '_' } }

    //listado de opciones del menu, esta aqui porque en un funcion aparte me generaba problemas
    var opcion = -1
    while (opcion != 0) {
        println("SALES")
        println("1. Borrar todo")
        println("2. Ver salas")
        println("3. Reservar")
        println("0. Salir")

        opcion = leerEnteroConMensaje(scanner, "Opción: ")

        if (opcion == 1) vaiciar(matriz)
        if (opcion == 2) mostrar(matriz)
        if (opcion == 3) reservar(scanner, matriz)
    }
}


/**
 * opcion para vaiciar las reservas echas vuelvo todo a como estaba al principio
 * @param matriz modificamos el array de datos para luego poder mostrarlos
 */
fun vaiciar(matriz: Array<Array<Char>>) {

    //creamos la matriz iterando por las columnas y las filas
    for (filas in 0 until 20) {
        for (columnas in 0 until 13) {
            matriz[filas][columnas] = '_'
        }
    }
    println("todo limpio")
}


/**
 * visulizacion principal de la matriz para ver los dato en ella con los borde ariba
 * @param matriz modificamos el array de datos para luego poder mostrarlos
 */
fun mostrar(matriz: Array<Array<Char>>) {

    print("      ")
    //iteramos la columnas para mostrara arriba un numero con la horas disponibles, no se muestra bien no me da tiempor a cambiar las distran
    for (columnas in 0 until 13) {
        print(8 + columnas)
    }

    println()

    //iteramos la filas para mostrara el numero de la sala que es ajustando la marcos para que quede bien puesta
    for (filas in 0 until 20) {

        print("S" + (filas + 1) + ":   ")
        for (columnas in 0 until 13) {
            print(matriz[filas][columnas] + "   ")
        }
        println()
    }
}

/**
 * Lógica de reserva.
 * @param scan recojemos los datos del usario
 * @param matriz modificamos el array de datos para luego poder mostrarlos
 */
fun reservar(scan: Scanner, matriz: Array<Array<Char>>) {

    //lemos los datos para poder manipualar el array
    val sala = leerEnteroConMensaje(scan, "Sala (1-20): ")
    val horaIni = leerEnteroConMensaje(scan, "Hora inicio (8-20): ")
    val cantidad = leerEnteroConMensaje(scan, "Horas: ")


    val columna = horaIni - 8

    //protocolo por si pone lo que no es el usario
    if (sala < 0 || sala > 19) {
        println("Sala incorrecta.")
    }

    //en caso de ser mayor al tiempo que se pede estar en la salas y reservarlas mostramos un mensaje de que no hay
    if (columna + cantidad + 1 > 13) {
        println("No cabe")
    }

    //pasa saber si ese horario esta ocupado declaramos la variable y comprobamos que las posiciones del array que nos da el
    //usario tengan un _ eso significa que esta vacio
    var ocupado = false
    for (i in 0 until (cantidad)) {

        if (matriz[sala][columna + i] != '_') {
            ocupado = true
        }
    }

    if (ocupado == true) {

        println("Error: Está ocupado")

    } else {

        //en caso de nos esta reservado ponemos una R en las pociones que nos ha pedido el usuario
        for (i in 0 until cantidad) {
            matriz[sala][columna + i] = 'R'
        }

    }
}
