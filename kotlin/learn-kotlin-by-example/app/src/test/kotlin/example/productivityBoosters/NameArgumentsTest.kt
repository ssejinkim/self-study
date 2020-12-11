package example.productivityBoosters

import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class NameArgumentsTest {

    @Test
    @DisplayName("Named Arguments")
    fun `Kotlin supports passing arguments to methods and constructors according to the order they are defined`() {

        fun format(userName: String, domain: String) = "$userName@$domain"

        val email = format("mario", "example.com")
        then(email).isEqualTo("mario@example.com")

        val email2 = format("domain.com", "username")
        then(email2).isEqualTo("domain.com@username")

        val email3 = format(userName = "foo", domain = "bar.com")
        then(email3).isEqualTo("foo@bar.com")

        val email4 = format(domain = "frog.com", userName = "pepe")
        then(email4).isEqualTo("pepe@frog.com")
    }
}