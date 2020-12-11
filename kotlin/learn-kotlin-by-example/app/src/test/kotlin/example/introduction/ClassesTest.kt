package example.introduction

import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.Test

class Classes {

    class Customer

    class Contact(val id: Int, var email: String)

    /*
    Classes
    https://kotlinlang.org/docs/reference/classes.html#classes
     */
    @Test
    fun `Class Declaration`() {

        val customer = Customer()

        then(customer).isNotNull();

        var contact = Contact(1, "mary@gmail.com")

        contact.email = "jane@gmail.com"

        then(contact.id).isEqualTo(1)
        then(contact.email).isEqualTo("jane@gmail.com")

    }
}