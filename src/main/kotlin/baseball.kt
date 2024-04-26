import kotlin.random.Random

fun main() {
    var goalNumString: String = generateGoalNum()
}

/**
 * 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 생성하는 함수
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
 * goal Number가 게임 규칙에 맞는 숫자인지 확인하는 함수:
 * 규칙 1. 각 자리의 숫자는 1 ~ 9 사이의 숫자여야함
 * 규칙 2. 겹치는 숫자가 없어야 함.
 *
 * @param goalNumString 검사할 goal number string
 * @return `true` if goalNumString이 게임 규칙에 맞는 경우, `false` 그 외의 경우
 */
fun isCorrectGoalNum(goalNumString: String): Boolean {
    if (goalNumString[1] == '0' || goalNumString[2] == '0') {
        return false
    }
    if (goalNumString[0] == goalNumString[1] ||
        goalNumString[0] == goalNumString[2] ||
        goalNumString[1] == goalNumString[2]) {
        return false
    }
    return true
}
