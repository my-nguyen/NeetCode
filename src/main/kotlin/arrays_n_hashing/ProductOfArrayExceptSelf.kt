package arrays_n_hashing

fun main() {
    val list = listOf(intArrayOf(1,2,3,4), intArrayOf(-1,1,0,-3,3), intArrayOf(0,0), intArrayOf(0,4,0))
    for (numbers in list) {
        println("numbers: ${numbers.contentToString()}, product of array except self: ${productOfArrayExceptSelf(numbers).contentToString()}")
    }
}

fun productOfArrayExceptSelf(numbers: IntArray): IntArray {
    val products = IntArray(numbers.size)
    val product = getProduct(numbers)
    when (countZeroes(numbers)) {
        0 -> {
            for (i in numbers.indices) {
                products[i] = product / numbers[i]
            }
        }
        1 -> {
            for (i in numbers.indices) {
                products[i] = if (numbers[i] != 0) 0 else product
            }
        }
    }
    return products
}

private fun getProduct(numbers: IntArray): Int {
    var product = 1
    for (number in numbers) {
        if (number != 0)
            product *= number
    }
    return product
}

private fun countZeroes(numbers: IntArray): Int {
    var count = 0
    for (number in numbers) {
        if (number == 0)
            count++
    }
    return count
}