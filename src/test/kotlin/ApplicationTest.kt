import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertTrue

class ApplicationTest {

    @Test
    fun testMakeNumList() {
        val result = makeUserNumList("345")
        assertEquals(listOf<Int>(3, 4, 5), result, "error in MakeNumList")
    }

    @Test
    fun testCheckMatch() {
        val result = checkMatch(listOf<Int>(1, 2, 3), listOf<Int>(4, 2, 3))
        assertEquals(false, result, "error in checkMatch")
    }

    @Test
    fun testInputErrorHandling() {
        val result = inputErrorHandling('3' , 3, "게임 중")
        assertEquals(3, result, "error in InputErrorHandling")
    }

    @Test
    fun testException() {
        val result = inputErrorHandling('@' , 3, "게임 중")
        assertEquals(-1, result)
    }

}