package sliding_window

fun main() {
    val strings = listOf("abcabcbb", "bbbbb", "pwwkew", "")
    for (string in strings) {
        println("string: $string, longest substring without repeating characters: ${longestSubstringWithoutRepeatingCharacters(string)}")
    }
}

fun longestSubstringWithoutRepeatingCharacters(string: String): Int {
    if (string.isEmpty())
        return 0

    val set = mutableSetOf<Char>()
    var i = 0
    set.add(string[0])
    var max = 1
    for (j in 1..string.lastIndex) {
        // keep removing character on the left as long as the character on the right is still in the set
        while (set.contains(string[j])) {
            set.remove(string[i])
            i++
        }
        set.add(string[j])
        max = maxOf(max, j-i+1)
    }
    return max
}