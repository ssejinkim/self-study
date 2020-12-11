package example.scopeFuctions

import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.Test

class AlsoTest {
    @Test
    fun `also works like apply  it executes a given block and returns the object called`() {

        data class Person(var name: String, var age: Int, var about: String) {
            constructor() : this("", 0, "")
        }

        fun writeCreateLog(p: Person): String = p.let {
            "A new person ${p.name} was created"
        }

        var log = ""
        var jake = Person("Jake", 0, "Android Developer")
            .also {
                log = writeCreateLog(it);
            }

        then(jake.name).isEqualTo("Jake")
        then(log).isEqualTo("A new person Jake was created")
    }
}