import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.lang.reflect.InvocationTargetException

class ControllerTest {
    val controller = Controller()
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
    @DisplayName("올바른 입력에 대한 inputNewGame 테스트")
    fun correctInputNewGameTest() {
        val inputNewGame = controller.javaClass.getDeclaredMethod("_inputNewGame")
        inputNewGame.trySetAccessible()

        setInput("1")
        assertThat(inputNewGame.invoke(controller)).isEqualTo(1)
        setInput("2")
        assertThat(inputNewGame.invoke(controller)).isEqualTo(2)
    }

    @Test
    @DisplayName("올바르지 않은 입력에 대한 inputNewGame 테스트")
    fun exceptionInputNewGameTest() {
        val inputNewGame = controller.javaClass.getDeclaredMethod("_inputNewGame")
        inputNewGame.trySetAccessible()

        val inputList = mutableListOf<String>()
        inputList.add("0")
        inputList.add("test")
        inputList.add("%13")

        for (input in inputList) {
            try {
                setInput(input)
                inputNewGame.invoke(controller)
            } catch (e: InvocationTargetException) {
                assertThat(e.targetException::class.java)
                    .isEqualTo(IllegalArgumentException::class.java)
            }
        }
    }

    @Test
    @DisplayName("올바른 입력에 대한 inputUserNum 테스트")
    fun correctinputUserNumTest() {
        val inputUserNum = controller.javaClass.getDeclaredMethod("_inputUserNum")
        inputUserNum.trySetAccessible()

        val inputList = mutableListOf<String>()
        inputList.add("111")
        inputList.add("123")
        inputList.add("789")

        for (input in inputList) {
            setInput(input)
            assertThat(inputUserNum.invoke(controller))
                .isEqualTo(input)
        }
    }

    @Test
    @DisplayName("올바르지 않은 입력에 대한 inputUserNum 테스트")
    fun exceptionInputUserNumTest() {
        val inputUserNum = controller.javaClass.getDeclaredMethod("_inputUserNum")
        inputUserNum.trySetAccessible()

        val inputList = mutableListOf<String>()
        inputList.add("000")
        inputList.add("1000")
        inputList.add("test")
        inputList.add("%13")

        for (input in inputList) {
            try {
                setInput(input)
                inputUserNum.invoke(controller)
            } catch (e: InvocationTargetException) {
                assertThat(e.targetException::class.java)
                    .isEqualTo(IllegalArgumentException::class.java)
            }
        }
    }

    @Test
    @DisplayName("state 값에 따른 outputState 테스트")
    fun outputStateTest() {
        var output: ByteArrayOutputStream
        val outputState = controller.javaClass.getDeclaredMethod("_outputState", Int::class.java)
        outputState.trySetAccessible()

        output = setOutput()
        outputState.invoke(controller, 20)
        assertThat(output.toString())
            .isEqualTo("2스트라이크 \r\n")

        output = setOutput()
        outputState.invoke(controller, 2)
        assertThat(output.toString())
            .isEqualTo("2볼 \r\n")

        output = setOutput()
        outputState.invoke(controller, 11)
        assertThat(output.toString())
            .isEqualTo("1볼 1스트라이크 \r\n")

        output = setOutput()
        outputState.invoke(controller, 30)
        assertThat(output.toString())
            .isEqualTo("3개의 숫자를 모두 맞히셨습니다! 게임 종료\r\n")

        output = setOutput()
        outputState.invoke(controller, 0)
        assertThat(output.toString())
            .isEqualTo("낫싱\r\n")
    }
}