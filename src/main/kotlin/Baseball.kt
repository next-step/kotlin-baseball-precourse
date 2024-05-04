import kotlin.random.Random

fun main() {
    do {
        // 프로그램 첫 실행 시 조건없이 시작
        val length = 3
        val answerNumList = setRandomNumber(length)

        // 3 스트라이크가 될 때 까지 반복
        do {
            val inputNumList = inputNumber()
            // 3개의 숫자 입력 예외 처리
            inputNumberException(inputNumList)

            val (strike, ball) = countStrikeBall(answerNumList, inputNumList, length)
            printDecision(strike, ball)
        } while (strike != 3)
        println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val flag = readlnOrNull()?.toInt()
        flagException(flag)
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

// 3개의 숫자 입력 예외 처리
fun inputNumberException(numList: List<Int>) {
    // 세자리 수 입력에서 중복된 숫자가 있는 예외
    var isDuplication = false
    for (i in numList) {
        if (numList.count { it == i } > 1) {
            isDuplication = true
            break
        }
    }

    when {
        (numList.size != 3) -> throw IllegalArgumentException("잘못된 입력: 3개의 숫자가 아닙니다.")
        (numList.any { it == 0 }) -> throw IllegalArgumentException("잘못된 입력: 숫자 0은 입력할 수 없습니다.")
        (isDuplication) -> throw IllegalArgumentException("잘못된 입력: 중복된 숫자가 있습니다.")
    }
}

// 재시작 조건 입력 예외 처리
fun flagException(flag: Int?) {
    if (flag == null)
        throw IllegalArgumentException("잘못된 조건 입력: 입력된 값이 없습니다.")
    if (flag != 1 && flag != 2)
        throw IllegalArgumentException("잘못된 조건 입력: 입력한 숫자가 조건에 맞지 않습니다.")
}