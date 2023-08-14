package two_pointers

fun main() {
    val numbers = listOf(intArrayOf(2,7,11,15), intArrayOf(2,3,4), intArrayOf(-1,0))
    val targets = listOf(9, 6, -1)
    for (i in targets.indices) {
        println("numbers: ${numbers[i].contentToString()}, target: ${targets[i]}, two sum II: ${twoSumIiInputArrayIsSorted(numbers[i], targets[i]).contentToString()}")
    }
}

fun twoSumIiInputArrayIsSorted(numbers: IntArray, target: Int): IntArray {
    var i = 0
    var j = numbers.lastIndex
    while (i < j) {
        val sum = numbers[i] + numbers[j]
        when {
            sum < target -> i++
            sum > target -> j--
            else -> return intArrayOf(i+1, j+1)
        }
    }
    return intArrayOf(0, 0)
}