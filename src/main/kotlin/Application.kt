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
            printGameResult(balls, strikes)
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
    return readlnOrNull() ?: throw IllegalArgumentException()
}
fun isValidInput(numbers: List<Int>):Boolean = numbers.size == 3 && numbers.all { it in 1..9 } && numbers.distinct().size == 3
fun parseUserInput(input: String):List<Int> = input.trim().map { it.toString().toInt() }
fun calculateResult(computerNumbers: List<Int>, userNumbers: List<Int>): Pair<Int, Int> {
    var strikes = 0
    var balls = 0
    val matchedIndices = mutableSetOf<Int>()

    for ((index, userNumber) in userNumbers.withIndex()) {
        if (userNumber == computerNumbers[index]) {
            strikes++
            matchedIndices.add(index)
        }
    }

    for ((index, userNumber) in userNumbers.withIndex()) {
        if (index !in matchedIndices && userNumber in computerNumbers) {
            balls++
        }
    }

    return Pair(strikes, balls)
}

fun printGameResult(balls: Int, strikes: Int) {
    println("$balls 볼 $strikes 스트라이크")
}
fun askForAnotherGame() : Boolean {
    print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ")
    val choice = readlnOrNull()
    return choice?.trim() == "1"
}
