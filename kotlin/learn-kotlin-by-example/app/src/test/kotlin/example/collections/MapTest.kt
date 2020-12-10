package example.collections

import org.assertj.core.api.BDDAssertions.*
import org.junit.jupiter.api.Test
import java.util.Map.entry

class MapTest {
    @Test
    fun `A map is a collection of key-value pairs, where each key is unique and is used to retrieve the corresponding value`() {
        val POINTS_X_PASS = 15
        val EZPassAccounts = mutableMapOf(1 to 100, 2 to 100, 3 to 100)
        val EZPassReport: Map<Int, Int> = EZPassAccounts

        fun accountsReport(): String {
            var result = "EZ-Pass report:\n"
            EZPassReport.forEach { k, v ->
                result += "ID $k: credit $v\n"
            }
            return result
        }

        fun updatePointsCredit(accountId: Int) {
            if (EZPassAccounts.containsKey(accountId))
                EZPassAccounts[accountId] = EZPassAccounts.getValue(accountId) + POINTS_X_PASS
            else throw NoSuchElementException()
        }

        var report = accountsReport()

        then(report)
                .isEqualTo(
                        "EZ-Pass report:\n" +
                                "ID 1: credit 100\n" +
                                "ID 2: credit 100\n" +
                                "ID 3: credit 100\n"
                )

        updatePointsCredit(1)
        updatePointsCredit(2)

        then(EZPassReport)
                .contains(entry(1, 115), entry(2, 115), entry(3, 100))

        assertThatThrownBy {
            updatePointsCredit(6)
        }.isInstanceOf(NoSuchElementException::class.java)
    }

}