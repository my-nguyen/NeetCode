package binary_search

import java.util.Comparator
import java.util.PriorityQueue

fun main() {
    val nums1 = listOf(intArrayOf(1,3), intArrayOf(1,2))
    val nums2 = listOf(intArrayOf(2), intArrayOf(3,4))
    for (i in nums1.indices) {
        println("nums1: ${nums1[i].contentToString()}, nums2: ${nums2[i].contentToString()} => median: ${findMedianSortedArrays(nums1[i], nums2[i])}")
    }
}

fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    val median = MyMedian()
    median.add(nums1)
    median.add(nums2)
    return median.median()
}

class MyMedian {
    private val minHeap = PriorityQueue<Int>()
    private val maxHeap = PriorityQueue<Int>(Comparator.reverseOrder())

    fun add(array: IntArray) {
        for (number in array)
            add(number)
    }

    fun median(): Double {
        if (minHeap.size > maxHeap.size)
            return minHeap.peek().toDouble()
        return (minHeap.peek() + maxHeap.peek()) / 2.0
    }

    private fun add(number: Int) {
        if (minHeap.isEmpty() || number > minHeap.peek())
            minHeap.add(number)
        else
            maxHeap.add(number)
        rebalance()
    }

    private fun rebalance() {
        if (minHeap.size > maxHeap.size + 1)
            maxHeap.add(minHeap.poll())
        else if (minHeap.size < maxHeap.size)
            minHeap.add(maxHeap.poll())
    }
}