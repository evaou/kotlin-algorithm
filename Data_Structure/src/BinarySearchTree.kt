import java.io.File
import java.util.Scanner

class TreeNode(val data: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun insertTreeNode(root: TreeNode, node: TreeNode) {
    var curNode: TreeNode? = root

    while (true) {
        if (node.data <= curNode!!.data) {
            if (curNode.left == null) {
                curNode.left = node
                break
            }
            curNode = curNode.left
        } else {
            if (curNode.right == null) {
                curNode.right = node
                break
            }
            curNode = curNode.right
        }
    }
}

fun printTreePreOrder(node: TreeNode?) {
    if (node == null) {
        return
    }

    print("${node.data} ")
    printTreePreOrder(node.left)
    printTreePreOrder(node.right)
 }

fun main(args: Array<String>) {
    val filename = "input.txt"
    val file = File(filename)
    val input = Scanner(file)
    val root = TreeNode(input.nextInt())
    var node: TreeNode

    while (input.hasNextInt()) {
        node = TreeNode(input.nextInt())
        insertTreeNode(root, node)
    }

    printTreePreOrder(root)
}