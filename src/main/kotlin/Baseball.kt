import kotlin.random.Random

fun main() {
    do {
        // 프로그램 첫 실행 시 조건없이 시작
        val length = 3
        val answerNumList = setRandomNumber(length)

        // 3 스트라이크가 될 때 까지 반복
        do {
            val inputNumList = inputNumber()
            val (strike, ball) = countStrikeBall(answerNumList, inputNumList, length)
            printDecision(strike, ball)
        } while (strike != 3)
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val flag = readlnOrNull()?.toInt()

    } while (flag != 2)


}

// 세자리 랜덤 숫자 생성
fun setRandomNumber(length: Int): List<Int> {
    val randomNum = mutableListOf<Int>()
    while (randomNum.size < length) {
        val num = Random.nextInt(1, 9)
        if (!randomNum.contains(num))
            randomNum.add(num)
    }
    return randomNum
}

// 숫자 입력
fun inputNumber(): MutableList<Int> {
    print("숫자를 입력해주세요 : ")
    val inputNum = readlnOrNull() ?: ""
    val inputNumList = inputNum.map { it.toString().toInt() }.toMutableList()

    return inputNumList
}

// 스트라이크, 볼 카운트
fun countStrikeBall(randomList: List<Int>, numList: List<Int>, length: Int): Pair<Int, Int> {
    var strike: Int = 0
    var ball: Int = 0
    for (i in 0..length) {
        if (numList[i] in randomList) {
            if (numList[i] == randomList[i])
                strike += 1
            else
                ball += 1
        }
    }
    return Pair(strike, ball)
}

// 비교 결과 출력
fun printDecision(strike: Int, ball: Int) {
    val result = when {
        (strike == 0 && ball == 0) -> "낫싱"
        (ball == 0) -> String.format("%d스트라이크", strike)
        (strike == 0) -> String.format("%d볼", ball)
        else -> String.format("%d볼 %d스트라이크", ball, strike)
    }
    println(result)
}