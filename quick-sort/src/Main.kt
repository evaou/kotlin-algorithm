import java.io.File
import java.util.Scanner


fun readFile(filename: String): IntArray {
    val file = File(filename)
    val input = Scanner(file)
    val list = ArrayList<Int>()
    var value: Int

    while (input.hasNextInt()) {
        value = input.nextInt()
        list.add(value)
    }

    return list.toIntArray()
}

fun printArray(array: IntArray, str: String = "") {
    print(str)

    for (i in 0 until array.size) {
        print("${array[i]} ")
    }

    println()
}

fun swap(array: IntArray, firstIdx: Int, secondIdx: Int) {
    val temp = array[firstIdx]

    array[firstIdx] = array[secondIdx]
    array[secondIdx] = temp
}

fun partition(array: IntArray, startIndex: Int, endIndex: Int, pivotIndex: Int): Int {
    val pivotValue = array[pivotIndex]
    var i = startIndex
    var j = endIndex

    while (true) {
        while (i < endIndex && array[i] < pivotValue) {
            i++
        }

        while (j > startIndex && array[j] > pivotValue) {
            j--
        }

        if (i < j) {
            swap(array, i, j)
        } else {
            swap(array, i, pivotIndex)
            break
        }
    }

    printArray(array)

    return i
}

fun quickSort(array: IntArray, startIndex: Int, endIndex: Int) {
    if (startIndex >= endIndex) {
        return
    }

    var pivotIndex = endIndex

    pivotIndex = partition(array, startIndex, endIndex -1, pivotIndex)
    quickSort(array, startIndex, pivotIndex - 1)
    quickSort(array, pivotIndex + 1, endIndex)
}

fun main(args: Array<String>) {
    val filename = "input.txt"
    val array: IntArray

    array = readFile(filename)
    printArray(array, "before: ")

    quickSort(array, 0, array.size - 1)

    printArray(array, "after: ")
}