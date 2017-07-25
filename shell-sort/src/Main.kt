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

fun shellSort(array: IntArray) {
    var interval = 1
    var insertedValue: Int
    var insertedIndex: Int

    while (interval < array.size / 3) {
        interval = 3 * interval + 1
    }

    while (interval > 0) {
        for (i in interval until array.size) {
            insertedValue = array[i]
            insertedIndex = i

            while (insertedIndex >= interval && insertedValue < array[insertedIndex - interval]) {
                array[insertedIndex] = array[insertedIndex - interval]
                insertedIndex = insertedIndex - interval
            }

            array[insertedIndex] = insertedValue
        }

        interval = (interval - 1) / 3

        printArray(array)
    }
}

fun main(args: Array<String>) {
    val filename = "input.txt"
    val array: IntArray

    array = readFile(filename)
    printArray(array, "before: ")

    shellSort(array)

    printArray(array, "after: ")
}