
/**
 * Funció solucions.main principal que executa el programa
 *
 * @author raimonizard
 * @author srivas
 * @since 02/12/2025
 */
fun main(){
    val ROWS: Int = 10
    val COLS: Int = 9

    val frame1: Array<IntArray> = Array(ROWS){ IntArray(COLS) }
    frame1[0] = intArrayOf(0,0,0,0,1,0,0,0,0)
    frame1[1] = intArrayOf(0,0,0,1,0,1,0,0,0)
    frame1[2] = intArrayOf(0,0,0,0,1,0,0,0,0)
    frame1[3] = intArrayOf(0,0,0,1,1,1,0,0,0)
    frame1[4] = intArrayOf(0,0,1,0,1,0,1,0,0)
    frame1[5] = intArrayOf(0,1,0,0,1,0,0,1,0)
    frame1[6] = intArrayOf(0,0,0,0,1,0,0,0,0)
    frame1[7] = intArrayOf(0,0,0,1,0,1,0,0,0)
    frame1[8] = intArrayOf(0,0,1,0,0,0,1,0,0)
    frame1[9] = intArrayOf(0,1,0,0,0,0,0,1,0)

    val frame2: Array<IntArray> = Array(ROWS){ IntArray(COLS) }
    frame2[0] = intArrayOf(0,0,0,0,1,0,0,0,0)
    frame2[1] = intArrayOf(0,0,0,1,0,1,0,0,0)
    frame2[2] = intArrayOf(0,0,0,0,1,0,0,0,0)
    frame2[3] = intArrayOf(0,1,1,1,1,1,0,0,0)
    frame2[4] = intArrayOf(0,0,0,0,1,0,1,0,0)
    frame2[5] = intArrayOf(0,0,0,0,1,0,0,1,0)
    frame2[6] = intArrayOf(0,0,0,0,1,0,0,0,0)
    frame2[7] = intArrayOf(0,0,0,1,0,1,0,0,0)
    frame2[8] = intArrayOf(0,0,1,0,0,0,1,0,0)
    frame2[9] = intArrayOf(0,1,0,0,0,0,0,1,0)

    val frame3: Array<IntArray> = Array(ROWS){ IntArray(COLS) }
    frame3[0] = intArrayOf(0,0,0,0,1,0,0,0,0)
    frame3[1] = intArrayOf(0,0,0,1,0,1,0,0,0)
    frame3[2] = intArrayOf(0,0,0,0,1,0,0,0,0)
    frame3[3] = intArrayOf(0,0,0,1,1,1,0,0,0)
    frame3[4] = intArrayOf(0,0,1,0,1,0,1,0,0)
    frame3[5] = intArrayOf(0,1,0,0,1,0,0,1,0)
    frame3[6] = intArrayOf(0,0,0,0,1,0,0,0,0)
    frame3[7] = intArrayOf(0,0,0,1,0,1,1,1,0)
    frame3[8] = intArrayOf(0,0,1,0,0,0,0,0,0)
    frame3[9] = intArrayOf(0,1,0,0,0,0,0,0,0)

    printPicture(frame1)
    println()
    printPicture(frame2)
    println()
    printPicture(frame3)
    println()

    // Mostra les diferències entre els frames
    checkMovement(frame1, frame2)
    checkMovement(frame2, frame3)

    // Mostra la llista de pixels que han canviat entre el frame1 i el frame2
    findPixels(frame1, frame2)

}

/**
 * Funció que serveix per imprimir i visualitzar els fotogrames en blanc i negre
 *
 * @author raimonizard
 * @param frame Paràmetre d'entrada de tipus matriu d'arrays Array<IntArray>
 * @since 1.0
 */
fun printPicture(frame: Array<IntArray>){
    val RESET: String = "\u001b[0m"
    val WHITE: String = "\u001b[37m"
    val BOLD: String = "\u001b[1m"
    val BLACK_BACKGROUND: String = "\u001b[40m"
    val RED_BACKGROUND: String = "\u001b[41m"
    val GREEN_BACKGROUND: String = "\u001b[42m"

    print("   ")
    for (i in 0 until frame[0].size)
        print("[$i]")

    println("")

    for (f in 0 until frame.size) {
        print("[$f]")
        for (c in 0 until frame[f].size) {
            when (frame[f][c]) {
                1 -> print("" + BLACK_BACKGROUND + WHITE + BOLD + String.format("%2s ", 1) + RESET)
                2 -> print("" + RED_BACKGROUND + WHITE + BOLD + String.format("%2s ", 2) + RESET)
                3 -> print("" + GREEN_BACKGROUND + WHITE + BOLD + String.format("%2s ", 3) + RESET)
                else ->  print(String.format("%2s ",0))
            }

        }
        println("")
    }
}

/**
 * Funció que rep dos fotogrames per paràmetre i mostra els pixels que han canviat
 *  - si tots dos fotogrames tenen el mateix valor per un pixel, es pren el valor d'aquell pixel
 *  - si per a un pixel el primer fotograma té un 1 i el segon té un 0, es pren el valor 2
 *  - si per a un píxel el primer fotograma té un 0 i el segon té un 1, es pren el valor 3
 *
 * @param f1 Paràmetre que representa una matriu de 2D de tipus Array<IntArray>
 * @param f2 Paràmetre que representa una matriu de 2D de tipus Array<IntArray>
 * @author gerard maestre
 * @since 2.0
 */
fun checkMovement(f1: Array<IntArray>, f2: Array<IntArray>):Unit{
    // TODO: Comparar els dos fotogrames
    val pixels1 = f1.size
    val pixels2 = f1[0].size

    //creem una nova matriu per poder emagatzemar els resultats dels cambis
    val resultFrame = Array(pixels1){ IntArray(pixels2) }

    //itereamos todas las posiciones de las columnas y filas
    for (posicion1 in 0 until pixels1) {
        for (posicion2 in 0 until pixels2) {
            val valMatriuO = f1[posicion1][posicion2]
            val valMatriu1 = f2[posicion1][posicion2]

            if (valMatriuO == valMatriu1) {

                //si son iguals mantenim el seu valor original
                resultFrame[posicion1][posicion2] = valMatriuO
            } else if (valMatriuO == 1 && valMatriu1 == 0) {

                //si abans hi havia un 1 i ara i ha un 0 posem un 2
                resultFrame[posicion1][posicion2] = 2
            } else {

                //si abans hi havia un 0 i ara un 1 posem un 3
                resultFrame[posicion1][posicion2] = 3
            }
        }
    }
    // TODO: Imprimir el fotograma resultant de la comparació
    printPicture(resultFrame)
}

/**
 * Funció que rep dos fotogrames per paràmetre i que troba i imprimeix les coordenades dels píxels que han canviat
 *
 * @param f1 Paràmetre que representa una matriu de 2D de tipus Array<IntArray>
 * @param f2 Paràmetre que representa una matriu de 2D de tipus Array<IntArray>
 * @author gerard maestre
 * @since 2.0
 */
fun findPixels(f1: Array<IntArray>, f2: Array<IntArray>){
    // TODO: Troba i imprimeix per pantalla els píxels que han canviat d'un frame a l'altre
        //itermaos sobre las cordenadas / posiciones de los pixeles / posciones en la matriz
        for (cordenada1 in f1.indices){
            for (cordenada2 in f1[cordenada1].indices){

                //comparem la posicio en los indices para saber las cordenadas que han cambiat en cada frame
                if (f1[cordenada1][cordenada2] != f2[cordenada1][cordenada2]){

                    //mostramos el resultado de las cordenadas que se han modificado
                    println("[$cordenada1,$cordenada2]")

                }
            }
        }

    // El format de sortida ha de ser [fila,columna] per cada pixel que hagi canviat. Cada pixel en una línia.
}