import java.io.File
import java.util.Scanner

class Queue<T>(val size: Int) {
    val array = Array<Node<T>?>(size, {null})
    var front: Int = 0
    var rear: Int = -1

    fun isFull(): Boolean {
        if (rear == size - 1) {
            println("\nQueue is full.")
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

    fun enQueue(value: Node<T>) {
        if (isFull()) {
            println("\nQueue is full. Cannot add element.")
        }

        array[++rear] = value
    }

    fun deQueue(): Node<T>? {
        if (isEmpty()) {
            println("\nQueue is empty. Cannot remove element")
            return null
        }

        return array[front++]
    }

    fun peek(): Node<T>? {
        return array[front]
    }
}

class Node<T>(var data: T) {
    var left: Node<T>? = null
    var right: Node<T>? = null
    var isVisited: Boolean = false
}

fun buildTree(array: CharArray, idx: Int): Pair<Node<Char>?, Int> {
    var curIdx = idx
    var curNode: Node<Char>? = null
    var tmpNode: Node<Char>?
    var tmpChar: Char
    var isLeftDone = false
    var result: Pair<Node<Char>?, Int>

    tmpChar = array[++curIdx]
    while (tmpChar != ')') {

        if (tmpChar == '(') {
            result = buildTree(array, curIdx)
            tmpNode = result.first
            curIdx = result.second

            if (isLeftDone) {
                curNode!!.right = tmpNode
            } else {
                curNode!!.left = tmpNode
                isLeftDone = true
            }
        } else {
            curNode = Node(tmpChar)
            isLeftDone = false
        }

        tmpChar = array[++curIdx]
    }

    return Pair(curNode, curIdx)
}

fun printTree(tree: Node<Char>?) {
    if (tree == null) {
        print("()")
        return
    }

    print("(" + tree.data)
    if (tree.left == null && tree.right == null) {
        print("")
    } else {
        printTree(tree.left)
        printTree(tree.right)
    }
    print(")")
}

fun printBreadthFirstTraversal(tree: Node<Char>?, queue: Queue<Char>) {
    var node: Node<Char>? = tree
    var leftNode: Node<Char>?
    var rightNode: Node<Char>?
    var isRootVisited = false

    while (node != null) {
        if (!node.isVisited) {
            print(node.data)
            node.isVisited = true

            if (isRootVisited) {
                queue.enQueue(node)
            } else {
                isRootVisited = true
            }
        }

        leftNode = node.left
        rightNode = node.right

        if (leftNode != null) {
            node = leftNode
            print(node.data)
            node.isVisited = true
            queue.enQueue(node)
        }

        if (rightNode != null) {
            node = rightNode
            print(node.data)
            node.isVisited = true
            queue.enQueue(node)
        }

        node = queue.deQueue()
    }
}

fun main(args: Array<String>) {
    val filename = "input.txt"
    val file = File(filename)
    val input = Scanner(file)
    val inputStr = input.next()
    val inputChars = inputStr.toCharArray()
    val result: Pair<Node<Char>?, Int>
    val tree: Node<Char>?
    val queue = Queue<Char>(inputChars.size)

    result = buildTree(inputChars, 0)
    tree = result.first

    print("tree: ")
    printTree(tree)

    print("\nbreadth first traversal: ")
    printBreadthFirstTraversal(tree, queue)
}