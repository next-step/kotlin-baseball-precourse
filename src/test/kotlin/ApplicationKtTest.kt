import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream

class ApplicationKtTest{
    @Test
    fun `test _selectRandomnumber`() {
        val numbers = _selectRandomnumber()
        assertEquals(3, numbers.size)
        for (number in numbers) {
            assert(number.toInt() in 1..9)
        }
    }

    @Test
    fun `test inputNumber`() {
        // 테스트 입력 설정
        val input = "123\n"
        System.setIn(ByteArrayInputStream(input.toByteArray()))

        val result = inputNumber()

        assertEquals("123", result)

        // 테스트 입력 리셋
        System.setIn(System.`in`)
    }
}