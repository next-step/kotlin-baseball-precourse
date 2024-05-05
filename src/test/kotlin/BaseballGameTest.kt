import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class BaseballGameTest {
    @BeforeEach
    fun prepareEach(){
        println("Starting..")
    }
    @ParameterizedTest(name = "BaseballGame([{0}, {1}, {2}]) should throw illegalArgumentException")
    @CsvSource(
        "1, 2, 2",
        "4, 4, 4",
        "1, 2, 1",
        "3, 3, 2")
    fun test_threeDigits_if_given_argument_out_of_bound(param1:Int, param2:Int, param3:Int) {
        Assertions.assertThatIllegalArgumentException().isThrownBy {
            BaseballGame(ThreeDigits(param1, param2, param3))
        }
    }

    @ParameterizedTest(name = "guessing ({3}, {4}, {5}) to answer ({0}, {1}, {2}) should be [balls = {6}, strikes = {7}]")
    @CsvSource(
        "1, 2, 3, 1, 2, 3, 0, 3",
        "4, 5, 6, 3, 5, 7, 0, 1",
        "1, 2, 3, 3, 1, 2, 3, 0",
        "7, 1, 9, 1, 4, 5, 1, 0",
        "4, 3, 2, 5, 6, 7, 0, 0",
        "9, 8, 2, 8, 5, 2, 1, 1")
    fun test_baseballGame_guess(gameParam1:Int, gameParam2:Int, gameParam3:Int, guessParam1:Int, guessParam2: Int, guessParam3:Int, expectedBalls:Int, expectedStrikes:Int){
        val game = BaseballGame(ThreeDigits(gameParam1, gameParam2, gameParam3))
        assertThat(game.guess(ThreeDigits(guessParam1, guessParam2, guessParam3))).matches {
            (it.balls == expectedBalls) and (it.strikes == expectedStrikes)
        }
    }

    companion object {
        @JvmStatic
        @BeforeAll
        fun setup() {
            println("Setting")
        }
    }
}