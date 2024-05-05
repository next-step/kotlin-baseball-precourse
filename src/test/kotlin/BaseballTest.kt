import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


class BaseballTest {

    @Test
    fun `스트라이크 볼 카운트 테스트`() {
        val answer = listOf(7, 1, 3)
        var (strike, ball) = 0 to 0
        // 1스트라이크 1볼
        var input = listOf(1, 2, 3)
        countStrikeBall(answer, input).let { (s, b) ->
            strike = s
            ball = b
        }
        assertEquals(1, strike)
        assertEquals(1, ball)

        // 1스트라이크
        input = listOf(2, 1, 6)
        countStrikeBall(answer, input).let { (s, b) ->
            strike = s
            ball = b
        }
        assertEquals(1, strike)
        assertEquals(0, ball)

        // 2볼
        input = listOf(6, 7, 1)
        countStrikeBall(answer, input).let { (s, b) ->
            strike = s
            ball = b
        }
        assertEquals(0, strike)
        assertEquals(2, ball)

        // 낫싱
        input = listOf(4, 5, 6)
        countStrikeBall(answer, input).let { (s, b) ->
            strike = s
            ball = b
        }
        assertEquals(0, strike)
        assertEquals(0, ball)
    }

    @Test
    fun `숫자 입력 예외 테스트`() {
        // 세자리 수 입력에서 중복된 숫자가 있는 경우
        var input = listOf(1, 1, 2)
        try {
            inputNumberException(input)
        } catch (e: IllegalArgumentException) {
            assertEquals("잘못된 입력: 중복된 숫자가 있습니다.", e.message)
        }

        // 숫자 0이 입력된 경우
        input = listOf(0, 2, 3)
        try {
            inputNumberException(input)
        } catch (e: IllegalArgumentException) {
            assertEquals("잘못된 입력: 숫자 0은 입력할 수 없습니다.", e.message)
        }

        // 입력된 값이 없는 경우
        input = emptyList()
        try {
            inputNumberException(input)
        } catch (e: IllegalArgumentException) {
            assertEquals("잘못된 입력: 입력된 값이 없습니다.", e.message)
        }

        // 3개의 숫자가 아닌 경우
        input = listOf(1, 2)
        try {
            inputNumberException(input)
        } catch (e: IllegalArgumentException) {
            assertEquals("잘못된 입력: 3개의 숫자가 아닙니다.", e.message)
        }
    }

    @Test
    fun `게임 재시작 여부 입력 예외 테스트`() {
        // 입력된 값이 없는 경우
        var flag: Int? = null
        try {
            flagException(flag)
        } catch (e: IllegalArgumentException) {
            assertEquals("잘못된 조건 입력: 입력된 값이 없습니다.", e.message)
        }

        // 입력한 숫자가 조건에 맞지 않는 경우
        flag = 3
        try {
            flagException(flag)
        } catch (e: IllegalArgumentException) {
            assertEquals("잘못된 조건 입력: 입력한 숫자가 조건에 맞지 않습니다.", e.message)
        }
    }
}
