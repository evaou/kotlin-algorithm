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

fun merge(leftArray: IntArray, rightArray: IntArray): IntArray {
    val array = IntArray(leftArray.size + rightArray.size)
    var index = 0
    var leftIndex = 0
    var rightIndex = 0

    while (leftIndex < leftArray.size && rightIndex < rightArray.size) {
        if (leftArray[leftIndex] < rightArray[rightIndex]) {
            array[index++] = leftArray[leftIndex++]
        } else {
            array[index++] = rightArray[rightIndex++]
        }
    }

    while (leftIndex < leftArray.size) {
        array[index++] = leftArray[leftIndex++]
    }

    while (rightIndex < rightArray.size) {
        array[index++] = rightArray[rightIndex++]
    }

    printArray(array)

    return array
}

fun mergeSort(array: IntArray): IntArray {
    if (array.size == 1) {
        return array
    }

    val midIndex = array.size / 2
    val leftArray: IntArray
    val rightArray: IntArray

    leftArray = mergeSort(array.copyOfRange(0, midIndex))
    rightArray = mergeSort(array.copyOfRange(midIndex, array.size))
    return merge(leftArray, rightArray)
}

fun main(args: Array<String>) {
    val filename = "input.txt"
    var array: IntArray

    array = readFile(filename)
    printArray(array, "before: ")

    array = mergeSort(array)

    printArray(array, "after: ")
}