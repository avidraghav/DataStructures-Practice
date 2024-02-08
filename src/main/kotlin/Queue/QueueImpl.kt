package Queue

class QueueImpl<T> : Queue<T> {
    private val storage = mutableListOf<T>()
    var size = 0
        private set

    override fun toString() = buildString {
        // appendLine("----top----")
        storage.forEach {
            append("$it")
        }
        //     appendLine("----bottom------")
    }

    override fun add(element: T) {
        storage.add(element)
        size++
    }

    override fun remove() {
        storage.removeFirst()
        size--
    }

    override fun peek(): T {
        return storage.first()
    }

}