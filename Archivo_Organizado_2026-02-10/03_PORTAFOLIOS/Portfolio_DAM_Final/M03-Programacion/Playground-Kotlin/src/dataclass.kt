import java.util.Scanner
import java.util.Locale

// ==========================================
// 1. DEFINICIÓN DE CLASES (PLANTILLAS)
// ==========================================
// IMPORTANTE: En el examen, define estas clases FUERA del main().

/**
 * [MODELO ESTÁNDAR] (Diapositiva: Definició)
 * Se usa para agrupar datos heterogéneos (String, Int, etc).
 */
data class Alumno(
    val nombre: String,
    val apellidos: String,
    var nota: Double // 'var' para poder modificarla
)

/**
 * [MODELO PRODUCTO] (Exercici Compra)
 * Útil para gestionar precios y nombres.
 */
data class Producto(
    val nombre: String,
    val precio: Float
)

/**
 * [MODELO CON TRAMPA] (Diapositiva: Tasques comunes - Compte!)
 * Las propiedades dentro de las llaves { } NO se incluyen en copy(), equals() ni toString().
 */
data class AlumnoConTrampa(val nombre: String) {
    var notaExtra: Int = 0
}

// ==========================================
// 2. CREACIÓN Y LECTURA
// ==========================================

fun crearScanner(): Scanner {
    return Scanner(System.`in`).useLocale(Locale.US)
}

/**
 * Lee variables sueltas y empaqueta un objeto.
 */
fun leerAlumno(scan: Scanner): Alumno {
    val nombre = scan.next()
    val apellidos = scan.next()
    val nota = scan.nextDouble()
    return Alumno(nombre, apellidos, nota)
}

/**
 * Crea una lista de objetos leyendo N veces.
 */
fun leerListaAlumnos(scan: Scanner, cantidad: Int): MutableList<Alumno> {
    val lista = mutableListOf<Alumno>()
    repeat(cantidad) {
        lista.add(leerAlumno(scan))
    }
    return lista
}

// ==========================================
// 3. FUNCIONES MÁGICAS (Copy, Equals, ToString)
// ==========================================

/**
 * [COPY] Crea un clon del objeto cambiando solo un dato.
 */
fun corregirNota(alumnoOriginal: Alumno, nuevaNota: Double): Alumno {
    return alumnoOriginal.copy(nota = nuevaNota)
}

/**
 * [EQUALS] Compara si dos objetos tienen EL MISMO CONTENIDO.
 */
fun sonIguales(a1: Alumno, a2: Alumno): Boolean {
    return a1 == a2
}

// ==========================================
// 4. LÓGICA CON LISTAS DE OBJETOS (BÚSQUEDA)
// ==========================================

/**
 * [BÚSQUEDA] Encuentra un alumno por su nombre.
 */
fun buscarPorNombre(lista: List<Alumno>, nombreBuscado: String): Alumno? {
    return lista.find { it.nombre == nombreBuscado }
}

/**
 * [MÁXIMOS] Encuentra al alumno con la nota más alta.
 */
fun buscarMejorAlumno(lista: List<Alumno>): Alumno? {
    return lista.maxByOrNull { it.nota }
}

/**
 * [MÍNIMOS] Encuentra el producto más barato (mínimo).
 * Útil para ejercicio "El més barat".
 */
fun buscarProductoMasBarato(lista: List<Producto>): Producto? {
    // minByOrNull devuelve el objeto con el valor más bajo en esa propiedad
    return lista.minByOrNull { it.precio }
}

// ==========================================
// 5. ORDENACIÓN Y POSICIONES (NUEVO)
// ==========================================

/**
 * [ORDENAR] Ordena la lista por precio (de mayor a menor).
 * Útil para ejercicio "El més car".
 */
fun ordenarPorPrecioDesc(lista: List<Producto>): List<Producto> {
    return lista.sortedByDescending { it.precio }
}

/**
 * [ORDENAR ALFABÉTICAMENTE] Ordena por nombre (A-Z).
 */
fun ordenarPorNombre(lista: List<Producto>): List<Producto> {
    return lista.sortedBy { it.nombre }
}

/**
 * [POSICIÓN CONCRETA] Obtiene el objeto en la posición P de una lista ordenada.
 * Recuerda restar 1 porque los índices empiezan en 0.
 */
fun obtenerEnPosicion(lista: List<Producto>, posicionHumana: Int): Producto {
    // Si piden "el 3º producto", accedemos al índice 2.
    return lista[posicionHumana - 1]
}

// ==========================================
// 6. LÓGICA RELATIVA (Anterior/Siguiente) (NUEVO)
// ==========================================

/**
 * [ANTERIOR] Busca un objeto y devuelve el que está JUSTO ANTES en la lista.
 * Útil para ejercicio "I TAMBE TINC...".
 * Devuelve null si es el primero o no existe.
 */
fun obtenerAnteriorA(lista: List<Producto>, nombreBuscado: String): Producto? {
    // 1. Buscamos dónde está el objeto
    val indice = lista.indexOfFirst { it.nombre == nombreBuscado }

    // 2. Si existe (indice != -1) y NO es el primero (indice > 0)
    if (indice > 0) {
        return lista[indice - 1]
    }
    return null
}

// ==========================================
// 7. FORMATO Y VISUALIZACIÓN (NUEVO)
// ==========================================

/**
 * [FORMATO PRECIO] Devuelve un String con el precio formateado a 2 decimales.
 * Vital para que el juez acepte la respuesta (ej: 10.50 en vez de 10.5).
 */
fun formatearPrecio(precio: Float): String {
    // %.2f significa "float con 2 decimales"
    return String.format(Locale.US, "%.2f", precio)
}

/**
 * [FORMATO NOTA] Igual que el precio pero para Doubles.
 */
fun formatearNota(nota: Double): String {
    return String.format(Locale.US, "%.2f", nota)
}

// ==========================================
// 8. CÁLCULOS AGREGADOS (NUEVO)
// ==========================================

/**
 * [CALCULAR MEDIA] Calcula la nota final basada en porcentajes.
 * Útil para ejercicio "Notes Alumnes" (40% y 60%).
 */
fun calcularNotaFinal(parcial1: Float, parcial2: Float): Float {
    // Recordar poner la 'f' en los decimales si usamos Float
    return (parcial1 * 0.40f) + (parcial2 * 0.60f)
}

// ==========================================
// 9. MAIN DE EJEMPLO
// ==========================================
/*
fun main() {
    // 1. Crear objetos
    val p1 = Producto("Pan", 1.50f)
    val p2 = Producto("Agua", 0.80f)
    val p3 = Producto("Carne", 12.50f)

    val lista = mutableListOf(p1, p2, p3)

    // 2. Ordenar por precio (Caro a Barato)
    val ranking = ordenarPorPrecioDesc(lista) // [Carne, Pan, Agua]

    // 3. Obtener extremos
    val masCaro = ranking.first()
    val masBarato = ranking.last()

    // 4. Obtener por posición (el 2º más caro)
    val segundo = obtenerEnPosicion(ranking, 2) // Pan

    println("Caro: ${masCaro.nombre}, Barato: ${masBarato.nombre}")

    // 5. Formato bonito
    println("Precio formateado: ${formatearPrecio(masCaro.precio)}")
}
*/