class Queue(val size: Int) {
    val array = IntArray(size)
    var front: Int = 0
    var rear: Int = -1

    fun isFull(): Boolean {
        if (rear == size - 1) {
            println("Queue is full.")
            return true
        }

        return false
    }

    fun isEmpty(): Boolean {
        if (rear == -1) {
            return true
        }

        return false
    }

    fun enQueue(value: Int) {
        if (isFull()) {
            println("Queue is full. Cannot add element.")
        }

        array[++rear] = value
    }

    fun deQueue(): Int {
        if (isEmpty()) {
            println("Queue is empty. Cannot remove element")
        }

        return array[front++]
    }

    fun peek(): Int {
        return array[front]
    }
}

fun main(args: Array<String>) {
    val queue = Queue(5)

    queue.enQueue(3)
    queue.enQueue(2)
    queue.enQueue(5)
    println(queue.deQueue())
    println(queue.peek())
    queue.enQueue(7)
    queue.enQueue(9)
    println(queue.deQueue())
    println(queue.deQueue())
}