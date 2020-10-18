package recursion

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    print("Enter number of elements:")
    val n = sc.nextInt()
    val a = IntArray(n)
    print("Enter elements:")
    for(i in 0 until n)
        a[i] = sc.nextInt()

    print("Given numbers:")
    printArray1(a,n-1)

    print("\nGiven numbers:")
    printArray2(a,0,n)
}
//IN NORMAL RECURSION CALLING FUNCTION IS BETWEEN THE CODE (SEE POINT 1)
fun printArray1(a: IntArray,i: Int){
    if(i==0)
        print("${a[i]} ")
    else {
        printArray1(a, i - 1)// 1
        print("${a[i]} ")
    }
}
//IN TAIL RECURSION CALLING FUNCTION IS END OF THE CODE (SEE POINT 2)
tailrec fun printArray2(a: IntArray,i: Int,n: Int){
    if(i==n-1) {
        print("${a[i]} ")
        return
    }
    print("${a[i]} ")
    printArray2(a, i + 1,n)// 2
}
