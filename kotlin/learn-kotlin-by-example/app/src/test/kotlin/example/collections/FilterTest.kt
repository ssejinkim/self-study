package example.collections

import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.Test

class FilterTest {

    @Test
    fun `filter function enables you to filter collections`() {
        val numbers = listOf(1, -2, -3, -4, 5, -6)

        //  It takes a filter predicate as a lambda-parameter.
        val positives = numbers.filter { x -> x > 0 }

        then(positives).contains(1, 5)

        val negatives = numbers.filter { it < 0 }

        then(negatives).contains(-2, -3, -4, -6)
    }
}