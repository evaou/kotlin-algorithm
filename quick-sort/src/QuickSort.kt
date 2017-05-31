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

fun swap(data: IntArray, i: Int, j: Int) {
    val temp = data[i]
    data[i] = data[j]
    data[j] = temp
}

fun partition(data: IntArray, left: Int, right: Int, pivot: Int): Int {
    var i = left
    var j = right

    while (true) {
        while (i < right && data[i] <= data[pivot]) {
            i++
        }

        while (j > left && data[j] >= data[pivot]) {
            j--
        }

        if (i >= j) {
            break
        }

        swap(data, i, j)
    }

    swap(data, j, pivot)

    return j
}

fun quickSort(data: IntArray, left: Int, right: Int) {
    if (left >= right) {
        return
    }

    val pivot = left
    val middle: Int

    middle = partition(data, left, right, pivot)
    quickSort(data, left, middle-1)
    quickSort(data, middle+1, right)

    printArray(data)
}

fun main(args: Array<String>) {
    val data = readFile("input.txt")

    println("Hello, Quick Sort!")
    printArray(data, "before: ")

    quickSort(data, 0, data.size - 1)

    printArray(data, "after: ")
}