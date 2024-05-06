import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.io.ByteArrayInputStream

class UserTest {

    @Test
    fun inputTest() {
        // 사용자가 올바른 입력을 했을 때
        val user = User()
        System.setIn(ByteArrayInputStream("123\n".toByteArray()))
        user.input()
        assertEquals(123, user.inputNumber)

        // 사용자가 잘못된 입력을 했을 때
        val user2 = User()
        System.setIn(ByteArrayInputStream("abc\n".toByteArray()))
        assertThrows<IllegalArgumentException> { user2.input() }
    }

    @Test
    fun changeTest() {
        val user = User()
        user.inputNumber = 123
        user.change()
        assertEquals(1, user.inputArray[0])
        assertEquals(2, user.inputArray[1])
        assertEquals(3, user.inputArray[2])
    }
}
