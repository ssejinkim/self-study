package example.specialClasses

import org.assertj.core.api.BDDAssertions.then
//import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test
import java.util.*

class ObjectKeywordTest {

    @Test
//    @RepeatedTest(value= 100_00, name="{displayName}")
    fun `Class and Object`() {
        class LuckDispatcher {
            fun getNumber(): Int {
                var objRandom = Random()
                return objRandom.nextInt(90)
            }
        }

        val d1 = LuckDispatcher()
        val d2 = LuckDispatcher()

        then(d1.getNumber()).isBetween(0, 90)
        then(d2.getNumber()).isBetween(0, 90)

    }

    @Test
    fun `object Expression`() {
        fun rentPrice(standardDays: Int, festivityDays: Int, specialDays: Int): Int {

            // a simple object/properties structure
            val dayRates = object {
                var standard: Int = 30 * standardDays
                var festivity: Int = 50 * festivityDays
                var special: Int = 100 * specialDays
            }

            return dayRates.standard + dayRates.festivity + dayRates.special

        }

        then(rentPrice(10, 2, 1))
                .isEqualTo(500)
    }


    //Named object 'DoAuth' is a singleton and cannot be local. Try to use anonymous object instead
    object DoAuth {
        fun takeParams(username: String, password: String): Boolean =
                username == "foo" && password == "qwerty"
    }

    @Test
    fun `object Declaration`() {

        then(DoAuth.takeParams("foo", "qwerty"))
                .isTrue()
        then(DoAuth.takeParams("bar", "qwerty"))
                .isFalse()

    }


    class BigBen {
        // Modifier 'companion' is not applicable inside 'local class'
        companion object Bonger {
            fun getBongs(nTimes: Int): String {
                var result = ""
                for (i in 1..nTimes) {
                  result += "Bong "
                }
                return result
            }
        }
    }

    @Test
    fun `Companion Object`() {
        // Syntactically it's similar to the static methods in Java: you call object members using its class name as a qualifier.
        // If you plan to use a companion object in Kotlin, consider using a package-level function instead.
        then(BigBen.getBongs(12)).isEqualTo("Bong ".repeat(12))

    }

}
