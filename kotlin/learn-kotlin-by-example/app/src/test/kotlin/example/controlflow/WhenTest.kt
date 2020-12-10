package example.controlflow

import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.Test

class WhenTest {

    @Test
    fun `When Statement`() {

        var result: Any? = null
        fun cases(obj: Any): Any = when (obj) {
            1 -> {
                println("One")
                result = "One"
            }
            "Hello" -> println("Greeting")
            is Long -> println("Long")
            !is String -> println("Not a string")
            else -> println("Unknown")
        }

        class MyClass

        cases(1)
        then(result).isEqualTo("One")

        cases("Hello")
        cases(0L)
        cases(MyClass())
        cases("hello")
    }

    @Test
    fun `When Expression`() {

        fun cases(obj: Any): Any = when (obj) {
            1 -> "One"
            "Hello" -> "Greeting"
            is Long -> "Long"
            !is String -> "Not a string"
            else -> "Unknown"
        }

        class MyClass

        then(cases(1)).isEqualTo("One")
        then(cases("Hello")).isEqualTo("Greeting")
        then(cases(0L)).isEqualTo("Long")
        then(cases(MyClass())).isEqualTo("Not a string")
        then(cases("hello")).isEqualTo("Unknown")

    }
}