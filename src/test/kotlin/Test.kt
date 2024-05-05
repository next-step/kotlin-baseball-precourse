package baseball

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Test
class BaseballTest {

    @Test
    fun `generateAnswer returns a string of 3 unique digits`() {
        val answer = generateAnswer()
        assertThat(answer.length).isEqualTo(3)
        assertThat(answer.toSet().size).isEqualTo(3)
        assertThat(answer.all { it.isDigit() && it != '0' }).isTrue()
    }

    @Test
    fun `checkInputIfValid returns true for valid input`() {
        val validInput = "123"
        assertTrue(checkInputIfValid(validInput))
    }

    @Test
    fun `checkInputIfValid returns false for invalid input`() {
        val invalidInputs = listOf("111", "1234", "abc", "012")
        invalidInputs.forEach { input ->
            assertFalse(checkInputIfValid(input))
        }
    }

    @Test
    fun `evaluate returns true only when there are 3 strikes`() {
        val answer = "123"
        assertEquals(Pair(3, 0), evaluate("123", answer), "3S0B true")
        assertNotEquals(Pair(3, 0), evaluate("132", answer), "3S0B false")
        assertNotEquals(Pair(3, 0), evaluate("456", answer), "3S0B false")
    }

    @Test
    fun `evaluateAndCount correctly identifies number of strikes and balls`() {
        val answer = "123"
        val testCases = mapOf(
            "123" to Pair(3, 0),   // 3스트라이크, 0볼
            "132" to Pair(1, 2),   // 1스트라이크, 2볼
            "456" to Pair(0, 0),   // 낫싱
            "145" to Pair(1, 0),   // 1스트라이크
            "231" to Pair(0, 3)    // 3볼
        )
        testCases.forEach { (input, expected) ->
            val (strikes, balls) = evaluate(input, answer)
            assertEquals(expected, Pair(strikes, balls), "input: $input, expected: $expected, Strikes: $strikes, Balls: $balls")
        }
    }
}
