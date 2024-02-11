package Tree

data class BinaryNode<T : Any>(
    val value: T,
    val left: BinaryNode<T>,
    val right: BinaryNode<T>
) {
    override fun toString(): String {
        return "$value"
    }
}