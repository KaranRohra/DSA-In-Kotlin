package recursion

import java.util.*
fun main() {
    val sc = Scanner(System.`in`)
    print("Enter number elements:")
    val n = sc.nextInt()
    print("Enter elements:")
    val a = IntArray(n)
    for(i in 0 until n)
        a[i] = sc.nextInt()

    runningLoop(a,n)

    print("Sorted Array:")
    for(i in 0 until n)
        print("${a[i]} ")
}
tailrec fun runningLoop(a: IntArray,n: Int,i: Int=0){
    if(i == n)
        return
    swappingLoop(a,n,i)
    runningLoop(a,n,i+1)
}
tailrec fun swappingLoop(a: IntArray,n: Int,i: Int,j: Int=0){
    if(j == n-i-1)
        return
    if(a[j] > a[j+1]){
        val temp = a[j]
        a[j] = a[j+1]
        a[j+1] = temp
    }
    swappingLoop(a,n,i,j+1)
    //Hello
}
