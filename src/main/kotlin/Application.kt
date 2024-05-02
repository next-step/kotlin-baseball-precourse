import kotlin.random.Random

fun main() {
    var playAgain = true
    while (playAgain) {
        val computerNumbers = generateComputerNumbers()
        playGame(computerNumbers)
        playAgain = askForAnotherGame()
    }
    println("게임이 종료되었습니다.")
}

fun playGame (computerNumbers: List<Int>) {
    var gameOver = false
    while (!gameOver) {
        val userInput = getUserInput()
        val userNumbers = parseUserInput(userInput)
        if (!isValidInput(userNumbers)) {
            throw IllegalArgumentException("애플리케이션 종료")
        }
        val (strikes, balls) = calculateResult(computerNumbers, userNumbers)
        if (strikes == 3) {
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            gameOver = true
        } else if (strikes != 0 || balls != 0){
            printGameResult(balls, strikes)
        } else {
            println("낫싱")
        }
    }
}
fun generateComputerNumbers(): List<Int> = List(3) { Random.nextInt(1, 10) }.distinct()
fun getUserInput(): String {}
fun isValidInput(numbers: List<Int>):
fun parseUserInput(input: String):
fun calculateResult(computerNumbers: List<Int>, userNumbers: List<Int>):
fun printGameResult(balls: Int, strikes: Int) {}
fun askForAnotherGame() : Boolean {}
