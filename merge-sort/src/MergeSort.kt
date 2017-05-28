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

fun main(args: Array<String>) {
    var data = readFile("input.txt")

    println("Hello, Merge Sort!")
}