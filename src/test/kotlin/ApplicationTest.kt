import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatCode
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream


class ApplicationTest {

    private lateinit var output: ByteArrayOutputStream

    @BeforeEach
    fun setUp(){
        output = ByteArrayOutputStream()
        System.setOut(PrintStream(output))
    }
    @Test
    fun testGenerateGoalNumber(){
        val number = generateGoalNumber()
        assertThat(number.length).isEqualTo(3)
        assertThat(number.toSet().size).isEqualTo(3)
        assertThat(number).containsOnlyDigits()
        assertThat(number.toList().all { it in '1'..'9' }).isTrue()
    }

    @Test
    fun testCompareNumber(){
        var result = compareNumber("789","789")
        assertThat(result).isEqualTo(0)
        result = compareNumber("643","789")
        assertThat(result).isEqualTo(-1)
    }

    @Test
    fun testCheckInputNumber(){
        assertThatThrownBy { checkInputNumber("") }
            .isInstanceOf(IllegalArgumentException::class.java)
        assertThatThrownBy { checkInputNumber("111") }
            .isInstanceOf(IllegalArgumentException::class.java)
        assertThatThrownBy { checkInputNumber("012") }
            .isInstanceOf(IllegalArgumentException::class.java)
        assertThatThrownBy { checkInputNumber("12") }
            .isInstanceOf(IllegalArgumentException::class.java)
        assertThatCode { checkInputNumber("987")}.doesNotThrowAnyException()
    }

    @Test
    fun testPrintResult(){
        printResult(3,0)
        assertThat(output.toString().trim()).isEqualTo("3스트라이크")
        output.reset()
        printResult(2,1)
        assertThat(output.toString().trim()).isEqualTo("1볼 2스트라이크")
        output.reset()
        printResult(2,0)
        assertThat(output.toString().trim()).isEqualTo("2스트라이크")
        output.reset()
        printResult(0,0)
        assertThat(output.toString().trim()).isEqualTo("낫싱")
        output.reset()
    }
}
