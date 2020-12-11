package example.collections

import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.Test

class ListTest {

    /*
    Kotlin Collections Overview
    https://kotlinlang.org/docs/reference/collections-overview.html#kotlin-collections-overview

    List
    https://kotlinlang.org/docs/reference/collections-overview.html#list
     */
    @Test
    fun `A list is an ordered collection of items`() {
        val systemUsers: MutableList<Int> = mutableListOf(1, 2, 3)
        val sudoers: List<Int> = systemUsers

        fun addSudoer(newUser: Int) {
            systemUsers.add(newUser)
        }

        fun getSysSudoers(): List<Int> {
            return sudoers
        }

        addSudoer(4)
        then(getSysSudoers())
                .hasSize(4)
                .containsExactly(1,2,3,4)

//        getSysSudoers().add(5) // error - List is read-only

    }
}