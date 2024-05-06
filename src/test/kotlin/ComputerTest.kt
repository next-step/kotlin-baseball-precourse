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
}