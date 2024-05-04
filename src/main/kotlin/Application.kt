fun main() {
    runSystem()
}

// 상대방 기능
fun createAnswer(): List<Int> {
    val range = (1..9)
    val numbers = mutableSetOf<Int>()
    while (numbers.size < 3) {
        numbers.add(range.random())
    }
    val answer: List<Int> = numbers.toList()
    return answer
}

// 시스템 기능
class GameInfo(mAnswer: List<Int>) {
    var ball: Int = 0
    var strike: Int = 0
    var answer: List<Int> = mAnswer

    fun clearScore() {
        ball = 0
        strike = 0
    }
}

fun runSystem() {
    do {
        startGame()
    } while (restartGame())
    println("애플리케이션을 종료합니다.")
}

fun startGame() {
    val gameInfo = GameInfo(createAnswer())
    do {
        print("숫자를 입력해 주세요 : ")
        var predict: List<Int> = getValidPredict()
        compareNumber(predict, gameInfo)
        printScore(gameInfo)
    } while (!checkEnd(gameInfo))
    println("3개의 숫자를 모두 맞히셨습니다! 게임 종료")
}

fun compareNumber(predict: List<Int>, gameInfo: GameInfo) {
    gameInfo.clearScore()
    predict.forEachIndexed { index: Int, num: Int ->
        val answerIdx: Int = gameInfo.answer.indexOf(num)
        if (answerIdx != -1 && answerIdx == index) {
            gameInfo.strike++
        } else if (answerIdx != -1) {
            gameInfo.ball++
        }
    }
}

fun printScore(gameInfo: GameInfo): String {
    var res: String = ""
    if (gameInfo.ball != 0)
        res += "${gameInfo.ball}볼 "
    if (gameInfo.strike != 0)
        res += "${gameInfo.strike}스트라이크"
    if (gameInfo.ball == 0 && gameInfo.strike == 0)
        res = "낫싱"
    println(res)
    return res
}

fun checkEnd(gameInfo: GameInfo): Boolean {
    return gameInfo.strike == 3
}

fun restartGame(): Boolean {
    println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    var restart: Boolean = false
    val opt: Int = getValidOption()
    if (opt == 1) {
        restart = true
    } else if (opt == 2) {
        restart = false
    }
    return restart
}

fun getInput(): Int {
    var userInput: Int = 0
    try {
        userInput = readln().toInt()
    }
    catch (exception: Exception) {
        throw IllegalArgumentException("잘못된 입력입니다. 애플리케이션을 종료합니다.")
    }
    return userInput
}

fun getValidPredict(): List<Int> {
    var res = List<Int>(3) { 0 }
    var isValid: Boolean = false
    while (!isValid) {
        var temp: Int = getInput()
        if (temp >= 1000) {
            println("예측값은 세자리수 입니다.")
            print("숫자를 입력해 주세요 : ")
            continue
        }
        val num100: Int = temp / 100
        temp %= 100
        val num010: Int = temp / 10
        temp %= 10
        val num001: Int = temp
        if (num100 == 0 || num010 == 0 || num001 == 0) {
            println("예측값의 각 자릿수는 1에서 9사이 값을 가져야 합니다.")
            print("숫자를 입력해 주세요 : ")
            continue
        }
        res = listOf(num100, num010, num001)
        isValid = true
    }
    return res
}

fun getValidOption(): Int {
    var opt: Int = 0
    while (true) {
        opt = getInput()
        if (opt in 1..2)
            break
        println("1 또는 2를 입력 하세요.")
        println("게임을 새로 시작: 1, 종료: 2")
    }
    return opt
}