
class LinkedNode(val value: Int) {
    var next: LinkedNode? = null
}

class Solution {
    fun buildList(input: IntArray): LinkedNode? {
        var tmpNode: LinkedNode
        var curNode: LinkedNode? = null
        var rootNode: LinkedNode? = null

        for (it in input.iterator()) {
            tmpNode = LinkedNode(it)

            if (rootNode == null) {
                rootNode = tmpNode
                curNode = tmpNode
                continue
            }

            curNode?.next = tmpNode
            curNode = tmpNode
        }

        return rootNode
    }

    fun separateList(inputList: LinkedNode?, listArray: Array<LinkedNode?>) {
        var evenList: LinkedNode? = null
        val oddReversedList: LinkedNode?
        var evenCurNode: LinkedNode? = null
        var oddCurNode: LinkedNode? = null
        var curNode: LinkedNode? = inputList
        var curIdx = 0
        var tmpNode: LinkedNode

        while (curNode != null) {
            tmpNode = LinkedNode(curNode.value)

            if (curIdx % 2 == 0) {
                if (evenList == null) {
                    evenList = tmpNode
                    evenCurNode = tmpNode
                } else {
                    evenCurNode?.next = tmpNode
                    evenCurNode = tmpNode
                }
            } else {
                if (oddCurNode == null) {
                    oddCurNode = tmpNode
                } else {
                    tmpNode.next = oddCurNode
                    oddCurNode = tmpNode
                }
            }

            curNode = curNode.next
            curIdx++
        }

        oddReversedList = oddCurNode

        listArray[0] = evenList
        listArray[1] = oddReversedList
    }

}

fun main(args: Array<String>) {
    val sol = Solution()
    val input = intArrayOf(0, 1, 2, 3, 4, 5)
    val inputList: LinkedNode?
    val listArray: Array<LinkedNode?> = arrayOf(null, null)
    var tmpNode: LinkedNode?

    inputList = sol.buildList(input)
    sol.separateList(inputList, listArray)

    tmpNode = listArray[0]
    while (tmpNode != null) {
        print("${tmpNode.value} ")
        tmpNode = tmpNode.next
    }
    println()

    tmpNode = listArray[1]
    while (tmpNode != null) {
        print("${tmpNode.value} ")
        tmpNode = tmpNode.next
    }
    println()
}


