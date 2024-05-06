import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ComTest {

    lateinit var com: Com

    @BeforeEach
    fun setUp() {
        com = Com()
    }

    @Test
    fun makeNumberTest() {
        com.makeNumber()
        assertEquals(3, com.randomNumber.size)
        for (number in com.randomNumber) {
            assert(number in 1..9)
        }
    }

    @Test
    fun compareTest() {
        com.randomNumber = intArrayOf(1, 2, 3)
        val userInput = intArrayOf(1, 4, 5)
        com.compare(userInput)
        assertEquals(1, com.strike)
        assertEquals(0, com.ball)
    }
}
