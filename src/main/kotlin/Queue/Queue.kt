package Queue

interface Queue<T> {
    fun add(element: T)
    fun remove()
    fun peek(): T
}