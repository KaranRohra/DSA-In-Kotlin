package data_structures.arrays.stack

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val c = Conversions()
    var option: Int
    do{
        println("1: Infix to Postfix")
        println("2: Infix to Postfix with Parentheses")
        println("3: Infix->Postfix Evaluation")
        println("4: Infix to Prefix")
        println("5: Infix to Prefix with Parentheses")
        println("6: Prefix Evaluation")
        println("7: Quit")
        print("Enter Your Option:")
        option=sc.nextInt()

        when(option){
            1->{
                print("Enter Infix Expression:")
                val infix=sc.next()
                val postfix = c.infixToPostfix(infix)
                println("Postfix Expression:$postfix")
            }
            2->{
                print("Enter Infix Expression:")
                val infix=sc.next()
                val postfix = c.infixToPostfixWithParentheses(infix)
                println("Postfix Expression:$postfix")
            }
            3->{
                print("Enter Infix Expression:")
                val infix=sc.next()
                val postfix= c.infixToPostfixWithParentheses(infix)
                println("Postfix Expression:$postfix")
                println("Evaluation:${c.postfixEvaluation(postfix)}")
            }
        }
    }while(option!=7)
}