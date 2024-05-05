import kotlin.random.Random

fun main() {
    val computerInput = generateComputerNumber()
    val userInput = inputUserNumber()
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