import java.io.File
import java.util.Scanner

class MinHeap(size: Int) {
    val array = IntArray(size)
    var heapNum = -1

    fun swap(x: Int, y: Int) {
        val tmp = array[x]
        array[x] = array[y]
        array[y] = tmp
    }

    fun insert(data: Int) {
        array[++heapNum] = data
        var i = heapNum

        while ( (i != 0) && (array[parent(i)] > array[i]) ) {
            swap(parent(i), i)
            i = parent(i)
        }
    }

    fun minHeapify(rootIdx: Int) {
        var smallestIdx = rootIdx
        val leftIdx = left(rootIdx)
        val rightIdx = right(rootIdx)

        if (rootIdx == parent(heapNum)) {
            return
        }

        if (leftIdx <= heapNum && array[smallestIdx] > array[leftIdx]) {
            smallestIdx = leftIdx
        }

        if (rightIdx <= heapNum && array[smallestIdx] > array[rightIdx]) {
            smallestIdx = rightIdx
        }

        if (smallestIdx != rootIdx) {
            swap(smallestIdx, rootIdx)
            minHeapify(smallestIdx)
        }
    }

    fun deleteMin() {
        swap(0, heapNum)
        heapNum--
        minHeapify(0)
    }

    fun decreaseKey(idx: Int, newData: Int) {
        array[idx] = newData
        var i = idx

        while ( (i != 0) && (array[parent(i)] > array[i]) ) {
            swap(parent(i), i)
            i = parent(i)
        }
    }

    fun parent(curIdx: Int): Int {
        return (curIdx-1)/2
    }

    fun left(curIdx: Int): Int {
        return (2*curIdx + 1)
    }

    fun right(curIdx: Int): Int {
        return (2*curIdx + 2)
    }

    fun getMin(): Int {
        return array[0]
    }

    fun printBST() {
        for (i in 0..heapNum) {
            print("${array[i]} ")
        }
        println()
    }
}

fun main(args: Array<String>) {
    val filename = "input.txt"
    val file = File(filename)
    val input = Scanner(file)
    val list: MutableList<Int> = mutableListOf()
    val size: Int
    val heap: MinHeap

    while (input.hasNextInt()) {
        list.add(input.nextInt())
    }

    size = list.size
    heap = MinHeap(size)

    list.forEach { data ->
        heap.insert(data)
    }

    print("heap: ")
    heap.printBST()

    println("min: ${heap.getMin()}")

    heap.deleteMin()
    print("heap after deleting min: ")
    heap.printBST()

    heap.decreaseKey(4, 15)
    print("heap after decreasing array[4] to 15: ")
    heap.printBST()
}