import java.util.Scanner

class Node<T>(var data: T) {
    var left: Node<T>? = null
    var right: Node<T>? = null
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

fun main(args: Array<String>) {
    val treeStr = "(1()(2()(5(3()(4))(6))))"
    val input = Scanner(treeStr)
    val inputStr = input.next()
    val inputChars = inputStr.toCharArray()
    val result: Pair<Node<Char>?, Int>
    val tree: Node<Char>?

    result = buildTree(inputChars, 0)
    tree = result.first

    printTree(tree)
}