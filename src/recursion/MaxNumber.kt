package recursion

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    print("Enter number of elements:")
    val n = sc.nextInt()
    val a = IntArray(n)
    print("Enter elements:")
    for (i in 0 until n)
        a[i] = sc.nextInt()
    println("Maximum number is ${max(a, n - 1)}")
}
fun max(a: IntArray,i: Int): Int {
    if (i == 0)
        return a[0]
    var max = max(a, i - 1)
    if (a[i] > max)
        max = a[i]
    return max
}