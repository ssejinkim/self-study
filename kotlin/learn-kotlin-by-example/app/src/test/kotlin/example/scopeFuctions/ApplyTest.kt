package example.scopeFuctions

import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.Test

class ApplyTest {

    @Test
    fun `apply executes a block of code on an object and returns the object itself  Inside the block, the object is referenced by this`() {
        data class Person(var name: String, var age: Int, var about: String) {
            constructor() : this("", 0, "")
        }

        val jake = Person()

        //This function is handy for initializing objects
        jake.apply {
            name = "Jake"
            age = 30
            about = "Android Developer"
        }

        then(jake.name).isEqualTo("Jake")
        then(jake.age).isEqualTo(30)
        then(jake.about).isEqualTo("Android Developer")

    }
}