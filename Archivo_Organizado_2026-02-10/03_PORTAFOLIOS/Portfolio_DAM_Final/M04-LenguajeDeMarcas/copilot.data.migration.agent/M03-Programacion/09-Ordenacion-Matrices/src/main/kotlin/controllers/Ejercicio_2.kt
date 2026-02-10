package controllers

/**
 * Calcula el nombre de parelles de ratolins al cap de n mesos.
 * Seqüència de Fibonacci: 1, 1, 2, 3, 5...
 *
 * @param mesos Nombre de mesos transcorreguts.
 * @return Nombre total de parelles.
 */
fun calcularRatolins(mesos: Int): Int {

    //si estem al mes 0 o 1, només hi ha 1 parella.
    if (mesos == 0 || mesos == 1) {
        return 1
    }

    //implementamos esta funcion para hacerlo mas rebusto despues de los test
    if (mesos < 0) return -1

    //ratolins avui = ratolins mes anterior + nous naixements
    //els nous naixements són igual al nombre de parelles fèrtils
    return calcularRatolins(mesos - 1) + calcularRatolins(mesos - 2)
}


fun main() {





}