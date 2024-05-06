import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.AfterEach
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class GameTest {
    private lateinit var game: Game
    private val standardOut = System.out
    private val outputStreamCaptor = ByteArrayOutputStream()

    @BeforeEach
    fun setUp() {
        game = Game()
        System.setOut(PrintStream(outputStreamCaptor))
    }

    @AfterEach
    fun resetTestEnv() {
        System.setOut(standardOut)
    }

    @Test
    fun randomNumber() {
        val numbers = game.randomNumber()
        assertThat(numbers).hasSize(3)
        assertThat(numbers.toSet().size).isEqualTo(3)
        assertThat(numbers.all { it in 1..9 }).isTrue()
    }

    @Test
    fun playerInputException() {
        val invalidInputs = listOf("", "000", "abc", "112", "1234", "901")
        invalidInputs.forEach { input ->
            System.setIn(ByteArrayInputStream(input.toByteArray()))
            assertThatThrownBy { game.playerInput() }
                .isInstanceOf(IllegalArgumentException::class.java)
        }
    }

    @Test
    fun playerInputCorrect() {
        val validInput = "123"
        System.setIn(ByteArrayInputStream(validInput.toByteArray()))
        assertThat(game.playerInput()).containsExactly(1, 2, 3)
    }

    @Test
    fun numberCompare() {
        game.computerNumber = listOf(1, 2, 3)
        assertThat(game.numberCompare(listOf(1, 2, 3))).isEqualTo(Pair(3, 0))
        assertThat(game.numberCompare(listOf(1, 3, 2))).isEqualTo(Pair(1, 2))
        assertThat(game.numberCompare(listOf(4, 5, 6))).isEqualTo(Pair(0, 0))
    }

    @Test
    fun printResult() {
        game.printResult(3, 0)
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("3스트라이크")

        outputStreamCaptor.reset()
        game.printResult(1, 2)
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("2볼 1스트라이크")

        outputStreamCaptor.reset()
        game.printResult(0, 3)
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("3볼")

        outputStreamCaptor.reset()
        game.printResult(0, 0)
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("낫싱")
    }

    @Test
    fun gameRestart() {
        game.computerNumber = listOf(1, 2, 3)
        System.setIn(ByteArrayInputStream("123\n2\n".toByteArray()))
        game.playGame()
        game.gameRestart()
        assertThat(outputStreamCaptor.toString()).contains("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        assertThat(outputStreamCaptor.toString()).contains("3개의 숫자를 모두 맞히셨습니다! 게임 종료")

        outputStreamCaptor.reset()

        System.setIn(ByteArrayInputStream("123\n1\n".toByteArray()))
        game.playGame()
        game.gameRestart()
        assertThat(outputStreamCaptor.toString()).contains("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    }
}