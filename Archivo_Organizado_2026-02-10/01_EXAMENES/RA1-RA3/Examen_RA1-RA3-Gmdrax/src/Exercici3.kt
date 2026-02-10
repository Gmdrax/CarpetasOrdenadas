import java.util.Locale
import java.util.Scanner

//TODO : Exercici3

fun main() {

    val scan = Scanner(System.`in`).useLocale(Locale.US)
    var lineaDeTexto = scan.next()

    while (lineaDeTexto != "*") {

        //creamos la variebles y valores que leemos y luego iremos modificando poco a poco para scar el resultado  resultaod
        var esArticulado = scan.next()
        var peso = scan.nextInt()
        var tipoDeVehiculo = scan.next()
        var esMiembro = scan.next()
        var dias = scan.nextDouble()
        var puedeAparcar = true
        var precio = 0.0

        //println("$esArticulado, $esPesado, $tipoDeVehiculo, $esMiembro, $dias ")}}

        //en caso de ser articulado no podra aparcar
        if (esArticulado == "S") {
            puedeAparcar = false

        //en caso de no se articulado continuamos
        } else {

            //si pesa mas de 10000 se le aplica un precio de 50
            if (peso >= 10000) {
                precio = 50.0

            //en caso de no pesar esa cantidad seguimos segun el tipo de vehiculo
            } else {

                //definimos un precio diferente por cada vehiculo
                if (tipoDeVehiculo == "C") precio = 30.0
                else if (tipoDeVehiculo == "F" || tipoDeVehiculo == "4") precio = 20.0
                else if (tipoDeVehiculo == "T") precio = 10.0
                else if (tipoDeVehiculo == "M") precio = 7.0
                else precio = 3.0


            }
        }

        if (puedeAparcar){

            //en caso de poder aparcar cojemos el precio que le hemos puesto segun el tipo de vehiculo y lo multiplicamos por los dias
            var total = precio * dias

            //en caso de ser miembre aplicamos un 50% de descuento
            if (esMiembro == "S") total *= 0.5

            //mostramos el resultado por cada vehiculo de la lista
            println("S $total")
        }
        else{
            println("N")
        }

    lineaDeTexto = scan.next()

    }

}
