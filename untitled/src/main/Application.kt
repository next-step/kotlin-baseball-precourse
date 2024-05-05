import kotlin.random.Random

fun main() {
    val tmp = mutableListOf<Int>()
    while (tmp.size < 3) {
        tmp.add(Random.nextInt(9))
    }

    val answer = tmp.joinToString("").toInt()
    //print(answer)

    val inputNum = mutableListOf<Int>()

    println("세 개의 숫자를 입력하세요(123처럼 빈칸 없이): ")
    val input = readLine()

    if (input != null && input.length == 3){
        for (char in input) {
            val num = char.toString().toInt()
            inputNum.add(num)
        }
    }
    //print(inputNum)
}