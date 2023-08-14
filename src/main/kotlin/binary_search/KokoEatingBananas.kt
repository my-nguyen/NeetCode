package binary_search

fun main() {
    val piles = listOf(
        intArrayOf(3,6,7,11), intArrayOf(30,11,23,4,20), intArrayOf(30,11,23,4,20), intArrayOf(312884470),
        intArrayOf(332484035,524908576,855865114,632922376,222257295,690155293,112677673,679580077,337406589,290818316,877337160,901728858,679284947,688210097,692137887,718203285,629455728,941802184)
    )
    val hours = listOf(8, 5, 6, 312884469, 823855818)
    for (i in piles.indices) {
        println("piles: ${piles[i].contentToString()}, hours: ${hours[i]}, Koko eating bananas: ${kokoEatingBananas(piles[i], hours[i])}")
    }
}

// incomplete solution. with the last test case, the expected result is 14
fun kokoEatingBananas(piles: IntArray, hours: Int): Int {
    if (piles.size == 1) {
        val max = maxOf(piles[0], hours)
        val min = minOf(piles[0], hours)
        return max / min + if (max > min) 1 else 0
    }

    piles.sort()
    if (piles.size == hours)
        return piles.last()

    var i = 0
    var j = piles.lastIndex
    while (i <= j) {
        val mid = (i + j) / 2
        val consumption = consume(piles, piles[mid])
        // println("i: $i, j: $j, mid: $mid, consumption: $consumption")
        if (consumption == hours)
            return piles[mid]

        if (consumption < hours)
            j = mid - 1
        else
            i = mid + 1
    }
    if (i == 0)
        return hours / piles[i] + if (hours % piles[i] != 0) 1 else 0

    // println("i $i j $j")
    // now i > j: need to look for a value between the range of piles[j] and piles[i]
    var k = piles[j]
    var l = piles[i]
    while (k <= l) {
        val mid = (k + l) / 2
        val consumption = consume(piles, mid)
        if (consumption == hours)
            return mid

        if (consumption < hours)
            k++
        else
            l--
    }

    return -1
}

private fun consume(piles: IntArray, speed: Int): Int {
    var total = 0
    for (pile in piles) {
        total += (pile / speed) + if (pile % speed > 0) 1 else 0
    }
    return total
}