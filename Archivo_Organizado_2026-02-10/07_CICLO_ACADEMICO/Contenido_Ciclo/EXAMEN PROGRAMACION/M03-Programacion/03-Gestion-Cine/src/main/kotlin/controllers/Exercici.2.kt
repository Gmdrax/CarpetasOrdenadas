package controllers

import utilities.abrirScanner
import utilities.cerrarScanner
import utilities.imprimirMensaje
import java.util.Scanner

/*
2. Implementeu un programa que permeti fer la reserva de seients de la sala d’un
cinema. La sala disposa de 20 files, a cada fila hi ha 15 butaques. El programa
mostrarà un menú amb les següents opcions:

a) Buidar sala: Prepara la sala per a la següent projecció de la pel·lícula, marcant
tots els seients com a lliures.

b) Visualitzar seients disponibles: El programa mostrarà una graella corresponent
als seients de la sala. Si el seient està reservat es mostrarà una ics (X) i si està
lliure es mostrarà un subratllat (_).

c) Reserva de seients: El programa demanarà les coordenades (fila i butaca) del
seient que es vol reservar. Després, comprovarà que estigui lliure i, si és així,
el marcarà com a reservat.

NOTA: Hauràs d’implementar una funció per a cadascuna de les diferents opcions
i també una per a fer el menú.
*/
fun main(){
    val scan = abrirScanner()
    val FILAS = 20
    val BUTACAS = 15
    var sala = Array(FILAS){ Array<String>(BUTACAS){"_"} }
    menu(scan, sala)
    cerrarScanner(scan)
}

/**
 * menu()
 * funcio de menu que demana la accio i crida a altres funcions
 *
 * @param scanner Scanner
 * @param arr array inicial
 */
fun menu(scanner: Scanner, arr: Array<Array<String>>){
    var sala = arr
    imprimirMensaje("Introdueix SI si vols fer algun accio, y NO en cas contrari")
    var accio = scanner.next().uppercase()
    while (accio!="NO"){
        imprimirMensaje("Introdueix B per buidar la sala, V per visualizar, R per reservar seient, i NO per sortir")
        accio = scanner.next().uppercase()
        when(accio){
            "B"-> sala = buidarSala(sala)
            "V"-> visualizarSala(sala)
            "R"-> {
                imprimirMensaje("Introdueix la fila que vols reservar: ")
                val fila = scanner.nextInt()-1
                imprimirMensaje("Introdueix la columna que vols reservar: ")
                val columna = scanner.nextInt()-1
                sala = reservarButaca(sala, fila, columna)
            }
        }
    }
}

/**
 * visualizarSala()
 * funcio per visualizar reservas de la sala, X com a reservat, i _ com a buida
 *
 * @param arr array per visualiar
 */
fun visualizarSala(arr: Array<Array<String>>){
    for (i in arr){
        println(i.joinToString(" "))
    }
}

/**
 * buidarSala()
 * funcio per buidar la sala, cambia tots a _
 *
 * @param arr Array per modificar
 * @return retorna array buida
 */
fun buidarSala(arr: Array<Array<String>>): Array<Array<String>>{
    var result = arr
    repeat(result.size){ fila->
        repeat(result[0].size){ columna->
            result[fila][columna]="_"
        }
    }
    visualizarSala(result)
    return result
}

/**
 * reservarButaca()
 * funcio per reservar la butaca, en cas que esta reservat, tonara al menu
 *
 * @param arr Array actual de reservas
 * @param scanner Scanner
 * @return retorna el array modificat o no
 */
fun reservarButaca(arr: Array<Array<String>>, fila: Int, columna:Int): Array<Array<String>>{
    val result = arr
    if (result[fila][columna]=="X"){
        imprimirMensaje("Ya esta reservada, cambia de sitio")
    }else{
        result[fila][columna]="X"
    }
    visualizarSala(result)
    return result
}