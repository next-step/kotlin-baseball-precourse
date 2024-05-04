import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class BaseballGameTest {
    val game = BaseballGame()
    val player = BaseballPlayer()

    @RepeatedTest(10000)    // 여러번 반복하여 생성해 함수가 올바른 정답을 만들어내는지 확인
    @DisplayName("컴퓨터가 올바른 수를 생성했는지 확인")
    fun testCreateRandomAnswer() {
        val answer: String = game._createRandomAnswer()

        // 생성된 수의 정당성을 확인
        assertThat(answer.matches(Regex("^[1-9]{3}$"))).isTrue()
        assertThat(answer[0]).isNotEqualTo(answer[1]).isNotEqualTo(answer[2])
        assertThat(answer[1]).isNotEqualTo(answer[2])
    }

    @ParameterizedTest  // 정답이 123일때, 다양한 입력에 대한 결과를 확인
    @CsvSource(
        "456, 0, 0",    // 456 -> 0 Strike, 0 Ball
        "345, 0, 1",    // 345 -> 0 Strike, 1 Ball
        "135, 1, 1",    // 135 -> 1 Strike, 1 Ball
        "124, 2, 0",    // 124 -> 2 Strike, 0 Ball
        "321, 1, 2",    // 321 -> 1 Strike, 2 Ball
        "123, 3, 0",    // 123 -> 3 Strike, 0 Ball
        "111, 1, 0",    // 111 -> 1 Strike, 0 Ball
        "811, 0, 1"     // 811 -> 0 Strike, 1 Ball
    )
    @DisplayName("ball 개수와 Strike 개수를 잘 체크하는지 확인")
    fun testJudgingGameResult(inputValue: String, expectedStrike: Int, expectedBall: Int) {
        // 정답을 123으로 설정
        game.answer = "123"

        player.inputString = inputValue
        assertThat(game._strikeCheck(player)).isEqualTo(expectedStrike)
        assertThat(game._ballCheck(player)).isEqualTo(expectedBall)
    }
}