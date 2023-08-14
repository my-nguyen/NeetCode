package stack

import java.util.*

fun main() {
    val list = listOf(arrayOf("2","1","+","3","*"), arrayOf("4","13","5","/","+"), arrayOf("10","6","9","3","+","-11","*","/","*","17","+","5","+"))
    for (tokens in list) {
        println("tokens: ${tokens.contentToString()}, evaluate reverse Polish notation: ${evaluateReversePolishNotation(tokens)}")
    }
}

fun evaluateReversePolishNotation(tokens: Array<String>): Int {
    val stack = Stack<Int>()
    for (token in tokens) {
        if (isOperator(token)) {
            val one = stack.pop()
            val two = stack.pop()
            val result = when (token) {
                "+" -> two + one
                "-" -> two - one
                "*" -> two * one
                else -> two / one
            }
            stack.push(result)
        } else {
            stack.push(token.toInt())
        }
    }
    return stack.peek()
}

private fun isOperator(string: String): Boolean {
    return string.length == 1 && (string[0] == '+' || string[0] == '-' || string[0] == '*' || string[0] == '/')
}