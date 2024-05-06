import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class GameManagerTest {

    private lateinit var gameManager: GameManager

    @BeforeEach
    fun setUp() {
        gameManager = GameManager()
        gameManager.computerNumber = "123"
    }

    @Test
    fun `컴퓨터 숫자가 123일 때, 사용자가 123을 입력하면, 3스트라이크 0볼을 반환해야 한다`() {
        // 실행
        val (strikes, balls) = gameManager.markNumber("123")

        // 검증
        assertThat(strikes).isEqualTo(3)
        assertThat(balls).isEqualTo(0)
    }

    @Test
    fun `컴퓨터 숫자가 123일 때, 사용자가 456을 입력하면, 0스트라이크 0볼을 반환해야 한다`() {
        // 실행
        val (strikes, balls) = gameManager.markNumber("456")

        // 검증
        assertThat(strikes).isEqualTo(0)
        assertThat(balls).isEqualTo(0)
    }

    @Test
    fun `컴퓨터 숫자가 123일 때, 사용자가 312을 입력하면, 0스크라이트 3볼을 반환해야 한다`() {
        // 실행
        val (strikes, balls) = gameManager.markNumber("312")

        // 검증
        assertThat(strikes).isEqualTo(0)
        assertThat(balls).isEqualTo(3)
    }

    @Test
    fun `checkNumber는 잘못된 입력이 들어오면 IllegalArgumentException를 발생시켜야 한다`() {
        // 길이가 3이 아닌 입력에 대한 테스트
        val invalidInputLength = "12"
        assertThatThrownBy { gameManager.checkNumber(invalidInputLength) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("잘못된 입력입니다.")

        // 중복된 숫자를 포함하는 입력에 대한 테스트
        val invalidInputDuplicate = "122"
        assertThatThrownBy { gameManager.checkNumber(invalidInputDuplicate) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining("잘못된 입력입니다.")
    }
}