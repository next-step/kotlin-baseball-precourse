fun main() { //기본 게임 구현
    val game = BaseballGame()
    game.play()
}

class BaseballGame {
    val targetNumbers: List<Int> = generateTargetNumbers() //public

    fun play() { //public test 가능, private 불가
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
                    return //잘못된 값 완전히 종료. isGameEnd=true시 종료조건문 반복.
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

    fun checkInput(userInput: String?, targetNumbers: List<Int>): String { //public 가능
        if (userInput == null || userInput.length != 3 || !userInput.all { it.isDigit() }) {
            throw IllegalArgumentException("Invalid input")
        }

        val userNumbers = userInput.map { it.toString().toInt() }
        val strikes = userNumbers.zip(targetNumbers).count { it.first == it.second }
        val balls = userNumbers.intersect(targetNumbers).size - strikes

        return when {
            strikes == 3 -> "3스트라이크"
            strikes > 0 || balls > 0 -> "${balls}볼 ${strikes}스트라이크"
            else -> "낫싱"
        }
    }
}