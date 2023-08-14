package two_pointers

fun main() {
    val list = listOf(intArrayOf(-1,0,1,2,-1,-4), intArrayOf(0,1,1), intArrayOf(0,0,0))
    for (numbers in list) {
        println("numbers: ${numbers.contentToString()}, three sum: ${threeSum(numbers)}")
    }
}

fun threeSum(numbers: IntArray): List<List<Int>> {
    numbers.sort()
    val result = mutableListOf<List<Int>>()
    for (i in 0..numbers.lastIndex-2) {
        var j = i + 1
        var k = numbers.lastIndex
        while (j < k) {
            val sum = numbers[i] + numbers[j] + numbers[k]
            when {
                sum < 0 -> j++
                sum > 0 -> k--
                else -> {
                    result.add(listOf(numbers[i], numbers[j], numbers[k]))
                    j++
                    k--
                }
            }
        }
    }
    return result
}