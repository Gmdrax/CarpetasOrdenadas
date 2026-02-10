package utilities

import java.util.Scanner

fun demanarInt(msg: String, scan: Scanner): Int {
    var numero: Int = 0
    var correcto = false

    while (!correcto) {
        print(msg)
        if (scan.hasNextInt()) {
            numero = scan.nextInt()
            correcto = true
        } else {
            scan.nextLine()
        }

    }
    return numero
}

fun demanarDouble(msg: String, scan: Scanner): Double {
    var numero: Double = 0.0
    var correcto = false

    while (!correcto) {
        print(msg)
        if (scan.hasNextDouble()) {
            numero = scan.nextDouble()
            correcto = true
        } else {
            scan.nextLine()
        }

    }
    return numero
}

fun demanarFloat(msg: String, scan: Scanner): Float {
    var numero: Float = 0.0f
    var correcto = false

    while (!correcto) {
        print(msg)
        if (scan.hasNextFloat()) {
            numero = scan.nextFloat()
            correcto = true
        } else {
            scan.nextLine()
        }

    }
    return numero
}

fun demanarString(msg: String, scan: Scanner): String {
    var numero: String = " "
    var correcto = false

    while (!correcto) {
        print(msg)
        if (scan.hasNext()) {
            numero = scan.next()
            correcto = true
        } else {
            scan.nextLine()
        }

    }
    return numero
}