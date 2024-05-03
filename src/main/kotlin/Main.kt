private sealed class GameState {
    data object IsLoading: GameState() // 1. 게임 시작 전  2. 게임 종료 후 플레이어에게 상태를 입력받기 전
    data object OnGoing: GameState()
    data object End: GameState()
}

private class GameController {
    var gameState: GameState = GameState.IsLoading

    fun startGame() {
        gameState = GameState.OnGoing
    }

    fun endGame() {
        gameState = GameState.GameEnd
    }
}

private class Computer {
    private val randomNumber: Array<Int> = setNumber()

    private fun setNumber(): Array<Int> {
        val number: Array<Int> = Array(3) { 0 }
        number[0] = getRandomNumber(number)
        number[1] = getRandomNumber(number)
        number[2] = getRandomNumber(number)

        return number
    }

    private fun getRandomNumber(numbers: Array<Int>): Int {
        var result = (1..9).random()
        while (numbers.contains(result)) {
            result = (1..9).random()
        }
        return result
    }

    fun printResult(userInputNumber: Array<Int>, gameController: GameController) {
        val strike: Int = countStrike(userInputNumber)
        val ball: Int = countBall(userInputNumber)

        if (strike == 3) {
            println("3스트라이크")
            println("3개의 숫자를 모두 맞히셨습니다!게임종료")
            gameController.endGame()
        }
        when {
            strike == 0 && ball == 0 -> println("낫싱")
            strike == 0 -> println("${ball}볼")
            ball == 0 -> println("${strike}스트라이크")
            else -> println("${ball}볼 ${strike}스트라이크")
        }
    }

    private fun countStrike(userInputNumber: Array<Int>): Int {
        var strike: Int = 0
        if (userInputNumber[0] == randomNumber[0]) strike++
        if (userInputNumber[1] == randomNumber[1]) strike++
        if (userInputNumber[2] == randomNumber[2]) strike++

        return strike
    }

    private fun countBall(userInputNumber: Array<Int>): Int {
        var ball: Int = 0
        if (userInputNumber[0] == randomNumber[1] || userInputNumber[0] == randomNumber[2]) ball++
        if (userInputNumber[1] == randomNumber[0] || userInputNumber[1] == randomNumber[2]) ball++
        if (userInputNumber[2] == randomNumber[0] || userInputNumber[2] == randomNumber[1]) ball++

        return ball
    }
}

private class Player {
    private fun getUserInput(): String {
        return readlnOrNull() ?: ""
    }

    fun getUserNumberInput(inputChecker: InputChecker): Array<Int> {
        print("숫자를 입력해 주세요 : ")
        var userInput: String = getUserInput()
        var inputNumberState: Boolean = inputChecker.checkThreeDigitInput(userInput)
        while (!inputNumberState) {
            print("숫자를 입력해 주세요 : ")
            userInput = getUserInput()
            inputNumberState = inputChecker.checkThreeDigitInput(userInput)
        }

        val result: Array<Int> = Array(3) { 0 }
        result[0] = userInput[0].digitToInt()
        result[1] = userInput[1].digitToInt()
        result[2] = userInput[2].digitToInt()

        return result
    }

    fun getUserGameStatusInput(inputChecker: InputChecker): Int {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        var userInput: String = getUserInput()
        var inputNumberState: Boolean = inputChecker.checkOneDigitInput(userInput)
        while (!inputNumberState) {
            userInput = getUserInput()
            inputNumberState = inputChecker.checkOneDigitInput(userInput)
        }

        return userInput.toInt()
    }
}

private class InputChecker {
    fun checkThreeDigitInput(userInput: String): Boolean {
        return isInt(userInput) && isThreeDigit(userInput) && notDuplicated(userInput)
    }

    fun checkOneDigitInput(userInput: String): Boolean {
        return isInt(userInput) && isOneOrTwo(userInput)
    }

    private fun isOneOrTwo(userInput: String): Boolean {
        val num = userInput.toInt()
        if (num == 1 || num == 2) {
            return true
        }
        println("입력값이 1 또는 2가 아닙니다.")
        return false
    }

    private fun isInt(userInput: String): Boolean {
        return try {
            userInput.toInt()
            true
        } catch (e: NumberFormatException) {
            println("입력값이 정수가 아닙니다.")
            false
        }
    }

    private fun isThreeDigit(userInput: String): Boolean {
        if (userInput.length == 3) {
            return true
        }
        println("입력값이 세 자리수가 아닙니다.")
        return false
    }

    private fun notDuplicated(userInput: String): Boolean {
        if (userInput[0] == userInput[1]) {
            return false
        }
        if (userInput[1] == userInput[2]) {
            return false
        }
        if (userInput[2] == userInput[0]) {
            return false
        }
        return true
    }
}

fun main() {
    val gameController = GameController()
    val computer = Computer()
    val player = Player()
    val inputChecker = InputChecker()

    gameController.gameState = GameState.OnGoing
    while (gameController.gameState == GameState.OnGoing) {
        val userInput = player.getUserNumberInput(inputChecker)
        computer.printResult(userInput, gameController)
    }
}