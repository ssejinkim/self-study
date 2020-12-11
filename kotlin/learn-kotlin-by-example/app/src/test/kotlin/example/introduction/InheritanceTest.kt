package example.introduction

import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.Test

class InheritanceTest {

    @Test
    fun `Inheritance`() {
        //classes are final by default : use open modifier
        open class Dog {
            //methods are also final by default
            open fun sayHello() = "wow wow!"
        }

        // () :invocation of the superclass default constructor.
        class Yorkshire : Dog() {
            //override method or attribute requires the override modifier
            override fun sayHello() = "wlf wlf!"
        }

        var dog = Dog()
        then(dog.sayHello()).isEqualTo("wow wow!")

        dog = Yorkshire()
        then(dog.sayHello()).isEqualTo("wlf wlf!")
    }

    @Test
    fun `Inheritance with Parameterized Constructor`() {

        open class Tiger(val origin: String) {
            fun sayHello() = "A tiger from $origin say : grrhhh!"
        }

        class SiberianTiger : Tiger("Siberia")

        val tiger: Tiger = SiberianTiger()

        then(tiger.sayHello()).isEqualTo("A tiger from Siberia say : grrhhh!")
    }

    @Test
    fun `Passing Constructor Arguments to Superclass`() {
        open class Lion(val name: String, val origin: String) {
            fun sayhello() = "$name, the lion from $origin says: graoh!"
        }

        class Asiatic(name: String) : Lion(name = name, origin = "India")

        val lion : Lion = Asiatic("Rufo")
        then(lion.sayhello()).isEqualTo("Rufo, the lion from India says: graoh!")
    }
}