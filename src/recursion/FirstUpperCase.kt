package recursion

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)

    print("Enter a String:")
    val str: CharArray = sc.nextLine().trim().toCharArray()

    firstUpper(str,str.size)
    print("Modified String:")
    println(str)
}
fun firstUpper(str: CharArray,n: Int,i: Int=0){
    if(i==n)
        return
    else if(i==0)
        str[i]=str[i].toUpperCase()
    else if(str[i]==' ' && str[i+1]>='a' && str[i+1]<='z')
        str[i+1]=str[i+1].toUpperCase()
    firstUpper(str,n,i+1)
}