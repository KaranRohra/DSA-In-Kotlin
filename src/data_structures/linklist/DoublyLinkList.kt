package data_structures.linklist

import java.util.*

class DoublyLinkList<T> {
    private var head:Node?=null
    private var tail:Node?=null
    private var size:Int = 0

    // INSERT BEGINNING
    fun insertBeginning(data: T){
        val ptr=Node(data)
        ptr.next=head
        if(head==null)
            tail=ptr
        else
            head!!.prev=ptr
        head=ptr
        size++
    }
    // INSERT AFTER
    fun insertAfter(data: T,key: Any?): Boolean{
        val ptr=Node(data)
        var p=head
        while (p!=null && p.data!=key){
                p=p.next
        }
        if(p==null){
            println("Key Not Found")
            return false
        }
        ptr.next=p.next
        ptr.prev=p
        if(p.next!=null)
            p.next!!.prev=ptr
        else
            tail=ptr
        p.next=ptr
        size++
        return true
    }
    //INSERT BEFORE
    fun insertBefore(data: T,key: Any?): Boolean{
        val ptr=Node(data)
        var p=head
        val follow:Node?
        while (p!=null && p.data!=key)
            p=p.next
        if(p==null){
            println("Key Not Found")
            return false
        }
        follow=p.prev
        if(follow==null) {
            insertBeginning(data)
        }
        else{
            ptr.next=p
            ptr.prev=follow
            follow.next=ptr
            p.prev=ptr
            size++
        }
        return true
    }
    // INSERT POSITION
    fun insertPosition(data: T,position: Int):Boolean{
        if(position !in 1..size+1) {
            println("Index is Not valid,please enter index between 1 and ${size+1}")
            return false
        }
        val ptr=Node(data)
        var p=head
        var follow: Node?=null
        var i=1
        while (p!=null && i!=position) {
            follow=p
            p=p.next
            i++
        }
        if(p!=null)
            follow=p.prev
        when {
            p==null -> insertEnd(data)
            follow==null -> insertBeginning(data)
            else -> {
                ptr.prev=follow
                ptr.next=p
                follow.next=ptr
                p.prev=ptr
                size++
            }
        }
        return true
    }
    // INSERT END
    fun insertEnd(data: T) {
        val ptr = Node(data)
        if (head == null) {
            head = ptr
        } else {
            ptr.prev=tail
            tail!!.next=ptr
        }
        tail = ptr
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
        if(head==null)
            tail=null
        size--
        return data
    }
    // DELETE AFTER
    fun deleteAfter(key: T): Any?{
        var p=head
        val afterP: Node?
        while (p!=null && p.data!=key) {
            p = p.next
        }
        if(p==null){
            println("Key Not Found")
            return null
        }
        if(p.next==null){
            println("End of LinkList")
            return null
        }
        afterP=p.next

        p.next=afterP!!.next
        if(afterP.next!=null)
            afterP.next!!.prev=p
        else
            tail=p
        afterP.next=null
        afterP.prev=null
        val data=afterP.data
        size--
        return data
    }
    // DELETE BEFORE
    fun deleteBefore(key: T): Any? {
        val oneBeforeP: Node?
        val twoBeforeP: Node?
        var p = head
        while (p != null && p.data != key) {
            p = p.next
        }
        if (p == null) {
            println("Key Not Found")
            return null
        }
        if (p.prev == null) {
            println("Start of LinkList")
            return null
        }

        oneBeforeP=p.prev
        twoBeforeP=oneBeforeP!!.prev

        if (oneBeforeP == head) {
            head = head!!.next
        } else {
            twoBeforeP!!.next = p
            p.prev = twoBeforeP
        }
        oneBeforeP.next = null
        oneBeforeP.prev = null
        size--
        return oneBeforeP.data
    }
    // DELETE POSITION
    fun deletePosition(pos: Int): Any?{
        if(pos !in 1..size){
            println("Invalid Position")
            return null
        }
        var p=head
        var i=1
        while (p!=null && i!=pos){
            p=p.next
            i++
        }
        val oneBeforeP=p!!.prev
        if(oneBeforeP==null)
            head = head!!.next
        else
            oneBeforeP.next = p.next

        if(p.next!=null)
            p.next!!.prev = oneBeforeP
        else
            tail=oneBeforeP
        p.next=null
        p.prev=null
        size--
        return p.data
    }
    // DELETE NODE
    //todo
    fun deleteNode(element: T): Any?{
        var p=head

        while (p!=null && p.data!=element) {
            p = p.next
        }
        if(p==null){
            println("Element Not Found")
            return null
        }
        val oneBeforeP=p.prev
        if(oneBeforeP==null)
            head=head!!.next
        else
            oneBeforeP.next=p.next

        p.next=null
        p.prev=null
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
        val sc= Scanner(System.`in`)
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