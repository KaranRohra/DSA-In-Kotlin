package data_structures.arrays.queues

import java.util.*

fun main() {
    val sc= Scanner(System.`in`)
    val q=CircularQueue()
    var option:Int
    do{
        println("1: Enqueue")
        println("2: Dequeue")
        println("3: Check Front")
        println("4: Check Rear")
        println("5: isFull")
        println("6: isEmpty")
        println("7: Quit")
        print("Enter your option:")
        option=sc.nextInt()
        when(option){
            1->{
                print("Enter a data to enqueue:")
                val data=sc.nextInt()
                if(q.enqueue(data))
                    println("$data is Inserted")
                else
                    println("Enqueue operation failed")
            }
            2->{
                val data=q.dequeue()
                if(data!=-1)
                    println("$data is Deleted")
                else
                    println("Dequeue operation failed")
            }
            3-> {
                val data=q.checkFront()
                if(data!=-1)
                    println("$data is at Front of Queue")
                else
                    println("Check front operation failed")
            }
            4 -> {
                val data=q.checkRear()
                if(data!=-1)
                    println("$data is at Rear of Queue")
                else
                    println("Check Rear operation failed")
            }
            5 -> {
                if (q.isFull())
                    println("Queue is Full")
                else
                    println("Queue is not Full")
            }
            6->{
                if(q.isEmpty())
                    println("Queue is Empty")
                else
                    println("Queue have some element")
            }
        }
        println()
    }while (option in 1..6)
}
class CircularQueue {
    private val queueArray=IntArray(MAX)
    private var front=-1
    private var rear=-1
    private var count=0
    fun enqueue(date: Int):Boolean{
        if(count==MAX){
            println("Queue is Full")
            return false
        }
        if(front==-1)
            front++
        rear++
        if(rear==MAX)
            rear=0
        queueArray[rear]=date
        count++
        return true
    }
    fun dequeue():Int{
        if(count==0){
            println("Queue is Empty")
            return -1
        }
        val data=queueArray[front]
        front++
        count--
        if(count==0) {
            front = -1
            rear = -1
        }
        if(front == MAX)
            front=0
        return data
    }
    fun checkFront():Int{
        if(count==0){
            println("Queue is Empty")
            return -1
        }
        return queueArray[front]
    }
    fun checkRear():Int{
        if(count==0){
            println("Queue is Empty")
            return -1
        }
        return queueArray[rear]
    }
    fun isEmpty():Boolean=count==0
    fun isFull():Boolean=count==MAX
    companion object{
        const val MAX=100
    }
}