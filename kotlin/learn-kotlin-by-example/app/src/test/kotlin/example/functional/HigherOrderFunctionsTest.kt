package example.functional

import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.Test

class HigherOrderFunctionsTest {

    /*
    Higher-Order Functions and Lambdas
    https://kotlinlang.org/docs/reference/lambdas.html#higher-order-functions-and-lambdas
    */
    @Test
    fun `Taking Functions as Parameters`() {
        fun calculate(x: Int, y: Int, operation: (Int, Int) -> Int): Int = operation(x, y)

        fun sum(x: Int, y: Int) = x + y

        // function argument
        //:: is the notation that references a function by name
        val sumResult = calculate(4, 5, ::sum)

        //lambda
        val mulResult = calculate(4, 5) { a, b -> a * b }

        then(sumResult).isEqualTo(9)
        then(mulResult).isEqualTo(20)

    }


    @Test
    fun `Returning Function`() {

        fun square(x: Int) = x * x

        fun operation(): (Int) -> Int {
            return ::square
        }

        val func = operation()

        then(func(2)).isEqualTo(4)

    }
}