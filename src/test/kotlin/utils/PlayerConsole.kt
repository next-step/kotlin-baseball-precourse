package utils

import org.junit.jupiter.api.*
import utils.Constraints.DUPLICATED_DIGIT_EXCEPTION
import utils.Constraints.LENGTH_MISMATCH_EXCEPTION
import utils.Constraints.NON_DIGIT_EXCEPTION
import utils.Constraints.OUT_OF_RANGE_EXCEPTION

import utils.PlayerConsole.enterAnswer
import java.io.ByteArrayInputStream

internal class PlayerConsoleTest {
    @Nested
    inner class InputLengthTest {
        @DisplayName("입력값 길이 3 미만")
        @Test
        fun case_inputLength1() {
            assertThrows<IllegalArgumentException>(LENGTH_MISMATCH_EXCEPTION) {
                System.setIn(ByteArrayInputStream("56".toByteArray()))
                enterAnswer()
            }
        }

        @DisplayName("입력값 길이 3")
        @Test
        fun case_inputLength3() {
            assertDoesNotThrow {
                System.setIn(ByteArrayInputStream("123".toByteArray()))
                enterAnswer()
            }
        }

        @DisplayName("입력값 길이 4 이상")
        @Test
        fun case_inputLength4() {
            assertThrows<IllegalArgumentException>(LENGTH_MISMATCH_EXCEPTION) {
                System.setIn(ByteArrayInputStream("1999".toByteArray()))
                enterAnswer()
            }
        }
    }

    @Nested
    inner class DuplicatedTest {
        @DisplayName("입력값 중복 없음")
        @Test
        fun case_noSameNum() {
            assertDoesNotThrow {
                System.setIn(ByteArrayInputStream("123".toByteArray()))
                enterAnswer()
            }
        }

        @DisplayName("입력값 2개 중복")
        @Test
        fun case_2sameNum() {
            assertThrows<IllegalArgumentException>(DUPLICATED_DIGIT_EXCEPTION) {
                System.setIn(ByteArrayInputStream("177".toByteArray()))
                enterAnswer()
            }
        }

        @DisplayName("입력값 3개 중복")
        @Test
        fun case_3sameNum() {
            assertThrows<IllegalArgumentException>(DUPLICATED_DIGIT_EXCEPTION) {
                System.setIn(ByteArrayInputStream("777".toByteArray()))
                enterAnswer()
            }
        }
    }

    @Nested
    inner class DigitCheckTest {
        @DisplayName("입력값에 숫자만 포함")
        @Test
        fun case_onlyNumInput() {
            assertDoesNotThrow {
                System.setIn(ByteArrayInputStream("123".toByteArray()))
                enterAnswer()
            }
        }

        @DisplayName("입력값에 특수문자 또는 문자가 포함")
        @Test
        fun case_inputError() {
            assertThrows<IllegalArgumentException>(NON_DIGIT_EXCEPTION) {
                System.setIn(ByteArrayInputStream("!12".toByteArray()))
                enterAnswer()
            }
        }
    }

    @Nested
    inner class RangeTest {
        @DisplayName("범위가 1 to 9")
        @Test
        fun case_withinRangeInput() {
            assertDoesNotThrow {
                System.setIn(ByteArrayInputStream("123".toByteArray()))
                enterAnswer()
            }
        }

        @DisplayName("범위가 1보다 작은 경우")
        @Test
        fun case_smallInput() {
            assertThrows<IllegalArgumentException>(OUT_OF_RANGE_EXCEPTION) {
                System.setIn(ByteArrayInputStream("102".toByteArray()))
                enterAnswer()
            }
        }
    }
}