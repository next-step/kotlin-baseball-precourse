import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class BaseBallTest {

    @Test
    @DisplayName("1에서 9까지 서로 다른 수로 이루어진 세 자리 수 생성")
    fun randomNumberValidateAssertion() {
        // given
        val randomNumberGenerator = RandomNumberGenerator()

        // when
        val randomNumber = randomNumberGenerator.setNumber()

        // then
        assertThat(randomNumber)
            .isSubsetOf(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9))
            .doesNotHaveDuplicates()
            .hasSize(3)
    }

    @Nested
    @DisplayName("플레이어 숫자 입력값 유효성 검사 테스트")
    inner class InputValidationTest {
        // given
        private val inputValidator = InputValidator()

       @Nested
       @DisplayName("세 자리 수 입력값 유효성 검사 테스트")
       inner class ThreeDigitInputValidationTest {
           @Test
           @DisplayName("세 자리 수를 입력하지 않은 경우 예외 발생")
           fun digitExceptionTest() {
               // when
               val playerInput = "1"

               // then
               assertThrows(IllegalArgumentException::class.java) { inputValidator.validateThreeDigitInput(playerInput) }
           }

           @Test
           @DisplayName("숫자 외의 값을 입력한 경우 예외 발생")
           fun typeExceptionTest() {
               // when
               val playerInput = "hello"

               // then
               assertThrows(IllegalArgumentException::class.java) { inputValidator.validateThreeDigitInput(playerInput) }
           }

           @Test
           @DisplayName("동일한 숫자를 여러번 입력한 경우 예외 발생")
           fun duplicationExceptionTest() {
               // when
               val playerInput = "131"

               // then
               assertThrows(IllegalArgumentException::class.java) { inputValidator.validateThreeDigitInput(playerInput) }
           }

           @Test
           @DisplayName("0이 입력값에 포함된 경우 예외 발생")
           fun includeZeroExceptionTest() {
               // when
               val playerInput = "012"

               // then
               assertThrows(IllegalArgumentException::class.java) { inputValidator.validateThreeDigitInput(playerInput) }
           }
       }

        @Nested
        @DisplayName("한 자리 수 입력값 유효성 검사 테스트")
        inner class OneDigitInputValidationTest {

            @Test
            @DisplayName("1이나 2를 입력한 경우 예외 발생하지 않음.")
            fun success() {
                // when
                val oneOrTwo = (1..2).random()
                val playerInput = oneOrTwo.toString()

                // then
                assertDoesNotThrow("예외가 발생하지 않았습니다.") { inputValidator.validateOneDigitInput(playerInput) }
            }

            @Test
            @DisplayName("")
            fun digitExceptionTest() {
                // when
                val exceptionNumber = (3 .. 10000).random()
                val playerInput = exceptionNumber.toString()

                assertThrows(IllegalArgumentException::class.java) { inputValidator.validateOneDigitInput(playerInput) }
            }

            @Test
            @DisplayName("숫자 외의 값을 입력한 경우 예외 발생")
            fun typeExceptionTest() {
                // when
                val playerInput = "hello"

                assertThrows(IllegalArgumentException::class.java) { inputValidator.validateOneDigitInput(playerInput) }
            }
        }
    }
}

