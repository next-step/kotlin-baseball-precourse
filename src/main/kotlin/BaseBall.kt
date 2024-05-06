fun main() {
    do {
        val game = Game()
        game.playGame()
    } while (game.gameRestart())
}

class Game{
    var computerNumber = randomNumber()

    //컴퓨터: 1~9 서로 다른 임의의 수 3개 랜덤 생성
    fun randomNumber(): List<Int> {
        return (1..9).shuffled().take(3)
    }

    //플레이어: 3개 숫자 입력
    //예외 처리
    fun playerInput(): List<Int> {
        print("숫자를 입력해 주세요 : ")
        val input = readLine() ?: throw IllegalArgumentException("입력이 없습니다")
        validateInput(input)
        return input.map { it.toString().toInt() }
    }

    fun validateInput(input: String) {
        if (input.length != 3 || !input.all { it.isDigit() } || input.toSet().size != 3 || input.any { it < '1' || it > '9' }) {
            throw IllegalArgumentException("1~9까지 서로 다른 수로 이루어진 3자리의 숫자를 입력하세요.")
        }
    }

    //랜덤 생성 숫자(컴퓨터)와 입력 숫자(플레이어) 비교
    fun numberCompare(guess: List<Int>): Pair<Int, Int> {
        return guess.foldIndexed(Pair(0, 0)) { index, acc, number ->
            when {
                number == computerNumber[index] -> acc.copy(first = acc.first + 1)
                number in computerNumber -> acc.copy(second = acc.second + 1)
                else -> acc
            }
        }
    }

    //출력
    fun printResult(strikes: Int, balls: Int) {
        when{
            strikes == 0 && balls == 0 -> println("낫싱")
            strikes > 0 && balls == 0 -> println("${strikes}스트라이크")
            strikes == 0 && balls > 0 -> println("${balls}볼")
            else -> println("${balls}볼 ${strikes}스트라이크")
        }
    }

    //정답 시 게임 종료
    fun playGame() {
        var strike = 0
        while(strike != 3) {
            val guess = playerInput()
            val (strikes, balls) = numberCompare(guess)
            strike = strikes
            printResult(strike, balls)
        }
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    }

    //게임 재시작 or 게임 종료
    fun gameRestart(): Boolean {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        return when (readLine()) {
            "1" -> true
            "2" -> false
            else -> false
        }
    }
}