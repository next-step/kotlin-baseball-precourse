import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.RepeatedTest

import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ComputerTest {

	val computer = Computer()

	@DisplayName("숫자 생성 확인")
	@RepeatedTest(100)
	fun checkNum(){
		val RANGE = (1..9)
		val first:Int
		var second:Int
		var third:Int
		first = RANGE.random()
		do {
			second = RANGE.random()
		} while (first == second)
		do {
			third = RANGE.random()
		} while (first == third || second == third)

		assert(first in RANGE)
		assert(second in RANGE)
		assert(third in RANGE)

		assert(first != second)
		assert(first != third)
		assert(third != second)
	}






	@Test
	@DisplayName("유효한 입력 확인")
	fun testValidInput() {
		val inputFunction: () -> Unit = {
			val input = "123\n" // Valid three-digit number
			System.setIn(input.byteInputStream())
			computer.input()
		}
		assertDoesNotThrow(inputFunction)
	}

	@Test
	@DisplayName("범위 밖 숫자 입력 확인")
	fun testOutOfRangeInput() {
		val inputFunction: () -> Unit = {
			val input = "23\n" // Out of range number
			System.setIn(input.byteInputStream())
			assertThrows(Exception::class.java) { computer.input() }
		}
		assertDoesNotThrow(inputFunction)
	}

	@ParameterizedTest
	@DisplayName("잘못된 입력 확인")
	@ValueSource(strings = ["23\n", "023\n", "a1d\n"])
	fun wrongInput(input:String){
		val inputFunction: () -> Unit = {
			System.setIn(input.byteInputStream())
			assertThrows(Exception::class.java) { computer.input() }
		}
		assertDoesNotThrow(inputFunction)
	}

	@Test
	@DisplayName("0 입력 확인")
	fun testZeroInput() {
		val inputFunction: () -> Unit = {
			val input = "023\n" // Out of range number
			System.setIn(input.byteInputStream())
			assertThrows(Exception::class.java) { computer.readNum() }
		}
		assertDoesNotThrow(inputFunction)
	}

	@Test
	@DisplayName("문자 입력 확인")
	fun testNonNumericInput() {
		val inputFunction: () -> Unit = {
			val input = "abc\n" // Non-numeric input
			System.setIn(input.byteInputStream())
			assertThrows(IllegalArgumentException::class.java) { computer.input() }
		}
		assertDoesNotThrow(inputFunction)
	}




}