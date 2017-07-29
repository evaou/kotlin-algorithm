import java.io.File
import java.util.Scanner

fun main(args: Array<String>) {
    val filename = "input.txt"
    val file = File(filename)
    val input = Scanner(file)
    val list = mutableListOf<Int>()

    while (input.hasNextInt()) {
        list.add(input.nextInt())
    }

    println("before: " + list)

    list.removeAt(0)
    list.remove(19)

    println("after: " + list)
}