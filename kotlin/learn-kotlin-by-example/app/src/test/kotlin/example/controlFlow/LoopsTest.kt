package example.controlFlow

import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.Test

class LoopsTest {

    @Test
    fun `for`() {
        val cakes = listOf("carrot", "cheese", "chocolate")

        for (cake in cakes) {
            println("Yummy, it's a $cake cake!")
        }

        then(cakes)
                .contains("carrot", "cheese", "chocolate")
    }

    @Test
    fun `while and do-while`() {
        fun bakeACake() = println("Bake a Cake")
        fun eatACake() = println("Eat a Cake")

        var cakesBaked = 0
        var cakesEaten = 0

        while (cakesBaked < 5) {
            bakeACake()
            cakesBaked++
        }

        then(cakesBaked).isEqualTo(5)

        do {
            eatACake()
            cakesEaten++
        } while (cakesEaten < cakesBaked)

        then(cakesEaten).isEqualTo(5)
    }

    @Test
    fun `Iterators`() {
        class Animal(val name: String)

        class Zoo(val animals: List<Animal>) {
            operator fun iterator(): Iterator<Animal> {
                return animals.iterator()
            }
        }

        val zoo = Zoo(listOf(Animal("zebra"), Animal("lion")))

        for (animal in zoo) {
            println("Watch out, it's a ${animal.name}")
        }

        val iterator = zoo.iterator()
        then(iterator).isNotEmpty

        while (iterator.hasNext()) {
            println("Watch out, it's a ${iterator.next().name}")
        }

        then(zoo.animals)
                .hasSize(2)
                .extracting("name")
                .contains("zebra", "lion")
    }
}