import kotlin.random.Random

class BaseballGame {
    private var continueGame = true

    fun start() {
        while (continueGame) {
            val answer = setComputer()  //컴퓨터가 선택한 숫자
            performPlayerAction(answer)
            continueGame = confirmGameExit()
        }
    }
    //숫자 맞히기
    private fun performPlayerAction(answer: IntArray) {
        var continueInput = true
        while (continueInput) {
            //println("Computer : ${answer.joinToString()}")    //테스트를 위한 코드
            val guess = getPlayerInput()
            val result = compareAnswerGuess(answer, guess)
            continueInput = printResult(result)
        }
    }
    //컴퓨터가 1에서 9까지 서로 다른 임의의 수 3개 선택
    private fun setComputer(): IntArray {
        val answer = mutableListOf<Int>()
        while (answer.size < 3) {
            answer.add(Random.nextInt(1, 10))
        }
        return answer.toIntArray()
    }
    //게임 플레이어가 1에서 9까지 3개의 숫자를 입력
    private fun getPlayerInput(): IntArray {
        println("Enter three numbers (without blanks like 123): ")
        val input = readLine()
        val guess = input?.let {
            if (it.length != 3 || !it.all { char -> char.isDigit() })
                throw IllegalArgumentException("Input must be three digits!")
            it.map { char -> char.toString().toInt() }.toIntArray()
        } ?: throw IllegalArgumentException("No input provided!")
        return guess
    }
    //컴퓨터가 선택한 숫자와 게임 플레이어가 입력한 숫자를 비교
    //같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱
    private fun compareAnswerGuess(answer: IntArray, guess: IntArray): String {
        var strikes = 0
        var balls = 0

        for (i in answer.indices) {
            if (answer[i] == guess[i]) {
                strikes++
            } else if (answer.contains(guess[i])) {
                balls++
            }
        }

        return when {
            strikes == 3 -> "3 strikes"
            strikes > 0 && balls > 0 -> "$strikes strike, $balls ball"
            strikes > 0 -> "$strikes strike"
            balls > 0 -> "$balls ball"
            else -> "nothing"
        }
    }
    //비교한 결과를 출력 (3개의 숫자를 모두 맞히지 못한 경우 결과가 힌트의 기능을 함)
    //3개의 숫자를 모두 맞히면 게임 종료
    private fun printResult(result: String): Boolean {
        println("Result: $result")
        if (result == "3 strikes") {
            println("You got all 3 numbers right! Game over")
            return false
        } else return true
    }
    //게임이 종료된 후 게임을 다시 시작하거나 완전히 종료
    private fun confirmGameExit(): Boolean {
        println("Enter 1 to start a new game or 2 to end the game")
        val input = readLine()?.trim()
        return when (input) {
            "1" -> true
            "2" -> false
            else -> {
                println("Invalid input. Please enter 1 for new game or 2 to exit.")
                confirmGameExit()
            }
        }
    }
}

fun main() {
    val game = BaseballGame()
    game.start()
}