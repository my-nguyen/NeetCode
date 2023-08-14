package arrays_n_hashing

fun main() {
    val arrays = listOf(intArrayOf(2,7,11,15), intArrayOf(3,2,4), intArrayOf(3,3))
    val targets = listOf(9, 6, 6)
    for (i in targets.indices) {
        println("nums: ${arrays[i].contentToString()}, target: ${targets[i]}, two sum: ${twoSum(arrays[i], targets[i])}")
    }
}

fun twoSum(nums: IntArray, target: Int): Pair<Int, Int> {
    val map = mutableMapOf<Int, Int>()
    map[nums[0]] = 0
    for (i in 1..nums.lastIndex) {
        val diff = target - nums[i]
        if (map.containsKey(diff))
            return Pair(i, map[diff]!!)
        map[nums[i]] = i
    }
    return Pair(0, 0)
}