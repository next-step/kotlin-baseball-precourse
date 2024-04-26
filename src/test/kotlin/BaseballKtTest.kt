import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.assertj.core.api.Assertions.assertThatCode
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class BaseballKtTest {

    private lateinit var input: ByteArrayInputStream
    private lateinit var output: ByteArrayOutputStream

    @BeforeEach
    fun setUp() {
        output = ByteArrayOutputStream()
        System.setOut(PrintStream(output))
    }

    @Test
    fun `generateGoalNum 함수는 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 생성한다`() {
        val goalNum = generateGoalNum()
        assertThat(goalNum.toInt()).isGreaterThanOrEqualTo(123)
            .isLessThan(988)
        assertThat(goalNum.toCharArray().distinct().size).isEqualTo(3)
    }

    @Test
    fun `checkInputNum 함수는 입력이 1부터 9까지 서로 다른 수로 이루어진 3자리의 수인지 확인한다`() {
        assertThatCode { checkInputNum("123") }.doesNotThrowAnyException()
        assertThatThrownBy { checkInputNum("1234") }.isInstanceOf(IllegalArgumentException::class.java)
        assertThatThrownBy { checkInputNum("12") }.isInstanceOf(IllegalArgumentException::class.java)
        assertThatThrownBy { checkInputNum("") }.isInstanceOf(IllegalArgumentException::class.java)
        assertThatThrownBy { checkInputNum("203") }.isInstanceOf(IllegalArgumentException::class.java)
        assertThatThrownBy { checkInputNum("112") }.isInstanceOf(IllegalArgumentException::class.java)
    }


    @Test
    fun `matchGoalNumAndUserNum 함수는 목표 숫자와 입력 숫자를 비교하여 매치 결과를 업데이트한다`() {
        val matchResultMap = mutableMapOf("스트라이크" to 0, "볼" to 0, "미스" to 0)
        matchGoalNumAndUserNum("123", "456", matchResultMap)
        assertThat(matchResultMap["스트라이크"]!! + matchResultMap["볼"]!! + matchResultMap["미스"]!!).isEqualTo(3)
        assertThat(matchResultMap["스트라이크"]).isEqualTo(0)
        assertThat(matchResultMap["볼"]).isEqualTo(0)
        assertThat(matchResultMap["미스"]).isEqualTo(3)

        resetMatchResultMap(matchResultMap)
        matchGoalNumAndUserNum("123", "123", matchResultMap)
        assertThat(matchResultMap["스트라이크"]!! + matchResultMap["볼"]!! + matchResultMap["미스"]!!).isEqualTo(3)
        assertThat(matchResultMap["스트라이크"]).isEqualTo(3)
        assertThat(matchResultMap["볼"]).isEqualTo(0)
        assertThat(matchResultMap["미스"]).isEqualTo(0)

        resetMatchResultMap(matchResultMap)
        matchGoalNumAndUserNum("123", "132", matchResultMap)
        assertThat(matchResultMap["스트라이크"]!! + matchResultMap["볼"]!! + matchResultMap["미스"]!!).isEqualTo(3)
        assertThat(matchResultMap["스트라이크"]).isEqualTo(1)
        assertThat(matchResultMap["볼"]).isEqualTo(2)
        assertThat(matchResultMap["미스"]).isEqualTo(0)

        resetMatchResultMap(matchResultMap)
        matchGoalNumAndUserNum("123", "231", matchResultMap)
        assertThat(matchResultMap["스트라이크"]!! + matchResultMap["볼"]!! + matchResultMap["미스"]!!).isEqualTo(3)
        assertThat(matchResultMap["스트라이크"]).isEqualTo(0)
        assertThat(matchResultMap["볼"]).isEqualTo(3)
        assertThat(matchResultMap["미스"]).isEqualTo(0)
    }

    @Test
    fun `isStrike 함수는 현재 선택된 숫자가 스트라이크인지 확인한다`() {
        assertThat(isStrike(0, '1', "123")).isTrue()
        assertThat(isStrike(1, '2', "123")).isTrue()
        assertThat(isStrike(2, '3', "123")).isTrue()

        assertThat(isStrike(0, '2', "123")).isFalse()
        assertThat(isStrike(1, '3', "123")).isFalse()
        assertThat(isStrike(2, '1', "123")).isFalse()
    }

    @Test
    fun `isBall 함수는 현재 선택된 숫자가 볼인지 확인한다`() {
        assertThat(isBall(0, '2', "123")).isTrue()
        assertThat(isBall(1, '3', "123")).isTrue()
        assertThat(isBall(2, '1', "123")).isTrue()

        assertThat(isBall(0, '1', "123")).isFalse()
        assertThat(isBall(1, '2', "123")).isFalse()
        assertThat(isBall(2, '3', "123")).isFalse()
    }

    @Test
    fun `printMatchResult 함수는 매치 결과를 출력한다`() {
        val matchResultMap = mutableMapOf("스트라이크" to 1, "볼" to 2, "미스" to 0)
        val expectedOutput = "2볼 1스트라이크"
        printMatchResult(matchResultMap)
        assertThat(output.toString().trim()).isEqualTo(expectedOutput)

        resetOutput()
        matchResultMap["볼"] = 0
        val expectedOutput2 = "1스트라이크"
        printMatchResult(matchResultMap)
        assertThat(output.toString().trim()).isEqualTo(expectedOutput2)

        resetOutput()
        matchResultMap["볼"] = 2
        matchResultMap["스트라이크"] = 0
        matchResultMap["미스"] = 1

        val expectedOutput3 = "2볼"
        printMatchResult(matchResultMap)
        assertThat(output.toString().trim()).isEqualTo(expectedOutput3)

        resetOutput()
        matchResultMap["스트라이크"] = 0
        matchResultMap["미스"] = 3
        val expectedOutput4 = "낫싱"
        printMatchResult(matchResultMap)
        assertThat(output.toString().trim()).isEqualTo(expectedOutput4)

    }

    @Test
    fun `checkValidFlag 함수는 플래그의 유효성을 확인한다`() {
        assertThatCode { checkValidFlag("1", false) }.doesNotThrowAnyException()
        assertThatCode { checkValidFlag("2", false) }.doesNotThrowAnyException()

        assertThatCode { checkValidFlag("1", true) }.doesNotThrowAnyException()
        assertThatCode { checkValidFlag("2", true) }.doesNotThrowAnyException()

        assertThatThrownBy { checkValidFlag("3", true) }.isInstanceOf(IllegalArgumentException::class.java)
        assertThatThrownBy { checkValidFlag("", true) }.isInstanceOf(IllegalArgumentException::class.java)
        assertThatThrownBy { checkValidFlag("ㅁㅁ", true) }.isInstanceOf(IllegalArgumentException::class.java)

    }

    private fun resetOutput() {
        output.reset()
    }
}
