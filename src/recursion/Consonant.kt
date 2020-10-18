package recursion

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    print("Enter a String:")
    val str = sc.next()
    println("Number of Consonants:"+consonantCount(str,str.length))
}
fun consonantCount(str: String,n: Int,i: Int=0): Int{
    return if(i == n)
        0
    else if(str[i]!='a' && str[i]!='e' && str[i]!='i' && str[i]!='o' && str[i]!='u' && str[i]!='A' && str[i]!='E' && str[i]!='I' && str[i]!='O' && str[i]!='U')
        consonantCount(str,n,i+1)+1
    else
        consonantCount(str,n,i+1)
}