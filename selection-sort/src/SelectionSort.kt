import java.io.File

fun readFile(filename: String): IntArray {
    val regex = Regex("\\s")
    val list = File(filename).readText().split(regex)
    val data = IntArray(list.size)

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

fun swap(i: Int, j: Int, data: IntArray) {
    val temp = data[i]

    data[i] = data[j]
    data[j] = temp
}

fun selectionSort(data: IntArray): IntArray {
    val dataSize = data.size
    var minIndex: Int

    for (i in 0..dataSize-2) {
        minIndex = i

        for (j in i+1..dataSize-1) {
            if (data[j] < data[minIndex]) {
                minIndex = j
            }
        }

        swap(i, minIndex, data)
        printArray(data)
    }

    return data
}

fun main(args: Array<String>) {
    var data = readFile("input.txt")

    println("Hello, Selection Sort!")
    printArray(data, "before: ")

    data = selectionSort(data)

    printArray(data, "after: ")
}
