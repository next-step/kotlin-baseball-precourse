sealed class GameState {
    data object IsLoading : GameState() // 1. 게임 시작 전  2. 게임 종료 후 플레이어에게 상태를 입력받기 전
    data object OnGoing : GameState()
    data object End : GameState()
}

class GameStateManager {
    private var gameState: GameState = GameState.IsLoading

    fun changeGameState(state: GameState) {
        this.gameState = state
    }

    fun getGameState(): GameState {
        return gameState
    }
}

class RandomNumberGenerator {
    fun setNumber(): Array<Int> {
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
}

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

class Player {
    private fun getUserInput(): String {
        return readlnOrNull() ?: ""
    }

    fun getUserNumberInput(inputChecker: InputChecker): Array<Int> {
        print("숫자를 입력해 주세요 : ")
        val userInput: String = getUserInput()
        inputChecker.checkThreeDigitInput(userInput)

        return getArrayInput(userInput)
    }

    private fun getArrayInput(userInput: String): Array<Int> {
        val result: Array<Int> = Array(3) { 0 }
        result[0] = userInput[0].digitToInt()
        result[1] = userInput[1].digitToInt()
        result[2] = userInput[2].digitToInt()

        return result
    }

    fun getUserGameStatusInput(inputChecker: InputChecker): Int {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val userInput: String = getUserInput()
        inputChecker.checkOneDigitInput(userInput)

        return userInput.toInt()
    }
}

class InputChecker {
    fun checkThreeDigitInput(userInput: String) {
        assertIntType(userInput)
        assertThreeDigit(userInput)
        assertDuplication(userInput)
    }

    fun checkOneDigitInput(userInput: String) {
        assertIntType(userInput)
        assertOneOrTwo(userInput)
    }

    private fun assertOneOrTwo(userInput: String) {
        val num = userInput.toInt()
        if (num == 1 || num == 2) {
            return
        }
        throw IllegalArgumentException ("입력값이 1 또는 2가 아닙니다.")
    }

    private fun assertIntType(userInput: String) {
        try {
            userInput.toInt()
            return
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException ("입력값이 정수가 아닙니다.")
        }
    }

    private fun assertThreeDigit(userInput: String) {
        if (userInput.length == 3) {
            return
        }
        throw IllegalArgumentException ("입력값이 세 자리수가 아닙니다.")
    }

    private fun assertDuplication(userInput: String){
        if (userInput[0] == userInput[1]) {
            throw IllegalArgumentException ("입력값에 중복이 존재합니다.")
        }
        if (userInput[1] == userInput[2]) {
            throw IllegalArgumentException ("입력값에 중복이 존재합니다.")
        }
        if (userInput[2] == userInput[0]) {
            throw IllegalArgumentException ("입력값에 중복이 존재합니다.")
        }
        return
    }
}

class GameManager {
    fun manageGame(gameStateManager: GameStateManager) {

        while (gameStateManager.getGameState() != GameState.End) {
            gameStateManager.changeGameState(GameState.OnGoing)

            val computer = Computer(RandomNumberGenerator().setNumber())
            val player = Player()
            val inputChecker = InputChecker()

            playGame(gameStateManager, player, computer, inputChecker)
            val userInput = player.getUserGameStatusInput(inputChecker)
            when (userInput) {
                1 -> continue
                2 -> gameStateManager.changeGameState(GameState.End)
            }
        }
    }

    private fun playGame(gameStateManager: GameStateManager, player: Player, computer: Computer, inputChecker: InputChecker) {
        while (gameStateManager.getGameState() == GameState.OnGoing) {
            val userInput = player.getUserNumberInput(inputChecker)
            computer.printResult(userInput, gameStateManager)
        }
    }
}

fun main() {
    val gameStateManager = GameStateManager()
    val gameManager = GameManager()

    gameManager.manageGame(gameStateManager)
}