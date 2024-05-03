package baseball.guessing

import role.Computer
import role.Player
import utils.Constraints.DIGIT_LENGTH
import utils.Constraints.NO_BALL
import utils.Constraints.NO_STRIKE

class numGuess(
    computer: Computer,
    player: Player
) : Guess(computer, player) {

    override fun print() {
        val (strike, ball) = provideStrikeAndBall()
        when {
            (strike != NO_STRIKE && ball != NO_BALL) -> println("${ball}볼 ${strike}스트라이크")
            (strike != NO_STRIKE && ball == NO_BALL) -> println("${strike}스트라이크")
            (strike == NO_STRIKE && ball != NO_BALL) -> println("${ball}볼")
            (strike == NO_STRIKE && ball == NO_BALL) -> println("낫싱")
        }
    }

    override fun calculate() {
        val startIndex = 0
        (startIndex until DIGIT_LENGTH).forEach { index ->
            compare(index)
        }
    }

    private fun compare(index: Int) {
        when {
            computer.isEquals(index, player.find(index)) -> plusStrike()
            computer.contains(player.find(index)) -> plusBall()
        }
    }
}