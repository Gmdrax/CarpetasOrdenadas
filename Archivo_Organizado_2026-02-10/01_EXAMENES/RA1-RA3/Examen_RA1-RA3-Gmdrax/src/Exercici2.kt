import java.util.Scanner

//TODO : Exercici2

    data class Cliente(val codi : String, val nom: String, val tarifa : Int, val consum: List<Int>)

fun main() {

    val scan = Scanner(System.`in`)

    //creamos un lista para ir metiendo los datos que tengamos de los clientes
    val clientes = mutableListOf<Cliente>()

    //creamos una variable para poder leer las lineas hasta qeu llegue a * y se pare
    var lineaDeTexto = scan.nextLine()

    while (lineaDeTexto != "*") {

        //separamos la lista de datos por la coomas para poder procesarlo por separado
        val particiones = lineaDeTexto.split(",").map { it.trim() }

        if (particiones.size >= 3) {

            //declaramos el cosumo diario para poder usarlo mas adelantes
            val cosumoDiario = particiones.subList(3, particiones.size).map { it.toInt() }

            //añadimos los datos a la lista que hemos creado
            clientes.add(Cliente(particiones[0], particiones[1], particiones[2].toInt(), cosumoDiario))
        }
        lineaDeTexto = scan.nextLine()
    }

}


