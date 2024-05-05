package baseball

import org.junit.jupiter.api.Test

class BaseballTest {

    @Test
    fun `generateAnswer returns a string of 3 unique digits`() {
        //generateAnswer 함수가 다음 조건을 만족하는 지 확인
        // 1. 세 자리 숫자를 생성
        // 2. 해당 숫자에는 중복된 수가 없음
        // 3. 해당 숫자는 0이 아닌 숫자로만 구성
    }

    @Test
    fun `checkInputIfValid returns true for valid input`() {
        // 예외처리가 valid input에 대해 정상 작동하는 지 확인
    }

    @Test
    fun `checkInputIfValid returns false for invalid input`() {
        // 예외처리가 invalid input에 대해 정상 작동하는 지 확인
    }

    @Test
    fun `evaluate returns true only when there are 3 strikes`() {
        // evaluate가 3스트라이크 시에만 true를 리턴하는 지 확인
    }

    @Test
    fun `evaluate correctly identifies number of strikes and balls`() {
        // evaluate 함수가 스트라이크, 볼의 수를 잘 카운트하는 지 확인
    }
}
