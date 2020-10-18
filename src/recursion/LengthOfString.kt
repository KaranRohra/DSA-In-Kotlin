package recursion

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    println("We are assuming that String is ending with \"/0\" ")
    print("Enter a String:")
    val str= sc.nextLine()+"/0"
    println("String length is ${length(str)}")
}

fun length(str: String,i: Int=0): Int{
    if(str[i]=='/' && str[i+1]=='0')
        return 0
    return 1+length(str,i+1)
}