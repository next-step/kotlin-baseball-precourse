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

                } catch() {


                }
            }
            print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ")
            val restartInput = readLine()
            isRestarting = restartInput?.trim() == "1"
        }
    }
}