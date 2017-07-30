fun main(args: Array<String>) {
    val map = mutableMapOf("Dog" to 17, "Cat" to 3, "Lion" to 98)

    map.put("Pig", 3)

    println("\nkeys:")
    for (i in map.keys) {
        println(i + " " + map[i])
    }

    map.remove("Cat")

    println("\nentries:")
    for ((key, value) in map.entries) {
        println(key + " : " + value)
    }

    map.clear()

    println("\nclear:")
    for (i in map.keys) {
        println(i + " " + map[i])
    }
}