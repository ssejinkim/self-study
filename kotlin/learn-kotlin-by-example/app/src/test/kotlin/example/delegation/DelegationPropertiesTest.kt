package example.delegation

import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.reflect.KProperty


var result = ""

class Delegate() {
    operator fun getValue(thisRef: Any?, prop: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${prop.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, prop: KProperty<*>, value: String) {
        result = "$value has been assigned to ${prop.name} in $thisRef"
    }
}

class Example {
    var p: String by Delegate()
    override fun toString() = "Example Class"
}


class DelegationPropertiesTest {

    @Test
    @DisplayName("Delegation Properties")
    fun `Kotlin provides a mechanism of delegated properties that allows delegating the calls of the property set and get methods to a certain object`() {


        val e = Example()
        then(e.p).isEqualTo("Example Class, thank you for delegating 'p' to me!")

        e.p = "NEW"
        then(result).isEqualTo("NEW has been assigned to p in Example Class")

    }

    @Test
    @DisplayName("Standard Delegates")
    fun `The Kotlin standard library contains a bunch of useful delegates, like lazy  observable  and others`() {

        class LazySample {
            var isInitialized: Boolean = false

            val lazyStr: String by lazy {
                isInitialized = true
                "my lazy"
            }

        }

        val lazySample = LazySample();
        then(lazySample.isInitialized).isFalse()

        var lazy = lazySample.lazyStr
        then(lazySample.isInitialized).isTrue()
        then(lazy).isEqualTo("my lazy")

    }

    @Test
    @DisplayName("Storing Properties in a Map")
    fun `Property delegation can be used for storing properties in a map`() {

        class User(map: Map<String, Any>) {

            val name: String by map
            val age: Int by map
            override fun toString(): String = "name = $name, age = $age"
        }

        val user = User(
            mapOf(
                "name" to "John Doe",
                "age" to 25
            )
        )

        then(user.toString()).isEqualTo("name = ${user.name}, age = ${user.age}")
    }

}

