package algorithm.sorting

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)

    print("Enter number of elements:")
    val n = sc.nextInt()

    print("Enter element:")
    val a = IntArray(n)
    for(i in 0 until n)
        a[i]=sc.nextInt()

    quickSort(a,0,n-1)

    print("Sorted Array: ")
    for(i in a)
        print("$i ")
}
fun quickSort(a: IntArray,lb: Int,ub: Int){
    if(lb<ub){
        var i = lb
        var j = ub
        val pivot = a[lb]
        var temp: Int
        while (i<j){
            i++
            while(i<=ub && a[i]<pivot)
                i++
            while(j>=lb && a[j]>pivot)
                j--
            if(i<j){
                temp=a[j]
                a[j]=a[i]
                a[i]=temp
            }
        }
        temp=a[j]
        a[j]=a[lb]
        a[lb]=temp

        quickSort(a,lb,j-1)
        quickSort(a,j+1,ub)
    }
}