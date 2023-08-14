package stack

import java.util.Stack

fun main() {
    val strings = listOf("()", "()[]{}", "(]")
    for (string in strings) {
        println("string: $string, valid parentheses? ${validParentheses(string)}")
    }
}

fun validParentheses(string: String): Boolean {
    val left = setOf('(', '[', '{')
    val map = mapOf(')' to '(', ']' to '[', '}' to '{')
    val stack = Stack<Char>()
    for (c in string) {
        if (left.contains(c))
            stack.push(c)
        else {
            if (stack.isEmpty() || stack.peek() != map[c])
                return false
            stack.pop()
        }
    }
    return stack.isEmpty()
}