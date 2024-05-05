package baseball

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
class BaseballTest {

    @Test
    fun `generateAnswer returns a string of 3 unique digits`() {
        val answer = generateAnswer()
        assertThat(answer.length).isEqualTo(3)
        assertThat(answer.toSet().size).isEqualTo(3)
        assertThat(answer.all { it.isDigit() && it != '0' }).isTrue()
    }

    @Test
    fun `checkInputIfValid returns true for valid input`() {
        // 예외처리가 valid input에 대해 정상 작동하는 지 확인
    }

    @Test
    fun `checkInputIfValid returns false for invalid input`() {
        // 예외처리가 invalid input에 대해 정상 작동하는 지 확인
    }

    @Test
    fun `evaluate returns true only when there are 3 strikes`() {
        // evaluate가 3스트라이크 시에만 true를 리턴하는 지 확인
    }

    @Test
    fun `evaluate correctly identifies number of strikes and balls`() {
        // evaluate 함수가 스트라이크, 볼의 수를 잘 카운트하는 지 확인
    }
}
