package example.functional

import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.Test

class ExtensionFunctionsAndPropertiesTest {

    data class Item(val name: String, val price: Float)

    data class Order(val items: Collection<Item>)

    private fun Order.maxPricedItemValue() = this.items.maxBy { it.price }?.price ?: 0F
    private fun Order.maxPricedItemName() = this.items.maxBy { it.price }?.name ?: "NO_PRODUCTS"

    private val Order.commaDelimitedItemNames: String
//            get() = items.map { it.name }.joinToString()
        get() = items.joinToString { it.name } //merge call chain

    /*
    Extensions
    https://kotlinlang.org/docs/reference/extensions.html#extensions
     */
    @Test
    fun `Extension Functions and Properties`() {

        val order = Order(
                listOf(
                        Item("Bread", 25.0F),
                        Item("Wine", 29.0F),
                        Item("Water", 12.0F)
                )
        )

        then(order.maxPricedItemValue()).isEqualTo(29.0F)
        then(order.maxPricedItemName()).isEqualTo("Wine")
        then(order.commaDelimitedItemNames).isEqualTo("Bread, Wine, Water")

    }

    @Test
    fun `It is even possible to execute extensions on null references`() {
        fun <T> T?.nullSafeToString() = this?.toString() ?: "NULL"

        then(null.nullSafeToString()).isEqualTo("NULL")
        then("Kotlin".nullSafeToString()).isEqualTo("Kotlin")
    }
}