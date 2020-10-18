package algorithm.sorting

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)

    print("Enter number of elements: ")
    val n = sc.nextInt()

    print("Enter element: ")
    val a = IntArray(n)
    for(i in 0 until n)
        a[i]=sc.nextInt()

    insertionSort(a,n)

    print("Sorted Array: ")
    for(i in a)
        print("$i ")
}
fun insertionSort(a: IntArray,n: Int){
    for(i in 1 until n){
        val key = a[i]
        var j = i-1
        while (j>=0 && a[j]>key){
            a[j+1]=a[j]
            j--
        }
        a[j+1]=key
    }
}