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

    override fun remove(): T? {
        val itemToRemoved = peek()
        return if (itemToRemoved != null) {
            storage.removeFirst()
            size--
            itemToRemoved
        } else {
            null
        }
    }

    override fun peek(): T? {
        if (size == 0)
            return null
        return storage.first()
    }

    override fun addAll(element: List<T>) {
        element.forEach { e->
            storage.add(e)
            size++
        }
    }

}