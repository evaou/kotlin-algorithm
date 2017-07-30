import java.io.File
import java.util.Scanner

class Node<T>(var data: T) {
    var left: Node<T>? = null
    var right: Node<T>? = null
    var isVisited: Boolean = false
}

class Stack<T>(val size: Int) {
    val array = Array<Node<T>?>(size, {null})
    var top = -1

    fun push(data: Node<T>) {
        if (isFull()) {
            println("Stack is full and cannot push data.")
        } else {
            array[++top] = data
        }
    }

    fun pop(): Node<T>? {
        if (isEmpty()) {
            println("Stack is empty and cannot pop data.")
            return null
        } else {
            return array[top--]
        }
    }

    fun peek(): Node<T>? {
        if (isEmpty()) {
            println("Stack is empty and cannot be peeked")
            return null
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

fun printInOrder(tree: Node<Char>?) {
    if (tree == null) {
        return
    }

    printInOrder(tree.left)
    print(tree.data)
    printInOrder(tree.right)
}

fun printPreOrder(tree: Node<Char>?) {
    if (tree == null) {
        return
    }

    print(tree.data)
    printPreOrder(tree.left)
    printPreOrder(tree.right)
}

fun printPostOrder(tree: Node<Char>?) {
    if (tree == null) {
        return
    }

    printPostOrder(tree.left)
    printPostOrder(tree.right)
    print(tree.data)
}
/*
fun printStackOrder(tree: Node<Char>?, stack: Stack<Char>) {
    var node: Node<Char>? = tree
    var leftNode: Node<Char>?
    var rightNode: Node<Char>?

    do {
        print(node!!.data)
        node.isVisited = true
        stack.push(node)

        leftNode = node.left
        rightNode = node.right

        if (leftNode != null) {
            node = leftNode
        } else if (rightNode != null) {
            node = rightNode
        } else {
            node = stack.pop()
            leftNode = node?.left
            rightNode = node?.right
            if ()
        }
    } while(node != null)
}
*/

fun main(args: Array<String>) {
    val filename = "input.txt"
    val file = File(filename)
    val input = Scanner(file)
    val inputStr = input.next()
    val inputChars = inputStr.toCharArray()
    val result: Pair<Node<Char>?, Int>
    val tree: Node<Char>?

    result = buildTree(inputChars, 0)
    tree = result.first

    print("tree: ")
    printTree(tree)

    print("\ninorder: ")
    printInOrder(tree)

    print("\npreorder: ")
    printPreOrder(tree)

    print("\npostorder: ")
    printPostOrder(tree)

    val stack = Stack<Char>(inputChars.size)
    print("\nstackorder: ")
    //printStackOrder(tree, stack)
}