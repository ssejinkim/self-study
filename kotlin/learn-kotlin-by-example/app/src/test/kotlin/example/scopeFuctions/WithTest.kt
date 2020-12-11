package example.scopeFuctions

import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class WithTest {

    @Test
    @DisplayName("with")
    fun `with is a non-extension function that can access members of its argument concisely  you can omit the instance name when referring to its members`() {

        class Configuration(var host: String, var port: Int)

        val configuration = Configuration(host = "127.0.0.1", port = 9000)

        var address = ""
        with(configuration) {
            println("$host")
            println("$port")
            address = "$host:$port"
        }

        then(address).isEqualTo("127.0.0.1:9000")

    }
}