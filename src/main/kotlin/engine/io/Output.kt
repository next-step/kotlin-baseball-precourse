package engine.io

import engine.BallCount

interface Output {
    fun displayBallCount(ballCount: BallCount)

    fun displayInputError(errorMessage: String?)

    fun displayCorrectMessage()

}
