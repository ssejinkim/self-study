package example.collections

import org.assertj.core.api.BDDAssertions.then
import org.assertj.core.api.BDDAssertions.thenThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.util.Map.entry
import kotlin.NoSuchElementException
import kotlin.math.abs

class CollectionFunctionsTest {


    @Test
    @DisplayName("filter")
    fun `filter function enables you to filter collections`() {

        val numbers = listOf(1, -2, -3, -4, 5, -6)

        //  It takes a filter predicate as a lambda-parameter.
        val positives = numbers.filter { x -> x > 0 }

        then(positives).contains(1, 5)

        val negatives = numbers.filter { it < 0 }

        then(negatives).contains(-2, -3, -4, -6)
    }

    @Test
    @DisplayName("map")
    fun `map extension function enables you to apply a transformation to all elements in a collection`() {

        val numbers = listOf(1, -2, -3, -4, 5, -6)

        val doubled = numbers.map { x -> x * 2 }

        then(doubled).contains(2, -4, -6, -8, 10, -12)

        val tripled = numbers.map { it * 3 }
        then(tripled).contains(3, -6, -9, -12, 15, -18)
    }

    @Test
    @DisplayName("any")
    fun `Function any returns true if the collection contains at least one element that matches the given predicate`() {

        val numbers = listOf(1, -2, -3, -4, 5, -6)

        val anyNegative = numbers.any { it < 0 }

        then(anyNegative).isTrue()

        val anyGT6 = numbers.any { it > 6 }

        then(anyGT6).isFalse()
    }

    @Test
    @DisplayName("all")
    fun `Function all returns true if all elements in collection match the given predicate`() {

        val numbers = listOf(1, -2, -3, -4, 5, -6)

        val allEven = numbers.all { it % 2 == 0 }

        then(allEven).isFalse()

        val allLess6 = numbers.all { it < 6 }

        then(allLess6).isTrue()
    }

    @Test
    @DisplayName("none")
    fun `Function none returns true if there are no elements that match the given predicate in the collection`() {

        val numbers = listOf(1, -2, -3, -4, 5, -6)

        val allEven = numbers.none { it % 2 == 1 }

        then(allEven).isFalse()

        val allLess6 = numbers.none { it > 6 }

        then(allLess6).isTrue()
    }

    @Test
    @DisplayName("find, findLast")
    fun `find and findLast functions return the first or the last collection element that matches the given predicate If there are no such elements, functions return null`() {

        val words = listOf("Lets", "find", "something", "in", "collection", "somehow")

        val first = words.find { it.startsWith("some") }

        then(first).isEqualTo("something")

        val last = words.findLast { it.startsWith("some") }

        then(last).isEqualTo("somehow")

        val nothing = words.find { it.contains("nothing") }

        then(nothing).isNull()

    }

    @Test
    @DisplayName("first, last")
    fun `These functions return the first and the last element of the collection correspondingly  You can also use them with a predicate`() {

        val numbers = listOf(1, -2, -3, -4, 5, -6)

        val first = numbers.first()

        then(first).isEqualTo(1)

        val last = numbers.last()

        then(last).isEqualTo(-6)

        val firstEven = numbers.first { it % 2 == 0 }

        then(firstEven).isEqualTo(-2)

        val lastOdd = numbers.last { it % 2 != 0 }

        then(lastOdd).isEqualTo(5)

        val emptyList = emptyList<Int>()

        thenThrownBy {
            numbers.first { it > 6 }
        }.isInstanceOf(NoSuchElementException::class.java)

        thenThrownBy {
            emptyList.first()
        }.isInstanceOf(NoSuchElementException::class.java)
    }

    @Test
    @DisplayName("firstOrNull, lastOrNull")
    fun `These functions return the first and the last element of the collection correspondingly If there are no such elements, functions return null`() {

        val words = listOf("foo", "bar", "baz", "faz")
        val empty = emptyList<String>()

        val first = empty.firstOrNull()
        then(first).isNull()

        val last = empty.lastOrNull()
        then(last).isNull()

        val firstF = words.firstOrNull { it.startsWith('f') }
        then(firstF).isEqualTo("foo")

        val firstZ = words.firstOrNull { it.startsWith("z") }
        then(firstZ).isNull()

        val lastF = words.lastOrNull { it.endsWith('f') }
        then(lastF).isNull()

        val lastZ = words.lastOrNull { it.endsWith("z") }
        then(lastZ).isEqualTo("faz")

    }

    @Test
    @DisplayName("count")
    fun `count functions returns either the total number of elements in a collection or the number of elements matching the given predicate`() {

        val numbers = listOf(1, -2, -3, -4, 5, -6)

        val totalCount = numbers.count()
        then(totalCount).isEqualTo(6)

        val evenCount = numbers.count { it % 2 == 0 }
        then(evenCount).isEqualTo(3)
    }


    @Test
    @DisplayName("associateBy, groupBy")
    fun `Functions associateBy and groupBy build maps from the elements of a collection indexed by the specified key`() {
        data class Person(val name: String, val city: String, val phone: String)

        val people = listOf(
            Person("John", "Boston", "+1-888-123456"),
            Person("Sarah", "Munich", "+49-777-789123"),
            Person("Svyatoslav", "Saint-Petersburg", "+7-999-456789"),
            Person("Vasilisa", "Saint-Petersburg", "+7-999-123456")
        )

        // keySelector
        val phoneBook = people.associateBy { it.phone }
        then(phoneBook)
            .contains(
                entry("+1-888-123456", Person("John", "Boston", "+1-888-123456")),
                entry("+49-777-789123", Person("Sarah", "Munich", "+49-777-789123")),
                entry("+7-999-456789", Person("Svyatoslav", "Saint-Petersburg", "+7-999-456789")),
                entry("+7-999-123456", Person("Vasilisa", "Saint-Petersburg", "+7-999-123456"))
            )

        // keySelector, valueSelector
        val cityBook = people.associateBy(Person::phone, Person::city)
        then(cityBook)
            .contains(
                entry("+1-888-123456", "Boston"),
                entry("+49-777-789123", "Munich"),
                entry("+7-999-456789", "Saint-Petersburg"),
                entry("+7-999-123456", "Saint-Petersburg")
            )

        val peopleCities = people.groupBy(Person::city, Person::name)
        then(peopleCities)
            .contains(
                entry("Boston", listOf("John")),
                entry("Munich", listOf("Sarah")),
                entry("Saint-Petersburg", listOf("Svyatoslav", "Vasilisa"))
            )
    }

    @Test
    @DisplayName("partition")
    fun `The partition function splits the original collection into a pair of lists using a given predicate`() {
        val numbers = listOf(1, -2, -3, -4, 5, -6)

        val evenOdd = numbers.partition { it % 2 == 0 }

        then(evenOdd)
            .isInstanceOf(Pair::class.java)
        then(evenOdd.first)
            .contains(-2, -4, -6)
        then(evenOdd.second)
            .contains(1, -3, 5)

        val (positive, negative) = numbers.partition { it > 0 }

        then(positive).contains(1, 5)
        then(negative).contains(-2, -3, -4, -6)

    }

    @Test
    @DisplayName("flatMap")
    fun `flatMap transforms each element of a collection into an iterable object and builds a single list of the transformation results`() {
        val numbers = listOf(1, 2, 3)

        val tripled = numbers.flatMap { listOf(it, it, it) }

        then(tripled).containsExactly(1, 1, 1, 2, 2, 2, 3, 3, 3)
    }

    @Test
    @DisplayName("min, max")
    fun `min and max functions return the smallest and the largest element of a collection  If the collection is empty, they return null`() {

        var numbers = listOf(1, 2, 3)

        then(numbers.min()).isEqualTo(1)
        then(numbers.max()).isEqualTo(3)

        var empty = emptyList<Int>()

        then(empty.min()).isNull()
        then(empty.max()).isNull()

    }

    @Test
    @DisplayName("sorted, sortedBy, sortedDescending, sortedByDescending")
    fun `sorted returns a list of collection elements sorted according to their natural sort order _ascending`() {

        val shuffled = listOf(5, 4, 2, 1, 3, -10)

        val natural = shuffled.sorted()
        then(natural).containsExactly(-10, 1, 2, 3, 4, 5)

        val inverted = shuffled.sortedBy { -it }
        then(inverted).containsExactly(5, 4, 3, 2, 1, -10)

        val descending = shuffled.sortedDescending()
        then(descending).containsExactly(5, 4, 3, 2, 1, -10)

        val descendingBy = shuffled.sortedByDescending { abs(it) }
        then(descendingBy).containsExactly(-10, 5, 4, 3, 2, 1)

    }

    @Test
    @DisplayName("zip")
    fun `zip function merges two given collections into a new collection`() {

        val a = listOf("a", "b", "c")
        val b = listOf(1, 2, 3, 4)

        // By default, the result collection contains Pairs of source collection elements with the same index
        val resultPairs = a zip b

        then(resultPairs).contains(Pair("a", 1), Pair("b", 2), Pair("c", 3))

        // you can define own structure of the result collection element
        val resultReduce = a.zip(b) { a, b -> "$a$b" }
        then(resultReduce).contains("a1", "b2", "c3")

    }

    @Test
    @DisplayName("getOrElse")
    fun `getOrElse provides safe access to elements of a collection`() {

        val list = listOf(0, 10, 20)

        val value1 = list.getOrElse(1) { 42 }
        then(value1).isEqualTo(10);

        val value2 = list.getOrElse(10) { 42 }
        then(value2).isEqualTo(42)


        val map = mutableMapOf<String, Int?>()

        val value3 = map.getOrElse("x") { 1 }
        then(value3).isEqualTo(1)

        map["x"] = 3

        val value4 = map.getOrElse("x") { 1 }
        then(value4).isEqualTo(3)

        map["x"] = null

        val value5 = map.getOrElse("x") { 1 }
        then(value5).isEqualTo(1)
    }
}
