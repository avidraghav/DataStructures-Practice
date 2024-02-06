package Stack

interface Stack<T : Any> {
    fun push(element: T)
    fun pop(): T?
    fun peek(): T?
}