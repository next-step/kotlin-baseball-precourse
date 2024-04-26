private sealed class GameState {
    data object BeforeStart: GameState()
    data object OnGoing: GameState()
    data object GameEnd: GameState()
}

private class GameController {
    var gameState: GameState = GameState.BeforeStart

    fun startGame() {
        gameState = GameState.OnGoing
    }

    fun endGame() {
        gameState = GameState.GameEnd
    }
}

private class Computer(val gameController: GameController) {
    val randomNumber: Array<Int> = setNumber()

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
        var inputNumberState: Boolean = inputChecker.checkInput(userInput)
        while (!inputNumberState) {
            userInput = getUserInput()
            inputNumberState = inputChecker.checkInput(userInput)
        }

        val result: Array<Int> = Array(3) { 0 }
        result[0] = userInput[0].digitToInt()
        result[1] = userInput[1].digitToInt()
        result[2] = userInput[2].digitToInt()

        return result
    }

    fun getUserGameStatusInput(): Int {
        print("숫자를 입력해 주세요 : ")
        return 0
    }
}

private class InputChecker {
    fun checkInput(userInput: String): Boolean {
        return isInt(userInput) && isThreeDigit(userInput) && notDuplicated(userInput)
    }

    private fun isInt(userInput: String): Boolean {
        return try {
            userInput.toInt()
            true
        } catch (e: NumberFormatException) {
            println("1부터 9까지 서로 다른 수로 이루어진 3자리수를 입력하세요.")
            false
        }
    }

    private fun isThreeDigit(userInput: String): Boolean {
        val num = userInput.toInt()
        if (num % 1000 == 0) {
            return true
        }
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

}