package graph


fun main() {
    val maxHeap = MaxHeap()
    maxHeap.add(10)
    maxHeap.add(20)
    maxHeap.add(15)
    maxHeap.add(30)
    maxHeap.add(40)

}

class MaxHeap {
    val list = mutableListOf<Int>()
    var heapEnd = list.lastIndex

    fun add(element: Int) {
        list.add(element)
        heapEnd = list.lastIndex
        var indexOfInsertedElement = list.lastIndex
        var targetIndex = list.lastIndex

        if (list.lastIndex == 0){
            print(list[targetIndex])
            println()
            return
        }

        while (targetIndex >= 0) {
            targetIndex = (targetIndex -1) / 2
            if (targetIndex in list.indices
                && element > list[targetIndex]
            ) {
                val temp = list[targetIndex]
                list[targetIndex] = element
                list[indexOfInsertedElement] = temp
                indexOfInsertedElement = targetIndex

                if (targetIndex == 0)
                    break

            } else break
        }

        list.forEach {
            print("$it ")
        }
        println()
    }
}