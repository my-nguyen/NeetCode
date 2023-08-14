package two_pointers

fun main() {
    val strings = listOf("A man, a plan, a canal: Panama", "race a car", " ")
    for (string in strings) {
        println("string: $string, valid palindrome? ${validPalindrome(string)}")
    }
}

fun validPalindrome(string: String): Boolean {
    val cleaned = cleanUp(string)
    var i = 0
    var j = cleaned.lastIndex
    while (i < j) {
        if (cleaned[i] != cleaned[j])
            return false
        i++
        j--
    }
    return true
}

fun cleanUp(string: String): String {
    val builder = StringBuilder()
    for (c in string) {
        if (!c.isLetterOrDigit())
            continue
        builder.append(if (c.isUpperCase()) c.toLowerCase() else c)
    }
    return builder.toString()
}