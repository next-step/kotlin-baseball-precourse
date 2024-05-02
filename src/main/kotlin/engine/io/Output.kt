package engine.io

import engine.BallCount

interface Output {
    fun displayBallCount(ballCount: BallCount)

    fun displayInputError()

    fun displayCorrectMessage()
}
