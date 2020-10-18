package data_structures.arrays.stack

interface Stack<T> {
    fun push(data: T): Boolean
    fun pop(): Any?
    fun peek(): Any?
    fun isEmpty(): Boolean
    fun isFull(): Boolean
}