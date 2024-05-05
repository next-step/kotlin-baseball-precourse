import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test


class NumberGameTest {

    @Test
    fun `generateComputerNumber should return 3-digit number without duplicate digits`() {
        val computerNumber = generateComputerNumber()
        assertEquals(3, computerNumber.length)
        assertTrue { computerNumber.toCharArray().distinct().size == 3 }
    }

    @Test
    fun `isValidInput should throw IllegalArgumentException for invalid input`() {
        assertThrows(IllegalArgumentException::class.java) {
            isValidInput("1234") // Input more than 3 digits
        }

        assertThrows(IllegalArgumentException::class.java) {
            isValidInput("12a") // Input non-digit character
        }

        assertThrows(IllegalArgumentException::class.java) {
            isValidInput("112") // Input duplicate digits
        }
    }

    @Test
    fun `calculateResult should return correct strikes and balls`() {
        val computerNumber = "123"
        assertEquals(Pair(0, 0), calculateResult(computerNumber, "456")) // 낫싱
        assertEquals(Pair(0, 1), calculateResult(computerNumber, "834")) // 1볼
        assertEquals(Pair(0, 2), calculateResult(computerNumber, "235")) // 2볼
        assertEquals(Pair(0, 3), calculateResult(computerNumber, "312")) // 3볼
        assertEquals(Pair(1, 0), calculateResult(computerNumber, "154")) // 1스트라이크
        assertEquals(Pair(2, 0), calculateResult(computerNumber, "124")) // 2스트라이크
        assertEquals(Pair(3, 0), calculateResult(computerNumber, "123")) // 3스트라이크
        assertEquals(Pair(1, 1), calculateResult(computerNumber, "134")) // 1스트라이크 1볼
    }

    @Test
    fun `checkResult should return false when strikes equal to 3`() {
        assertEquals(false, checkResult(3))
    }

    @Test
    fun `checkResult should return true when strikes less than 3`() {
        assertEquals(true, checkResult(2))
        assertEquals(true, checkResult(1))
        assertEquals(true, checkResult(0))
    }

    @Test
    fun `selectReplay should return true when input is 1`() {
        System.setIn("1\n".byteInputStream())
        assertEquals(true, selectReplay())
    }

    @Test
    fun `selectReplay should return false when input is not 1`() {
        System.setIn("2\n".byteInputStream())
        assertEquals(false, selectReplay())
    }
}