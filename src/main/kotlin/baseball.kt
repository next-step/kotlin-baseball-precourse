import java.io.BufferedReader
import kotlin.random.Random

fun main() {
    val br = BufferedReader(System.`in`.bufferedReader())
    var goalNumString: String = generateGoalNum()
    var inputNumString = ""
    val matchResultMap = mutableMapOf("스트라이크" to 0, "볼" to 0, "미스" to 0)
    var flag = "0" // 0 : 게임 중, 1 : goalNumber 생성 필요, 2 : 게임 종료
    var gameOver = false

    while (flag != "2") {                       // flag가 "2" 일 때까지 게임 반복
        resetMatchResultMap(matchResultMap)     // resultMap 초기화

        if (flag == "1") {                      // flar가 "1"인 경우 게임을 다시 시작하기 위한 세팅
            goalNumString = generateGoalNum()
            flag = "0"
            gameOver = false
        }

        print("숫자를 입력해 주세요 : ")            // 유저의 숫자 입력을 받음
        inputNumString = br.readLine()

        try {                                   // 잘못된 입력을 받은 경우 예외 발생 후 게임 종료
            checkInputNum(inputNumString)
        } catch (e: IllegalArgumentException) {
            println("1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 입력해주세요.")
            break
        }

        matchGoalNumAndUserNum(goalNumString, inputNumString, matchResultMap) // 목표와 입력 매칭
        printMatchResult(matchResultMap)

        if (matchResultMap["스트라이크"] == 3) {   // 숫자를 맞춘 경우 게임종료 메시지 출력, flag 입력 받음
            printGameOverMessage()
            flag = br.readLine()
            gameOver = true
        }

        try {                                    // flag가 유효한지 확인
            checkValidFlag(flag, gameOver)
        } catch (e: IllegalArgumentException) {
            println("1 또는 2를 입력해주세요.")
            break
        }
    }
}

/**
 * 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 생성하는 함수:
 *
 * @return 무작위로 생성된 String type의 1부터 9까지 서로 다른 수로 이루어진 3자리의 수
 */
fun generateGoalNum(): String {
    var goalNumString: String = Random.nextInt(123, 988).toString()
    while (!isCorrectGoalNum(goalNumString)) {
        goalNumString = Random.nextInt(123, 988).toString()
    }
    return goalNumString
}

/**
 * goal Number가 게임 규칙에 맞는 숫자인지 확인하는 함수
 * 규칙 1. 각 자리의 숫자는 1 ~ 9 사이의 숫자여야함
 * 규칙 2. 겹치는 숫자가 없어야 함.
 *
 * @param goalNumString 검사할 goal number string
 * @return `true` if goalNumString이 게임 규칙에 맞는 경우, `false` 그 외의 경우
 */
fun isCorrectGoalNum(goalNumString: String): Boolean {
    if (isNotValidNumber(goalNumString)) {
        return false
    }
    if (isNotDistinctNumber(goalNumString)) {
        return false
    }
    return true
}

/**
 * 사용자가 입력한 숫자가 규칙에 맞는 지 확인하는 함수:
 * 규칙 1. 입력이 1 ~ 9 사이의 숫자로 이루어져야 함
 * 규칙 2. 입력이 세 자리 숫자여야 함
 * 규칙 3. 겹치는 숫자가 없어야 함.
 *
 * 위의 조건 중 하나라도 해당되면 [IllegalArgumentException]을 throw
 *
 * @param inputNumString 확인할 입력 숫자 문자열
 * @throws IllegalArgumentException 입력한 숫자가 규칙에 맞지 않는 경우
 */
fun checkInputNum(inputNumString: String) {
    if (isNotValidNumber(inputNumString)) {
        throw IllegalArgumentException()
    } else if (isNotThreeDigitNumber(inputNumString)) {
        throw IllegalArgumentException()
    } else if (isNotDistinctNumber(inputNumString)) {
        throw IllegalArgumentException()
    }
}

/**
 * 입력이 1 ~ 9 사이의 숫자로 이루어지지 않은 경우를 체크함.
 *
 * @param numString 확인할 입력 숫자 문자열
 * @return `true` if 입력이 숫자로 이루어지지 않은 경우, `false` 그 외의 경우.
 */
fun isNotValidNumber(numString: String): Boolean {
    numString.forEach { n ->
        if (n !in '1'..'9') {
            return true
        }
    }
    return false
}

/**
 * 입력이 세 자리인지 체크 함
 *
 * @param inputNumString 확인할 입력 숫자 문자열
 * @return `true` if 입력이 세 자리로 이루어지지 않은 경우, `false` 그 외의 경우.
 */
fun isNotThreeDigitNumber(inputNumString: String): Boolean {
    val inputNum: Int = inputNumString.toInt()
    return inputNum !in 100..999
}

/**
 * 안 겹치는 세 자리의 수인지 체크함.
 *
 * @param numString 확인할 숫자 문자열
 * @return `true` if 겹치는 숫자가 있는 경우, `false` 그 외의 경우.
 */
fun isNotDistinctNumber(numString: String): Boolean {
    return (numString[0] == numString[1] || numString[0] == numString[2] || numString[1] == numString[2])
}

/**
 * goalNumString과 inputNumString을 매칭하고 matchResultMap을 업데이트함.
 *
 * @param goalNumString 목표 숫자 문자열
 * @param inputNumString 사용자 입력 숫자 문자열
 * @param matchResultMap 매칭 결과를 저장하는 MutableMap
 *   맵의 키는 "스트라이크", "볼", "미스"이며, 값은 해당 결과의 개수임.
 */
fun matchGoalNumAndUserNum(
    goalNumString: String,
    inputNumString: String,
    matchResultMap: MutableMap<String, Int>
) {
    for (i in 0..2) {
        if (isStrike(i, inputNumString[i], goalNumString)) {
            matchResultMap["스트라이크"] = matchResultMap["스트라이크"]!! + 1
        } else if (isBall(i, inputNumString[i], goalNumString)) {
            matchResultMap["볼"] = matchResultMap["볼"]!! + 1
        } else {
            matchResultMap["미스"] = matchResultMap["미스"]!! + 1
        }
    }
}

/**
 * 현재 선택된 숫자가 스트라이크인지 확인.
 *
 * @param index 현재 자릿수를 나태는 index.
 * @param curNumChar 현재 숫자를 나타내는 문자.
 * @param goalNumString 목표 숫자를 나타내는 문자열.
 * @return `true` if 스트라이크인 경우, `false` 그 외의 경우.
 */
fun isStrike(index: Int, curNumChar: Char, goalNumString: String): Boolean {
    goalNumString.forEachIndexed { i, n ->
        if (i == index && n == curNumChar) {
            return true
        }
    }
    return false
}

/**
 * 현재 선택된 숫자가 볼인지 확인.
 *
 * @param index 현재 자릿수를 나태는 index.
 * @param curNumChar 현재 숫자를 나타내는 문자.
 * @param goalNumString 목표 숫자를 나타내는 문자열.
 * @return `true` if 볼인 경우, `false` 그 외의 경우.
 */
fun isBall(index: Int, curNumChar: Char, goalNumString: String): Boolean {
    goalNumString.forEachIndexed { i, n ->
        if (i != index && n == curNumChar) {
            return true
        }
    }
    return false
}

/**
 * 매칭 결과를 출력하는 함수.
 *
 * @param matchResultMap 매칭 결과를 저장하는 MutableMap.
 *   맵의 키는 "스트라이크", "볼", "미스"이며, 값은 해당 결과의 개수임.
 */
fun printMatchResult(matchResultMap: MutableMap<String, Int>) {
    if (matchResultMap["미스"] == 3) {
        println("낫싱")
        return
    }
    if (matchResultMap["스트라이크"] == 0) {
        println("${matchResultMap["볼"]}볼")
    } else if (matchResultMap["볼"] == 0) {
        println("${matchResultMap["스트라이크"]}스트라이크")
    } else {
        println("${matchResultMap["볼"]}볼 ${matchResultMap["스트라이크"]}스트라이크")
    }
}

/**
 * 게임 종료 메시지 출력하는 함수.
 *
 * 3 스트라이크일 때 출력
 */
fun printGameOverMessage() {
    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
}

/**
 * 플래그의 유효성을 확인하는 함수.
 *
 * 게임이 종료되지 않은 경우 확인하지 않음.
 * 플래그가 "1" 또는 "2"가 아닌 경우 [IllegalArgumentException]을 throw.
 *
 * @param flag 확인할 플래그.
 * @param gameOver 게임이 종료되었는지 여부를 나타내는 플래그.
 * @throws IllegalArgumentException 플래그가 유효하지 않은 경우.
 */
fun checkValidFlag(flag: String, gameOver: Boolean) {
    if (!gameOver) {
        return
    }
    if (flag != "1" && flag != "2") {
        throw IllegalArgumentException()
    }
}

/**
 * matchResultMap의 모든 값을 0으로 초기화하는 함수.
 *
 * @param matchResultMap 초기화할 MutableMap.
 *   맵의 키는 "스트라이크", "볼", "미스"이며, 값은 해당 결과의 개수임.
 */
fun resetMatchResultMap(matchResultMap: MutableMap<String, Int>) {
    matchResultMap["스트라이크"] = 0
    matchResultMap["볼"] = 0
    matchResultMap["미스"] = 0
}