package example.controlFlow

import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.Test

class EqualityChecksTest {

    @Test
    fun `Equality Checks`() {
        val authors = setOf("Shakespeare", "Hemingway", "Twain")
        val writers = setOf("Twain", "Shakespeare", "Hemingway")

        val authors2 = authors

        then(authors == writers).isTrue()
        then(authors === writers).isFalse()
        then(authors === authors2).isTrue()
    }
}