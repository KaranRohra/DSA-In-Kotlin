package data_structures.arrays.stack

import java.util.*

fun main(){
    val sc = Scanner(System.`in`)
    val s: Stack<Int> = MyStack()
    var option: Int
    menu@ do {
        println("1: Push")
        println("2: Pop")
        println("3: Peek")
        println("4: isEmpty")
        println("5: isFull")
        println("6: Quit")
        print("Enter your option:")
        option=sc.nextInt()
        when(option){
            1-> {
                print("Enter Data:")
                val data=sc.nextInt()
                if(s.push(data))
                    println("$data is successfully Pushed to Stack")
                else
                    println("Push operation failed")
            }
            2-> {
                val data = s.pop()
                if(data!=null)
                    println("$data is successfully Popped from Stack")
                else
                    println("Pop operation failed")
            }
            3-> {
                val data=s.peek()
                if(data!=null)
                    println("${s.peek()} is at top of Stack")
                else
                    println("Peek operation failed")
            }
            4-> if(s.isEmpty()) println("Stack is Empty") else println("Stack have some elements")
            5-> if(s.isFull()) println("Stack is Full") else println("Stack is not Full")
            6-> break@menu
            else-> println("Invalid Option")
        }
        println()
    }while(true)
}