package data_structures.linklist

import java.util.*

class SinglyLinkList<T>{
    private var head: Node? = null
    private var size=0
    // INSERT BEGINNING
    fun insertBeginning(data: T){
        val ptr=Node(data)
        ptr.next=head
        head=ptr
        size++
    }
    // INSERT AFTER
    fun insertAfter(data: T,key: T): Boolean{
        val ptr=Node(data)
        var p=head

        while(p!=null && p.data!=key)
            p= p.next
        if (p==null){
            println("Key Not Found")
            return false
        }
        ptr.next=p.next
        p.next=ptr
        size++
        return true
    }
    // INSERT BEFORE
    fun insertBefore(data: T,key: T):Boolean{
        val ptr=Node(data)
        var p=head
        var follow: Node? =null
        while (p!=null && p.data!=key){
            follow = p
            p= p.next
        }
        if(p==null){
            println("Key not Found")
            return false
        }
        if(follow==null) //if(p==head)
            head=ptr
        else
            follow.next=ptr
        ptr.next=p
        size++
        return true
    }
    // INSERT POSITION
    fun insertPosition(data: T,position: Int):Boolean{
        if(position !in 0..size) {
            println("Index is Not valid")
            return false
        }
        val ptr=Node(data)
        var p=head
        var follow: Node?=null
        var i=0
        while (p!=null && i!=position){
            follow=p
            p=p.next
            i++
        }
        if(follow==null) // p==head || i==0
            head=ptr
        else
            follow.next=ptr
        ptr.next=p
        size++
        return true
    }
    // INSERT END
    fun insertEnd(data: T){
        val ptr=Node(data)
        var p=head
        if(head==null){
            head=ptr
            return
        }
        while (p!!.next != null)
            p = p.next
        p.next = ptr
        size++
    }
    // DELETE BEGINNING
    fun deleteBeginning(): Any? {
        if(head==null){
            println("LinkList is Empty")
            return null
        }
        val data=head!!.data
        head=head!!.next
        size--
        return data
    }
    // DELETE AFTER
    fun deleteAfter(key: T): Any?{
        var p=head
        while (p!=null && p.data!=key)
            p=p.next
        if(p==null){
            println("Key Not Found")
            return null
        }
        if(p.next==null){
            println("End of LinkList")
            return null
        }
        val data=p.next!!.data
        p.next=p.next!!.next
        size--
        return data
    }
    // DELETE BEFORE
    fun deleteBefore(key: T): Any?{
        var prev2: Node?=null
        var prev1: Node?=null
        var p=head
        while (p!=null && p.data!=key) {
            prev2=prev1
            prev1=p
            p=p.next
        }
        if(p==null){
            println("Key Not Found")
            return null
        }
        if(p==head){
            println("Start of LinkList")
            return null
        }
        if(prev1==head){
            val data=head!!.data
            head=head!!.next
            return data
        }
        val data=prev1!!.data
        prev2!!.next=p
        prev1.next=null
        size--
        return data
    }
    // DELETE POSITION
    fun deletePosition(pos: Int): Any?{
        if(pos<0 || pos>size){
            println("Invalid Position")
            return null
        }
        var p=head
        var follow: Node?=null
        var i=0
        while (p!=null && i!=pos){
            follow=p
            p=p.next
            i++
        }
        if(follow==null)
            head=head!!.next
        else
            follow.next=p!!.next
        p!!.next=null
        size--
        return p.data
    }
    // DELETE NODE
    fun deleteNode(element: T): Any?{
        var p=head
        var follow: Node?=null
        while (p!=null && p.data!=element) {
            follow=p
            p = p.next
        }
        if(p==null){
            println("Element Not Found")
            return null
        }
        if(follow==null)
            head=head!!.next
        else
            follow.next=p.next
        p.next=null
        size--
        return p.data
    }
    // DELETE END
    fun deleteEnd():Any?{
        var p=head
        if(p==null){
            println("LinkList is Empty")
            return null
        }
        size--
        if(p.next==null) {
            head=null
            return p.data
        }
        while (p!!.next!!.next!=null)
            p=p.next
        val data=p.next!!.data
        p.next=null
        return data
    }
    // SEARCH
    fun search(key: Any): Int{
        var p=head
        var i=-1
        while (p!=null && p.data!=key) {
            p = p.next
            i++
        }
        return i
    }
    // CREATE
    fun create(): Boolean{
        val sc=Scanner(System.`in`)
        if(head!=null){
            println("LinkList already Created")
            return false
        }
        var option: Int
        do{
            println("1: To Insert")
            println("2: To Quit")
            print("Enter your Option:")
            option=sc.nextInt()
            if(option==1) {
                print("Enter data to Insert:")
                @Suppress("UNCHECKED_CAST")
                insertEnd(data = sc.nextInt() as T)
            }
        }while (option==1)
        return true
    }
    //IS EMPTY
    fun isEmpty(): Boolean=head==null
    // DESTROY
    fun destroy(){
        var p=head
        var follow: Node
        while (p!=null){
            follow=p
            p=p.next
            follow.next=null
        }
        head=null
    }
    // DISPLAY
    fun display(){
        var p=head
        if(head==null){
            println("LinkList is empty")
        }
        else{
            while (p!=null){
                print("${p.data} ")
                p=p.next
            }
        }
    }
    //SIZE
    fun size():Int=size
}