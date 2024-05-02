import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ApplicationKtTest{

    @Test
    fun `test calculate`() {

        val computerNumbers = listOf(1, 2, 3)
        val userNumbers = listOf(1, 2, 3)
        val expectedOutput = 3 to 0

        val output = calculateResult(computerNumbers, userNumbers)

        assertEquals(output, expectedOutput)
    }

    @Test
    fun `test calculate2`() {
        val computerNumbers = listOf(1, 2, 3)
        val userNumbers = listOf(4, 5, 6)
        val expectedOutput = 0 to 0

        val output = calculateResult(computerNumbers, userNumbers)

        assertEquals(output, expectedOutput)
    }

    @Test
    fun `test calculate3`() {
        val computerNumbers = listOf(7, 1, 3)
        val userNumbers = listOf(1, 2, 3)
        val expectedOutput = 1 to 1

        val output = calculateResult(computerNumbers, userNumbers)

        assertEquals(output, expectedOutput)
    }

    @Test
    fun `test calculate4`() {
        val computerNumbers = listOf(7, 1, 3)
        val userNumbers = listOf(6, 7, 1)
        val expectedOutput = 0 to 2

        val output = calculateResult(computerNumbers, userNumbers)

        assertThat(output).isEqualTo(expectedOutput)
    }
}
