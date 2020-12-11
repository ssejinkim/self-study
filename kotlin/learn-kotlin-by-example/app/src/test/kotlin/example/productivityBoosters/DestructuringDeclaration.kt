package example.productivityBoosters

import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class DestructuringDeclaration {

    @Test
    @DisplayName("Destructuring Declaration")
    fun `Destructuring declaration syntax can be very handy, especially when you need an instance only for accessing its members`() {


        val (x, y, z) = arrayListOf(5, 10, 15)
        then(x).isEqualTo(5)
        then(y).isEqualTo(10)
        then(z).isEqualTo(15)

        val map = mapOf("Alice" to 21, "Bob" to 25)

        for ((name, age) in map) {
            then(age).isEqualTo(map[name])
        }


        fun findMinMax(list: List<Int>) : Pair<Int?, Int?> {
           return Pair(list.min(), list.max())
        }

        val (min, max) = findMinMax(listOf(100, 90, 50, 98, 76, 83))
        then(min).isEqualTo(50)
        then(max).isEqualTo(100)
    }
}