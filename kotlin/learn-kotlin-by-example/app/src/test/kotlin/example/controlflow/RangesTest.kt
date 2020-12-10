package example.controlflow

import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.Test

class RangesTest {
    @Test
    fun `Ranges`() {

        var list = mutableListOf<Int>()

        for (i in 0..3) {
            list.add(i)
        }

        then(list).contains(0, 1, 2, 3)

        list.clear()

        for (i in 0 until 3) {
            list.add(i)
        }

        then(list).contains(0, 1, 2)


        list.clear()
        for (i in 2..8 step 2) {
            list.add(i)
        }

        then(list).contains(2, 4, 6, 8)

        list.clear()

        for (i in 3 downTo 0) {
            list.add(i)
        }

        then(list).containsExactly(3, 2, 1, 0)
    }

    @Test
    fun `Char ranges`() {
        var list = mutableListOf<Char>()

        for (c in 'a'..'d') {
            list.add(c)
        }

        then(list).contains('a', 'b', 'c', 'd')

        list.clear()

        for (c in 'z' downTo 's' step 2) {
            list.add(c)
        }

        then(list).containsExactly('z', 'x', 'v', 't')
    }

    @Test
    fun `Ranges are also useful in if statement`() {

        val x = 2
        var result = false;

        if(x in 1..5) {
           result = true
        }

        then(result).isTrue()
        
        if(x !in 6..10) {
           result = false
        }

        then(result).isFalse()
    }
}