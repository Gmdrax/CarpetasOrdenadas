import java.util.Scanner
import java.util.Locale

// ==========================================
// 1. CREACIÓN DE LISTAS (Diapositiva: Declaració)
// ==========================================

/**
 * Crea una lista que NO se puede modificar (Immutable).
 * Útil para datos fijos: Días de la semana, configuraciones...
 */
fun crearListaFija(): List<String> {
    return listOf("Lunes", "Martes", "Miércoles", "Jueves", "Viernes")
}

/**
 * Crea una lista que SÍ se puede modificar (Mutable).
 * Útil para inventarios, carritos de compra, listas de alumnos...
 * Se puede crear vacía usando mutableListOf<Tipo>().
 */
fun crearListaModificable(): MutableList<String> {
    // Opción A: Crear con datos iniciales
    // return mutableListOf("Rojo", "Verde", "Azul")

    // Opción B: Crear vacía (muy común en exámenes)
    return mutableListOf<String>()
}

// ==========================================
// 2. ACCESO A DATOS (Diapositiva: Funcions immutables)
// ==========================================

/**
 * Accede a un elemento. Funciona igual que los arrays.
 */
fun obtenerElemento(lista: List<String>, posicion: Int): String {
    return lista[posicion] // O lista.get(posicion)
}

/**
 * Funciones rápidas para obtener extremos.
 */
fun obtenerExtremos(lista: List<String>) {
    if (lista.isNotEmpty()) {
        println("Primero: ${lista.first()}")
        println("Último: ${lista.last()}")
    }
}

// ==========================================
// 3. SEGURIDAD CONTRA NULLS (Diapositiva: Nulabilitat)
// ==========================================

/**
 * Accede a una posición de forma segura.
 * Si la posición no existe, devuelve null en vez de dar error.
 * Uso: .elementAtOrNull(pos)
 */
fun obtenerSeguro(lista: List<String>, posicion: Int): String? {
    return lista.elementAtOrNull(posicion)
}

/**
 * Obtiene el primero o último de forma segura.
 * Si la lista está vacía, devuelve null.
 * Uso: .firstOrNull() y .lastOrNull()
 */
fun obtenerExtremosSeguros(lista: List<String>) {
    val primero = lista.firstOrNull() ?: "Lista vacía"
    val ultimo = lista.lastOrNull() ?: "Lista vacía"
    println("Primero: $primero, Último: $ultimo")
}

/**
 * Comprueba si la lista está vacía.
 * El temario menciona .none() (devuelve true si está vacía o no cumple condición).
 * También existe .isEmpty().
 */
fun estaVacia(lista: List<String>): Boolean {
    return lista.none() // O lista.isEmpty()
}

// ==========================================
// 4. MODIFICACIÓN (Solo MutableList) (Diapositiva: Funcions mutables)
// ==========================================

/**
 * Añade elementos a la lista.
 * Uso: .add(elemento) o .add(posicion, elemento)
 */
fun anadirElemento(lista: MutableList<String>, nuevoElemento: String) {
    lista.add(nuevoElemento) // Lo añade al final
}

fun insertarElemento(lista: MutableList<String>, posicion: Int, nuevoElemento: String) {
    if (posicion in 0..lista.size) {
        lista.add(posicion, nuevoElemento) // Lo inserta en medio
    }
}

/**
 * Elimina elementos.
 * Uso: .remove(objeto) o .removeAt(indice)
 */
fun eliminarElemento(lista: MutableList<String>, elemento: String) {
    lista.remove(elemento) // Elimina la primera aparición de "elemento"
}

fun eliminarPorPosicion(lista: MutableList<String>, posicion: Int) {
    if (posicion in lista.indices) {
        lista.removeAt(posicion) // Elimina lo que haya en esa posición
    }
}

/**
 * Modifica un valor existente.
 * Uso: lista[pos] = valor o lista.set(pos, valor)
 */
fun modificarElemento(lista: MutableList<String>, posicion: Int, nuevoValor: String) {
    if (posicion in lista.indices) {
        lista[posicion] = nuevoValor
    }
}

/**
 * Borra TODO el contenido de la lista.
 * Uso: .clear()
 */
fun vaciarLista(lista: MutableList<String>) {
    lista.clear()
}

// ==========================================
// 5. ITERACIÓN (Diapositiva: Iterar llistes)
// ==========================================

/**
 * Recorrer por valor (Foreach).
 * El más sencillo si no necesitas la posición.
 */
fun imprimirListaSimple(lista: List<String>) {
    for (elemento in lista) {
        println(elemento)
    }
}

/**
 * Recorrer por índice.
 * Útil si necesitas saber la posición (ej: "Elemento 5: Patata").
 */
fun imprimirListaConIndices(lista: List<String>) {
    for (i in lista.indices) {
        println("Posición $i: ${lista[i]}")
    }
}

// ==========================================
// 7. ALGORITMOS DE MOVIMIENTO (Swap/Francesco)
// ==========================================

/**
 * [NUEVA] Intercambia dos elementos de posición.
 * Fundamental para algoritmos de ordenación o "adelantamientos".
 */
fun intercambiar(lista: MutableList<String>, pos1: Int, pos2: Int) {
    if (pos1 in lista.indices && pos2 in lista.indices) {
        val temp = lista[pos1]
        lista[pos1] = lista[pos2]
        lista[pos2] = temp
    }
}

/**
 * [NUEVA] Busca un elemento y lo adelanta una posición (Swap con el anterior).
 * Lógica exacta del ejercicio "Francesco Virgolini".
 */
fun adelantarElemento(lista: MutableList<String>, elemento: String) {
    val pos = lista.indexOf(elemento)
    // Solo adelantamos si existe (pos != -1) y no es el primero (pos > 0)
    if (pos > 0) {
        intercambiar(lista, pos, pos - 1)
    }
}

// ==========================================
// 8. LÓGICA DE LISTAS PARALELAS Y TABLAS (Pokémon)
// ==========================================

/**
 * [NUEVA] Crea una "Tabla de Máximos" (Direct Access Table).
 * Útil cuando tienes IDs numéricos (ej: Pokédex 1..700) y quieres guardar
 * el mejor valor (Nivel) asociado a cada ID.
 * @param indices Lista con los IDs (ej: listaPokedex)
 * @param valores Lista con los valores a comparar (ej: listaNiveles)
 * @param maxId El ID más alto posible (ej: 700 para Pokémon).
 */
fun crearTablaDeMaximos(indices: List<Int>, valores: List<Int>, maxId: Int): MutableList<Int> {
    // Creamos una lista llena de 0s con tamaño suficiente
    val tablaMaximos = MutableList(maxId + 1) { 0 }

    // Recorremos las listas paralelas
    for (i in indices.indices) {
        val id = indices[i]
        val valor = valores[i]

        // Si encontramos un valor mayor al guardado, actualizamos
        if (valor > tablaMaximos[id]) {
            tablaMaximos[id] = valor
        }
    }
    return tablaMaximos
}

/**
 * [NUEVA] Itera dos listas paralelas (ej: Horas y Juegos).
 * Patrón usado en el ejercicio "Shitlist" de Albert.
 */
fun procesarListasParalelas(lista1: List<String>, lista2: List<Int>) {
    // Usamos el índice de la lista más corta para no salirnos
    val tamañoSeguro = minOf(lista1.size, lista2.size)

    for (i in 0 until tamañoSeguro) {
        println("En la posición $i: ${lista1[i]} va con ${lista2[i]}")
    }
}

// ==========================================
// 9. PROCESAMIENTO DE ADYACENTES (Parejas)
// ==========================================

/**
 * [NUEVA] Compara cada elemento con el SIGUIENTE.
 * Patrón usado en el ejercicio de añadir puntos suspensivos ("...").
 * Recorre hasta size - 1 para evitar error "IndexOutOfBounds".
 */
fun procesarParejasAdyacentes(lista: List<String>) {
    for (i in 0 until lista.size - 1) {
        val actual = lista[i]
        val siguiente = lista[i + 1]

        if (actual.length < siguiente.length) {
            println("$actual es más corta que $siguiente")
        }
    }
    // Recordatorio: El último elemento no se procesa dentro del bucle
    // porque no tiene "siguiente". Hay que tratarlo fuera si hace falta.
}

// ==========================================
// 11. FILTRADO AVANZADO (Club/Sabates)
// ==========================================

/**
 * [NUEVA] Filtra una lista permitiendo que un elemento "vetado"
 * aparezca solo UNA vez (la primera). El resto pasan siempre.
 */
fun filtrarConLimiteUnico(lista: List<String>, elementoLimitado: String): List<String> {
    val resultado = mutableListOf<String>()
    var yaAparecio = false

    for (elemento in lista) {
        if (elemento == elementoLimitado) {
            // Si es el elemento especial, solo lo añadimos si no ha salido antes
            if (!yaAparecio) {
                resultado.add(elemento)
                yaAparecio = true
            }
        } else {
            // Si es cualquier otro, pasa siempre
            resultado.add(elemento)
        }
    }
    return resultado
}

/**
 * [NUEVA] Cuenta cuántos elementos están dentro de un rango [min, max].
 * Lógica del ejercicio "Sabates".
 */
fun contarEnRango(lista: List<Int>, objetivo: Int, margen: Int): Int {
    val min = objetivo - margen
    val max = objetivo + margen

    // count {} es una función nativa de Kotlin muy potente para exámenes
    return lista.count { it >= min && it <= max }
}

// ==========================================
// 12. ALGORITMOS DE VISIBILIDAD (Cavalcada)
// ==========================================

/**
 * [NUEVA] Cuenta cuántos elementos son "visibles" desde atrás.
 * Un elemento es visible si es estrictamente MAYOR que el máximo de todos los que tiene delante.
 * Recorre la lista AL REVÉS (downTo).
 */
fun contarVisiblesDesdeAtras(alturas: List<Int>): Int {
    var contador = 0
    var alturaMaximaDelante = 0 // Inicializamos con 0 (o Int.MIN_VALUE si hay negativos)

    // Recorremos desde el final hasta el principio
    for (i in alturas.indices.reversed()) { // o (alturas.size - 1 downTo 0)
        val alturaActual = alturas[i]

        if (alturaActual > alturaMaximaDelante) {
            contador++
            alturaMaximaDelante = alturaActual // Actualizamos el "tapón"
        }
    }
    return contador
}

// ==========================================
// 13. VALIDACIÓN DE PATRONES (Clonador/Capicua)
// ==========================================

/**
 * [NUEVA] Comprueba si una lista es CAPICÚA (Palíndromo).
 * Se lee igual de izquierda a derecha que de derecha a izquierda.
 */
fun <T> esListaCapicua(lista: List<T>): Boolean {
    // La forma más rápida en Kotlin: comparar la lista con su reversa
    return lista == lista.reversed()
}

/**
 * [NUEVA] Comprueba si todos los elementos de una lista son iguales a un modelo.
 * Útil para el ejercicio "Clonador" (comparar trozos de ceros).
 */
fun todosSonIgualesA(lista: List<String>, modelo: String): Boolean {
    // all {} devuelve true si TODOS cumplen la condición
    return lista.all { it == modelo }
}

// ==========================================
// 10. MAIN DE EJEMPLO
// ==========================================
/*
fun main() {
    // 1. Crear
    val compra = crearListaModificable()
    anadirElemento(compra, "Manzanas")
    anadirElemento(compra, "Pan")
    anadirElemento(compra, "Leche")

    // 2. Probar Adelantamiento (Swap)
    adelantarElemento(compra, "Pan")

    // 3. Probar Visibilidad (Cavalcada)
    // Filas: [180, 160, 190, 150]. La de 150 ve. La de 190 ve (tapa a 160 y 180).
    val filas = listOf(180, 160, 190, 150)
    println("Filas que ven la cavalcada: ${contarVisiblesDesdeAtras(filas)}") // Debería ser 2 (150 y 190)

    // 4. Probar Capicua
    val numeros = listOf(1, 2, 3, 2, 1)
    if (esListaCapicua(numeros)) println("Es capicúa")
}
*/