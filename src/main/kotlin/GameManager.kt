class GameManager {
    private var computer: Computer = Computer()
    private val userInterface: UserInterface = UserInterface()
    private var isGameRestart: Int = 1
    private var isGameEnd: Boolean = true

    private fun initGame() {
        computer = Computer()
        isGameEnd = false
    }

    private fun startGame() {
        while (isGameRestart == 1) {
            initGame()
            playGameContinue()
        }
    }

    private fun playGameContinue() {
        while (!isGameEnd) {
            val inputNumber: List<Int> = userInterface.inputThreeNumber()
            val strikeAndBallCountList: List<Int> =
                computer.compareInputWithCorrectNumber(inputNumber)
            userInterface.printResult(strikeAndBallCountList)
            checkGameEnd(strikeAndBallCountList)
        }
    }

    private fun checkGameEnd(strikeAndBallCountList: List<Int>) {
        val strikeIndex = 0
        if (strikeAndBallCountList[strikeIndex] == 3) {
            isGameEnd = true
            isGameRestart = userInterface.inputGameRestart()
        }
    }

    fun startGamePlayWithExceptionChecker() {
        try {
            startGame()
        } catch (e: IllegalArgumentException) {
            println("잘못된 입력 감지. ${e.message}, 게임을 종료합니다.")
        }
    }
}