package baseball.game

import baseball.guessing.numGuess
import baseball.guessing.Guess
import utils.computer
import utils.Constraints.ANSWER_BALL
import utils.Constraints.ANSWER_STRIKE
import utils.Constraints.CORRECT_AND_FINISH
import utils.Constraints.YES_RESTART
import utils.PlayerConsole
class BaseballGame : Game {
    override fun start() {
        do {
            startGame()
        } while (restart())
    }

    override fun restart(): Boolean =
        PlayerConsole.enterRestart() == YES_RESTART

    private fun startGame() {
        val computer = computer.create()

        do {
            val player = PlayerConsole.enterAnswer()

            val guessing: Guess = numGuess(computer, player)
            guessing.print()

            val (strike, ball) =guessing.provideStrikeAndBall()

        } while (!isAnswer(strike, ball))

        println(CORRECT_AND_FINISH)
    }

    private fun isAnswer(strike: Int, ball: Int): Boolean =
        (strike == ANSWER_STRIKE && ball == ANSWER_BALL)
}