import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach

import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.io.OutputStream
import java.io.PrintStream

class BaseballGameTest {
    private val baseballGame = BaseballGame(3)

    @Test
    fun `숫자야구의 룰에 맞는 입력만을 유효하다고 판단한다`() {
        assertTrue(baseballGame.isValidInput("123"))
        assertFalse(baseballGame.isValidInput("122"))
        assertFalse(baseballGame.isValidInput("1234"))
        assertFalse(baseballGame.isValidInput("abc"))
        assertFalse(baseballGame.isValidInput("5"))
        assertFalse(baseballGame.isValidInput("카테캠화이팅"))
    }

    @Test
    fun `예상하는 숫자를 입력 받으면 스트라이크, 볼을 알맞게 계산한다`() {
        baseballGame.answer = listOf(7,1,3)

        baseballGame.guess("123")
        assertEquals(baseballGame._strikeCount,1)
        assertEquals(baseballGame._ballCount,1)

        baseballGame.guess("145")
        assertEquals(baseballGame._strikeCount,0)
        assertEquals(baseballGame._ballCount,1)

        baseballGame.guess("671")
        assertEquals(baseballGame._strikeCount,0)
        assertEquals(baseballGame._ballCount,2)

        baseballGame.guess("216")
        assertEquals(baseballGame._strikeCount,1)
        assertEquals(baseballGame._ballCount,0)

        baseballGame.guess("371")
        assertEquals(baseballGame._strikeCount,0)
        assertEquals(baseballGame._ballCount,3)

        baseballGame.guess("713")
        assertEquals(baseballGame._strikeCount,3)
        assertEquals(baseballGame._ballCount,0)
    }

    @Test
    fun `올바르지 않은 형식을 입력한 경우 IllegalArgumentException을 발생한다`(){
        assertThrows(IllegalArgumentException::class.java){
            baseballGame.guess("12")
        }

        assertThrows(IllegalArgumentException::class.java){
            baseballGame.guess("1234")
        }

        assertThrows(IllegalArgumentException::class.java){
            baseballGame.guess("455")
        }
    }

    @Test
    fun `정답은 랜덤하게 생성하며 올바른 형식으로 생성된다`(){
        for(i in 1..100){
            val answer = baseballGame.makeAnswer()
            assertTrue(baseballGame.isValidInput(answer.joinToString("")))
        }
    }

    @Test
    fun `정답을 맞추면 restart 메서드를 호출하여 게임을 다시 시작하거나 종료한다`(){
        val before = baseballGame.answer
        var inputStream = ByteArrayInputStream("1".toByteArray())
        System.setIn(inputStream)

        baseballGame.restart()
        assertNotSame(before, baseballGame.answer)

        inputStream = ByteArrayInputStream("2".toByteArray())
        System.setIn(inputStream)

        baseballGame.restart()
        assertEquals(true, baseballGame.terminateFlag)
    }

}