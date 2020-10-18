package recursion

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val str: String = sc.next()
    if(palindrome(str,str.length))
        println("Palindrome")
    else
        println("Not Palindrome")
}
tailrec fun palindrome(str: String,n: Int,i: Int=0): Boolean{
    return when(true){
        i==n -> true
        str[i]!=str[n-1] -> false
        else -> palindrome(str,n-1,i+1)
    }
}