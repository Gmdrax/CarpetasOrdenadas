import java.util.Scanner


//Llegeix el preu original i el preu actual i imprimeix el descompte (en %).
fun main() {

    val scan = Scanner(System.`in`)

    var original = scan.nextDouble()
    var actual = scan.nextDouble()


    println(""+(100 - (actual * 100) / original) +"%")

}


