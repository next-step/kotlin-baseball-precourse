import kotlin.random.Random

fun main() {
    val computerInput = generateComputerNumber()
    val userInput = inputUserNumber()
    isValidInput(userInput)
    val (strikes, balls) = calculateResult(computerInput, userInput)
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