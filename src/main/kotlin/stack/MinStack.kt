package stack

import java.util.*

interface Command {
    fun run(value: Int?): Int?
}

lateinit var stack: MinStack2

fun buildMap(): Map<String, Command> {
    val map = mutableMapOf<String, Command>()
    map["MinStack"] = object : Command {
        override fun run(value: Int?): Int? {
            stack = MinStack2()
            return null
        }
    }
    map["push"] = object : Command {
        override fun run(value: Int?): Int? {
            stack.push(value!!)
            return null
        }
    }
    map["getMin"] = object : Command {
        override fun run(value: Int?) = stack.getMin()
    }
    map["pop"] = object : Command {
        override fun run(value: Int?): Int? {
            stack.pop()
            return null
        }
    }
    map["top"] = object : Command {
        override fun run(value: Int?) = stack.top()
    }
    return map
}

fun main() {
    val map = buildMap()
    val methods = listOf("MinStack", "push", "push", "push", "getMin", "pop", "top", "getMin")
    val arguments = listOf(null, -2, 0, -3, null, null, null, null)
    for (i in methods.indices) {
        println(map[methods[i]]!!.run(arguments[i]))
    }
}

class MinStack() {
    val stack = Stack<Int>()
    val minQueue = PriorityQueue<Int>()

    fun push(value: Int) {
        stack.push(value)
        minQueue.add(value)
    }

    fun pop() {
        minQueue.remove(stack.peek())
        stack.pop()
    }

    fun top() = stack.peek()

    fun getMin() = minQueue.peek()
}

// based on YouTuber Nick White's implementation
class MinStack2() {
    private val data = mutableListOf<Int>()
    // keep track of the index of each new min value, not the value itself
    private val minIndices = Stack<Int>()

    fun push(value: Int) {
        data.add(value)
        // when the new value is smaller than the current minimum, push the index of the new value
        if (data.size == 1 || value < data[minIndices.peek()])
            minIndices.push(data.lastIndex)
    }

    fun pop() {
        // if the last saved value is also the current minimum, pop its index
        if (minIndices.peek() == data.lastIndex)
            minIndices.pop()
        // data.removeLast()
        data.removeAt(data.lastIndex)
    }

    fun top() = data.last()

    fun getMin() = data[minIndices.peek()]
}