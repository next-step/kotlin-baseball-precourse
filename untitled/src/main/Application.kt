import kotlin.random.Random

fun main() {
    val tmp = mutableListOf<Int>()
    while (tmp.size < 3) {
        tmp.add(Random.nextInt(1, 10))
    }
    val tmpArray = tmp.toIntArray()

    println("세 개의 숫자를 입력하세요(123처럼 빈칸 없이): ")
    val input = readLine()
    val inputNum = mutableListOf<Int>()

    if (input == null || input.length != 3) {
        throw IllegalArgumentException("올바른 입력값이 아닙니다!")
    } else {
        for (char in input) {
            val num = char.toString().toInt()
            inputNum.add(num)
        }
    }

    check(inputNum.toIntArray(), tmpArray)
}