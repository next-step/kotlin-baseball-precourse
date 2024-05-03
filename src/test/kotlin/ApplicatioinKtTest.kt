import engine.BallCount
import engine.BaseBall
import engine.io.Input
import engine.io.NumberGenerator
import engine.io.Output
import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ApplicatioinKtTest {
    private lateinit var generator: RandomNumberGenerator
    private lateinit var console: Console
    private lateinit var baseBall: BaseBall

    @BeforeEach
    fun setUp() {
        generator = RandomNumberGenerator()
        console = Console()
        baseBall = BaseBall(generator, console, console)
    }

    @Test
    fun testGameSimpleFlow() {
        val generator = StaticNumberGenerator(listOf(1, 2, 3))
        val inputs = listOf("123", "2").iterator()
        val input = TestInput(inputs)
        val output = TestOutput()

        val game = BaseBall(generator, input, output)
        game.run()

        // output.messages.forEach { message -> println(message) }
        assertEquals("3스트라이크", output.messages[0])
        assertEquals("3개의 숫자를 모두 맞히셨습니다! 게임 종료", output.messages[3],)
    }

    @Test
    fun testGameExampleFlow() {
        val generator = StaticNumberGenerator(listOf(7, 1, 3))
        val inputs = listOf("123", "145", "671", "216", "713", "2").iterator()
        val input = TestInput(inputs)
        val output = TestOutput()

        val game = BaseBall(generator, input, output)
        game.run()

        // output.messages.forEach { message -> println(message) }
        assertEquals("1볼 1스트라이크", output.messages[0])
        assertEquals("1볼", output.messages[1])
        assertEquals("2볼", output.messages[2])
        assertEquals("1스트라이크", output.messages[3])
        assertEquals("3스트라이크", output.messages[4])
        assertEquals("3개의 숫자를 모두 맞히셨습니다! 게임 종료", output.messages[5])
    }
}

class StaticNumberGenerator(private val numbers: List<Int>) : NumberGenerator {
    override fun generate(count: Int): List<Int> = numbers.take(count)
}

class TestInput(private val responses: Iterator<String>) : Input {
    override fun input(message: String): String {
        println(message)
        return if (responses.hasNext()) responses.next() else ""
    }
}

class TestOutput : Output {
    val messages = mutableListOf<String>()

    override fun displayBallCount(ballCount: BallCount) {
        var message = ""
        with(ballCount) {
            when {
                strike > 0 && ball > 0 -> message = "${ball}볼 ${strike}스트라이크"
                strike > 0 -> message = "${strike}스트라이크"
                ball > 0 -> message = "${ball}볼"
                else -> message = "낫싱"
            }
        }
        messages.add(message)
    }

    override fun displayInputError(errorMessage: String?) {
        messages.add("입력이 잘못되었습니다.")
    }

    override fun displayCorrectMessage() {
        messages.add("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    }
}
