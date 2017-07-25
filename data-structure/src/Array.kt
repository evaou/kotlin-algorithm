fun main(args: Array<String>) {
    val size = 9
    val array = intArrayOf(10, 20, 30)
    val array2d = Array(size, {Array(size, {0})})

    for (i in 0 until array.size) {
        print("%d ".format(array[i]))
    }
    println()

    for (i in 0 until array2d.size) {
        for (j in 0 until array2d.size) {
            array2d[i][j] = (i+1) * (j+1)
        }
    }

    for (i in 0 until array2d.size) {
        for (j in 0 until array2d.size) {
            print("%2d ".format(array2d[i][j]))
        }
        println()
    }
}
