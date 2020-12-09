package example.introduction

import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.Test


class FunctionsTest {

    @Test
    internal fun `Default Parameter Values and Named Arguments`() {
        var argument = ""

        fun printMessage(message: String): Unit {
            argument = message;
            println(message)
        }

        fun printMessageWithPrefix(message: String, prefix: String = "Info") {
            argument = "[$prefix] $message"
            println("[$prefix] $message")
        }

        fun sum(x: Int, y: Int): Int {
            return x + y;
        }

        fun multiply(x: Int, y: Int) = x * y

        printMessage("Hello")
        then(argument).isEqualTo("Hello")

        printMessageWithPrefix("Hello", "Log")
        then(argument).isEqualTo("[Log] Hello")

        printMessageWithPrefix("Hello")
        then(argument)
                .`as`("optional parameter with default value")
                .isEqualTo("[Info] Hello")

        printMessageWithPrefix(prefix = "Log", message = "Hello")
        then(argument)
                .`as`("using name arguments")
                .isEqualTo("[Log] Hello")

        then(sum(1, 2)).isEqualTo(3)
        then(multiply(2, 4)).isEqualTo(8)
    }

    @Test
    internal fun `Infix Functions`() {

        //local function
        infix fun Int.times(str: String) = str.repeat(this)

        println(2 times "Bye ")
        then(2 times "Bye ")
                .`as`("Member functions and extensions with a single parameter can be turned into infix functions.")
                .isEqualTo("Bye Bye ")
        then(2.times("Bye ")).isEqualTo("Bye Bye ")

        val pair = "Ferrari" to "Katrina"
        println(pair)
        then(pair).isEqualTo(Pair("Ferrari", "Katrina"))

        val (a, b) = pair
        then(a).isEqualTo("Ferrari")
        then(b).isEqualTo("Katrina")

        infix fun String.onto(other: String) = Pair(this, other)
        val myPair = "McLaren" onto "Lucas"
        println(myPair)

        then(myPair).isEqualTo(Pair("McLaren", "Lucas"))

        class Person(val name: String) {
            val likedPeople = mutableListOf<Person>()
            infix fun likes(other: Person) {
                likedPeople.add(other)
            }
        }

        val sophia = Person("Sophia")
        val claudia = Person("Claudia")

        sophia likes claudia

        then(sophia.likedPeople).hasSize(1)
        then(sophia.likedPeople).contains(claudia)

    }

    @Test
    internal fun `Operator Functions`() {
        operator fun Int.times(str: String) = str.repeat(this)
        println(2 * "Bye ")
        then(2 * "Bye ")
                .`as`("operator")
                .isEqualTo("Bye Bye ")

        //The get() operator enables bracket-access syntax.
        operator fun String.get(range: IntRange) = substring(range)
        val str = "Always forgive your enemies; nothing annoys them so much."
        println(str[0..13])
        then(str[0..13]).isEqualTo("Always forgive")
    }

    @Test
    internal fun `Functions with vararg Parameters`() {
        var arguments = mutableListOf<String>()

        //vararg
        fun printAll(vararg messages: String) {
            arguments.clear()
            for (m in messages) {
                arguments.add(m)
                println(m)
            }
        }

        printAll("Hello", "Hallo", "Salut", "Hola", "안녕")

        then(arguments).hasSize(5)
        then(arguments).contains("Hello", "Hallo", "Salut", "Hola", "안녕")

        fun printAllWithPrefix(vararg messages: String, prefix: String) {
            arguments.clear()
            for (m in messages) {
                arguments.add(prefix + m)
                println(prefix + m)
            }
        }

        val prefix = "Greeting: "

        printAllWithPrefix(
                "Hello", "Hallo", "Salut", "Hola", "안녕",
                prefix = prefix
        )

        then(arguments)
                .contains("${prefix}Hello", "${prefix}Hallo", "${prefix}Salut", "${prefix}Hola", "${prefix}안녕")

        //out?
        //spread operator *
        fun log(vararg entries: String): Array<out String> {
            printAll(*entries)
            return entries
        }

        then(log("Hello", "Hallo", "Salut", "Hola", "안녕"))
                .contains("Hello", "Hallo", "Salut", "Hola", "안녕")
    }
}
