package example.specialClasses

import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.Test



class SealedClassesTest {

    /*
    Sealed Classes
    https://kotlinlang.org/docs/reference/sealed-classes.html
     */
    @Test
    fun `Sealed Classes`() {
        then(greetingMammal(Human("Alex", "programmer")))
                .isEqualTo("Hello, Alex; You're working as a programmer")

        then(greetingMammal(Cat("Snowy")))
                .isEqualTo("Hello, Snowy")

    }
}

//it can only be subclassed from inside the same file
//It cannot be subclassed outside of the file where the sealed class is declared.
sealed class Mammal(val name: String)
class Cat(catName: String) : Mammal(catName)
class Human(humanName: String, val job: String) : Mammal(humanName)

fun greetingMammal(mammal: Mammal): String {
    return when (mammal) {
        is Human -> "Hello, ${mammal.name}; You're working as a ${mammal.job}"
        is Cat-> "Hello, ${mammal.name}"
    }
}
