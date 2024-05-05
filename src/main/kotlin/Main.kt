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
    // 입력에 대한 평가 및 결과 출력
}