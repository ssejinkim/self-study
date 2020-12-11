package example.functional

import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.Test

class LambdaFunctionsTest {

    /*
    Lambda Expressions and Anonymous Functions
    https://kotlinlang.org/docs/reference/lambdas.html#lambda-expressions-and-anonymous-functions
     */
    @Test
    fun `Lambda Functions`() {
        val upperCase1: (String) -> String = { str: String -> str.toUpperCase() }
        val upperCase2: (String) -> String = { str -> str.toUpperCase() } // Type inference inside lambda
        val upperCase3 = { str: String -> str.toUpperCase() } // Type inference outside lambda
//        val upperCase4 = { str -> str.toUpperCase() } // You cannot do both together
        val upperCase5: (String) -> String = { it.toUpperCase() }
        val upperCase6: (String) -> String = String::toUpperCase // lambda consists of a single function call, you may use function pointers (::) .

        then(upperCase1("lowerCase")).isEqualTo("LOWERCASE")
        then(upperCase2("lowerCase")).isEqualTo("LOWERCASE")
        then(upperCase3("lowerCase")).isEqualTo("LOWERCASE")
        then(upperCase5("lowerCase")).isEqualTo("LOWERCASE")
        then(upperCase6("lowerCase")).isEqualTo("LOWERCASE")
    }

}