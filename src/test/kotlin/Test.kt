import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource


class Test {
    val game = Game()

    @DisplayName("비중복 숫자 생성 테스트")
    @RepeatedTest(50)
    fun notDuplicatedGenerate() {
        val RANGE = (1..9)
        game.generate()
        var nums = game.numbers

        for (i in 0..2)
            assert(nums[i] in RANGE)

        assert(nums[0] != nums[1])
        assert(nums[0] != nums[2])
        assert(nums[1] != nums[2])
    }

    @ParameterizedTest
    @DisplayName("0 입력 테스트")
    @ValueSource(strings = ["560", "709", "048"])
    fun inputZero (v:String){
        val func: () -> Unit = {
            System.setIn(v.byteInputStream())
            assertThatThrownBy { game.examine() }.isInstanceOf(Exception::class.java)
        }
        assertDoesNotThrow(func)
    }

    @ParameterizedTest
    @DisplayName("숫자 이외 입력 테스트")
    @ValueSource(strings = ["", "145s", "8*f"])
    fun inputNotNum (v:String){
        val func: () -> Unit = {
            System.setIn(v.byteInputStream())
            assertThatThrownBy { game.examine() }.isInstanceOf(Exception::class.java)
        }
        assertDoesNotThrow(func)
    }

    @ParameterizedTest
    @DisplayName("재시작 이외의 숫자 테스트")
    @ValueSource(strings = ["3", "6", "7", "9"])
    fun wrongPlay (v:String){
        game.win = true
        val func: () -> Unit = {
            System.setIn(v.byteInputStream())
            assertThrows<Exception> { game.run() }
        }
        assertDoesNotThrow(func)
    }
}