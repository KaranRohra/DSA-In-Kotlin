package data_structures.arrays.stack

class MyStack<T>: Stack<T>{

    private val MAX=100
    private val myStack: Array<Any> = Array(MAX){}
    var top=-1

    override fun push(data: T): Boolean {
        if(top==MAX-1){
            println("Stack is Full")
            return false
        }
        myStack[++top]= data!!
        return true
    }

    override fun pop(): Any? {
        if(top==-1){
            println("Stack is Empty")
            return null
        }
        return myStack[top--]
    }

    override fun peek(): Any? {
        if(top==-1){
            println("Stack is Empty")
            return null
        }
        return myStack[top]
    }

    override fun isEmpty(): Boolean = top==-1
    override fun isFull(): Boolean = top==MAX-1
}