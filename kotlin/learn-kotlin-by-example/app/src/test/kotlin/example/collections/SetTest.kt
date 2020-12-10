package example.collections

import org.assertj.core.api.BDDAssertions.then
import org.junit.jupiter.api.Test

class SetTest {

    @Test
    fun `A set is an unordered collection that does not support duplicates`() {
        val openIssues = mutableSetOf<String>("uniqueDescr1", "uniqueDescr2", "uniqueDescr3")

        fun addIssue(uniqueDesc: String): Boolean {
            return openIssues.add(uniqueDesc)
        }

        fun getStatusLog(isAdded: Boolean): String {
            return if (isAdded) "registered correctly." else "marked as duplicate and rejected."
        }

        val aNewIssue = "uniqueDescr4"
        val anIssueAlreadyIn = "uniqueDescr2"

        then(getStatusLog(addIssue(aNewIssue))).isEqualTo("registered correctly.")
        then(getStatusLog(addIssue(anIssueAlreadyIn))).isEqualTo("marked as duplicate and rejected.")
    }

}