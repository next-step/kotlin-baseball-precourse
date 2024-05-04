package baseball.game

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import utils.Constraints
import utils.Constraints.LENGTH_MISMATCH_EXCEPTION
import utils.Constraints.WRONG_FORMAT_EXCEPTION
import utils.PlayerConsole
import java.io.ByteArrayInputStream

internal class BaseballGameTest {

    @DisplayName("재시작 입력값 : 1")
    @Test
    fun case_restart1() {
        System.setIn(ByteArrayInputStream("1".toByteArray()))

        assertDoesNotThrow {
            val restart = PlayerConsole.enterRestart()
            assertEquals(restart, Constraints.YES_RESTART)
        }
    }

    @DisplayName("재시작 입력값 : 2")
    @Test
    fun case_restart2() {
        System.setIn(ByteArrayInputStream("2".toByteArray()))

        assertDoesNotThrow {
            val restart = PlayerConsole.enterRestart()
            assertEquals(restart, Constraints.NO_RESTART)
        }
    }

    @DisplayName("재시작 입력값 : 3")
    @Test
    fun case_restart3_error() {
        assertThrows<IllegalArgumentException>(WRONG_FORMAT_EXCEPTION) {
            System.setIn(ByteArrayInputStream("3".toByteArray()))
            PlayerConsole.enterRestart()
        }
    }

    @DisplayName("재시작 입력값 : 12")
    @Test
    fun case_restart_lengthError() {
        assertThrows<IllegalArgumentException>(LENGTH_MISMATCH_EXCEPTION) {
            System.setIn(ByteArrayInputStream("12".toByteArray()))
            PlayerConsole.enterRestart()
        }
    }
}