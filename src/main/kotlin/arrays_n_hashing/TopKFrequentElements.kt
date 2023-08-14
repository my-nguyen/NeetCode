package arrays_n_hashing

fun main() {
    val numbers = listOf(intArrayOf(1,1,1,2,2,3), intArrayOf(1), intArrayOf(-1,-1), intArrayOf(4,1,-1,2,-1,2,3))
    val ks = listOf(2, 1, 1, 2)
    for (i in numbers.indices) {
        println("numbers: ${numbers[i].contentToString()}, top ${ks[i]} frequent elements: ${topKFrequentElements(numbers[i], ks[i]).contentToString()}")
    }
}

fun topKFrequentElements(numbers: IntArray, k: Int): IntArray {
    val map = mutableMapOf<Int, Int>()
    for (number in numbers) {
        map[number] = map.getOrDefault(number, 0) + 1
    }
    val map2 = map.toList().sortedByDescending { (_, value) -> value }.toMap()
    return map2.keys.toList().take(k).toIntArray()
}