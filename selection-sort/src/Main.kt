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

fun selectionSort(array: IntArray) {
    var minIndex: Int

    for (i in 0 until array.size) {
        minIndex = i

        for (j in i+1 until array.size) {
            if (array[j] < array[minIndex]) {
                minIndex = j
            }
        }

        swap(array, i, minIndex)
        printArray(array)
    }
}

fun main(args: Array<String>) {
    val filename = "input.txt"
    val array: IntArray

    array = readFile(filename)
    printArray(array, "before: ")

    selectionSort(array)

    printArray(array, "after: ")
}