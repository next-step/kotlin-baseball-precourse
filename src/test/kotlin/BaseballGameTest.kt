import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class BaseballGameTest {
    @Test
    @DisplayName("입력이 정상적으로 처리되는지 확인")
    fun testUserInput() {
        val game = BaseballGame()
        val result = game.checkInput("123", game.targetNumbers)
        assertEquals("낫싱", result)
    }

    @Test
    @DisplayName("입력이 잘못된 경우 IllegalArgumentException 발생")
    fun testInvalidInput() {
        val game = BaseballGame()
        val exception = assertThrows(IllegalArgumentException::class.java) {
            game.checkInput("abc", game.targetNumbers)
        }
        assertEquals("Invalid input", exception.message)
    }

    @Test
    @DisplayName("게임이 정상적으로 종료되는지 확인")
    fun testGameEnd() {
        val game = BaseballGame()
        val result = game.checkInput(game.targetNumbers.joinToString(separator = ""), game.targetNumbers)
        assertEquals("3스트라이크", result)
    }
}