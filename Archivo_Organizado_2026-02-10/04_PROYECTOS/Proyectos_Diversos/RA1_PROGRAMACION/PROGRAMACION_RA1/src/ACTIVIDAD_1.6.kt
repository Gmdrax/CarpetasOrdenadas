import java.util.Scanner

//En una escola tenim tres classes i volem saber quin és el nombre de taules que necessitarem tenir en total. Dependrà del
//nombre d'alumnes per aula. Cal tenir en compte que a cada taula hi caben 2 alumnes.
fun main() {

    val scan = Scanner(System.`in`)

    var numero1 : Int = scan.nextInt()

        var clase1 = ((numero1/2)+ numero1%2)

    var numero2 : Int = scan.nextInt()

        var clase2 = ((numero2/2)+ numero2%2)

    var numero3 : Int = scan.nextInt()

        var clase3 = ((numero3/2)+ numero3%2)

    println(clase1 + clase2 + clase3)

}

