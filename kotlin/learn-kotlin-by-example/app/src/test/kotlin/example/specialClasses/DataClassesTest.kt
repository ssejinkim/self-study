package example.specialClasses

import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.Test

class DataClassesTest {

    @Test
    fun `Data Classes`() {
        data class User(val name: String, val id: Int)

        val user = User("Alex", 1)
        val secondUser = User("Alex", 1)
        val thirdUser = User("Max", 2)

        then(user == secondUser).isTrue()
        then(user === secondUser).isFalse()
        then(user == thirdUser).isFalse()

        then(user.hashCode() == secondUser.hashCode()).isTrue()
        then(user.hashCode() == thirdUser.hashCode()).isFalse()

        val userCopy = user.copy()
        then(userCopy == user).isTrue()
        then(userCopy === user).isFalse()

        val userCopy2 = user.copy("Max")
        then(userCopy2.component1()).isEqualTo("Max")
        then(userCopy2.component2()).isEqualTo(1)

        val userCopy3 = user.copy(id = 3)
        then(userCopy3.component1()).isEqualTo("Alex")
        then(userCopy3.component2()).isEqualTo(3)
    }

}