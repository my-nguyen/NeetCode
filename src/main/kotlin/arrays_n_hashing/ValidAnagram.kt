package arrays_n_hashing

fun main() {
    val strings1 = listOf("anagram", "rat")
    val strings2 = listOf("nagaram", "car")
    for (i in strings1.indices) {
        println("s: ${strings1[i]}, t: ${strings2[i]}, valid anagram? ${validAnagram(strings1[i], strings2[i])}")
    }
}

fun validAnagram(s: String, t: String): Boolean {
    if (s.length != t.length)
        return false

    val counts = IntArray(26)
    for (c in s) {
        counts[c - 'a']++
    }

    for (c in t) {
        if (counts[c - 'a'] == 0)
            return false
        counts[c - 'a']--
    }
    return true
}