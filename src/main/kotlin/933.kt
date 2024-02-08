import Queue.QueueImpl

fun main() {
    val obj = RecentCounter()
}

class RecentCounter() {
    private val que = QueueImpl<Int>()

    fun ping(t: Int): Int {
        que.add(t)
        if (t > 3000) {
            while (que.peek() < (t - 3000)) {
                que.remove()
            }
        }
        return que.size
    }

}
