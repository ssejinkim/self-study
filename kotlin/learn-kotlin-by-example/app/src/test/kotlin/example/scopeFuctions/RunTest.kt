package example.scopeFuctions

import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class RunTest {

    @Test
    @DisplayName("run")
    fun `executes a code block and returns its result  inside run the object is accessed by this`() {
        fun getNullableLength(ns: String?): Int? {

            return ns?.run {
                println("is empty? ${isEmpty()}")
                println("length ${this.length}")
                this.length
            }
        }

        val length = getNullableLength(null)
        then(length).isNull()

        val length2 = getNullableLength("")
        then(length2).isEqualTo(0)

        val length3 = getNullableLength("some string with Kotlin")
        then(length3).isEqualTo(23)
    }
}