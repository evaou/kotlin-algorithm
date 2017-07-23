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

fun insertionSort(array: IntArray) {
    var insertedValue: Int
    var insertedIndex: Int

    for (i in 1 until array.size) {
        insertedValue = array[i]
        insertedIndex = i

        while (insertedIndex > 0 && array[insertedIndex-1] > insertedValue) {
            array[insertedIndex] = array[insertedIndex-1]
            insertedIndex--
        }

        array[insertedIndex] = insertedValue

        printArray(array)
    }
}

fun main(args: Array<String>) {
    val filename = "input.txt"
    val array: IntArray

    array = readFile(filename)
    printArray(array, "before: ")

    insertionSort(array)

    printArray(array, "after: ")
}