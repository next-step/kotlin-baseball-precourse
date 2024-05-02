package engine

import Console
import RandomNumberGenerator
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class BaseBallTest {
    private val mockGenerator = RandomNumberGenerator()
    private val mockConsole = Console()

    private val baseBall = BaseBall(mockGenerator, mockConsole, mockConsole)

    @Test
    @DisplayName("Input Case(1) : Valid")
    fun `parse should return list of integers for valid input`() {
        // Given
        val inputString = "123"

        // When
        val result = baseBall.parse(inputString)

        // Then
        assertNotNull(result)
        assertEquals(listOf(1, 2, 3), result)
    }

    @Test
    @DisplayName("Input Case(2) : Duplicate Digits")
    fun `parse should return null for input with duplicate digits`() {
        // Given
        val inputString = "112"

        // When
        val result = baseBall.parse(inputString)

        // Then
        assertNull(result)
    }

    @Test
    @DisplayName("Input Case(3) : Non-digit Characters")
    fun `parse should return null for input with non-digit characters`() {
        // Given
        val inputString = "1a3"

        // When
        val result = baseBall.parse(inputString)

        // Then
        assertNull(result)
    }

    @Test
    @DisplayName("Input Case(4) : Incorrect Length")
    fun `parse should return null for input with incorrect length`() {
        // Given
        val inputString = "1234" // More than COUNT_OF_NUMBERS

        // When
        val result = baseBall.parse(inputString)

        // Then
        assertNull(result)
    }

    @Test
    @DisplayName("Input Case(5) : Invalid Numbers")
    fun `parse should return null for input with invalid numbers`() {
        // Given
        val inputString = "089" // Contains 0, which is invalid

        // When
        val result = baseBall.parse(inputString)

        // Then
        assertNull(result)
    }

    @Test
    @DisplayName("BallCount(1) : all strikes")
    fun `test all matches - all strikes`() {
        val answer = listOf(1, 2, 3)
        val inputNumbers = listOf(1, 2, 3)
        val result: BallCount = baseBall.returnBallCount(answer, inputNumbers)
        // mockConsole.displayBallCount(result)
        assertEquals(3, result.strike)
        assertEquals(0, result.ball)
    }

    @Test
    @DisplayName("BallCount(2) : some strikes")
    fun `test partial matches - some strikes`() {
        val answer = listOf(1, 2, 3)
        val inputNumbers = listOf(1, 4, 3)
        val result: BallCount = baseBall.returnBallCount(answer, inputNumbers)
        // mockConsole.displayBallCount(result)
        assertEquals(2, result.strike)
        assertEquals(0, result.ball)
    }

    @Test
    @DisplayName("BallCount(3) : all balls")
    fun `test partial matches - all balls`() {
        val answer = listOf(1, 2, 3)
        val inputNumbers = listOf(2, 3, 1)
        val result: BallCount = baseBall.returnBallCount(answer, inputNumbers)

        assertEquals(0, result.strike)
        assertEquals(3, result.ball)
    }

    @Test
    @DisplayName("BallCount(4) : some balls")
    fun `test partial matches - some balls`() {
        val answer = listOf(1, 2, 3)
        val inputNumbers = listOf(6, 8, 1)
        val result: BallCount = baseBall.returnBallCount(answer, inputNumbers)

        assertEquals(0, result.strike)
        assertEquals(1, result.ball)
    }

    @Test
    @DisplayName("BallCount(5) : strikes and balls")
    fun `test mixed strikes and balls`() {
        val answer = listOf(1, 2, 3)
        val inputNumbers = listOf(1, 3, 5)
        val result: BallCount = baseBall.returnBallCount(answer, inputNumbers)

        assertEquals(1, result.strike)
        assertEquals(1, result.ball)
    }

    @Test
    fun `test no matches`() {
        val answer = listOf(1, 2, 3)
        val inputNumbers = listOf(4, 5, 6)
        val result = baseBall.returnBallCount(answer, inputNumbers)
        assertEquals(0, result.strike)
        assertEquals(0, result.ball)
    }
}
