package example.productivityBoosters

import org.assertj.core.api.BDDAssertions.then
import org.assertj.core.api.BDDAssertions.thenThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.time.chrono.ChronoLocalDate

class SmartCastsTest {

    @Test
    @DisplayName("Smart Casts")
    fun `The Kotlin compiler is smart enough to perform type casts automatically in most cases`() {

        val date: ChronoLocalDate? = LocalDate.now()

        if (date != null) {
            then(date.isLeapYear).isNotNull()
        }

        date?.let { then(it.isLeapYear).isNotNull() }

        then(date!!.isLeapYear).isNotNull()

        val nullDate: ChronoLocalDate? = null;
        thenThrownBy {
            then(nullDate!!.isLeapYear).isNotNull()
        }.isInstanceOf(RuntimeException::class.java)

        if (date != null && date.isLeapYear) {
            println("It's a leap year!")
        }

        if (date != null || date.isLeapYear) {
            println("There's no Feb 29 this year..")
        }

        if (date is LocalDate) {
            val month = date.monthValue
            println(month)
            then(month).isBetween(1, 12)
        }
    }
}