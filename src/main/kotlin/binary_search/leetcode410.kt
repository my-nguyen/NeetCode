package binary_search

// Split Array Largest Sum
// Hard
fun main() {
    val arrays = listOf(intArrayOf(7,2,5,10,8), intArrayOf(1,2,3,4,5))
    val ms = listOf(2, 2)
    for (i in ms.indices) {
        println("array: ${arrays[i].contentToString()}, m: ${ms[i]} => split array largest sum: ${leetcode410_optimized(arrays[i], ms[i])}")
    }
}

fun leetcode410_optimized(nums: IntArray, m: Int): Int {
    var left = nums.max()
    var right = nums.sum()
    var result = right
    while (left <= right) {
        val mid = (left + right) / 2
        if (canSplit(nums, mid, m)) {
            result = mid
            right = mid - 1
        } else {
            left = mid + 1
        }
    }
    return result
}

fun leetcode410_brute(nums: IntArray, m: Int): Int {
    return dfs(nums, 0, m)
}

private fun canSplit(array: IntArray, max: Int, m: Int): Boolean {
    var subarray = 0
    var sum = 0
    for (number in array) {
        sum += number
        if (sum > max) {
            subarray++
            sum = number
        }
    }
    return subarray + 1 <= m
}

private fun dfs(nums: IntArray, i: Int, m: Int): Int {
    if (m == 1)
        return nums.copyOfRange(i, nums.size).sum()
    // to pass the compiler
    return 0
}

