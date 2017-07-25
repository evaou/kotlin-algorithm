class Stack(val size: Int) {
    val array = IntArray(size)
    var top = -1

    fun push(data: Int) {
        if (isFull()) {
            println("Stack is full and cannot push data.")
        } else {
            array[++top] = data
        }
    }

    fun pop(): Int {
        if (isEmpty()) {
            println("Stack is empty and cannot pop data.")
            return -1
        } else {
            return array[top--]
        }
    }

    fun peek(): Int {
        if (isEmpty()) {
            println("Stack is empty and cannot be peeked")
            return -1
        } else {
            return array[top]
        }
    }

    fun isFull(): Boolean {
        return (top == (size - 1))
    }

    fun isEmpty(): Boolean {
        return (top == -1)
    }
}

fun main(args: Array<String>) {
    val stack = Stack(3)

    stack.pop()
    stack.push(3)
    stack.push(11)
    stack.push(13)
    stack.push(12)
    stack.pop()
    println(stack.peek())
    stack.push(5)
    println(stack.peek())
    stack.pop()
    stack.pop()
    stack.pop()
    println(stack.peek())
}