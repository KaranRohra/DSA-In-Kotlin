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

    selectionSort(a,n)

    print("Sorted Array: ")
    for(i in a)
        print("$i ")
}
fun selectionSort(a: IntArray, n: Int){
    var minPos: Int
    var temp: Int
    for(i in 0 until n-1){
        minPos=i
        for(j in i until n){
            if(a[j]<a[minPos])
                minPos=j
        }
        temp=a[minPos]
        a[minPos]=a[i]
        a[i]=temp
    }
}