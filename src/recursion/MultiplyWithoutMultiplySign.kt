package recursion

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    print("Enter two numbers to multiply:")
    val a = sc.nextInt()
    val b = sc.nextInt()
    val c = multiply(a, b)
    val d = multiply(maxOf(a,b), minOf(a,b))// for making good time complexity
    println("$a * $b = $c")
    println("$a * $b = $d")
}
fun multiply(a: Int,b: Int,i: Int=0): Int{
    if(i==b)
        return 0
    return a + multiply(a,b,i+1)
}