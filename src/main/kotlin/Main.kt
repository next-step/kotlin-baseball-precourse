package baseball

fun main() {
    while (true) {
        val targetNumbers = generateAnswer()

        println("숫자를 입력해 주세요:")
        var input = readln()

        while (!checkInputIfValid(input)) {
            throw IllegalArgumentException("잘못된 값 입력: 입력값은 서로 다른 1에서 9까지의 3자리 수여야 합니다.")
        }

        while (evaluate(input, targetNumbers) != Pair(3,0)) { // 3스트라이크일 때 반복 중단
            println("숫자를 입력해 주세요:")
            input = readln()
            if (!checkInputIfValid(input)) {
                throw IllegalArgumentException("잘못된 값 입력: 입력값은 서로 다른 1에서 9까지의 3자리 수여야 합니다.")
            }
        }

        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val option = readln()
        if (option == "2") break
    }
}

fun generateAnswer(): String {
    val numbers = (1..9).shuffled().take(3)
    return numbers.joinToString("")
}

fun checkInputIfValid(input: String): Boolean {
    return input.length == 3 && input.all { it.isDigit() && it != '0' } && input.toSet().size == 3
}

fun evaluate(input: String, answer: String): Pair<Int, Int> {
    var strikes = 0
    var balls = 0

    input.forEachIndexed { index, num ->
        when {
            num == answer[index] -> strikes++
            num in answer -> balls++
        }
    }

    return Pair(strikes, balls)
}