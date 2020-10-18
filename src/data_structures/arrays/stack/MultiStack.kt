package data_structures.arrays.stack

import java.util.*

fun main() {
    val sc=Scanner(System.`in`)
    val s=MultiStack()
    var option1: Int
    var option2: Int
    do {
        println("1:Stack 1")
        println("2:Stack 2")
        println("3:Quit")
        println("Enter your option")
        option1=sc.nextInt()
        if(option1 in 1..2) {
            do {
                println("1:Push")
                println("2:Pop")
                println("3:Peek")
                println("4:Quit")
                println("Enter your option")
                option2 = sc.nextInt()
                when (option2) {
                    1 -> {

                    }
                }
            } while (option2 in 1..3)
        }
    }while (option1 in 1..2)
}
class MultiStack{
    private val stackArray = IntArray(MAX)
    var top1=-1
    var top2= MAX
    fun push(data: Int,option: Int):Boolean{
        when {
            top2-top1==1 -> {
                println("Stack is Full")
                return false
            }
            option==1 -> {
                top1++
                stackArray[top1]=data
                return true
            }
            option==2 -> {
                top2--
                stackArray[top2]=data
                return true
            }
            else -> {
                println("Invalid Option")
                return false
            }
        }
    }
    fun pop(option: Int):Int{
        when (option) {
            1 -> {
                return if(top1==-1){
                    println("Stack is empty")
                    -1
                } else {
                    top1--
                    stackArray[top1 + 1]
                }
            }
            2 -> {
                return if(top2== MAX){
                    println("Stack is empty")
                    -1
                } else {
                    top2++
                    stackArray[top2 - 1]
                }
            }
            else -> {
                println("Invalid Option")
                return -1
            }
        }
    }
    fun peek(option: Int):Int{
        when (option) {
            1 -> {
                return if(top1==-1){
                    println("Stack is empty")
                    -1
                } else
                    stackArray[top1]
            }
            2 -> {
                return if(top2== MAX){
                    println("Stack is empty")
                    -1
                } else
                    stackArray[top2]
            }
            else -> {
                println("Invalid Option")
                return -1
            }
        }
    }

    companion object {
        private const val MAX = 100
    }
}