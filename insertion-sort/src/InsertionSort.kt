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

fun swap(i: Int, j: Int, data: IntArray): IntArray {
    val temp = data[i]
    data[i] = data[j]
    data[j] = temp

    return data
}

fun insertionSort(data: IntArray): IntArray {

    for (i in 1..data.size - 1) {
        var temp = data[i]
        var checkIndex = i

        while (checkIndex > 0) {
            if (data[checkIndex] < data[checkIndex - 1]) {
                swap(checkIndex, checkIndex-1, data)
            }
            checkIndex--
        }

        data[checkIndex ] = temp
    }
}

fun main(args: Array<String>) {
    println("Hello, Insertion Sort!")

    var data = readFile("input.txt")

    printArray(data, "before: ")
    data = insertionSort(data)
    printArray(data, "after: ")
}