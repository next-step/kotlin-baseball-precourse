import java.io.BufferedReader
import kotlin.random.Random

fun main() {
    var goalNumString: String = generateGoalNum()
    val br = BufferedReader(System.`in`.bufferedReader())
    print("숫자를 입력해 주세요 : ")
    var inputNumString: String = br.readLine()

    try {
        checkInputNum(inputNumString)
    } catch (e: IllegalArgumentException) {
        println("1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 입력해주세요.")
        return
    }

    val matchResultMap = mutableMapOf("스트라이크" to 0, "볼" to 0, "미스" to 0)

    matchGoalNumAndUserNum(goalNumString, inputNumString, matchResultMap)
    printMatchResult(matchResultMap)
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