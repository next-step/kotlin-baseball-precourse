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
fun getUserInput(): String {print("숫자를 입력해 주세요 : ")
    return readLine() ?: throw new IllegalArgumentException()
}
fun isValidInput(numbers: List<Int>):Boolean = numbers.size == 3 && numbers.all { it in 1..9 }
fun parseUserInput(input: String):List<Int> = input.trim().map { it.toString().toInt() }
fun calculateResult(computerNumbers: List<Int>, userNumbers: List<Int>):
fun printGameResult(balls: Int, strikes: Int) {}
fun askForAnotherGame() : Boolean {}
