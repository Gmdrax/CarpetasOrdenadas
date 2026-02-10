package problemas

import java.util.Scanner

fun main() {
    val scan = Scanner(System.`in`)

    println("Introduce una posible contraseña para analizar:")
    // Leemos la línea entera porque puede tener espacios (aunque las contraseñas no debieran)
    val input = scan.nextLine()

    // 1. Limpieza (Trim)
    // Quitamos espacios sobrantes al principio y final
    val password = input.trim()

    // 2. Análisis de longitud
    val longitud = password.length
    println("Longitud detectada: $longitud caracteres")

    // 3. Validación compleja (Recorrer char a char)
    var tieneMayuscula = false
    var tieneMinuscula = false
    var tieneNumero = false
    var contadorVocales = 0
    val vocales = "aeiouAEIOU"

    // Recorremos el string letra a letra
    for (caracter in password) {
        // Comprobamos el tipo de carácter
        if (caracter.isUpperCase()) tieneMayuscula = true
        if (caracter.isLowerCase()) tieneMinuscula = true
        if (caracter.isDigit()) tieneNumero = true

        // Contamos vocales (Búsqueda dentro de otro string)
        // 'in' devuelve true si el caracter está dentro del string 'vocales'
        if (caracter in vocales) contadorVocales++
    }

    // 4. Transformación (Cifrado básico)
    // Vamos a ocultar las vocales cambiándolas por asteriscos '*'
    // Usamos map para transformar cada char y joinToString para volver a unirlo
    val passwordOculta = password.map { char ->
        if (char in vocales) '*' else char
    }.joinToString("")

    // 5. Comparación (Palíndromo)
    // Comprobamos si se lee igual al revés (ignorando mayúsculas)
    val esPalindromo = password.equals(password.reversed(), ignoreCase = true)

    // 6. Resultados
    println("--- ANÁLISIS ---")
    println("Tiene mayúsculas: ${if (tieneMayuscula) "SÍ" else "NO"}")
    println("Tiene números: ${if (tieneNumero) "SÍ" else "NO"}")
    println("Total vocales: $contadorVocales")
    println("Versión censurada: $passwordOculta")
    if (esPalindromo) println("¡CURIOSO! Es un palíndromo.")

    // Nivel de seguridad (Lógica final)
    if (longitud >= 8 && tieneMayuscula && tieneNumero) {
        println("VEREDICTO: Contraseña Segura")
    } else {
        println("VEREDICTO: Contraseña Débil")
    }
}