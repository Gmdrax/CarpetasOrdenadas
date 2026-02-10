import java.util.Scanner

//En una escola tenim tres classes i volem saber quin és el nombre de taules que necessitarem tenir en total. Dependrà del
//nombre d'alumnes per aula. Cal tenir en compte que a cada taula hi caben 2 alumnes.
fun main() {

    val scan = Scanner(System.`in`)

    var numero1 : Int = scan.nextInt()
    var numero2 : Int = scan.nextInt()
    var numero3 : Int = scan.nextInt()

    println((numero1 / 2) + (numero2 / 2) + (numero3 / 2))

}

