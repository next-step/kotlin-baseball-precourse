import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.Assertions.*

class GameTest {
    @Test
    @DisplayName("generate number size test")
    fun generateNumberSizeTest() {
        val baseBallGame = Game()
        assertEquals(baseBallGame.threeNumber.size, 3)
    }

    @Test
    @DisplayName("input number size test")
    fun inputExceptionTest1() {
        val baseBallGame = Game()
        val assertion = assertThrows<IllegalArgumentException> {
            baseBallGame.inputNumber("1")
        }
        assertEquals("3개의 숫자를 입력해야 합니다.", assertion.message)
    }

    @Test
    @DisplayName("input number accuracy test")
    fun inputExceptionTest2() {
        val baseBallGame = Game()
        val assertion = assertThrows<IllegalArgumentException> {
            baseBallGame.inputNumber("12#")
        }
        assertEquals("1부터 9까지의 숫자만 입력해야 합니다.", assertion.message)
    }

    @Test
    @DisplayName("input number duplicate test")
    fun inputExceptionTest3() {
        val baseBallGame = Game()
        val assertion = assertThrows<IllegalArgumentException> {
            baseBallGame.inputNumber("122")
        }
        assertEquals("중복된 숫자를 입력했습니다.", assertion.message)
    }

    @Test
    @DisplayName("number hint test")
    fun numberHintTest() {
        val baseBallGame = Game()
        assertEquals(baseBallGame.printHint(3, 0), "3스트라이크")
        assertEquals(baseBallGame.printHint(2, 1), "1볼 2스트라이크")
        assertEquals(baseBallGame.printHint(0, 2), "2볼")
        assertEquals(baseBallGame.printHint(0, 0), "낫싱")
    }
}