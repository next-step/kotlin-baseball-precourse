fun main() { //기본 게임 구현
    val game = BaseballGame()
    game.play()
}

class BaseballGame {
    val targetNumbers: List<Int> = generateTargetNumbers()

    fun play() {
        var isRestarting = true

        while (isRestarting) {
            var isGameEnd = false

            while (!isGameEnd) {
                print("숫자를 입력해 주세요 : ")
                val userInput = readLine()
                try {
                    val result = checkInput(userInput, targetNumbers) // targetNumbers 전달
                    println(result)
                    if (result == "3스트라이크") {
                        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
                        isGameEnd = true
                    }
                } catch (e: IllegalArgumentException) {
                    return
                }
            }

            print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ")
            val restartInput = readLine()
            isRestarting = restartInput?.trim() == "1"
        }
    }
    private fun generateTargetNumbers(): List<Int> {
        val numbers = mutableListOf<Int>()
        while (numbers.size < 3) {
            val randomNumber = (1..9).random()
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber)
            }
        }
        return numbers
    }
}