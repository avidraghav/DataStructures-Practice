package Stack

class StackImpl<T : Any> : Stack<T>{

    private var storage = arrayListOf<T>()

    override fun toString() = buildString {
        appendLine("----top----")
        storage.asReversed().forEach {
            appendLine("$it")
        }
        appendLine("----bottom------")
    }

    // adds an item to the stack in O(1) time
    override fun push(element: T) {
        storage.add(element)
    }

    // deletes an item from the stack in O(1) time and returns it
    override fun pop(): T? {
        return if(storage.isNotEmpty())
            storage.removeLast()
        else
            null
    }

}