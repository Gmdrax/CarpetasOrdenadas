package org.example.controllers

import java.util.Scanner
import java.util.Locale

/**
 * Función principal de entrada a la aplicación de la máquina de billetes.
 *
 * Se encarga de inicializar el escáner y gestionar el bucle principal de la máquina.
 * La máquina funciona indefinidamente hasta que un operador introduce el código secreto.
 *
 * @author Gerard y Noa
 * @since 15/12/2025
 */

// Data class para almacenar la información de un billete individual
data class InfoBillete(
    val nombre: String,
    val precioBase: Double,
    val zona: Int,
    val precioFinal: Double
)

// Data class con el estado de la compra actual
data class EstadoCompra(
    val listaBilletes: MutableList<InfoBillete>,
    val totalAPagar: Double,
    val finalizada: Boolean
)

fun main() {
    val scan = obrirScanner()

    // Configuración inicial de precios base (Zona 1)
    // Extraído de la tabla de precios del documento
    val preciosBase = mapOf(
        1 to 2.40,  // Bitllet senzill
        2 to 11.35, // TCasual
        3 to 40.00, // TUsual
        4 to 10.00, // TFamiliar
        5 to 80.00  // TJove
    )

    // Iniciar el bucle de la máquina
    println("Iniciant sistema BITB...")
    ejecutarMaquina(scan, preciosBase)

    tancarScanner(scan)
}

/**
 * Funció per obrir l'escàner
 *
 * @author Gerard y Noa
 * @since 15/12/2025
 */
fun obrirScanner() : Scanner {
    // Usamos Locale.US para asegurar que los decimales se lean con punto si es necesario
    val sc : Scanner = Scanner(System.`in`).useLocale(Locale.US)
    return sc
}

/**
 * Funció per tancar l'escàner
 *
 * @author Gerard y Noa
 * @since 15/12/2025
 */
fun tancarScanner(sc:Scanner) {
    sc.close()
}

/**
 * Contiene el bucle principal de la máquina. Gestiona las sesiones de venta continuas.
 * Si recibe el código de parada, detiene la ejecución.
 *
 * @author Gerard y Noa
 * @since 15/12/2025
 */
fun ejecutarMaquina(scan: Scanner, precios: Map<Int, Double>) {
    var maquinaActiva = true

    // El algoritmo nunca se detiene a menos que se use el código secreto
    while (maquinaActiva) {
        // Inicializamos el estado para un nuevo cliente
        val estadoActual = EstadoCompra(mutableListOf(), 0.0, false)

        // Procesamos la sesión del cliente
        val codigoSalida = procesarSesionCliente(scan, estadoActual, precios)

        // Verificamos si se ha introducido el código secreto de apagado (4321)
        if (codigoSalida == 4321) {
            println("Codi secret introduït. Apagant el sistema...")
            maquinaActiva = false
        }
    }
}

/**
 * Gestiona la interacción completa con un solo cliente: selección de billetes, zonas y pago.
 *
 * @param scan El scanner para entrada de datos.
 * @param estado El estado inicial de la compra.
 * @param precios Mapa de precios base.
 * @return Un entero de control (0 para normal, 4321 para apagar).
 * @author Gerard y Noa
 * @since 15/12/2025
 */
fun procesarSesionCliente(scan: Scanner, estado: EstadoCompra, precios: Map<Int, Double>): Int {
    var seguirComprando = true

    // Bucle de selección de billetes (máximo 3 o hasta que el usuario diga No)
    while (seguirComprando && estado.listaBilletes.size < 3) {
        mostrarMenuPrincipal()

        val tipoBillete = demanarOpcio(scan)

        // Comprobamos código secreto
        if (tipoBillete == 4321) return 4321

        // Validamos que la opción sea correcta (1-5)
        if (tipoBillete in 1..5) {
            val zona = demanarZona(scan)

            // Calculamos el precio y actualizamos el estado
            val nuevoBillete = crearBillete(tipoBillete, zona, precios)
            estado.listaBilletes.add(nuevoBillete)

            mostrarDetalleSeleccion(nuevoBillete)

            // Preguntar si quiere seguir comprando si aún no ha llegado al límite de 3
            if (estado.listaBilletes.size < 3) {
                seguirComprando = preguntarSeguir(scan)
            } else {
                seguirComprando = false
                println("Màxim de bitllets assolit (3).")
            }
        } else {
            println("Opció no vàlida. Torna-ho a intentar.")
        }
    }

    // Si hay billetes en la cesta, procedemos al cobro
    if (estado.listaBilletes.isNotEmpty()) {
        val total = calcularTotal(estado.listaBilletes)
        gestionarPago(scan, total)
        gestionarTicket(scan, estado.listaBilletes, total)
    }

    println("Adeu!!")
    println("------------------------------------------------")
    return 0
}

/**
 * Muestra el menú de opciones de billetes disponibles.
 *
 * @author Gerard y Noa
 * @since 15/12/2025
 */
fun mostrarMenuPrincipal() {
    println("Quin bitllet desitja adquirir?")
    println("1. Bitllet senzill")
    println("2. TCasual")
    println("3. TUsual")
    println("4. TFamiliar")
    println("5. TJove")
}

/**
 * Solicita la opción al usuario.
 *
 * @author Gerard y Noa
 * @since 15/12/2025
 */
fun demanarOpcio(scan: Scanner): Int {
    while (!scan.hasNextInt()) {
        println("Si us plau, introdueix un número vàlid.")
        scan.next()
    }
    return scan.nextInt()
}

/**
 * Solicita la zona de viaje (1, 2 o 3).
 *
 * @author Gerard y Noa
 * @since 15/12/2025
 */
fun demanarZona(scan: Scanner): Int {
    var zona = 0
    do {
        println("Quina zona vol viatjar? [1, 2, 3]")
        if (scan.hasNextInt()) {
            zona = scan.nextInt()
            if (zona !in 1..3) println("Zona incorrecta.")
        } else {
            scan.next() // limpiar buffer
        }
    } while (zona !in 1..3)
    return zona
}

/**
 * Crea un objeto InfoBillete con el precio calculado según la zona.
 * Aplica los multiplicadores especificados en el ejercicio.
 *
 * @author Gerard y Noa
 * @since 15/12/2025
 */
fun crearBillete(tipo: Int, zona: Int, precios: Map<Int, Double>): InfoBillete {
    val precioBase = precios[tipo] ?: 0.0
    var nombre = ""

    nombre = when(tipo) {
        1 -> "Bitllet senzill"
        2 -> "TCasual"
        3 -> "TUsual"
        4 -> "TFamiliar"
        5 -> "TJove"
        else -> "Desconegut"
    }

    // Cálculo del multiplicador según la zona
    val multiplicador = when(zona) {
        2 -> 1.3125
        3 -> 1.8443
        else -> 1.0
    }

    val precioFinal = precioBase * multiplicador
    return InfoBillete(nombre, precioBase, zona, precioFinal)
}

/**
 * Muestra por consola qué ha elegido el usuario en este paso.
 *
 * @author Gerard y Noa
 * @since 15/12/2025
 */
fun mostrarDetalleSeleccion(billete: InfoBillete) {
    println("Ha escollit la opcio: ${billete.nombre}, zona ${billete.zona}")
    println("El preu del bitllet es ${String.format("%.2f", billete.precioFinal)}€")
}

/**
 * Pregunta al usuario si desea añadir más billetes a la compra actual.
 *
 * @author Gerard y Noa
 * @since 15/12/2025
 */
fun preguntarSeguir(scan: Scanner): Boolean {
    println("Vols seguir comprant? [S,N]")
    val respuesta = scan.next().uppercase()
    return respuesta == "S"
}

/**
 * Calcula la suma total de los billetes seleccionados.
 *
 * @author Gerard y Noa
 * @since 15/12/2025
 */
fun calcularTotal(lista: List<InfoBillete>): Double {
    var suma = 0.0
    for (b in lista) {
        suma += b.precioFinal
    }
    return suma
}

/**
 * Gestiona el proceso de introducción de monedas y billetes.
 * Solo acepta valores de curso legal especificados.
 *
 * @param total La cantidad total a pagar.
 * @author Gerard y Noa
 * @since 15/12/2025
 */
fun gestionarPago(scan: Scanner, total: Double) {
    var restante = total

    // Valores válidos permitidos
    val valoresValidos = listOf(0.05, 0.10, 0.20, 0.50, 1.0, 2.0, 5.0, 10.0, 20.0, 50.0)

    println("Ha de pagar ${String.format("%.2f", total)}€")

    while (restante > 0.009) { // Usamos margen pequeño para evitar errores de punto flotante
        println("Introdueixi monedes o bitllets vàlids de EURO:")

        if (scan.hasNextDouble()) {
            val input = scan.nextDouble()

            // Verificamos si el dinero introducido es válido
            if (valoresValidos.contains(input)) {
                restante -= input
                if (restante > 0) {
                    println("Ha introduït: ${String.format("%.2f", input)}€, li resta per pagar ${String.format("%.2f", restante)}€")
                }
            } else {
                println("Import no vàlid. Només s'accepten: 0.05, 0.10, 0.20, 0.50, 1, 2, 5, 10, 20, 50.")
            }
        } else {
            scan.next() // Limpiar entrada incorrecta
        }
    }

    // Si ha pagado de más, calculamos el cambio
    if (restante < 0) {
        val cambio = Math.abs(restante)
        println("Reculli el seu bitllet i el seu canvi: ${String.format("%.2f", cambio)}€")
    } else {
        println("Reculli el seu bitllet.")
    }
}

/**
 * Pregunta si se quiere imprimir el ticket y muestra el resumen final.
 *
 * @author Gerard y Noa
 * @since 15/12/2025
 */
fun gestionarTicket(scan: Scanner, lista: List<InfoBillete>, total: Double) {
    println("Vols el tiquet [S,N]")
    val resp = scan.next().uppercase()

    if (resp == "S") {
        println("--- TIQUET ---")
        for (b in lista) {
            println("${b.nombre} zona ${b.zona}  Preu: ${String.format("%.2f", b.precioFinal)}€")
        }
        println("----------------")
        println("TOTAL: ${String.format("%.2f", total)}€")
        println("Reculli el teu tiquet.")
    }
}