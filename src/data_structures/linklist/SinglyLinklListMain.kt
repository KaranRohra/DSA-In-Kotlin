package data_structures.linklist

import java.util.*

fun main() {
    val sc=Scanner(System.`in`)
    val list=SinglyLinkList<Int>()
    var option: Int

    do {
        println("1: Insert")
        println("2: Delete")
        println("3: Search")
        println("4: Create")
        println("5: Destroy")
        println("6: isEmpty")
        println("7: Display")
        println("8: Size of LinkList")
        println("9: Quit")
        print("Enter your option:")
        option=sc.nextInt()

        when(option){
            1 -> {
                println("\n1: Insert Beginning")
                println("2: Insert After")
                println("3: Insert Before")
                println("4: Insert Position")
                println("5: Insert End")
                println("6: Quit")
                print("Enter your option:")
                val insertOption = sc.nextInt()
                var data = 0
                if (insertOption in 1..5) {
                    print("Enter Data to Insert:")
                    data = sc.nextInt()
                }
                when (insertOption) {
                    1 -> {
                        list.insertBeginning(data = data)
                        println("$data is Inserted")
                    }
                    2 -> {
                        print("Enter Key:")
                        val key = sc.nextInt()
                        if (list.insertAfter(data = data, key = key))
                            println("$data is Inserted After $key")
                        else
                            println("Insert operation failed")
                    }
                    3 -> {
                        print("Enter Key:")
                        val key = sc.nextInt()
                        if (list.insertBefore(data = data, key = key))
                            println("$data is Inserted Before $key")
                        else
                            println("Insert operation failed")
                    }
                    4 -> {
                        print("Enter Index:")
                        val index = sc.nextInt()
                        if (list.insertPosition(data = data, position = index))
                            println("$data is Inserted at $index Index")
                        else
                            println("Insert operation failed")
                    }
                    5 -> {
                        list.insertEnd(data = data)
                        println("$data is Inserted")
                    }
                }
            }
            2 -> {
                println("\n1: Delete Beginning")
                println("2: Delete After")
                println("3: Delete Before")
                println("4: Delete Position")
                println("5: Delete Node")
                println("6: Delete End")
                println("7: Quit")
                print("Enter your option:")
                when (sc.nextInt()) {
                    1 -> {
                        val data = list.deleteBeginning()
                        if (data != null)
                            println("$data is Delete")
                        else
                            println("Delete Operation Failed")
                    }
                    2 -> {
                        print("Enter key:")
                        val data = list.deleteAfter(sc.nextInt())
                        if (data != null)
                            println("$data is Delete")
                        else
                            println("Delete Operation Failed")
                    }
                    3 -> {
                        print("Enter key:")
                        val data = list.deleteBefore(sc.nextInt())
                        if (data != null)
                            println("$data is Delete")
                        else
                            println("Delete Operation Failed")
                    }
                    4 -> {
                        print("Enter Position:")
                        val data = list.deletePosition(sc.nextInt())
                        if (data != null)
                            println("$data is Delete")
                        else
                            println("Delete Operation Failed")
                    }
                    5->{
                        print("Enter Element to Delete:")
                        val data = list.deleteNode(sc.nextInt())
                        if (data != null)
                            println("$data is Delete")
                        else
                            println("Delete Operation Failed")
                    }
                    6->{
                        val data = list.deleteEnd()
                        if (data != null)
                            println("$data is Delete")
                        else
                            println("Delete Operation Failed")
                    }
                }
            }
            3->{
                print("Enter Element to Search:")
                val data = sc.nextInt()
                val index=list.search(data)
                if (index != -1)
                    println("$data is Present at $index")
                else
                    println("$data is Not Present in LinkList")
            }
            4->{
                if(list.create())
                    println("linkList is Created SuccessFully")
                else
                    println("Creation Operation Failed")
            }
            5->{
                list.destroy()
                println("LinkList is successfully Destroyed")
            }
            6-> {
                if(list.isEmpty())
                    println("LinkList Empty")
                else
                    println("LinkList is NOt Empty")
            }
            7 -> list.display()
            8 -> println("${list.size()} is Size of LinkList")
        }
        println()
    }while (option in 1..8)
}