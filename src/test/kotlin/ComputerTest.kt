import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ComputerTest() {

    @Test
    @DisplayName("3개의 수가 잘 생성됬는지 확인")
    fun generateRandomNumberTest() {
        val computer: Computer = Computer()
        assertThat(computer.correctNumberList.size).isEqualTo(3)
    }

    @Test
    @DisplayName("스트라이크를 잘 판단하는 지 확인")
    fun checkStrikesTest() {
        val computer: Computer = Computer()
        assertThat(computer.checkStrikes(0, 1, listOf(1, 2, 3))).isEqualTo(1)
    }

    @Test
    @DisplayName("볼을 잘 판단하는지 확인")
    fun checkBallsTest() {
        val computer: Computer = Computer()
        assertThat(computer.checkBalls(2, 1, listOf(1, 2, 3))).isEqualTo(1)
    }
}