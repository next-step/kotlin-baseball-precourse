import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import kotlin.IllegalArgumentException

class UserInterfaceTest() {
    @Test
    @DisplayName("출력이 잘 되는지 테스트")
    fun replaceCountListWithStringTest() {
        val userInterface: UserInterface = UserInterface()
        assertThat(userInterface.replaceCountListWithString(listOf(1, 1))).isEqualTo("1스트라이크 1볼")
        assertThat(userInterface.replaceCountListWithString(listOf(0, 0))).isEqualTo("낫싱")
        assertThat(userInterface.replaceCountListWithString(listOf(1, 0))).isEqualTo("1스트라이크")
        assertThat(userInterface.replaceCountListWithString(listOf(0, 1))).isEqualTo("1볼")
    }

    @ParameterizedTest
    @ValueSource(strings = ["1234", "402", "133", "12", "cake"])
    @DisplayName("잘못된 3자리 입력값을 받았을 때 IllegalArgumentException을 발생시키는지 테스트")
    fun changeNumberTest(string: String) {
        val userInterface: UserInterface = UserInterface()
        assertThrows<IllegalArgumentException> { userInterface.changeNumber(string) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["3", "cake", "-1"])
    @DisplayName("잘못된 게임 재시작 여부 입력값을 받았을 때 IllegalArgumentException을 발생시키는지 테스트")
    fun checkGameRestartExceptionTest(string: String) {
        val userInterface: UserInterface = UserInterface()
        assertThrows<IllegalArgumentException> { userInterface.checkGameRestartException(string) }
    }
}
