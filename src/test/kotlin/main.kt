import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class Test {

    @Test
    fun testRandom() {
        val result = random()
        assertThat(result.distinct().size).isEqualTo(3) //중복 숫자 없어야 함
        assertThat(result.size).isEqualTo(3) //숫자 3개여야 함
        assertThat(result).allMatch { it in 1..9 } //모든 숫자가 1..9 사이인지
    }

    @Test
    fun testJudgement() {
        val inputNumber: Array<Int?> = arrayOf(1, 2, 3) //1, 2, 3 int 배열
        val answerNumber: Array<Int?> = arrayOf(1, 2, 3) //1, 2, 3 int 배열
        val result = judgement(inputNumber, answerNumber) //judgement 함수 돌린 결과
        assertThat(Pair(3, 0)).isEqualTo(result) //strike인지

        val inputNumber2: Array<Int?> = arrayOf(1, 4, 3)
        val answerNumber2: Array<Int?> = arrayOf(3, 1, 2)
        val result2 = judgement(inputNumber2, answerNumber2)
        assertThat(Pair(0, 2)).isEqualTo(result2) //2볼인지
    }

    @Test
    fun testDisplay() {
        assertThat("낫싱").isEqualTo(display(Pair(0, 0))) //스트라이크 0, 볼 0일 때 낫싱
        assertThat("정답입니다").isEqualTo(display(Pair(3, 0))) //3스트라이크 0 볼일 때 정답 처리
        assertThat("1 스트라이크 2 볼").isEqualTo(display(Pair(1, 2))) // 1스트라이크 2 볼일 때 관련 문장 출력

    }



}

class InputValidationTest {
    @Test
    fun testValidInput() {
        val userInput = "123"
        val input = userInput.map { it.toString().toInt() }
        assertThat(listOf(1, 2, 3)).isEqualTo(input)
    }

    @Test
    fun testInvalidInput() {
        val userInput = "abc"
        assertThrows<IllegalArgumentException> {
            userInput.map { it.toString().toInt() }
        }
    }
}