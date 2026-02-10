package controllers

fun main() {
    println(multiplicar(15,3))
}

/**Multiplica dos números sense fer servir operadors aritmètics
 *
 * @param Int Primer multiplicador
 * @param Int Segon multiplicador
 * @return La multiplicació dels dos nombres introduïts
 * @author Gerard, Joel, Leo
 */
fun multiplicar(a: Int, b: Int): Int{
    var result:Int

    when{
        a==0||b==0 -> result=0
        b==1 -> result=a
        b==-1 -> result=-a
        else ->{
            //Dividim els valors
            val aDoubled=a shl 1
            val bHalved=b shr 1

            //Adaptem la formula per si és parell o senar
            if (b and 1==1){
                result=multiplicar(aDoubled,bHalved)+a
            }else{
                result=multiplicar(aDoubled,bHalved)
            }
        }
    }

    return result
}