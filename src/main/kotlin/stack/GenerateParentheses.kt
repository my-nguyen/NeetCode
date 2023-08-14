package stack

fun main() {
    val numbers = listOf(1, 2, 3, 4)
    for (n in numbers) {
        println("n: $n, generate parentheses: ${generateParentheses(n)}")
    }
}

fun generateParentheses(n: Int): List<String> {
    val strings = mutableListOf<String>()
    generate(strings, "", 0, 0, n)
    return strings
}

// based on YouTuber Nick White's implementation
private fun generate(strings: MutableList<String>, string: String, open: Int, close: Int, max: Int) {
    if (string.length == max * 2) {
        strings.add(string)
        return
    }

    if (open < max)
        generate(strings, "$string(", open+1, close, max)
    if (close < open)
        generate(strings, "$string)", open, close+1, max)
}

// based on the interview with TikTok on 6/27/23
private fun generate2(count: Int, left: Int, right: Int, string: String, result: MutableList<String>) {
    if (left == count && right == count) {
        result.add(string)
        return
    }

    if (left < count)
        generate2(count, left+1, right, "$string(", result)
    if (right < left)
        generate2(count, left, right+1, "$string)", result)
}