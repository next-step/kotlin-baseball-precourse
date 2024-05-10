class Application {

    fun play(){
        while (true) {

            // 정답 생성
            val answer = Answer()

            // 게임 루프
            while (true) {
                println("숫자를 입력해 주세요 :")

                // 숫자 입력
                val guess = readLine()

                // 예외 처리
                try {
                    // 입력이 널이거나 3자리가 아니거나 숫자가 아니면 예외 발생
                    if (guess == null || guess.length != 3 || !guess.all { it.isDigit() }) {
                        throw IllegalArgumentException("잘못된 입력입니다. 세 자리 숫자를 입력하세요.")
                    }

                    // 정답 체크
                    val result = check(answer, guess)
                    println(result)
                    println("--------------------")

                    if (result == "3스트라이크") {
                        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
                        println("--------------------")
                        break
                    }
                } catch (e: IllegalArgumentException) {
                    println("--------------------")
                    println(e.message)
                    println("--------------------")
                    return
                }
            }

            println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
            val choice = readLine()

            when (choice) {
                "1" -> continue
                "2" -> {
                    println("게임을 종료합니다.")
                    return
                }
                else -> {
                    println("잘못된 입력입니다. 다시 입력하세요.")
                    println("--------------------")
                }
            }
        }
    }

    // 정답 생성
    fun Answer(): String {
        val digits = ('0'..'9').toList()
        return digits.shuffled().take(3).joinToString("")
    }

    // 정답 체크
    fun check(answer: String, guess: String): String {
        var strikes = 0
        var balls = 0

        // 각 자리수 비교
        for ((index, digit) in guess.withIndex()) {
            if (digit == answer[index]) {
                strikes++
            } else if (digit in answer) {
                balls++
            }
        }

        return when {
            strikes == 3 -> "3스트라이크"
            strikes > 0 && balls > 0 -> "${balls}볼 ${strikes}스트라이크"
            strikes > 0 -> "${strikes}스트라이크"
            balls > 0 -> "${balls}볼"
            else -> "낫싱"
        }
    }
}

// main 시작
fun main() {
    val app = Application()
    app.play()
}
