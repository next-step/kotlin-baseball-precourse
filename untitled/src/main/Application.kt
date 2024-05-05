import kotlin.random.Random

fun main() {
    val tmp = mutableListOf<Int>()
    while (tmp.size < 3) {
        tmp.add(Random.nextInt(9))
    }

    //val answer = tmp.joinToString("").toInt()
    //print(answer)

    println("세 개의 숫자를 입력하세요(123처럼 빈칸 없이): ")
    val input = readLine() ?: throw IllegalArgumentException("입력이 null입니다.")

    val inputNum = input.takeIf { it.length == 3 }?.map { it.toString().toInt() }
        ?: throw IllegalArgumentException("올바른 입력값이 아닙니다!")
    //print(inputNum)
}