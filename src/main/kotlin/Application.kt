fun main() {
    var playAgain = true
    while (playAgain) {
        val computerNumbers = generateComputerNumbers()
        playGame(computerNumbers)
        playAgain = askForAnotherGame()
    }
    println("게임이 종료되었습니다.")
}

fun generateComputerNumbers(): List<Int> {}
fun playGame (computerNumbers: List<Int>) {}
fun askForAnotherGame() : Int {}
