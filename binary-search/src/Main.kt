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

fun binarySearch(array: IntArray, value: Int): Pair<Int, Int> {
    var leftIndex = 0
    var rightIndex = array.size - 1
    var index = -1
    var time = 0
    var midIndex: Int

    while (index < 0 && leftIndex < rightIndex) {
        time++
        midIndex = (leftIndex + rightIndex) / 2

        if (array[midIndex] == value) {
            index = midIndex
            break
        }

        if (value > array[midIndex]) {
            leftIndex = midIndex + 1
        } else {
            rightIndex = midIndex - 1
        }
    }

    return Pair(index, time)
}

fun main(args: Array<String>) {
    val filename = "input.txt"
    val array: IntArray
    val value = 31

    array = readFile(filename)
    printArray(array, "sorted array: ")

    val (index, time) = binarySearch(array, value)

    if (index < 0) {
        println("$value is not found")
    } else {
        println("$value is found at index $index after $time iterations")
    }
}