package baseball.game

import baseball.guessing.numGuess
import baseball.guessing.Guess
import utils.computer
import utils.PlayerConsole

class BaseballGame: Game{
    override fun start() {
        do {
            startGame()
        } while (restart())
    }

    override fun restart(): Boolean =
        PlayerConsole.enterRestart() == "1"

    private fun startGame() {
        val computer = computer.create()

        do {
            val player = PlayerConsole.enterAnswer()

            val guessing: Guess = numGuess(computer, player)
            guessing.print()

            val (strike, ball) =guessing.provideStrikeAndBall()

        } while (!isAnswer(strike, ball))

        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    }

    private fun isAnswer(strike: Int, ball: Int): Boolean =
        (strike == 3 && ball == 0)
}
