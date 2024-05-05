import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatIllegalArgumentException
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.RepeatedTest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ToolsTest {
    @ParameterizedTest(name = "strToIntegers(\"{0}\") should throw illegalArgumentException")
    @ValueSource(strings = ["hello","12aa34","..123","5-3","-1","12 51"])
    fun test_strToIntegers_if_given_illegal_argument(input:String){
        assertThatIllegalArgumentException()
            .isThrownBy { Tools.strToIntegers(input) }
    }

    @ParameterizedTest(name = "strToIntegers(\"{0}\") should be {1}")
    @MethodSource("generateData")
    fun test_strToIntegers_if_it_has_zeros(input:String, expectedResult:List<Int>){
        assertThat(Tools.strToIntegers(input)).isEqualTo(expectedResult)
    }

    @Test
    @DisplayName("input with empty string should return empty list")
    fun test_strToIntegers_if_it_is_empty(){
        assertThat(Tools.strToIntegers("")).isEqualTo(listOf<Int>())
    }

    @RepeatedTest(100)
    @DisplayName("permutation() should not contain duplicates and works without any failures")
    fun test_permutation(){
        assertThat(Tools.permutation(5)).doesNotHaveDuplicates()
    }

    @ParameterizedTest(name = "permutation(\"{0}\") should not contain duplicates and works without any failures")
    @ValueSource(ints = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10])
    fun test_permutation_if_inside_bound(input:Int){
        assertThat(Tools.permutation(input)).doesNotHaveDuplicates()
    }

    @ParameterizedTest(name = "permutation(\"{0}\") should throw illegalArgumentException")
    @ValueSource(ints = [-2,-1, 11, 12])
    fun test_permutation_if_out_of_bound(input:Int){
        assertThatIllegalArgumentException()
            .isThrownBy { Tools.permutation(input) }
    }


    private fun generateData(): Stream<Arguments> {
        return Stream.of(
            Arguments.of("02134", listOf(0,2,1,3,4)),
            Arguments.of("53120", listOf(5,3,1,2,0)),
            Arguments.of("00000", listOf(0,0,0,0,0)),
            Arguments.of("0", listOf(0)),
            Arguments.of("189701350478990", listOf(1,8,9,7,0,1,3,5,0,4,7,8,9,9,0))
        )
    }
}