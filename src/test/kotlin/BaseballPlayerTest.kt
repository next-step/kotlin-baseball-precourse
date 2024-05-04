import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class BaseballPlayerTest {
    val player = BaseballPlayer()

    @ParameterizedTest
    @ValueSource(strings = ["123", "111", "875", "999", "147", "456", "815", "321", "654", "987"])
    @DisplayName("유효한 입력에 대해서, 그를 잘 판단하는지 확인")
    fun testValidInputChecker(input: String) {
        assertThat(player.checkValidation(input)).isEqualTo(input)
    }

    @ParameterizedTest
    @ValueSource(strings = ["1234", "012", "890", "abc", "일이삼", "1", "12", "12345", "123456", "1234567"])
    @DisplayName("유효하지 않은 입력에 대해서, 그를 잘 판단하여 Exception을 일으키는지 확인")
    fun testInvalidInputChecker(input: String) {
        assertThrows(IllegalArgumentException::class.java) {
            player.checkValidation(input)
        }
    }
}