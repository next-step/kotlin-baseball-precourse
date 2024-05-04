package baseball.guessing

import role.Computer
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import utils.PlayerConsole
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

internal class BaseballHintTest {

    private lateinit var outputStreamCaptor: ByteArrayOutputStream

    @BeforeEach
    fun setUp() {
        this.outputStreamCaptor = ByteArrayOutputStream()
    }

    @DisplayName("3스트라이크")
    @Test
    fun case_3Strike() {// 3개가 다 맞는 경우
        System.setIn(ByteArrayInputStream("123".toByteArray()))
        System.setOut(PrintStream(outputStreamCaptor))

        val computer = Computer(listOf(1, 2, 3))
        val player = PlayerConsole.enterAnswer()

        val numGuess: Guess = numGuess(computer, player)
        numGuess.print()

        val output = outputStreamCaptor.toString()
        assertThat(output).contains("3스트라이크")
    }

    @DisplayName("2볼 1스트라이크")
    @Test
    fun case_2Ball1Strike() {
        System.setIn(ByteArrayInputStream("123".toByteArray()))
        System.setOut(PrintStream(outputStreamCaptor))

        val computer = Computer(listOf(1, 3, 2))
        val player = PlayerConsole.enterAnswer()

        val numGuess: Guess = numGuess(computer, player)
        numGuess.print()

        val output = outputStreamCaptor.toString()
        assertThat(output).contains("2볼 1스트라이크")
    }

    @DisplayName("1볼 1스트라이크")
    @Test
    fun case_1Ball11Strike() {
        System.setIn(ByteArrayInputStream("246".toByteArray()))
        System.setOut(PrintStream(outputStreamCaptor))

        val computer = Computer(listOf(2, 6, 8))
        val player = PlayerConsole.enterAnswer()

        val numGuess: Guess = numGuess(computer, player)
        numGuess.print()

        val output = outputStreamCaptor.toString()
        assertThat(output).contains("1볼 1스트라이크")
    }

    @DisplayName("1스트라이크")
    @Test
    fun case_1Strike() {
        System.setIn(ByteArrayInputStream("145".toByteArray()))
        System.setOut(PrintStream(outputStreamCaptor))

        val computer = Computer(listOf(1, 3, 2))
        val player = PlayerConsole.enterAnswer()

        val numGuess: Guess = numGuess(computer, player)
        numGuess.print()

        val output = outputStreamCaptor.toString()
        assertThat(output).contains("1스트라이크")
    }

    @DisplayName("1볼")
    @Test
    fun case_1ball() {
        System.setIn(ByteArrayInputStream("981".toByteArray()))
        System.setOut(PrintStream(outputStreamCaptor))

        val computer = Computer(listOf(1, 3, 2))
        val player = PlayerConsole.enterAnswer()

        val numGuess: Guess = numGuess(computer, player)
        numGuess.print()

        val output = outputStreamCaptor.toString()
        assertThat(output).contains("1볼")
    }

    @DisplayName("2볼")
    @Test
    fun case_2Ball() {
        System.setIn(ByteArrayInputStream("923".toByteArray()))
        System.setOut(PrintStream(outputStreamCaptor))

        val computer = Computer(listOf(1, 3, 2))
        val player = PlayerConsole.enterAnswer()

        val numGuess: Guess = numGuess(computer, player)
        numGuess.print()

        val output = outputStreamCaptor.toString()
        assertThat(output).contains("2볼")
    }

    @DisplayName("3볼")
    @Test
    fun case_3Ball() {
        System.setIn(ByteArrayInputStream("246".toByteArray()))
        System.setOut(PrintStream(outputStreamCaptor))

        val computer = Computer(listOf(6, 2, 4))
        val player = PlayerConsole.enterAnswer()

        val numGuess: Guess = numGuess(computer, player)
        numGuess.print()

        val output = outputStreamCaptor.toString()
        assertThat(output).contains("3볼")
    }

}