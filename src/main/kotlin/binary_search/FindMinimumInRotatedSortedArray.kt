package binary_search

fun main() {
    val list = listOf(intArrayOf(3,4,5,1,2), intArrayOf(4,5,6,7,0,1,2), intArrayOf(11,13,15,17), intArrayOf(4,5,6,7,0,1,2), intArrayOf(0,1,2,4,5,6,7), intArrayOf(1), intArrayOf(2,1))
    for (numbers in list) {
        println("numbers: ${numbers.contentToString()}, find minimum in rotated sorted array: ${findMinimumInRotatedSortedArray2(numbers)}")
    }
}

fun findMinimumInRotatedSortedArray(numbers: IntArray): Int {
    if (numbers.size == 1)
        return numbers[0]
    if (numbers.first() < numbers.last())
        return numbers.first()

    var i = 0
    var j = numbers.lastIndex
    while (i <= j) {
        val k = (i + j) / 2
        if (k > 0 && numbers[k-1] > numbers[k])
            return numbers[k]
        if (k < numbers.lastIndex && numbers[k] > numbers[k+1])
            return numbers[k + 1]

        if (numbers[i] < numbers[k])
            i = k
        else
            j = k
    }
    return -1
}

// based on YouTuber Nick White's algorithm
fun findMinimumInRotatedSortedArray2(numbers: IntArray): Int {
    if (numbers.isEmpty())
        return -1
    if (numbers.size == 1)
        return numbers[0]

    var i = 0
    var j = numbers.lastIndex
    while (i < j) {
        val k = i + (j - i) / 2
        if (k > 0 && numbers[k] < numbers[k - 1])
            return numbers[k]

        if (numbers[i] <= numbers[k] && numbers[k] > numbers[j]) {
            i = k + 1
        } else {
            j = k - 1
        }
    }
    return numbers[i]
}