import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class BaseBallTest {

    @DisplayName("1에서 9까지 서로 다른 수로 이루어진 세 자리 수 생성")
    @Test
    fun randomNumberValidateAssertion() {
        // given
        val randomNumberGenerator = RandomNumberGenerator()

        // when
        val randomNumber = randomNumberGenerator.setNumber()

        // then
        assert(randomNumber.toSet().size == 3) { "생성된 수는 서로 다른 숫자여야 합니다." }
        assertFalse(randomNumber.contains(0)) { "생성된 수에 0을 포함할 수 없습니다." }
    }
}