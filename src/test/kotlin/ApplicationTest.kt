import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
class ApplicationTest {

    lateinit var gameInfo: GameInfo
    @BeforeEach
    fun setUp() {
        gameInfo = GameInfo(createAnswer())

    }

    @Test
    fun `정답은 1에서 9사이의 서로다른 3자리 숫자로 구성되어야 함`() {
        val answer: List<Int> = gameInfo.answer
        assertThat(answer[0]).isIn(1..9)
        assertThat(answer[1]).isIn(1..9)
        assertThat(answer[2]).isIn(1..9)
        assertThat(answer.toSet().size).isEqualTo(3)
    }
    @Test
    fun `유효한 예측은 각 자릿수가 1에서 9사이의 값을 가지는 3자리 수`() {
    }
    @Test
    fun `자릿수가 같으면 스트라이크, 다르면 볼, 아예 포함하고 있지않으면 아무것도 하지않음`() {

    }
    @Test
    fun `3스트라이크이면 게임을 종료함`() {
        gameInfo.clearScore()
        gameInfo.strike = 3
        assertThat(checkEnd(gameInfo)).isTrue()
    }
    @Test
    fun `0볼 0스트라이크 인 경우 낫싱 출력, 이외의 경우 0이 아닌 스트라이크와 볼의 개수 출력`() {
    }
    @Test
    fun `게임이 끝났을 때 1을 입력하면 새로 시작, 2를 입력하면 종료`() {

    }
}