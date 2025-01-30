package Queue

interface Queue<T> {
    fun add(element: T)
    fun remove(): T?
    fun peek(): T?
    fun addAll(element: List<T>)
}