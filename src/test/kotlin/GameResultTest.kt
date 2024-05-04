import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class GameResultTest {
    var ouputStream = ByteArrayOutputStream()

    @BeforeEach
    fun initOutputStream() {
        // 출력 테스트 전 System.out으로 설정되어 있던 출력 스트림을 ouputStream으로 변경
        ouputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(ouputStream))
    }

    @ParameterizedTest
    @CsvSource (
        "0, 0, 낫싱",
        "1, 0, 1볼",
        "2, 0, 2볼",
        "3, 0, 3볼",
        "0, 1, 1스트라이크",
        "0, 2, 2스트라이크",
        "0, 3, 3스트라이크",
        "1, 1, 1볼 1스트라이크",
        "2, 1, 2볼 1스트라이크",
    )
    @DisplayName("게임 결과를 잘 출력하는지 확인")
    fun testPrintGameResult(BallCount: Int, StrikeCount: Int, expected: String) {
        val gameResult = GameResult(BallCount, StrikeCount)
        gameResult.printGameResult()

        // outputStream에 출력된 결과를 비교
        assertThat(ouputStream.toString().trim()).isEqualTo(expected)
    }
}