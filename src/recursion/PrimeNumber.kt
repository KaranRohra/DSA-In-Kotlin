package recursion

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    print("enter a number:")
    prime(sc.nextInt())
}
tailrec fun prime(n:Int,i: Int=2){
    if(n<=0){
        println("Invalid Input")
    }
    else if(i==n){
        println("$n is Prime Number")
    }
    else if(n==1 || n%i == 0 ){
        println("$n is Not a Prime Number")
    }
    else
    prime(n,i+1)
}