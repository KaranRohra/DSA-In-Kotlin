package data_structures.arrays.queues

import java.util.*

fun main() {
    val sc= Scanner(System.`in`)
    val q=PriorityQueue()
    var option:Int
    do{
        println("1: Enqueue")
        println("2: Dequeue")
        println("3: Check Front")
        println("4: Check Rear")
        println("5: Display")
        println("6: isFull")
        println("7: isEmpty")
        println("8: Quit")
        print("Enter your option:")
        option=sc.nextInt()
        when(option){
            1->{
                print("Enter a data to enqueue:")
                val data=sc.nextInt()
                print("Enter Priority:")
                val pri=sc.nextInt()
                if(q.enqueue(data,pri))
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
            5-> q.display()
            6-> {
                if(q.isFull())
                    println("Queue is Full")
                else
                    println("Queue is not Full")
            }
            7->{
                if(q.isEmpty())
                    println("Queue is Empty")
                else
                    println("Queue have some element")
            }
        }
        println()
    }while (option in 1..7)
}
class PriorityQueue {
    private val queueArray = IntArray(MAX)
    private val priority = IntArray(MAX)
    private var rear=-1
    private var front=-1

    fun enqueue(data: Int,pri: Int): Boolean{
        if(rear== MAX-1){
            println("Queue is Full")
            return false
        }
        if(front==-1){
            rear++
            front++
            queueArray[front]=data
            priority[front]=pri
            return true
        }
        var i=front
        val pos: Int
        while (i<=rear && priority[i]>=pri)
            i++
        pos=i
        while (i<=rear){
            queueArray[i+1]=queueArray[i]
            priority[i+1]=priority[i]
            i++
        }
        rear++
        queueArray[pos]=data
        priority[pos]=pri
        return true
    }
    fun dequeue():Int{
        if(front==-1){
            println("Queue is empty")
            return -1
        }
        val data=queueArray[front]
        front++
        if(front>rear){
            front=-1
            rear=-1
        }
        return data
    }
    fun checkFront():Int{
        if(front==-1){
            println("Queue is empty")
            return -1
        }
        return queueArray[front]
    }
    fun checkRear():Int{
        if(rear==-1){
            println("Queue is empty")
            return -1
        }
        return queueArray[rear]
    }
    fun display(){
        if(front!=-1)
        for(i in front..rear)
            print("${queueArray[i]} ")
        else
            print("Queue is Empty")
        println()
    }
    fun isFull():Boolean=rear == MAX -1
    fun isEmpty():Boolean=front == -1
    companion object{
        private const val MAX=100
    }
}