package org.example.controllers

import java.io.File
import java.util.Scanner

data class Client(
    val codi: Int,
    val nom: String,
    val cognoms: String,
    val DN: String,
    val adreca: String,
    val email: String
)


val fichero = File("clients.txt")

fun main() {
    val scan = Scanner(System.`in`)
    if (!fichero.exists()) fichero.createNewFile()

    var numero = -1
    while (numero != 0) {
        mostrarOpciones()
        if (scan.hasNextInt()) {
            numero = scan.nextInt()
            scan.nextLine()
            menu(numero, scan)
        } else {
            scan.next()
            numero = -1
        }
    }
}

fun mostrarOpciones (){
    println("""
    (1) Alta client
    (2) Consultar Client per posicio
    (3) Consultar Client per codi        
    (4) Modificar Client
    (5) Esborrar Client
    (6) Listat Client
   
    """)
}

fun menu(numero: Int, scan: Scanner) {
    when (numero) {
        1 -> altaClient(fichero, scan)
        2 -> consultarPosicio(fichero, scan)
         3 -> consultarCodi(fichero, scan)
        // 4 -> modificarClient(fichero, scan)
        // 5 -> esborrarClient(fichero, scan)
        // 6 -> llistatClients(fichero,scan)
        0 -> println("Adéu!")
        else -> println("Opció no vàlida")
    }

}

fun clientToString(client: Client): String {
    return "%-6d".format(client.codi) +
            "%-20s".format(client.nom.take(20)) +
            "%-30s".format(client.cognoms.take(30)) +
            "%-8s".format(client.DN.take(8)) +
            "%-40s".format(client.adreca.take(40)) +
            "%-30s".format(client.email.take(30))
}

fun altaClient(fichero: File, scan: Scanner) {
    println("NOU CLIENT")

    print("Codi: "); val codi = scan.nextInt(); scan.nextLine()

    if (codi==codi){
        println("persona ya registrada")
    }

    print("Nom: "); val nom = scan.nextLine()
    print("Cognoms: "); val cognoms = scan.nextLine()
    print("Data (DDMMYYYY): "); val data = scan.nextLine()
    print("Adreça: "); val adreca = scan.nextLine()
    print("Email: "); val email = scan.nextLine()

    val nouClient = Client(codi, nom, cognoms, data, adreca, email)

    fichero.appendText(clientToString(nouClient) + "\n")

    println("Client guardat correctament")
    println("Prem ENTER per tornar al menú")
    scan.nextLine()
}

fun consultarPosicio(fichero: File, scan: Scanner) {
    print("Quin número de registre vols veure? ")
    val posicion = scan.nextInt()
    scan.nextLine()

    val llistat = fichero.readLines()

    if (posicion > 0 && posicion <= llistat.size) {

        val linea = llistat[posicion - 1]

        println("CLIENT TROBAT")
        println("Codi:    " + linea.substring(0, 6).trim())
        println("Nom:     " + linea.substring(6, 26).trim())
        println("Cognoms: " + linea.substring(26, 56).trim())
        println("DNI:     " + linea.substring(56, 64).trim())
        println("Adreça:  " + linea.substring(64, 104).trim())
        println("Email:   " + linea.substring(104, 134).trim())

    } else {
        println("Aquesta posició no existeix")
    }

    println("Prem ENTER per tornar")
    scan.nextLine()
}


fun consultarCodi(fichero: File, scan: Scanner) {

    print("Introdueix el CODI del client a buscar: ")
    val codiBuscat = scan.nextLine()
    fichero.
    var trobat = false
    var i = 0

    while (i < lineas.size && !trobat) {
        val datos = lineas[i].split(";")

        if (datos[0] == codiBuscat) {
            if (datos[0] == codiBuscat) {
                println("\nClient trobat:")
                println(lineas[i])
                trobat = true
            }
            i++
        }

        if (!trobat) {
            println("\nError: No s'ha trobat cap registre amb el codi '$codiBuscat'")
            println(lineaEncontrada)
        }
    }
}
/*
fun modificarClient (numero : Int) : String{

}

fun esborrarClient (numero : Int) : String{

}

fun llistatClients (numero : Int) : String{

}*/