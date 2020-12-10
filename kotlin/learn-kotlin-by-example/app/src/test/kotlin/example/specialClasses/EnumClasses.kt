package example.specialClasses

import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.Test

class EnumClasses {

    //Modifier 'enum' is not applicable to 'local class'
    enum class State {
        IDLE, RUNNING, FINISHED
    }

    @Test
    fun `Enum Classes`() {
        fun cases(state: State) = when (state) {
            State.IDLE -> "It's idle"
            State.RUNNING -> "It's running"
            State.FINISHED -> "It's finished"
        }

        then(cases(State.IDLE)).isEqualTo("It's idle")
        then(cases(State.RUNNING)).isEqualTo("It's running")
        then(cases(State.FINISHED)).isEqualTo("It's finished")
    }


    enum class Color(private val rgb: Int) {
        RED(0xFF0000),
        GREEN(0x00FF00),
        BLUE(0x0000FF),
        YELLOW(0xFFFF00); // separated form the list of instances by semicolon

        fun containsRed() = (this.rgb and 0xFF0000 != 0)
    }

    @Test
    fun `Enums may contain properties`() {
        val color = Color.RED

        then(color == Color.RED).isTrue()
        then(color.toString()).isEqualTo("RED")
        then(color.containsRed()).isTrue()
        then(Color.BLUE.containsRed()).isFalse()
        then(Color.GREEN.containsRed()).isFalse()
        then(Color.YELLOW.containsRed()).isTrue()
    }
}