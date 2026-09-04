class LRUCache(val capacity: Int) {

    data class Node(var key:Int, var value:Int, var prev:Node?=null, var next:Node?=null)

    private val cache = HashMap<Int, Node>()

    private var left = Node(0,0)
    private var right = Node(0,0)

    init{
        left.next = right
        right.prev = left
    }


    fun get(key: Int): Int {
        val node = cache[key]?: return -1

        remove(node)
        insertAtRight(node)

        return node.value
    }

    fun put(key: Int, value: Int) {
        cache[key]?.let{remove(it)}
        val node = Node(key, value)
        cache[key] = node
        insertAtRight(node)

        if(cache.size>capacity){
            val lru = left.next!!
            remove(lru)
            cache.remove(lru.key)
        }
    }

    private fun remove(node:Node){
        val previous = node?.prev
        val next = node?.next

        previous?.next = next
        next?.prev = previous
    }

    private fun insertAtRight(node:Node){
        val previousMostRecent = right?.prev
        previousMostRecent?.next = node
        node?.prev = previousMostRecent
        node?.next = right
        right?.prev = node
    }
}
