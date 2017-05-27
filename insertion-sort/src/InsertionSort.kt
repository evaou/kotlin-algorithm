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

fun insertionSort(data: IntArray): IntArray {
    for (i in 1..data.size - 1) {
        var checkValue = data[i]
        var checkIndex = i

        while (checkIndex > 0 && (data[checkIndex-1] > checkValue)) {
            data[checkIndex] = data[checkIndex - 1]
            checkIndex--
        }

        data[checkIndex] = checkValue
        printArray(data)
    }

    return data
}

fun main(args: Array<String>) {
    var data = readFile("input.txt")

    println("Hello, Insertion Sort!")
    printArray(data, "before: ")

    data = insertionSort(data)

    printArray(data, "after: ")
}