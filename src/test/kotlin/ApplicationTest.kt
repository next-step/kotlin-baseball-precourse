import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import org.junit.jupiter.api.assertThrows

class ApplicationTest {

    @Test
    fun generateNumberTest() {
        val generateNumber = generateNumber()
        assertThat(generateNumber.length).isEqualTo(3)
        assertThat(generateNumber).matches("[1-9]{3}")
    }

    @Test
    fun enterNumberTest() {
        val input = "123\n"

        val inputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(inputStream)
        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        val result = enterNumber()

        System.setIn(System.`in`)
        System.setOut(System.out)

        assertThat(result).isEqualTo("123")
    }


    @Test
    fun validateNumberInvalidInputTest() {
        // 유효하지 않은 입력값
        val input = "abc"

        // 예외 발생 여부 확인
        val exception = assertThrows<IllegalArgumentException> {
            validateNumber(input)
        }

        // 예외 메시지 확인
        assertThat(exception.message).isEqualTo("세 자리 자연수를 입력하세요.")
    }

    @Test
    fun calculateBallCountTest() {
        // 정답 숫자와 입력 숫자 설정
        val answerNumber = "123"
        val inputNumber = "456"

        // 함수 실행 및 반환값 확인
        val result = calculateBallCount(inputNumber, answerNumber)

        // 반환된 값이 예상한 결과와 일치하는지 확인
        assertThat(result).isEqualTo("낫싱")
    }

    @Test
    fun calculateBallCountTest2() {
        // 정답 숫자와 입력 숫자 설정
        val answerNumber = "123"
        val inputNumber = "356"

        // 함수 실행 및 반환값 확인
        val result = calculateBallCount(inputNumber, answerNumber)

        // 반환된 값이 예상한 결과와 일치하는지 확인
        assertThat(result).isEqualTo("1볼")
    }

    @Test
    fun calculateBallCountTest3() {
        // 정답 숫자와 입력 숫자 설정
        val answerNumber = "123"
        val inputNumber = "421"

        // 함수 실행 및 반환값 확인
        val result = calculateBallCount(inputNumber, answerNumber)

        // 반환된 값이 예상한 결과와 일치하는지 확인
        assertThat(result).isEqualTo("1스트라이크 1볼")
    }

    @Test
    fun calculateBallCountTest4() {
        val answerNumber = "123"
        val inputNumber = "123"

        val result = calculateBallCount(inputNumber, answerNumber)

        assertThat(result).isEqualTo("3스트라이크")
    }
}