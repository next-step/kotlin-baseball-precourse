import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test



class ApplicationTest {

    @Test
    fun testGenerateGoalNumber(){
        val number = generateGoalNumber()
        assertThat(number.length).isEqualTo(3)
        assertThat(number.toSet().size).isEqualTo(3)
        assertThat(number).containsOnlyDigits()
    }

    @Test
    fun testCompareNumber(){
        val result = compareNumber("789","789")
        assertThat(result).isEqualTo(0)
    }

    @Test
    fun testCheckInputNumber(){
        assertThatThrownBy { checkInputNumber("aaa") }
            .isInstanceOf(IllegalArgumentException::class.java)
    }
}