import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.RepeatedTest

import org.junit.jupiter.api.Test

class ComputerTest {

	val computer = Computer()

	@DisplayName("숫자 생성 확인")
	@RepeatedTest(100)
	fun checkNum(){
		val RANGE = (1..9)
		var first:Int
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
			val input = "\n" // Out of range number
			System.setIn(input.byteInputStream())
			assertThrows(Exception::class.java) { computer.input() }
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