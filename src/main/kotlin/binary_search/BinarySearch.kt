package binary_search

fun main() {
    val numbers = listOf(intArrayOf(-1,0,3,5,9,12), intArrayOf(-1,0,3,5,9,12), intArrayOf(5))
    val targets = listOf(9, 2, 5)
    for (i in targets.indices) {
        println("numbers: ${numbers[i].contentToString()}, target: ${targets[i]}, binary search: ${binarySearch(numbers[i], targets[i])}")
    }
}

fun binarySearch(numbers: IntArray, target: Int): Int {
    var i = 0
    var j = numbers.lastIndex
    while (i <= j) {
        val mid = (i + j) / 2
        if (numbers[mid] == target)
            return mid

        if (numbers[mid] < target)
            i = mid + 1
        else
            j = mid - 1
    }
    return -1
}