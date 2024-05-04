import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream

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
    fun `유효하지 않은 입력(정수형이 아닌 입력)은 IllegalArgumentException를 발생시킴`() {
        var inputStream = ByteArrayInputStream("a".toByteArray())
        System.setIn(inputStream)
        assertThatThrownBy { getInput() }.isInstanceOf(IllegalArgumentException::class.java)

        inputStream = ByteArrayInputStream("1.2".toByteArray())
        System.setIn(inputStream)
        assertThatThrownBy { getInput() }.isInstanceOf(IllegalArgumentException::class.java)

        inputStream = ByteArrayInputStream("일".toByteArray())
        System.setIn(inputStream)
        assertThatThrownBy { getInput() }.isInstanceOf(IllegalArgumentException::class.java)

        inputStream = ByteArrayInputStream("1".toByteArray())
        System.setIn(inputStream)
        assertThat(getInput()).isEqualTo(1)
    }
    @Test
    fun `자릿수가 같으면 스트라이크, 다르면 볼, 아예 포함하고 있지않으면 아무것도 하지않음`() {
        setTestAnswer(1,2,3)
        var predict = listOf(1,4,5)
        compareNumber(predict, gameInfo)
        assertThat(gameInfo.ball).isEqualTo(0)
        assertThat(gameInfo.strike).isEqualTo(1)

        predict = listOf(4,3,2)
        compareNumber(predict, gameInfo)
        assertThat(gameInfo.ball).isEqualTo(2)
        assertThat(gameInfo.strike).isEqualTo(0)

        predict = listOf(1,3,2)
        compareNumber(predict, gameInfo)
        assertThat(gameInfo.ball).isEqualTo(2)
        assertThat(gameInfo.strike).isEqualTo(1)

        predict = listOf(7,8,9)
        compareNumber(predict, gameInfo)
        assertThat(gameInfo.ball).isEqualTo(0)
        assertThat(gameInfo.strike).isEqualTo(0)

        predict = listOf(1,2,3)
        compareNumber(predict, gameInfo)
        assertThat(gameInfo.ball).isEqualTo(0)
        assertThat(gameInfo.strike).isEqualTo(3)
    }
    @Test
    fun `0볼 0스트라이크 인 경우 낫싱 출력, 이외의 경우 0이 아닌 스트라이크와 볼의 개수 출력`() {
        setTestScore(0,0)
        assertThat(printScore(gameInfo)).isEqualTo("낫싱")
        setTestScore(2,0)
        assertThat(printScore(gameInfo)).isEqualTo("2볼 ")
        setTestScore(0,2)
        assertThat(printScore(gameInfo)).isEqualTo("2스트라이크")
        setTestScore(1,2)
        assertThat(printScore(gameInfo)).isEqualTo("1볼 2스트라이크")
    }
    @Test
    fun `3스트라이크이면 게임을 종료함`() {
        setTestScore(0,3)
        assertThat(checkEnd(gameInfo)).isTrue()
    }
    @Test
    fun `게임이 끝났을 때 1을 입력하면 새로 시작, 2를 입력하면 종료`() {
        var inputStream = ByteArrayInputStream("1".toByteArray())
        System.setIn(inputStream)
        assertThat(restartGame()).isEqualTo(true)

        inputStream = ByteArrayInputStream("2".toByteArray())
        System.setIn(inputStream)
        assertThat(restartGame()).isEqualTo(false)
    }
    fun setTestScore(ball:Int, strike: Int) {
        gameInfo.ball = ball
        gameInfo.strike = strike
    }

    fun setTestAnswer(num1: Int, num2: Int, num3: Int) {
        gameInfo.answer = listOf(num1, num2, num3)
    }
}