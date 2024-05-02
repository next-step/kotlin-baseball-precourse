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
    @DisplayName("Valid Input Case")
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
    @DisplayName("Duplicate Digits Case")
    fun `parse should return null for input with duplicate digits`() {
        // Given
        val inputString = "112"

        // When
        val result = baseBall.parse(inputString)

        // Then
        assertNull(result)
    }

    @Test
    @DisplayName("Non-digit Characters Case")
    fun `parse should return null for input with non-digit characters`() {
        // Given
        val inputString = "1a3"

        // When
        val result = baseBall.parse(inputString)

        // Then
        assertNull(result)
    }

    @Test
    @DisplayName("Incorrect Length Case")
    fun `parse should return null for input with incorrect length`() {
        // Given
        val inputString = "1234" // More than COUNT_OF_NUMBERS

        // When
        val result = baseBall.parse(inputString)

        // Then
        assertNull(result)
    }

    @Test
    @DisplayName("Invalid Numbers Case")
    fun `parse should return null for input with invalid numbers`() {
        // Given
        val inputString = "089" // Contains 0, which is invalid

        // When
        val result = baseBall.parse(inputString)

        // Then
        assertNull(result)
    }
}
