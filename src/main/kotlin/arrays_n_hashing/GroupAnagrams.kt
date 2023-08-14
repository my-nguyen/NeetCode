package arrays_n_hashing

fun main() {
    val strings = listOf(arrayOf(""), arrayOf("a"), arrayOf("eat","tea","tan","ate","nat","bat"))
    for (list in strings) {
        println("strings: $list, anagrams: ${groupAnagrams(list)}")
    }
}

fun groupAnagrams(strings: Array<String>): List<List<String>> {
    val result = mutableListOf<List<String>>()
    if (strings.size == 1) {
        result.add(strings.toList())
        return result
    }

    val anagrams = mutableMapOf<IntArray, MutableList<String>>()
    anagrams[getFrequency(strings[0])] = mutableListOf<String>().also { it.add(strings[0]) }

    for (i in 1..strings.lastIndex) {
        val frequency = findAnagram(anagrams, strings[i])
        if (frequency != null) {
            anagrams[frequency]!!.add(strings[i])
        } else {
            anagrams[getFrequency(strings[i])] = mutableListOf<String>().also { it.add(strings[i]) }
        }
    }

    for (value in anagrams.values) {
        result.add(value)
    }
    return result
}

// check whether a string is an anagram of one of the anagrams created so far. if yes then return the matching frequency
// so the string can be added to the anagrams later.
private fun findAnagram(anagrams: Map<IntArray, List<String>>, string: String): IntArray? {
    for ((frequency, strings) in anagrams) {
        // only pass a copy of the frequency
        if (isAnagram(strings[0].length, frequency.copyOf(), string))
            return frequency
    }
    return null
}

// given a string, return an array of 26 integers representing 26 characters in the alphabet, each integer being
// the frequency of the corresponding character
private fun getFrequency(string: String): IntArray {
    val frequency = IntArray(26)
    for (c in string) {
        frequency[c - 'a']++
    }
    return frequency
}

// check whether a string has the expected character frequency, and thus an anagram
private fun isAnagram(length: Int, frequency: IntArray, string: String): Boolean {
    if (length != string.length)
        return false

    for (c in string) {
        val i = c - 'a'
        if (frequency[i] == 0)
            return false
        frequency[i]--
    }
    return true
}