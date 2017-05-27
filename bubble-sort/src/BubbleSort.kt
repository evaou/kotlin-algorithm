import java.io.File

fun swap(i: Int, j: Int, data: IntArray) {
    val temp = data[i]

    data[i] = data[j]
    data[j] = temp
}

fun bubbleSort(data: IntArray): IntArray {
    val dataSize = data.size

    for (i in 0..dataSize-2) {

        for (j in 0..dataSize-2-i) {
            if (data[j] > data[j+1]) {
                swap(j, j+1, data)
            }
        }

        printArray(data)
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

fun readFile(filename: String): IntArray {
    val regex = Regex("\\s")
    val list = File(filename).readText().split(regex)
    val data = IntArray(list.size)

    for (i in list.indices) {
        data[i] = Integer.parseInt(list[i])
    }

    return data
}

fun main(args: Array<String>) {
    var data = readFile("input.txt")

    println("Hello, Bubble Sort!")
    printArray(data, "before: ")

    data = bubbleSort(data)

    printArray(data, "after: ")
}
