package sliding_window

fun main() {
    val string1s = listOf("ab", "ab")
    val string2s = listOf("eidbaooo", "eidboaoo")
    for (i in string1s.indices) {
        println("s1: ${string1s[i]}, s2: ${string2s[i]}, permutation in string: ${permutationInString(string1s[i], string2s[i])}")
    }
}

fun permutationInString(s1: String, s2: String): Boolean {
    val frequency = getFrequency(s1)
    for (i in s2.indices) {
        if (frequency.containsKey(s2[i])) {
            if (containsPermutation(s2, i, frequency.toMutableMap()))
                return true
        }
    }
    return false
}

private fun getFrequency(string: String): Map<Char, Int> {
    val frequency = mutableMapOf<Char, Int>()
    for (c in string) {
        frequency[c] = frequency.getOrDefault(c, 0) + 1
    }
    return frequency
}

private fun containsPermutation(string: String, index: Int, frequency: MutableMap<Char, Int>): Boolean {
    for (i in index..string.lastIndex) {
        if (frequency.isEmpty())
            return true
        val key = string[i]
        if (!frequency.containsKey(key))
            return false
        if (frequency[key] == 1)
            frequency.remove(key)
        else
            frequency[key] = frequency[key]!! - 1
    }
    return frequency.isEmpty()
}

