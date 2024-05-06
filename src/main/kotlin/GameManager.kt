class GameManager constructor(){
    var computerNumber: String = ""

    fun newGame() {
        while(true) {
            setComputerNumber()
            start()
            if (!isReGame()) return
        }
    }
    private fun setComputerNumber(){
        val numbers = (1..9).toList().shuffled().take(3)
        this.computerNumber = numbers.joinToString("")
//        println(this.computerNumber)
    }
    private fun start() {
        while (true) {
            var guessNumber: String = guessNumber()
            checkNumber(guessNumber)

            var (strikes, balls) = markNumber(guessNumber)
            printScores(strikes, balls)
            if (strikes == 3) {
                println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
                break
            }
        }
    }
    private fun guessNumber(): String {
        print("숫자를 입력해 주세요 : ")
        return readLine().toString()
    }
    private fun checkNumber(guessNumber: String) {
        // 입력 값이 3자리 숫자가 아니거나, 중복된 숫자를 포함하는 경우 예외 발생
        if (guessNumber.length != 3 || guessNumber.toSet().size != 3) {
            throw IllegalArgumentException("잘못된 입력입니다. 서로 다른 3자리 숫자를 입력해주세요.")
        }
    }

    private fun markNumber(guessNumber: String): Pair<Int, Int> {
        var strikes = 0
        var balls = 0

        guessNumber.forEachIndexed { index, c ->
            if (c == computerNumber[index]) {
                // 같은 위치에 같은 숫자가 있는 경우, 스트라이크
                strikes++
            } else if (c in computerNumber) {
                // 다른 위치에 숫자가 있는 경우, 볼
                balls++
            }
        }
        return Pair(strikes, balls)
    }

    private fun printScores(strikes: Int, balls: Int) {
        when {
            strikes != 0 && balls != 0 -> println("${balls}볼 ${strikes}스트라이크")
            strikes != 0 -> println("${strikes}스트라이크")
            balls != 0 -> println("${balls}볼")
            else -> println("낫싱")
        }
    }
    private fun isReGame():Boolean {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val number: String = readLine().toString()
        when{
            number.equals("1") -> return true
            else -> return false
        }
    }
}

fun main() {
    val gameManager: GameManager = GameManager()
    gameManager.newGame()
}