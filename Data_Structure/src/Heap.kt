import java.io.File
import java.util.Scanner

class MinHeap(val size: Int) {
    val array = IntArray(size)
    var heapSize = -1

    fun swap(array: IntArray, x: Int, y: Int) {
        val tmp = array[x]
        array[x] = array[y]
        array[y] = tmp
    }

    fun insert(data: Int) {
        array[++heapSize] = data


    }

    fun parent(curIdx: Int): Int {
        return curIdx/2
    }

    fun left(curIdx: Int): Int {
        return (curIdx/2 + 1)
    }

    fun right(curIdx: Int): Int {
        return (curIdx/2 + 2)
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
}