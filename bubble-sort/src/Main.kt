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

fun bubbleSort(array: IntArray) {
    var isSwap = true

    while (isSwap) {
        isSwap = false

        for (j in 1 until array.size) {
            if (array[j] < array[j-1]) {
                swap(array, j, j-1)
                isSwap = true
            }
        }

        if (isSwap) {
            printArray(array)
        }
    }
}

fun main(args: Array<String>) {
    val filename = "input.txt"
    val array: IntArray

    array = readFile(filename)
    printArray(array, "before: ")

    bubbleSort(array)

    printArray(array, "after: ")
}