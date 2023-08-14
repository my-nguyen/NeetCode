package binary_search

fun main() {
    val matrices = listOf(
        arrayOf(intArrayOf(1,3,5,7), intArrayOf(10,11,16,20), intArrayOf(23,30,34,60)),
        arrayOf(intArrayOf(1,3,5,7), intArrayOf(10,11,16,20), intArrayOf(23,30,34,60)),
        arrayOf(intArrayOf(1,3,5,7), intArrayOf(10,11,16,20), intArrayOf(23,30,34,60)),
        arrayOf(intArrayOf(1,3))
    )
    val targets = listOf(3, 13, 5, 3)
    for (i in matrices.indices) {
        println("search a 2D matrix: ${searchA2DMatrix(matrices[i], targets[i])}")
    }
}

fun searchA2DMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    val rows = matrix.size
    val cols = matrix[0].size
    var i = 0
    var j = (rows * cols) - 1
    while (i <= j) {
        val mid = (i + j) / 2
        val midValue = matrix[mid / cols][mid % cols]
        if (midValue == target)
            return true

        if (midValue < target)
            i = mid + 1
        else
            j = mid - 1
    }
    return false
}