import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import java.io.ByteArrayInputStream
import java.io.InputStream

class BaseballGameTest {
    //컴퓨터(상대방)가 1에서 9까지 서로 다른 임의의 수 3개 선택
    @Test
    fun `setComputer should return an array of size 3 containing numbers between 1 and 9`() {
        val game = BaseballGame()
        val computerGuess = game.setComputer()

        assertEquals(3, computerGuess.size)
        assertTrue(computerGuess.all { it in 1..9 })

        val uniqueNumbers = computerGuess.toSet()
        assertEquals(3, uniqueNumbers.size)
    }

    //게임 플레이어가 1에서 9까지 숫자를 3개 입력
    @Test
    fun `getPlayerInput should return valid input as IntArray`() {
        val game = BaseballGame()

        val input = "789"
        val inputStream: InputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(inputStream)

        //플레이어의 입력을 intArray 형으로 올바르게 저장하는지 여부 확인
        val result = game.getPlayerInput()
        assertArrayEquals(intArrayOf(7, 8, 9), result)
    }

    //같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱이란 힌트를 게임 플레이어에게 제공
    @Test
    fun `compareAnswerGuess should return the correct result`() {
        val game = BaseballGame()
        val answer = intArrayOf(1, 2, 3)

        // 3 strikes
        var result = game.compareAnswerGuess(answer, intArrayOf(1, 2, 3))
        assertEquals("3 strikes", result)

        // 1 strike, 2 balls
        result = game.compareAnswerGuess(answer, intArrayOf(1, 5, 2))
        assertEquals("1 strike, 1 ball", result)

        // 1 strike
        result = game.compareAnswerGuess(answer, intArrayOf(1, 8, 4))
        assertEquals("1 strike", result)

        // 2 balls
        result = game.compareAnswerGuess(answer, intArrayOf(2, 9, 1))
        assertEquals("2 ball", result)

        // nothing
        result = game.compareAnswerGuess(answer, intArrayOf(4, 5, 6))
        assertEquals("nothing", result)
    }


    //3개의 숫자를 맞히면 게임 종료
    @Test
    fun `printResult should return false for 3 strikes`() {
        val game = BaseballGame()

        val result = game.printResult("3 strikes")
        assertFalse(result)
    }
    //3개의 숫자를 맞히지 못한 경우, 계속 게임 진행
    @Test
    fun `printResult should return true for other results`() {
        val game = BaseballGame()

        val result1 = game.printResult("2 ball")
        val result2 = game.printResult("1 strike, 1 ball")

        assertTrue(result1)
        assertTrue(result2)
    }

    //게임 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있도록 기능 구현
    @Test
    fun `confirmGameExit should return true for input 1`() {

        val game = BaseballGame()
        val input = "1"
        val inputStream: InputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(inputStream)

        val result = game.confirmGameExit()

        if (!result) throw AssertionError("Expected true but got false")
    }

    @Test
    fun `confirmGameExit should return false for input 2`() {

        val game = BaseballGame()
        val input = "2"
        val inputStream: InputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(inputStream)

        val result = game.confirmGameExit()

        if (result) throw AssertionError("Expected false but got true")
    }

    @Test
    fun `confirmGameExit should retry for invalid input`() {

        val game = BaseballGame()
        val input = "invalid\n1"
        val inputStream: InputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(inputStream)

        val result = game.confirmGameExit()

        if (!result) throw AssertionError("Expected true but got false")
    }

}