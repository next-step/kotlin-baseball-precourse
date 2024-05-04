import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class ApplicationTest {
    @Test
    fun testCalculate_exactMatch() {
        val game = BaseballGame()
        game.setTargetNumberForTesting(listOf(1, 2, 3))
        assertThat(game.calculate(123)).isEqualTo("3스트라이크")
    }

    @Test
    fun testCalculate_partialMatch() {
        val game = BaseballGame()
        game.setTargetNumberForTesting(listOf(1, 2, 3))
        assertThat(game.calculate(132)).isEqualTo("2볼 1스트라이크")
    }

    @Test
    fun testCalculate_noMatch() {
        val game = BaseballGame()
        game.setTargetNumberForTesting(listOf(1, 2, 3))
        assertThat(game.calculate(456)).isEqualTo("낫싱")
    }
}
