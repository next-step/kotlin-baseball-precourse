import kotlin.random.Random

fun main() {
    val answerNumList = setRandomNumber(3)
    val inputNumList = inputNumber()
}

// 세자리 랜덤 숫자 생성
fun setRandomNumber(length: Int) : List<Int> {
    val randomNum = mutableListOf<Int>()
    while (randomNum.size < length) {
        val num = Random.nextInt(1,9)
        if (!randomNum.contains(num))
            randomNum.add(num)
    }
    return randomNum
}

// 숫자 입력
fun inputNumber() : MutableList<Int> {
    print("숫자를 입력해주세요 : ")
    val inputNum = readlnOrNull() ?: ""
    val inputNumList = inputNum.map { it.toString().toInt() }.toMutableList()

    return inputNumList
}