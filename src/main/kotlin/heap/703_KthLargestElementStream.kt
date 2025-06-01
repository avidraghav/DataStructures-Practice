package heap


fun main(){


    val o = KthLargest(3 , intArrayOf(4,5,8,2))
    println(o.add(3))
    println(o.add(5))

    val nums=intArrayOf(4,5,8,2)
    val map = mutableMapOf<Int,Pair<Int,Int>>()
    nums.forEach{num->
        map[num] = map.getOrDefault(num,Pair(num,0))
    }
}

class KthLargest(val k: Int, nums: IntArray) {
    val maxHeap = MaxHeap(nums)
    // val f = k

    fun add(`val`: Int): Int {
        maxHeap.add(`val`)
        if(maxHeap.size >= k && k>0){
            repeat(k-1){
                maxHeap.poll()
            }
        }
        return maxHeap.first()
    }

}


class MaxHeap(val nums:IntArray){
    private val heap = nums.toMutableList()
    val size get() = heap.size
    fun first() = heap.first()


    init {
        for(i in (heap.size/2 - 1) downTo 0)
         shiftDown(i)
    }

    fun add(num:Int){
        heap.add(num)
        shiftUp()
    }

    fun shiftUp(){
        var i = heap.lastIndex
        while(i>0){
            val parent = (i-1)/2
            if(heap[parent]<heap[i]){
                val temp = heap[parent]
                heap[parent] = heap[i]
                heap[i] = temp
                i = parent
            }else break
        }
    }

     fun poll(){
        heap[0] = heap.last()
        heap.removeAt(heap.lastIndex)
         for(i in (heap.size/2 - 1) downTo 0)
             shiftDown(i)
     }

    fun shiftDown(i:Int){
        var heapify = i
        val left = 2*i +1
        val right = 2*i +2

        if (left < size && heap[left] > heap[heapify]) {
            heapify = left
        }
        if (right < size && heap[right] > heap[heapify]) {
            heapify = right
        }

        if(heapify!=i){
            val temp = heap[i]
            heap[i] =  heap[heapify]
            heap[heapify] = temp

            shiftDown(heapify)
        }
            
    }



}

/**
 * Your KthLargest object will be instantiated and called as such:
 * var obj = KthLargest(k, nums)
 * var param_1 = obj.add(`val`)
 */