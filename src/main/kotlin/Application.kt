
fun main() {
    gamePlay()
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    var choice = readLine()
    while (choice == "1") {
        gamePlay()
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        choice = readLine()
    }
}

fun generateNumber(): String {
    val numbers = (1..9).shuffled().take(3)
    return numbers.joinToString("")
}

fun enterNumber(): String {
    print("숫자를 입력해 주세요 : ")
    var inputNumber = readLine() ?: ""
    return inputNumber
}

fun validateNumber(input: String): String {
    val validRegex = Regex("^[1-9][0-9]{2}\$")

    if (!validRegex.matches(input)) {
        throw IllegalArgumentException("세 자리 자연수를 입력하세요.")
    }

    return input
}

fun calculateBallCount(inputNumber: String, answerNumber: String): String {
    var strikeCount = answerNumber.zip(inputNumber).count { it.first == it.second }
    var intersectionCount = answerNumber.toSet().intersect(inputNumber.toSet()).size
    val ballCount = intersectionCount - strikeCount
    return when {
        strikeCount > 0 && ballCount > 0 -> "${strikeCount}스트라이크 ${ballCount}볼"
        strikeCount > 0 -> "${strikeCount}스트라이크"
        ballCount > 0 -> "${ballCount}볼"
        else -> "낫싱"
    }
}

fun gamePlay() {
    val answerNumber = generateNumber()
    var strikeOut = false

    while (!strikeOut) {
        val inputNumber = enterNumber()
        val validInputNumber = validateNumber(inputNumber)
        val result = calculateBallCount(validInputNumber, answerNumber)
        println(result)
        if (result.startsWith("3스트라이크")) {
            println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
            strikeOut = true
        }
    }
}