package recursion

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    print("Enter a and b:")
    val a = sc.nextInt()
    val b = sc.nextInt()

    println("$a raise to $b is ${pow(a,b,1)}")
    println("$a raise to $b is ${fastPow(a,b)} Using Fast Power Method")
}
tailrec fun pow(a: Int,b: Int,r: Int): Int{
    if(b == 0)
        return r
    return pow(a,b-1,a*r)
}
fun fastPow(a: Int,b: Int): Int{// (a^2)^(b/2) == (a^(b/2))^2 == a^b
    if(b == 0)
        return 1
    else if(b%2 == 0)
        return fastPow(a*a,b/2)
    return a*fastPow(a,b-1)
}