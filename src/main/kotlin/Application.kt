
fun main() {}

fun generateNumber(): String {
    val numbers = (1..9).shuffled().take(3)
    return numbers.joinToString("")
}

fun enterNumber(): String {
    print("숫자를 입력해 주세요 : ")
    var inputNumber = readLine() ?: ""
    return inputNumber
}