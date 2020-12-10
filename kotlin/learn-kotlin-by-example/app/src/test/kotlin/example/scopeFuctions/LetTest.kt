package example.scopeFuctions

import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LetTest {

    @Test
    @DisplayName("let")
    fun `The Kotlin standard library function let can be used for scoping and null-checks`() {

        fun customPrint(s: String) {
            println(s.toUpperCase())
        }

        val empty = "test".let {
            customPrint(it)
            it.isEmpty()
        }

        then(empty).isFalse()


        fun noneNull(str: String?): Int {

            str?.let {
                customPrint(it)
                return str.length
            }

            return 0

        }

        val length = noneNull(null)
        then(length).isEqualTo(0)

        val length2 = noneNull("my string")
        then(length2).isEqualTo(9)
    }
}