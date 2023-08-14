package arrays_n_hashing

fun main() {
    val arrays = listOf(intArrayOf(1,2,3,1), intArrayOf(1,2,3,4), intArrayOf(1,1,1,3,3,4,3,2,4,2))
    for (array in arrays) {
        println("array: ${array.contentToString()}, contains duplicate? ${containsDuplicate(array)}")
    }
}

fun containsDuplicate(array: IntArray): Boolean {
    val set = mutableSetOf<Int>()
    for (number in array) {
        if (set.contains(number))
            return true
        set.add(number)
    }
    return false
}