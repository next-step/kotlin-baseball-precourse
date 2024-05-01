fun main() {
    var answer: List<Int> = createAnswer()
}
// 상대방 기능
fun createAnswer(): List<Int> {
    val range = (1..9)
    val numbers = mutableSetOf<Int>()
    while (numbers.size < 3) {
        numbers.add(range.random())
    }
    val answer: List<Int> = numbers.toList()
    return answer
}
// 시스템 기능
