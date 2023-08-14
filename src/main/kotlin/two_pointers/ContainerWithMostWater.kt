package two_pointers

fun main() {
    val list = listOf(intArrayOf(1,8,6,2,5,4,8,3,7), intArrayOf(1,1))
    for (heights in list) {
        println("heights: ${heights.contentToString()}, container with most water: ${containerWithMostWater(heights)}")
    }
}

fun containerWithMostWater(heights: IntArray): Int {
    var i = 0
    var j = heights.lastIndex
    var result = 0
    while (i < j) {
        var area = 0
        val width = j - i
        if (heights[i] < heights[j]) {
            area = heights[i] * width
            i++
        } else {
            area = heights[j] * width
            j--
        }
        result = maxOf(result, area)
    }
    return result
}