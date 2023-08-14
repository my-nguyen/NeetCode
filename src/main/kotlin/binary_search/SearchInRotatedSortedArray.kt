package binary_search

fun main() {
    val numbers = listOf(intArrayOf(4,5,6,7,0,1,2), intArrayOf(4,5,6,7,0,1,2), intArrayOf(1), intArrayOf(3,1))
    val targets = listOf(0, 3, 0, 3)
    for (i in numbers.indices) {
        println("numbers: ${numbers[i].contentToString()}, target: ${targets[i]}, search in rotated sorted array: ${searchInRotatedSortedArray2(numbers[i], targets[i])}")
    }
}

// incorrect implementation
fun searchInRotatedSortedArray(numbers: IntArray, target: Int): Int {
    if (numbers.size == 1)
        return if (numbers[0] == target) 0 else -1

    val index = findMinimum(numbers)
    println("index: $index")
    if (numbers[index] == target)
        return index

    /*if (index == 0)
        return search(numbers, index, numbers.lastIndex, target)
    if (numbers[0] <= target && target <= numbers[index])
        return search(numbers, 0, index, target)
    return search(numbers, index, numbers.lastIndex, target)*/
    return if (numbers[0] < numbers[index])
        return search(numbers, 0, index, target)
    else
        search(numbers, index, numbers.lastIndex, target)
}

// based on YouTuber Nick White's implementation
private fun searchInRotatedSortedArray2(nums: IntArray?, target: Int): Int {
    if (nums == null || nums.isEmpty())
        return -1

    var i = 0
    var j = nums.lastIndex
    // modify binary search to look for the smallest element
    while (i < j) {
        val k = i + (j - i) / 2
        if (nums[k] > nums[j]) {
            i = k + 1
        } else {
            j = k
        }
    }

    // found the smallest element
    val smallest = i
    // decide whether the target is to the right or to the left of smallest element
    if (nums[smallest] <= target && target <= nums[nums.lastIndex]) {
        i = smallest
        j = nums.size - 1
    } else {
        i = 0
        j = smallest
    }

    // do the normal binary search
    while (i <= j) {
        val k = i + (j - i) / 2
        if (nums[k] == target)
            return k

        if (nums[k] < target) {
            i = k + 1
        } else {
            j = k - 1
        }
    }
    return -1
}

private fun findMinimum(numbers: IntArray): Int {
    if (numbers.first() < numbers.last())
        return 0

    var i = 0
    var j = numbers.lastIndex
    while (i <= j) {
        val k = (i + j) / 2
        if (k > 0 && numbers[k-1] > numbers[k])
            return k
        if (k < numbers.lastIndex && numbers[k] > numbers[k+1])
            return k + 1

        if (numbers[i] < numbers[k])
            i = k
        else
            j = k
    }
    return -1
}

private fun search(numbers: IntArray, left: Int, right: Int, target: Int): Int {
    var i = left
    var j = right
    println("i $i, j: $j")
    while (i <= j) {
        val k = (i + j) / 2
        println("k $k, numbers[k]: ${numbers[k]}, target: $target")
        if (numbers[k] == target)
            return k

        if (numbers[k] < target)
            i = k + 1
        else
            j = k - 1
    }
    return -1
}