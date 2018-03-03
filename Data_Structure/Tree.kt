class TreeNode(val value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Queue {
    val array: ArrayList<TreeNode> = arrayListOf()
    var startIdx = -1
    var endIdx = 0

    fun enqueue(node: TreeNode) {
        array.add(node)
        if (startIdx == -1) {
            startIdx++
        }
        endIdx++
    }

    fun dequeue(): TreeNode? {
        var node: TreeNode? = null

        if (startIdx != -1 && endIdx > startIdx) {
            node = array.get(startIdx)
            startIdx++
        }

        return node
    }
}

class Solution {
    fun buildBinaryTree(input: IntArray): TreeNode? {
        var root: TreeNode? = null
        var tmpNode: TreeNode
        val queue = Queue()
        var curNode: TreeNode? = null

        for (i in 0 until input.size) {
            tmpNode = TreeNode(input[i])
            queue.enqueue(tmpNode)

            if (root == null) {
                root = tmpNode
                curNode = queue.dequeue()
                continue
            }

            if (curNode?.left == null) {
                curNode?.left = tmpNode
            } else if (curNode.right == null) {
                curNode.right = tmpNode
                curNode = queue.dequeue()
            }
        }

        return root
    }

    fun getInOrderStack(node: TreeNode?, array: ArrayList<TreeNode>) {
        if (node == null) {
            return
        }

        getInOrderStack(node.left, array)
        array.add(node)
        getInOrderStack(node.right, array)
    }

    fun getPreOrderStack(node: TreeNode?, array: ArrayList<TreeNode>) {
        if (node == null) {
            return
        }

        array.add(node)
        getPreOrderStack(node.left, array)
        getPreOrderStack(node.right, array)
    }

    fun getPostOrderStack(node: TreeNode?, array: ArrayList<TreeNode>) {
        if (node == null) {
            return
        }

        getPostOrderStack(node.left, array)
        getPostOrderStack(node.right, array)
        array.add(node)
    }

    fun printStack(array: ArrayList<TreeNode>) {
        var tmpNode: TreeNode
        var lastIdx = array.lastIndex

        while (lastIdx >= 0) {
            tmpNode = array.get(lastIdx)
            lastIdx--
            print("${tmpNode.value} ")
        }
        println()
    }
}

fun main(args: Array<String>) {
    val sol = Solution()
    val input = intArrayOf(1, 2, 3, 4, 5, 6, 7)
    val root: TreeNode?
    var array: ArrayList<TreeNode>

    root = sol.buildBinaryTree(input)

    array = arrayListOf()
    sol.getInOrderStack(root, array)
    sol.printStack(array)

    array = arrayListOf()
    sol.getPreOrderStack(root, array)
    sol.printStack(array)

    array = arrayListOf()
    sol.getPostOrderStack(root, array)
    sol.printStack(array)
}


