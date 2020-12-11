package example.delegation

import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test


class DelegationPatternTest {

    /*
    Delegation
    https://kotlinlang.org/docs/reference/delegation.html#delegation
     */
    @Test
    @DisplayName("Delegation Pattern")
    fun `Kotlin supports easy implementation of the delegation pattern on the native level without any boilerplate code`() {
        val singers = listOf(
            TomAraya("Thrash Metal"),
            ElvisPresley("Dancin` to the Jailhouse Rock.")
        )

        singers.forEach {
            it.makeSound()
        }

        then(singers)
            .extracting { it.makeSound() }
            .containsExactly(
                "THRASH METAL!!!",
                "I'm King of Rock 'N' Roll: Dancin` to the Jailhouse Rock."
            )
    }
}

// an interface cannot be local.
interface SoundBehavior {
    fun makeSound(): String
}

class ScreamBehavior(private val n: String) : SoundBehavior {
    override fun makeSound() = "${n.toUpperCase()}!!!"
}

class RockAndRoleBehavior(private val n: String) : SoundBehavior {
    override fun makeSound() = "I'm King of Rock 'N' Roll: $n"
}

class TomAraya(n: String) : SoundBehavior by ScreamBehavior(n)

class ElvisPresley(n: String) : SoundBehavior by RockAndRoleBehavior(n)