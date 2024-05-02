import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class ViewTest {
    val view = View()
    val initInput = System.`in`
    val initOutput = System.out

    @BeforeEach
    fun resetIO() {
        System.setIn(initInput)
        System.setOut(initOutput)
    }

    fun setInput(input: String) {
        System.setIn(input.byteInputStream())
    }

    fun setOutput(): ByteArrayOutputStream {
        val output = ByteArrayOutputStream()
        System.setOut(PrintStream(output))
        return output
    }

    @Test
    @DisplayName("input 테스트")
    fun inputTest() {
        val msg = "test message"
        setInput(msg)
        val input = view.input()
        assertThat(input).isEqualTo(msg)
    }

    @Test
    @DisplayName("output 테스트")
    fun outputTest() {
        val msg = "test message"
        val output = setOutput()
        view.output(msg)
        assertThat(output.toString()).isEqualTo(msg)
    }

    @Test
    @DisplayName("outputln 테스트")
    fun outputlnTest() {
        val msg = "test message"
        val output = setOutput()
        view.outputln(msg)
        assertThat(output.toString()).isEqualTo("$msg\r\n")
    }
}