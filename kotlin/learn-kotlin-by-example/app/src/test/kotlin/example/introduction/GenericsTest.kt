package example.introduction

import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.Test


class MutableStack<E>(vararg items: E) {
    private val elements = items.toMutableList()

    fun push(element: E) = elements.add(element)

    fun peek(): E = elements.last()

    fun pop(): E = elements.removeAt(elements.size - 1)

    fun isEmpty() = elements.isEmpty()

    fun size() = elements.size

    override fun toString(): String = "MutableStack(${elements.joinToString()})"

}

//generify function
fun <E> mutableStackOf(vararg elements: E) = MutableStack(*elements)

class GenericsTest {
    @Test
    fun `Generic Classes`() {
        val stack = mutableStackOf("A", "B", "C")

        println(stack)
        then(stack.toString()).isEqualTo("MutableStack(A, B, C)")

        stack.push("D")
        then(stack.size()).isEqualTo(4)
        then(stack.peek()).isEqualTo("D")

        then(stack.pop()).isEqualTo("D")

        stack.pop()
        stack.pop()
        stack.pop()

        then(stack.isEmpty()).isTrue()

    }
}