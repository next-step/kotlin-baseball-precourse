class Computer(private val randomNumber: Array<Int>) {
    fun printResult(userInputNumber: Array<Int>, gameStateManager: GameStateManager) {
        val strike: Int = countStrike(userInputNumber)
        val ball: Int = countBall(userInputNumber)

        if (strike == 3) {
            println("3스트라이크")
            println("3개의 숫자를 모두 맞히셨습니다!게임종료")
            gameStateManager.changeGameState(GameState.IsLoading)
        } else {
            when {
                strike == 0 && ball == 0 -> println("낫싱")
                strike == 0 -> println("${ball}볼")
                ball == 0 -> println("${strike}스트라이크")
                else -> println("${ball}볼 ${strike}스트라이크")
            }
        }
    }

    private fun countStrike(userInputNumber: Array<Int>): Int {
        var strike = 0
        if (userInputNumber[0] == randomNumber[0]) strike++
        if (userInputNumber[1] == randomNumber[1]) strike++
        if (userInputNumber[2] == randomNumber[2]) strike++

        return strike
    }

    private fun countBall(userInputNumber: Array<Int>): Int {
        var ball = 0
        if (userInputNumber[0] == randomNumber[1] || userInputNumber[0] == randomNumber[2]) ball++
        if (userInputNumber[1] == randomNumber[0] || userInputNumber[1] == randomNumber[2]) ball++
        if (userInputNumber[2] == randomNumber[0] || userInputNumber[2] == randomNumber[1]) ball++

        return ball
    }
}