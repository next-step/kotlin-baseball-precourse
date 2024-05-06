class GameManager constructor(){
    var computerNumber: String = ""

    fun setComputerNumber(){
        val numbers = (1..9).toList().shuffled().take(3)
        this.computerNumber = numbers.joinToString("")
        println(this.computerNumber)
    }

    fun guess() {
        while(true) {
            var guessNumber: String = enterNumber()

            checkNumber(guessNumber)

            var (strikes, balls) = mark(guessNumber)
            printScores(strikes, balls)
            if(strikes == 3){
                println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
                break
            }
        }
    }

    private fun checkNumber(guessNumber: String) {
        // 입력 값이 3자리 숫자가 아니거나, 중복된 숫자를 포함하는 경우 예외 발생
        if (guessNumber.length != 3 || guessNumber.toSet().size != 3) {
            throw IllegalArgumentException("잘못된 입력입니다. 서로 다른 3자리 숫자를 입력해주세요.")
        }
    }

    private fun enterNumber(): String {
        print("숫자를 입력해 주세요 : ")
        return readLine().toString()
    }

    private fun mark(guessNumber: String): Pair<Int, Int> {
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


}

fun main() {
    val gameManager: GameManager = GameManager()
    gameManager.setComputerNumber()
    gameManager.guess()
}