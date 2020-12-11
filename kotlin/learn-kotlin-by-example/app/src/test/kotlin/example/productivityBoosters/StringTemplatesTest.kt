package example.productivityBoosters

import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class StringTemplatesTest {

    /*
    String templates
    https://kotlinlang.org/docs/reference/basic-types.html#string-templates
     */
    @Test
    @DisplayName("String Templates")
    fun `String templates allow you to include variable references and expressions into strings`() {

        val name = "Kotliner"

        val greeting = "Hello $name"
        then(greeting).isEqualTo("Hello Kotliner")

        val GREETING = "HELLO ${name.toUpperCase()}"
        then(GREETING).isEqualTo("HELLO KOTLINER")
    }

}