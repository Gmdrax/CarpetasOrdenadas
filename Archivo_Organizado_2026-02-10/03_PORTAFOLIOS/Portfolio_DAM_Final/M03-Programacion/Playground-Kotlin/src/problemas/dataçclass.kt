package problemas

import java.util.Scanner
import java.util.Locale

// 1. Definición de la Data Class (La Plantilla)
// Fuera del main para que sea accesible
data class Producto(
    val nombre: String,
    var precio: Double, // var porque el precio puede cambiar (rebajas)
    val stock: Int
)

fun main() {
    val scan = Scanner(System.`in`).useLocale(Locale.US)

    // 2. Crear una lista de Objetos (Inventario)
    val inventario = mutableListOf<Producto>()

    println("¿Cuántos productos vas a dar de alta?")
    val cantidad = scan.nextInt()

    // 3. Lectura y Creación de Objetos
    repeat(cantidad) {
        println("Producto ${it + 1}: (Nombre Precio Stock)")
        val nom = scan.next()
        val pre = scan.nextDouble()
        val sto = scan.nextInt()

        // Creamos el objeto y lo metemos en la lista
        val nuevoProd = Producto(nom, pre, sto)
        inventario.add(nuevoProd)
    }

    // 4. Lógica de Negocio: Buscar el más caro
    // maxByOrNull devuelve el OBJETO completo que tiene el precio máximo
    val masCaro = inventario.maxByOrNull { it.precio }
    // Usamos ?.nombre porque si la lista está vacía devuelve null
    println("El producto de lujo es: ${masCaro?.nombre} (${masCaro?.precio}€)")

    // 5. Calcular valor total del almacén
    // sumOf recorre y suma el resultado de la operación para cada item
    val valorTotal = inventario.sumOf { it.precio * it.stock }
    println("Valor total del inventario: $valorTotal€")

    // 6. Rebajas (Modificación con copy)
    println("¡REBAJAS! Bajamos un 10% a todo lo que cueste más de 50€")

    // Recorremos la lista usando índices para poder modificarla
    for (i in inventario.indices) {
        val prod = inventario[i]

        if (prod.precio > 50.0) {
            val nuevoPrecio = prod.precio * 0.90 // 10% descuento

            // TRUCO: Las data classes son inmutables en sus 'val',
            // pero como 'precio' es 'var', podríamos hacer prod.precio = ...
            // PERO la forma elegante y segura es usar COPY para actualizar la lista:
            inventario[i] = prod.copy(precio = nuevoPrecio)

            println("Rebajado: ${prod.nombre} ahora vale ${inventario[i].precio}")
        }
    }

    // 7. Filtrado final
    // Queremos ver solo lo que tiene poco stock (< 5 unidades)
    val casiAgotados = inventario.filter { it.stock < 5 }

    println("\n--- PRODUCTOS CASI AGOTADOS ---")
    if (casiAgotados.isEmpty()) {
        println("Todo bien de stock.")
    } else {
        // Imprimimos usando el toString() automático de la data class
        for (p in casiAgotados) {
            println(p) // Saldrá: Producto(nombre=..., precio=..., stock=...)
        }
    }
}