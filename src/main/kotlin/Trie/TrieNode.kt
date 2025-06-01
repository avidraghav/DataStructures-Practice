package Trie

data class TrieNode(
    var prefixCount: Int = 0,
    var wordCount: Int = 0,
    var list: MutableList<TriePointer> = MutableList(26) { TriePointer() }
)

data class TriePointer(
    var char: Boolean = false,
    var next: TrieNode? = null,
)


fun main() {

    val trie = Trie()
    trie.insert("apple")
   // trie.insert("apple")
    println(trie.search("apple"))
}

class Trie {

    var root: TrieNode? = null
    fun insert(word: String) {
        if (root == null) root = TrieNode()
        var currentNode = root
        word.forEachIndexed { i, c ->
            val triePointer = currentNode?.list?.get(c - 'a')
            if (triePointer?.char == false) {
                triePointer.char = true
                val next = TrieNode()
                next.prefixCount = currentNode?.prefixCount?.plus(1) ?: 0
                next.wordCount = if (i == word.lastIndex) 1 else 0
                triePointer.next = next
                currentNode = next
            }
            else {
                currentNode = triePointer?.next
                currentNode?.prefixCount = currentNode?.prefixCount?.plus(1) ?: 0
                if (i == word.lastIndex)
                    currentNode?.wordCount = currentNode?.wordCount?.plus(1) ?: 0
            }
        }
    }

    fun search(word: String): Boolean {
        var currentNode = root ?: return false
        for (c in word) {
            val pointer = currentNode.list[c - 'a']
            if (!pointer.char || pointer.next == null) {
                return false
            }
            currentNode = pointer.next!!
        }
        return currentNode.wordCount > 0
    }


    fun startsWith(prefix: String): Boolean {
        var currentNode = root ?: return false
        for (c in prefix) {
            val pointer = currentNode.list[c - 'a']
            if (!pointer.char || pointer.next == null) {
                return false
            }
            currentNode = pointer.next!!
        }
        return true
    }


}





