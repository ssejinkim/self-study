package example.controlFlow

import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.Test

class ConditionalExpressionTest {

    @Test
    fun `Conditional Expression`() {
        fun max(a: Int, b: Int) = if (a > b) a else b

        then(max(99, -42)).isEqualTo(99)
    }
}