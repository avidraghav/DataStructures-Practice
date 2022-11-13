package LinkedList

class LinkedList<T : Any> {

    var head: Node<T>? = null
        private set
    var tail: Node<T>? = null
        private set
    var size = 0
        private set

    private fun isEmpty() = size == 0

    override fun toString(): String {
        return if (isEmpty()) {
            "Empty List"
        } else {
            head.toString()
        }
    }

    // Insert at 1st position
    // O(1)
    fun push(value: T): LinkedList<T> = apply {
        head = Node(value = value, next = head)
        if (tail == null) {
            tail = head
        }
        size++
    }

    // Insert at Last position
    // O(1)
    fun append(value: T): LinkedList<T> = apply {
        if (isEmpty()) {
            push(value)
            return@apply
        }
        val tail = Node(value = value, null)
        this.tail!!.next = tail
        this.tail = tail
        size++
    }

    // Insert at any given position
    // To find the insertion position - O(pos)
    // To insert O(1)
    fun insert(value: T, pos: Int): LinkedList<T> = apply {
        if (isEmpty() || pos == 1) {
            push(value)
            return@apply
        }
        val newNode = Node(value, null)
        if (pos == 2) {
            var pointer = head

            pointer = head!!.next

            newNode.next = pointer
            head!!.next = newNode
            size++
            return@apply
        }
        var p1 = head
        var p2 = p1
        for (i in 1 until pos) {
            p1 = p1!!.next
            if (i == pos - 2)
                p2 = p1
        }
        newNode.next = p1
        p2!!.next = newNode
        size++
    }

    // remove from LinkedList
    // remove from front O(1)
    // to find the deletion position O(pos)
    // delete O(1)
    fun popAt(pos: Int = 1) = apply {
        if (pos > size) {
            if (isEmpty())
                return@apply
            else {
                println("invalid position")
                return@apply
            }
        } else if (pos == 1) {
            head = head!!.next
        } else if (pos == 2) {
            var pointer = head
            pointer = head!!.next
            head!!.next = pointer!!.next
            pointer.next = null
        } else {
            var pointer = head
            var p1 = head
            for (i in 1 until pos) {
                pointer = pointer!!.next
                if (i == pos - 2)
                    p1 = pointer
            }
            p1!!.next = pointer!!.next
            if (pos == size) {
                tail = null
                tail = p1
            } else {
                pointer.next = null
            }
        }
        size--
    }
}












