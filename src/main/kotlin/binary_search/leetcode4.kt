package binary_search

import java.util.PriorityQueue

// Median of Two Sorted Arrays
fun main() {
    val nums1 = listOf(intArrayOf(1,3), intArrayOf(1,2))
    val nums2 = listOf(intArrayOf(2), intArrayOf(3,4))
    for (i in nums2.indices) {
        println("nums1: ${nums1[i].contentToString()}, nums2: ${nums2[i].contentToString()} => median: ${leetcode4_solution(nums1[i], nums2[i])}")
    }
}

// I manually translated this based on Python code by Neetcode, but it gets into an infinite loop
fun leetcode4_solution(nums1: IntArray, nums2: IntArray): Float {
    // make sure array1 is smaller than array2
    val A = if (nums2.size < nums1.size) nums2 else nums1 // array1
    val B = if (nums2.size < nums1.size) nums1 else nums2 // array2

    val total = nums1.size + nums2.size
    val half = total / 2
    var l = 0
    var r = A.lastIndex
    while (true) {
        val i = (l + r) / 2 // mid1
        val j = half - i - 2 // mid2
        val Aleft = if (i >= 0) A[i] else Int.MIN_VALUE // left1
        val Aright = if (i + 1 < A.size) A[i + 1] else Int.MAX_VALUE
        val Bleft = if (j >= 0) B[j] else Int.MIN_VALUE
        val Bright = if (j + 1 < B.size) B[j + 1] else Int.MAX_VALUE

        // partition is correct
        if (Aleft <= Bright && Bleft <= Aright) {
            return if (total % 2 != 0) minOf(Aright, Bright).toFloat()
            else (maxOf(Aleft, Bleft) + minOf(Aright, Bright)) / 2.0f
        } else if (Aleft > Bright) {
            r = i - 1
        } else {
            l = i + 1
        }
    }
}

fun leetcode4_mine(nums1: IntArray, nums2: IntArray): Float {
    val median = Median(nums1 + nums2)
    return median.median()
}

class Median(array: IntArray) {
    val minQueue = PriorityQueue<Int>()
    val maxQueue = PriorityQueue<Int>(Comparator.reverseOrder())

    init {
        for (number in array)
            insert(number)
    }
    fun median(): Float {
        return if (minQueue.size == maxQueue.size)
            (minQueue.peek() + maxQueue.peek()) / 2.0f
        else
            minQueue.peek().toFloat()
    }

    private fun insert(number: Int) {
        if (minQueue.isEmpty() || number >= minQueue.peek())
            minQueue.add(number)
        else
            maxQueue.add(number)

        if (minQueue.size - maxQueue.size == 2)
            maxQueue.add(minQueue.poll())
        else if (minQueue.size < maxQueue.size)
            minQueue.add(maxQueue.poll())
    }
}