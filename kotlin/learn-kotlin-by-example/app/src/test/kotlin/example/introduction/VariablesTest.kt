package example.introduction

import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.Test


class VariablesTest {

    @Test
    internal fun `variables`() {

        var a: String = "initial"
        then(a is String).isTrue()

        val b: Int = 1
        then(b is Int).isTrue()

        //type inference
        var c = 3
        then(c is Int).isTrue()

        var e: Int
//        println(e) // compile time error - Variable 'e' must be initialized

        val d : Int

        if(true) {
            d = 1
        } else {
            d = 2
        }

        //must be initialized before the first read
        then(d).isEqualTo(1)

    }
}