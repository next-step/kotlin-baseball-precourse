
fun main() {}

fun generateNumber(): String {
    val numbers = (1..9).shuffled().take(3)
    return numbers.joinToString("")
}
