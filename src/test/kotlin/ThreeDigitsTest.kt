import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class ThreeDigitsTest {
    @ParameterizedTest(name = "ThreeDigit({0}, {1}, {2}) should create valid instance")
    @CsvSource(
        "1, 2, 3",
        "4, 5, 6",
        "1, 0, 8",
        "4, 3, 2",
        "9, 8, 0")
    fun test_threeDigits(param1:Int, param2:Int, param3:Int){
        assertThat(ThreeDigits(param1, param2, param3)).matches {
            (it.digit1 == param1) and (it.digit2 == param2) and (it.digit3 == param3)
        }
    }
    @ParameterizedTest(name = "ThreeDigit({0}, {1}, {2}) should throw illegalArgumentException")
    @CsvSource(
        "1, 2, 11",
        "-1, 5, 6",
        "11, 12, 13",
        "8, 9, 10",
        "4, -10, 0")
    fun test_threeDigits_if_given_argument_out_of_bound(param1:Int, param2:Int, param3:Int){
        Assertions.assertThatIllegalArgumentException().isThrownBy {
            ThreeDigits(param1,param2,param3)
        }
    }

    @ParameterizedTest(name = "ThreeDigit.fromList([{0}, {1}, {2}]) should create valid instance")
    @CsvSource(
        "1, 2, 3",
        "4, 5, 6",
        "1, 0, 8",
        "4, 3, 2",
        "9, 8, 0")
    fun test_threeDigits_from_list(param1:Int, param2:Int, param3:Int){
        assertThat(ThreeDigits.fromList(listOf(param1, param2, param3))).matches {
            (it.digit1 == param1) and (it.digit2 == param2) and (it.digit3 == param3)
        }
    }

    @Test
    @DisplayName("ThreeDigit.fromList with invalid size of list should throw illegalArgumentException")
    fun test_threeDigits_from_list_if_given_invalid_size_of_list(){
        Assertions.assertThatIllegalArgumentException().isThrownBy {
            ThreeDigits.fromList(listOf(1, 2, 3, 4))
        }
    }

    @ParameterizedTest(name = "ThreeDigit({0}, {1}, {2})[{3}] should be {4}")
    @CsvSource(
        "1, 2, 3, 0, 1",
        "4, 5, 6, 1, 5",
        "1, 0, 8, 2, 8",
        "4, 3, 2, 0, 4",
        "9, 8, 0, 2, 0")
    fun test_threeDigits_indexing(param1:Int, param2:Int, param3:Int, index:Int, expected:Int){
        assertThat(ThreeDigits(param1, param2, param3)[index]).isEqualTo(expected)
    }

    @Test
    @DisplayName("indexing ThreeDigit with index out of bound should throw indexOutOfBoundsException")
    fun test_threeDigits_indexing_out_of_bound(){
        Assertions.assertThatIndexOutOfBoundsException().isThrownBy {
            ThreeDigits(1,2,3)[4]
        }
    }
}