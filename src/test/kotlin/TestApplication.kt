import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class BaseballGameTest {

    // generateSecretNumber 함수가 중복 없는 3개의 숫자를 정확히 생성하는지 테스트
    @Test
    fun testGenerateSecretNumber() {
        val secretNumber = generateSecretNumber()
        assertThat(secretNumber.size).isEqualTo(3)
        assertThat(secretNumber.distinct().size).isEqualTo(3) // 중복된 숫자가 없어야 함
        assertThat(secretNumber).allMatch { it in 1..9 } // 숫자는 1부터 9 사이여야 함
    }

    // checkGuess 함수가 정상적으로 스트라이크와 볼을 계산하는지 테스트
    @Test
    fun testCheckGuess() {
        val secretNumber = listOf(1, 2, 3)

        // 모든 숫자와 위치가 맞는 경우 (3 스트라이크)
        var guess = "123"
        var result = checkGuess(guess, secretNumber)
        assertThat(result.first).isEqualTo(3)
        assertThat(result.second).isEqualTo(0)

        // 숫자는 모두 맞지만 위치가 다른 경우 (3 볼)
        guess = "312"
        result = checkGuess(guess, secretNumber)
        assertThat(result.first).isEqualTo(0)
        assertThat(result.second).isEqualTo(3)

        // 일부 숫자만 맞고 위치도 일치하는 경우 (1 스트라이크, 2 볼)
        guess = "132"
        result = checkGuess(guess, secretNumber)
        assertThat(result.first).isEqualTo(1)
        assertThat(result.second).isEqualTo(2)

        // 모든 숫자가 틀린 경우 (낫싱)
        guess = "456"
        result = checkGuess(guess, secretNumber)
        assertThat(result.first).isEqualTo(0)
        assertThat(result.second).isEqualTo(0)
    }
}
