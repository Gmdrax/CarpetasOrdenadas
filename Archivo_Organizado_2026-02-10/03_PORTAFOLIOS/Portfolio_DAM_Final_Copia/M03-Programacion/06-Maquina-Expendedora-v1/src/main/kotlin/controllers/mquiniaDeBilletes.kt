package org.example.controllers

import java.util.Scanner
import java.util.Locale

/**
 * Funció principal de l'aplicació.
 * Simplement inicialitza els recursos i crida a la lògica principal.
 *
 * @author Gerard y Noa
 * @since 16/12/2025
 */
fun main() {
    val scan = obrirScanner()

    //iniciem el bucle principal de la màquina
    iniciarMaquina(scan)

    tancarScanner(scan)
}

/**
 * Classe simple per agrupar les dades d'un bitllet.
 */
class DadesBitllet(var nom: String, var zona: Int, var preu: Double)

/**
 * Crea i configura l'escàner per llegir dades.
 * Usa Locale.US per assegurar que els decimals funcionin amb punt.
 *
 * @return L'objecte Scanner configurat.
 * @author Gerard y Noa
 * @since 16/12/2025
 */
fun obrirScanner(): Scanner {
    val sc = Scanner(System.`in`)
    //configurem per llegir decimals amb punt (ex: 2.50)
    sc.useLocale(Locale.US)
    return sc
}

/**
 * Tanca el recurs de l'escàner.
 *
 * @param sc L'escàner a tancar.
 * @author Gerard y Noa
 * @since 16/12/2025
 */
fun tancarScanner(sc: Scanner) {
    sc.close()
}

/**
 * Controla el cicle de vida de la màquina.
 * Es manté en bucle fins que es rep el codi d'apagada.
 *
 * @param scan L'escàner per llegir l'entrada.
 * @author Gerard y Noa
 * @since 16/12/2025
 */
fun iniciarMaquina(scan: Scanner) {
    var maquinaActiva = true
    var codiResultat: Int

    println("Iniciant sistema BITB...")

    //mantenim la màquina encesa infinitament fins al codi secret
    while (maquinaActiva) {
        //processem un client complet i guardem el resultat
        codiResultat = gestionarClient(scan)

        //comprovem si el resultat és el codi d'apagada
        if (codiResultat == 4321) {
            println("Codi secret introduït. Apagant el sistema...")
            maquinaActiva = false
        }
    }
}

/**
 * Gestiona tot el procés de compra d'un sol client (selecció i pagament).
 *
 * @param scan L'escàner d'entrada.
 * @return Un codi d'estat (0 per normal, 4321 per apagar).
 * @author Gerard y Noa
 * @since 16/12/2025
 */
fun gestionarClient(scan: Scanner): Int {
    //creem un array fix per guardar fins a 3 bitllets
    val cistellaCompra = arrayOfNulls<DadesBitllet>(3)
    var contadorBitllets = 0
    var codiEstatCompra = 0
    var seleccioFinalitzada = false

    //bucle per permetre comprar múltiples bitllets
    while (!seleccioFinalitzada) {
        //cridem a la funció per afegir un bitllet a la posició actual
        val codiOpcio = afegirBitllet(scan, cistellaCompra, contadorBitllets)

        //verifiquem si s'ha introduït el codi secret
        if (codiOpcio == 4321) {
            codiEstatCompra = 4321
            seleccioFinalitzada = true
        } else if (codiOpcio == 1) {
            //si s'ha afegit correctament, incrementem el comptador
            contadorBitllets = contadorBitllets + 1
        }

        //si no s'ha de apagar, comprovem si l'usuari vol seguir o ha omplert la cistella
        if (codiEstatCompra != 4321) {
            seleccioFinalitzada = verificarFiSeleccio(scan, contadorBitllets)
        }
    }

    //si no hi ha codi d'apagada i tenim bitllets, procedim a cobrar
    if (codiEstatCompra == 0 && contadorBitllets > 0) {
        processarPagament(scan, cistellaCompra, contadorBitllets)
    }

    //si tot ha anat bé, ens acomiadem del client
    if (codiEstatCompra == 0) {
        println("Adeu!!\n------------------------------------------------")
    }

    return codiEstatCompra
}

/**
 * Gestiona la lògica d'escollir un bitllet i afegir-lo a la llista.
 *
 * @param scan L'escàner.
 * @param cistellaCompra L'array on guardem els bitllets.
 * @param posicioActual La posició actual de l'array on guardarem el bitllet.
 * @return 1 si s'ha afegit, 0 si error/cancel, 4321 si codi secret.
 * @author Gerard y Noa
 * @since 16/12/2025
 */
fun afegirBitllet(scan: Scanner, cistellaCompra: Array<DadesBitllet?>, posicioActual: Int): Int {
    var resultatOperacio = 0

    mostrarMenuOpcions()

    //llegim l'opció de l'usuari de manera segura
    val opcioEscollida = llegirEnterSegur(scan)

    //comprovem si és el codi secret
    if (opcioEscollida == 4321) {
        resultatOperacio = 4321
    } else {
        //validem que l'opció estigui dins del rang permès
        if (opcioEscollida >= 1 && opcioEscollida <= 5) {
            val zonaSeleccionada = solicitarZona(scan)
            val nomBitllet = obtenirNomBitllet(opcioEscollida)
            val preuCalculat = calcularPreuBitllet(opcioEscollida, zonaSeleccionada)

            //guardem les dades en la posició lliure de l'array
            cistellaCompra[posicioActual] = DadesBitllet(nomBitllet, zonaSeleccionada, preuCalculat)

            mostrarDetallSeleccio(nomBitllet, zonaSeleccionada, preuCalculat)
            resultatOperacio = 1
        } else {
            println("Opció no vàlida.")
            resultatOperacio = 0
        }
    }
    return resultatOperacio
}

/**
 * Determina si s'ha d'acabar el bucle de compra.
 *
 * @param scan Escàner.
 * @param nombreBitllets Nombre actual de bitllets comprats.
 * @return True si s'ha d'acabar, False si es continua.
 * @author Gerard y Noa
 * @since 16/12/2025
 */
fun verificarFiSeleccio(scan: Scanner, nombreBitllets: Int): Boolean {
    var finalitzarBucle = false

    //si ja tenim 3 bitllets, forcem la sortida
    if (nombreBitllets >= 3) {
        println("Màxim de bitllets assolit (3).")
        finalitzarBucle = true
    } else if (nombreBitllets > 0) {
        //si encara hi ha lloc, preguntem a l'usuari explícitament
        val volContinuar = preguntarSiNo(scan)
        if (!volContinuar) {
            finalitzarBucle = true
        }
    }
    return finalitzarBucle
}

/**
 * Calcula i gestiona el cobrament i la impressió del tiquet.
 *
 * @param scan Escàner.
 * @param cistellaCompra Array de bitllets.
 * @param totalElements Quants bitllets vàlids hi ha a l'array.
 * @author Gerard y Noa
 * @since 16/12/2025
 */
fun processarPagament(scan: Scanner, cistellaCompra: Array<DadesBitllet?>, totalElements: Int) {
    //calculem el preu total sumant tots els bitllets
    val importTotal = sumarPreusCistella(cistellaCompra, totalElements)

    //iniciem el procés de introducció de monedes
    gestionarEntradaDiners(scan, importTotal)

    //oferim el tiquet al final
    imprimirTiquetFinal(scan, cistellaCompra, totalElements, importTotal)
}

/**
 * Suma els preus de l'array de bitllets.
 *
 * @param cistellaCompra Array de bitllets.
 * @param quantitatBitllets Quants elements hi ha plens.
 * @return La suma total.
 * @author Gerard y Noa
 * @since 16/12/2025
 */
fun sumarPreusCistella(cistellaCompra: Array<DadesBitllet?>, quantitatBitllets: Int): Double {
    var sumaAcumulada = 0.0
    var indexActual = 0

    //iterem sobre l'array només fins a la quantitat de bitllets venuts
    while (indexActual < quantitatBitllets) {
        //sumem el preu del bitllet actual al total
        sumaAcumulada = sumaAcumulada + cistellaCompra[indexActual]!!.preu
        indexActual = indexActual + 1
    }
    return sumaAcumulada
}

/**
 * Mostra les opcions del menú principal.
 *
 * @author Gerard y Noa
 * @since 16/12/2025
 */
fun mostrarMenuOpcions() {
    println("Quin bitllet desitja adquirir?")
    println("1. Bitllet senzill")
    println("2. TCasual")
    println("3. TUsual")
    println("4. TFamiliar")
    println("5. TJove")
}

/**
 * Llegeix un enter validant que sigui un número.
 *
 * @param scan L'escàner.
 * @return L'enter llegit o -1 si era invàlid.
 * @author Gerard y Noa
 * @since 16/12/2025
 */
fun llegirEnterSegur(scan: Scanner): Int {
    var valorLlegit = 0
    //comprovem si el següent token és un enter
    if (scan.hasNextInt()) {
        valorLlegit = scan.nextInt()
    } else {
        scan.next() //consumim l'entrada invàlida per netejar el buffer
        valorLlegit = -1
    }
    return valorLlegit
}

/**
 * Demana la zona validant que sigui 1, 2 o 3.
 *
 * @param scan L'escàner.
 * @return La zona vàlida.
 * @author Gerard y Noa
 * @since 16/12/2025
 */
fun solicitarZona(scan: Scanner): Int {
    var zonaValidada = 0
    var esDadaValida = false

    //repetim fins que l'usuari introdueixi una zona correcta
    while (!esDadaValida) {
        println("Quina zona vol viatjar? [1, 2, 3]")
        val entradaUsuari = llegirEnterSegur(scan)

        //verifiquem que estigui dins del rang
        if (entradaUsuari >= 1 && entradaUsuari <= 3) {
            zonaValidada = entradaUsuari
            esDadaValida = true
        } else {
            println("Zona incorrecta.")
        }
    }
    return zonaValidada
}

/**
 * Tradueix el codi numèric al nom del bitllet.
 *
 * @param codiOpcio Codi del bitllet.
 * @return El nom en String.
 * @author Gerard y Noa
 * @since 16/12/2025
 */
fun obtenirNomBitllet(codiOpcio: Int): String {
    var nomResultat = "Desconegut"

    //assignem el nom manualment segons el codi
    if (codiOpcio == 1) nomResultat = "Bitllet senzill"
    else if (codiOpcio == 2) nomResultat = "TCasual"
    else if (codiOpcio == 3) nomResultat = "TUsual"
    else if (codiOpcio == 4) nomResultat = "TFamiliar"
    else if (codiOpcio == 5) nomResultat = "TJove"

    return nomResultat
}

/**
 * Calcula el preu segons tipus i zona sense usar mapes.
 *
 * @param tipusBitllet Codi del bitllet.
 * @param numeroZona Zona escollida.
 * @return Preu final calculat.
 * @author Gerard y Noa
 * @since 16/12/2025
 */
fun calcularPreuBitllet(tipusBitllet: Int, numeroZona: Int): Double {
    var preuBase = 0.0

    //assignem el preu base segons la taula
    if (tipusBitllet == 1) preuBase = 2.40
    else if (tipusBitllet == 2) preuBase = 11.35
    else if (tipusBitllet == 3) preuBase = 40.00
    else if (tipusBitllet == 4) preuBase = 10.00
    else if (tipusBitllet == 5) preuBase = 80.00

    //calculem el multiplicador segons la zona
    var factorMultiplicador = 1.0
    if (numeroZona == 2) factorMultiplicador = 1.3125
    else if (numeroZona == 3) factorMultiplicador = 1.8443

    return preuBase * factorMultiplicador
}

/**
 * Gestiona la introducció de monedes fins a pagar el total.
 *
 * @param scan Escàner.
 * @param preuTotalAPagar Quantitat a pagar.
 * @author Gerard y Noa
 * @since 16/12/2025
 */
fun gestionarEntradaDiners(scan: Scanner, preuTotalAPagar: Double) {
    var importPendent = preuTotalAPagar

    println("Ha de pagar " + formatarDosDecimals(preuTotalAPagar) + "€")

    //bucle mentre quedi import pendent (usem 0.009 per precisió decimal)
    while (importPendent > 0.009) {
        println("Introdueixi monedes o bitllets vàlids de EURO:")

        var dinersIntroduits = 0.0
        //llegim l'entrada comprovant que sigui un double
        if (scan.hasNextDouble()) {
            dinersIntroduits = scan.nextDouble()
        } else {
            scan.next() //netegem entrada incorrecta
        }

        //validem si la moneda és de curs legal
        if (validarMoneda(dinersIntroduits)) {
            //restem l'import introduït al pendent
            importPendent = importPendent - dinersIntroduits
            mostrarEstatCompte(dinersIntroduits, importPendent)
        } else {
            println("Import no vàlid.")
        }
    }

    retornarCanvi(importPendent)
}

/**
 * Comprova si la moneda és vàlida manualment.
 *
 * @param valorMoneda Valor introduït.
 * @return True si és vàlid.
 * @author Gerard y Noa
 * @since 16/12/2025
 */
fun validarMoneda(valorMoneda: Double): Boolean {
    var esMonedaValida = false

    //comprovem manualment cada valor permès
    if (valorMoneda == 0.05 || valorMoneda == 0.10 || valorMoneda == 0.20 || valorMoneda == 0.50) esMonedaValida = true
    else if (valorMoneda == 1.0 || valorMoneda == 2.0 || valorMoneda == 5.0) esMonedaValida = true
    else if (valorMoneda == 10.0 || valorMoneda == 20.0 || valorMoneda == 50.0) esMonedaValida = true

    return esMonedaValida
}

/**
 * Imprimeix l'estat actual del pagament.
 *
 * @param importIntroduit Quantitat introduïda.
 * @param importRestant Quantitat que falta.
 * @author Gerard y Noa
 * @since 16/12/2025
 */
fun mostrarEstatCompte(importIntroduit: Double, importRestant: Double) {
    //només mostrem quant falta si el valor és positiu
    if (importRestant > 0.009) {
        println("Ha introduït: " + formatarDosDecimals(importIntroduit) + "€, li resta per pagar " + formatarDosDecimals(importRestant) + "€")
    }
}

/**
 * Calcula i mostra el canvi si s'escau.
 *
 * @param saldoFinal Valor final (si és negatiu, és canvi a tornar).
 * @author Gerard y Noa
 * @since 16/12/2025
 */
fun retornarCanvi(saldoFinal: Double) {
    //si el saldo és negatiu, significa que hem de tornar canvi
    if (saldoFinal < -0.009) {
        //convertim a positiu per mostrar el canvi
        val canviATornar = saldoFinal * -1.0
        println("Reculli el seu bitllet i el seu canvi: " + formatarDosDecimals(canviATornar) + "€")
    } else {
        println("Reculli el seu bitllet.")
    }
}

/**
 * Pregunta S o N a l'usuari.
 *
 * @param scan Escàner.
 * @return True si és Sí.
 * @author Gerard y Noa
 * @since 16/12/2025
 */
fun preguntarSiNo(scan: Scanner): Boolean {
    var respostaEsAfirmativa = false
    println("Vols seguir comprant? [S,N]")
    val textResposta = scan.next()

    //comprovem si la resposta és 'S' o 's' sense usar funcions complexes
    if (textResposta == "S" || textResposta == "s") {
        respostaEsAfirmativa = true
    }
    return respostaEsAfirmativa
}

/**
 * Imprimeix el detall del bitllet acabat de seleccionar.
 *
 * @param nomBitllet Nom del bitllet.
 * @param numeroZona Zona.
 * @param preuFinal Preu calculat.
 * @author Gerard y Noa
 * @since 16/12/2025
 */
fun mostrarDetallSeleccio(nomBitllet: String, numeroZona: Int, preuFinal: Double) {
    println("Ha escollit la opcio: " + nomBitllet + ", zona " + numeroZona)
    println("El preu del bitllet es " + formatarDosDecimals(preuFinal) + "€")
}

/**
 * Genera el tiquet final si l'usuari ho demana.
 *
 * @param scan Escàner.
 * @param cistellaCompra Array amb les dades.
 * @param quantitatElements Quantitat de bitllets venuts.
 * @param preuTotalCompra Preu total acumulat.
 * @author Gerard y Noa
 * @since 16/12/2025
 */
fun imprimirTiquetFinal(scan: Scanner, cistellaCompra: Array<DadesBitllet?>, quantitatElements: Int, preuTotalCompra: Double) {
    println("Vols el tiquet [S,N]")
    val textResposta = scan.next()

    //si l'usuari diu que sí, imprimim el detall
    if (textResposta == "S" || textResposta == "s") {
        println("--- TIQUET ---")

        var indexActual = 0
        //recorrem l'array per mostrar cada línia del tiquet
        while (indexActual < quantitatElements) {
            val bitlletActual = cistellaCompra[indexActual]!!
            println(bitlletActual.nom + " zona " + bitlletActual.zona + "  Preu: " + formatarDosDecimals(bitlletActual.preu) + "€")
            indexActual = indexActual + 1
        }

        println("----------------")
        println("TOTAL: " + formatarDosDecimals(preuTotalCompra) + "€")
        println("Reculli el teu tiquet.")
    }
}

/**
 * Funció auxiliar per formatar a 2 decimals sense lògica complexa repetida.
 *
 * @param valorNumeric El número a formatar.
 * @return String formatat.
 * @author Gerard y Noa
 * @since 16/12/2025
 */
fun formatarDosDecimals(valorNumeric: Double): String {
    return String.format("%.2f", valorNumeric)
}