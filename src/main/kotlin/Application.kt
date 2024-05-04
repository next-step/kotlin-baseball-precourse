import kotlin.random.Random
import java.io.BufferedReader


fun generateGoalNumber(): String {
    var number = mutableSetOf<Int>()

    while (number.size < 3) {
        val randomNumber = Random.nextInt(1, 10)
        number.add(randomNumber)
    }
    return number.joinToString("")
}

fun checkInputNumber(number: String) {
    //세 자리 숫자인지 확인
    if (number.length != 3) {
        throw IllegalArgumentException("세 자리 숫자가 아닙니다")
    }
    // 각 자리 숫자가 1~9인지 확인
    number.forEach {
        if (it !in '1'..'9') {
            throw IllegalArgumentException("각 자리의 수가 1~9 범위의 숫자가 아닙니다")
        }
    }
    // 각 자리 숫자가 서로 다른지 확인
    if (number[0] == number[1] || number[0] == number[1] || number[1] == number[2]) {
        throw IllegalArgumentException("각 자리의 수가 서로 다른 숫자가 아닙니다")
    }

}

fun printResult(strikeCount: Int, ballCount: Int) {
    val result = when {
        strikeCount > 0 && ballCount > 0 -> "${ballCount}볼 ${strikeCount}스트라이크"
        strikeCount > 0 -> "${strikeCount}스트라이크"
        ballCount > 0 -> "${ballCount}볼"
        else -> "낫싱"
    }
    println(result)
}

fun compareNumber(goalNumber: String, userNumber: String): Int {
    var strikeCount: Int = 0
    var ballCount: Int = 0

    //각 자리 값 비교
    for (i in 0..2) {
        if (userNumber[i] == goalNumber[i]) {
            strikeCount++
        } else if (userNumber[i] in goalNumber) {
            ballCount++
        }
    }
    //비교 결과 출력
    printResult(strikeCount, ballCount)
    //goalNumber와 userNumber가 동일하다면 0 리턴
    if (goalNumber == userNumber) return 0
    // goalNumber와 userNumber가 다르다면 -1 리턴
    return -1
}

fun play() {
    val br = BufferedReader(System.`in`.bufferedReader())
    val goalNumber = generateGoalNumber()
    do {
        print("숫자를 입력해 주세요 : ")
        val inputNumber = br.readLine()
        checkInputNumber(inputNumber)
    } while (compareNumber(goalNumber, inputNumber) != 0)
    println("3개의 숫자를 모두 맞히셨습니다! 게임종료")
}

fun main() {
    play()

    while (true) {
        println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
        val br = BufferedReader(System.`in`.bufferedReader())
        val inputCommand = br.readLine()
        when (inputCommand) {
            "1" -> play()
            "2" -> {
                br.close()
                return
            }

            else -> {
                throw IllegalArgumentException("유효한 입력값( 새로 시작: 1, 종료: 2)이 아닙니다")
            }
        }
    }
}