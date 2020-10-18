package data_structures.arrays.queues

import java.util.*
fun main() {
    val sc= Scanner(System.`in`)
    val q=DoubleEndedQueue()
    var option:Int
    do{
        println("1: Enqueue from Rear")
        println("2: Dequeue from Front")
        println("3: Enqueue from Front")
        println("4: Dequeue from Rear")
        println("5: Check Front")
        println("6: Check Rear")
        println("7: isFull")
        println("8: isEmpty")
        println("9: Quit")
        print("Enter your option:")
        option=sc.nextInt()
        when(option){
            1->{
                print("Enter a data ,to enqueue:")
                val data=sc.nextInt()
                if(q.enqueueFromRear(data))
                    println("$data is Inserted at Rear")
                else
                    println("Enqueue operation failed")
            }
            2->{
                val data=q.dequeueFromFront()
                if(data!=-1)
                    println("$data is Deleted from Front")
                else
                    println("Dequeue operation failed")
            }
            3->{
                print("Enter a data ,to enqueue:")
                val data=sc.nextInt()
                if(q.enqueueFromFront(data))
                    println("$data is Inserted at Front")
                else
                    println("Enqueue operation failed")
            }
            4->{
                val data=q.dequeueFromRear()
                if(data!=-1)
                    println("$data is Deleted from Rear")
                else
                    println("Dequeue operation failed")
            }
            5-> {
                val data=q.checkFront()
                if(data!=-1)
                    println("$data is at Front of Queue")
                else
                    println("Check front operation failed")
            }
            6 -> {
                val data=q.checkRear()
                if(data!=-1)
                    println("$data is at Rear of Queue")
                else
                    println("Check Rear operation failed")
            }
            7-> {
                if(q.isFull())
                    println("Queue is Full")
                else
                    println("Queue is not Full")
            }
            8->{
                if(q.isEmpty())
                    println("Queue is Empty")
                else
                    println("Queue have some element")
            }
        }
        println()
    }while (option in 1..8)
}
class DoubleEndedQueue {
    private val queueArray=IntArray(MAX)
    private var front=-1
    private var rear=-1

    fun enqueueFromRear(data: Int):Boolean{
        if(rear==MAX-1){
            println("Queue is Full from Rear end")
            return false
        }
        if(front==-1)
            front=1
        rear++
        queueArray[rear]=data
        return true
    }
    fun dequeueFromFront():Int{
        if(front==-1){
            println("Queue is Empty from Front end")
            return -1
        }
        front++
        return queueArray[front-1]
    }
    fun enqueueFromFront(data:Int):Boolean{
        if(front==0){
            println("Queue is Full from Front end")
            return false
        }
        if(front==-1) {
            front = 0
            rear = 0
        }
        else
            front--
        queueArray[front]=data
        return true
    }
    fun dequeueFromRear():Int{
        if(rear==-1){
            println("Queue is Empty from Rear end")
            return -1
        }
        rear--
        return queueArray[rear+1]
    }
    fun checkFront():Int {
        if (front == -1) {
            println("Queue is empty")
            return -1
        }
        return queueArray[front]
    }
    fun checkRear():Int {
        if (rear == -1) {
            println("Queue is empty")
            return -1
        }
        return queueArray[rear]
    }
    fun isFull():Boolean=rear==MAX -1
    fun isEmpty():Boolean=front==-1
    companion object{
        const val MAX=100
    }
}