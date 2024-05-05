import kotlin.random.Random

fun main() {
    var checkReplayFlag = true
    while (checkReplayFlag) {
        val computerInput = generateComputerNumber()
        var checkResultFlag = true
        while (checkResultFlag) {
            val userInput = inputUserNumber()
            isValidInput(userInput)
            val (strikes, balls) = calculateResult(computerInput, userInput)
            printResult(strikes, balls)
            checkResultFlag = checkResult(strikes)
        }
        checkReplayFlag = selectReplay()
    }
}

fun generateComputerNumber(): String {
    val numbers = mutableListOf<Int>()
    while (numbers.size < 3) {
        val randomNumber = Random.nextInt(1, 10)
        if (!numbers.contains(randomNumber)) {
            numbers.add(randomNumber)
        }
    }
    return numbers.joinToString("")
}

fun inputUserNumber(): String {
    print("숫자를 입력해 주세요 : ")
    return readlnOrNull() ?: ""
}

fun isValidInput(input: String) {
    if (input.length != 3 || !input.all { it.isDigit() }) {
        throw IllegalArgumentException("1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 입력해주세요.")
    }
}

fun calculateResult(computerInput: String, userInput: String): Pair<Int, Int> {
    var strikes = 0
    var balls = 0
    for (i in computerInput.indices) {
        if (computerInput[i] == userInput[i]) {
            strikes++
        } else if (computerInput.contains(userInput[i])) {
            balls++
        }
    }
    return Pair(strikes, balls)
}

fun printResult(strikes: Int, balls: Int) {
    when {
        strikes > 0 && balls > 0 -> println("${balls}볼 ${strikes}스트라이크")
        strikes > 0 -> println("${strikes}스트라이크")
        balls > 0 -> println("${balls}볼")
        else -> println("낫싱")
    }
}

fun checkResult(strikes: Int): Boolean {
    if (strikes == 3) {
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        return false
    } else {
        return true
    }
}

fun selectReplay(): Boolean {
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    val selection = readlnOrNull() ?: ""
    return selection == "1"
}