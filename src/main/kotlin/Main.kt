package baseball

fun main() {
    // 프로그램 실행부
}

fun generateAnswer(): String {
    val numbers = (1..9).shuffled().take(3)
    return numbers.joinToString("")
}

fun checkInputIfValid(input: String): Boolean {
    return input.length == 3 && input.all { it.isDigit() && it != '0' } && input.toSet().size == 3
}

fun evaluate(input: String, answer: String): String {
    var strikes = 0
    var balls = 0

    input.forEachIndexed { index, num ->
        when (num) {
            answer[index] -> strikes++
            in answer -> balls++
        }
    }

    val result = when {
        strikes == 0 && balls == 0 -> "낫싱"
        strikes > 0 && balls == 0 -> "${strikes}스트라이크"
        strikes == 0 && balls > 0 -> "${balls}볼"
        else -> "${balls}볼 ${strikes}스트라이크"
    }

    println(result)

    return result
}