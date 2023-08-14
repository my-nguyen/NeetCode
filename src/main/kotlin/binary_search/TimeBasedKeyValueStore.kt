package binary_search

interface Command {
    fun run(param1: String?, param2: String?, param3: Int?): String?
}

lateinit var timeMap: TimeMap

fun buildMap(): Map<String, Command> {
    val map = mutableMapOf<String, Command>()
    map["TimeMap"] = object : Command {
        override fun run(param1: String?, param2: String?, param3: Int?): String? {
            timeMap = TimeMap()
            return null
        }
    }
    map["set"] = object : Command {
        override fun run(param1: String?, param2: String?, param3: Int?): String? {
            timeMap.set(param1!!, param2!!, param3!!)
            return null
        }
    }
    map["get"] = object : Command {
        override fun run(param1: String?, param2: String?, param3: Int?) = timeMap.get(param1!!, param3!!)
    }
    return map
}

fun main() {
    val map = buildMap()
    val methods = listOf("TimeMap", "set", "get", "get", "set", "get", "get")
    val arguments = listOf(
        Pair(listOf(null, null), null), Pair(listOf("foo", "bar"), 1), Pair(listOf("foo", null), 1), Pair(listOf("foo", null), 3),
        Pair(listOf("foo", "bar2"), 4), Pair(listOf("foo", null), 4), Pair(listOf("foo", null), 5)
    )
    for (i in methods.indices) {
        println(map[methods[i]]!!.run(arguments[i].first[0], arguments[i].first[1], arguments[i].second))
    }
}

// empty implementation
class TimeMap() {
    fun set(key: String, value: String, timestamp: Int) {
    }

    fun get(key: String, timestamp: Int): String {
        return ""
    }
}