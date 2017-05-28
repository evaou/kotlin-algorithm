import java.io.File

fun readFile(filename: String): IntArray {
    val regex = Regex("\\s")
    val list = File(filename).readText().split(regex)
    val listSize = list.size
    val data = IntArray(listSize)

    for (i in list.indices) {
        data[i] = Integer.parseInt(list[i])
    }

    return data
}

fun printArray(data: IntArray, str: String = "") {
    print(str + "(")

    for (i in data.indices) {
        if (i > 0) {
            print(", ")
        }
        print(data[i])
    }

    println(")")
}

fun mergeData(leftData: IntArray, rightData: IntArray): IntArray {
    val data = IntArray(leftData.size + rightData.size)
    var leftIndex = 0
    var rightIndex = 0
    var index = 0
    val leftSize = leftData.size
    val rightSize = rightData.size

    while (leftIndex < leftSize && rightIndex < rightSize) {
        if (leftData[leftIndex] < rightData[rightIndex]) {
            data[index] = leftData[leftIndex]
            leftIndex++
        } else {
            data[index] = rightData[rightIndex]
            rightIndex++
        }
        index++
    }

    while (leftIndex < leftSize) {
        data[index] = leftData[leftIndex]
        index++
        leftIndex++
    }

    while(rightIndex < rightSize) {
        data[index] = rightData[rightIndex]
        index++
        rightIndex++
    }

    printArray(data)

    return data
}

fun mergeSort(data: IntArray): IntArray {
    if (data.size == 1) {
        return data
    }

    val midIndex: Int = data.size/2
    var leftData = data.copyOfRange(0, midIndex)
    var rightData = data.copyOfRange(midIndex, data.size)

    leftData = mergeSort(leftData)
    rightData = mergeSort(rightData)
    mergeData(leftData, rightData)

    return data
}

fun main(args: Array<String>) {
    var data = readFile("input.txt")

    println("Hello, Merge Sort!")
    printArray(data, "before: ")

    data = mergeSort(data)

    printArray(data, "after: ")
}