import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.io.ByteArrayInputStream

class ApplicationTest {
    @Test
    fun testPlayAgainInput() {
        val testInput = ByteArrayInputStream("1\n".toByteArray())
        System.setIn(testInput)

        val app = Application()
        val result = app.playAgain()

        assertTrue(result)
    }
}

class InputTest {
    @Test
    fun testValidInput() {

        val userInput = "123"

        val inputList = userInput.map { it.toString().toInt() }

        assertEquals(listOf(1, 2, 3), inputList)
    }

    @Test
    fun testInvalidInput() {

        val userInput = "abc"

        assertThrows<IllegalArgumentException> {
            userInput.map { it.toString().toInt() }
        }
    }
}

class ComputerNumberGeneratorTest {
    @Test
    fun testNumberGeneration() {

        val numbers = ComputerNumberGenerator.generate()

        assertEquals(3, numbers.size)
        assertTrue(numbers.all { it in 1..9 })
    }
}

class CheckTest {
    @Test
    fun testCheckFunction() {

        val userInput = listOf(1, 2, 3)
        val computerNumbers = listOf(1, 4, 5)

        val result = check(userInput, computerNumbers)

        assertEquals(1, result.strikes)
        assertEquals(0, result.balls)
    }
}

class ResultTest {
    @Test
    fun testResultIsCorrect() {

        val result1 = Result(3, 0)
        val result2 = Result(2, 1)

        assertTrue(result1.isCorrect())
        assertTrue(!result2.isCorrect())
    }

    @Test
    fun testResultToString() {

        val result1 = Result(0, 0)
        val result2 = Result(2, 1)

        assertEquals("낫싱", result1.toString())
        assertEquals("2스트라이크 1볼", result2.toString())
    }
}
